/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.ifpb.pos.cheques.resources;

import edu.ifpb.pos.cheques.dao.DAO;
import edu.ifpb.pos.cheques.dao.DAOJPA;
import edu.ifpb.pos.cheques.entities.Cheque;
import edu.ifpb.pos.cheques.utils.JsonConverter;
import org.restlet.representation.Representation;
import org.restlet.representation.StringRepresentation;
import org.restlet.resource.Get;
import org.restlet.resource.Post;
import org.restlet.resource.ServerResource;

/**
 *
 * @author Rafael
 */
public class ChequeResource extends ServerResource{
    private final DAO<Cheque> dao = new DAOJPA();
    
    @Get
    public StringRepresentation getChequeByNumber() {        
        try {
            String c = (String) getRequest().getAttributes().get("numero");
            Long cod = Long.parseLong(c);
            String f = (String) getRequest().getAttributes().get("filtro-tipo");
            if((f.equals("recebido"))||(f.equals("emitido"))){
                Cheque cheque = dao.buscar(cod, Cheque.class);
                String tipo = "CHEQUE " + f.toUpperCase();
                if(tipo.equals(cheque.getOutras_inf())){
                    String result = JsonConverter.convertToJson(cheque);
                    return new StringRepresentation(result);
                }else{
                    throw new Exception("O id do cheque não condiz com o tipo especificado!");
                }
            }else{
                throw new Exception("O parâmetro 1 deve conter o valor (emitido) ou (recebido)!!!!");
            }
        } catch (Exception ex) {
            return new StringRepresentation("Error: " + ex.getMessage());
        }
    }
}
