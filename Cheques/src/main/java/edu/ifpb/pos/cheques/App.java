/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.ifpb.pos.cheques;

import edu.ifpb.pos.cheques.resources.ChequeEmitidoResource;
import edu.ifpb.pos.cheques.resources.ChequeRecebidoResource;
import edu.ifpb.pos.cheques.resources.ChequeResource;
import org.restlet.Application;
import org.restlet.Component;
import org.restlet.data.Protocol;
import org.restlet.routing.Router;

/**
 *
 * @author Rafael
 */
public class App {
    public static void main(String[] args) throws Exception{
        Component component = new Component();
        component.getServers().add(Protocol.HTTP, 8060);
        
        Router router = new Router();
        router.attach("/cheque/r", ChequeRecebidoResource.class);
        router.attach("/cheque/e", ChequeEmitidoResource.class);
        router.attach("/cheque/{numero}", ChequeResource.class);
        
        Application application = new Application();
        application.setInboundRoot(router);
        
        component.getDefaultHost().attach("", application);
        component.start();
    }
}
