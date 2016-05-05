/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.ifpb.pos.controlepecas.intermediario.resources;

import edu.ifpb.pos.pecas.basico.entities.Peca;
import edu.ifpb.pos.controlepecas.intermediario.utils.JsonConverter;
import edu.ifpb.pos.controlepecas.intermediario.utils.Qtde;
import edu.ifpb.pos.controlepecas.intermediario.utils.ServiceReader;
import edu.ifpb.pos.pecas.basico.entities.ListaDePecas;
import edu.ifpb.pos.pecas.basico.services.PecaService;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.restlet.representation.StringRepresentation;
import org.restlet.resource.Get;
import org.restlet.resource.ServerResource;

/**
 *
 * @author Rafael
 */
public class EstoqueListResource extends ServerResource{
    PecaService servBasic = ServiceReader.getService();
    
    @Get
    public StringRepresentation list(){
        try{
            ListaDePecas l = servBasic.listPecas();
//            for (int i = 0; i < p.length; i++) {
//                    Peca peca = p[i];
//                    System.out.println("Nome - 1: " + peca.getNome());
//                }
//            List<Peca> list = Arrays.asList(p);
//            for (Peca peca : list) {
//                System.out.println("Nome: " + peca.getNome());
//            }
            String result = JsonConverter.convertToJson(l.getLista());
            return new StringRepresentation(result);
        } catch (Exception ex) {
            return new StringRepresentation("ERROR: " + ex.getMessage());
        }
    }
}
