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
import org.restlet.representation.StringRepresentation;
import org.restlet.resource.Get;
import org.restlet.resource.ServerResource;

/**
 *
 * @author Rafael
 */
public class ChequeResource extends ServerResource{
    private final DAO<Cheque> dao = new DAOJPA();
    
    @Get
    public StringRepresentation list() {        
        try {
            String c = (String) getRequest().getAttributes().get("numero");
            Long cod = Long.parseLong(c);
            String result = JsonConverter.convertToJson(dao.buscar(cod, Cheque.class));
            return new StringRepresentation(result);
        } catch (Exception ex) {
            return new StringRepresentation("Error: " + ex.getMessage());
        }
    }
}
