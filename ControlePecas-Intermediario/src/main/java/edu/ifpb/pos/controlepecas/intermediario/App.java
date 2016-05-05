/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.ifpb.pos.controlepecas.intermediario;

import edu.ifpb.pos.pecas.basico.entities.Peca;
import edu.ifpb.pos.controlepecas.intermediario.resources.EstoqueListResource;
import edu.ifpb.pos.controlepecas.intermediario.resources.EstoqueResource;
import edu.ifpb.pos.controlepecas.intermediario.utils.ServiceReader;
import edu.ifpb.pos.pecas.basico.services.PecaService;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;
import org.restlet.Application;
import org.restlet.Component;
import org.restlet.data.Protocol;
import org.restlet.routing.Router;

/**
 *
 * @author Rafael
 */
public class App {
//    public static void main(String[] args) throws RemoteException {
//        PecaService servBasic = ServiceReader.getService();
//        Peca p = new Peca();
//        p.setCodigo(new Long("12345"));
//        p.setNome("Pneu Pirelle T22");
//        p.setQtdeEmEstoque(2);
//        p.setSetor("Pneus");
//        p.setValor(120.00);
//        List<Long> veiculos = new ArrayList<>();
//        veiculos.add(new Long("123"));
//        veiculos.add(new Long("321"));
//        List<Long> fornecedores = new ArrayList<>();
//        fornecedores.add(new Long("301"));
//        p.setFornecedores(fornecedores);
//        p.setVeiculos(veiculos);
//        servBasic.addPeca(p);
//    }
    public static void main(String[] args) throws Exception {
        Component component = new Component();
        component.getServers().add(Protocol.HTTP, 8060);
        
        Router router = new Router();
        router.attach("/peca/{cod}", EstoqueResource.class);
        router.attach("/pecas", EstoqueListResource.class);
        
        Application application = new Application();
        application.setInboundRoot(router);
        
        component.getDefaultHost().attach("", application);
        component.start();
    }
   
}
