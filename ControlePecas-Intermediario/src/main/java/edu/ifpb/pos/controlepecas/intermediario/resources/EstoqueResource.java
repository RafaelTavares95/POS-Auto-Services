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
import edu.ifpb.pos.pecas.basico.services.PecaService;
import org.restlet.representation.Representation;
import org.restlet.representation.StringRepresentation;
import org.restlet.resource.Delete;
import org.restlet.resource.Get;
import org.restlet.resource.Post;
import org.restlet.resource.Put;
import org.restlet.resource.ServerResource;

/**
 *
 * @author Rafael
 */
public class EstoqueResource extends ServerResource{
    
    PecaService servBasic = ServiceReader.getService();
    
    @Post
    public StringRepresentation addEstoque(Representation r) {
        try {
            String c = (String) getRequest().getAttributes().get("cod");
            Long cod = Long.parseLong(c);
            String json = r.getText();
            Qtde qtde = JsonConverter.convertToQtde(json);
            Peca p = servBasic.getPeca(cod);
            p.setQtdeEmEstoque(p.getQtdeEmEstoque() + qtde.getValor());
            servBasic.editPeca(p);
            return new StringRepresentation("Quantidade Adicionada com sucesso.");
        } catch (Exception ex) {
            return new StringRepresentation("ERROR: " + ex.getMessage());
        }
    }
    
    @Put
    public StringRepresentation removeEstoque(Representation r) {
        try {
            String c = (String) getRequest().getAttributes().get("cod");
            Long cod = Long.parseLong(c);
            String json = r.getText();
            Qtde qtde = JsonConverter.convertToQtde(json);
            Peca p = servBasic.getPeca(cod);
            if((p.getQtdeEmEstoque() - qtde.getValor()) > 0){
                p.setQtdeEmEstoque(p.getQtdeEmEstoque() - qtde.getValor());
                servBasic.editPeca(p);
            }else{
                    throw new Exception("Você tentou remover uma quantidade de peças "
                            + "maior do que a existente no estoque");
            }        
            return new StringRepresentation("Quantidade Removida com sucesso.");
        } catch (Exception ex) {
            return new StringRepresentation("ERROR: " + ex.getMessage());
        }
    }
    
    @Get
    public StringRepresentation getQtde(){
        try{
            String c = (String) getRequest().getAttributes().get("cod");
            Long cod = Long.parseLong(c);
            Peca p = servBasic.getPeca(cod);
            Qtde qtde= new Qtde();
            qtde.setValor(p.getQtdeEmEstoque());
            String result = JsonConverter.convertToJson(qtde);
            if (result.equals("null")) {
                result = "{}";
            }
            return new StringRepresentation(result);
        } catch (Exception ex) {
            return new StringRepresentation("ERROR: " + ex.getMessage());
        }
    }
}
