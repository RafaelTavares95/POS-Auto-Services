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
public class ChequeRecebidoResource extends ServerResource{
    private final DAO<Cheque> dao = new DAOJPA();
    
    @Post
     public StringRepresentation addChequeRecebido(Representation r) {
        try {
            String q = r.getText();
            Cheque cheque = JsonConverter.convertToCheque(q);
            dao.salvar(cheque);
            return new StringRepresentation("Success: Cheque inserido com sucesso!");
        } catch (Exception ex) {
            return new StringRepresentation("Error: " + ex.getMessage());
        }
    }
}
