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
import org.restlet.resource.Post;
import org.restlet.resource.ServerResource;

/**
 *
 * @author Rafael
 */
public class ChequeInsertResource extends ServerResource{
    private final DAO<Cheque> dao = new DAOJPA();
    
    @Post
     public StringRepresentation addCheque(Representation r) {
        try {
            String c = (String) getRequest().getAttributes().get("filtro-tipo");
            if((c.equals("recebido"))||(c.equals("emitido"))){
                String q = r.getText();
                Cheque cheque = JsonConverter.convertToCheque(q);
                cheque.setOutras_inf("CHEQUE " + c.toUpperCase());
                dao.salvar(cheque);
                return new StringRepresentation("Success: Cheque do tipo ("+c+") inserido com sucesso!");
            }else{
                throw new Exception("O parâmetro deve conter o valor (emitido) ou (recebido)!!!!");
            }
        } catch (Exception ex) {
            return new StringRepresentation("Error: " + ex.getMessage());
        }
    }
}
