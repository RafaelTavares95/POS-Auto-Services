/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.ifpb.pos.cheques;

import edu.ifpb.pos.cheques.resources.ChequeInsertResource;
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
        router.attach("/cheque/{filtro-tipo}", ChequeInsertResource.class);
        router.attach("/cheque/{filtro-tipo}/{numero}", ChequeResource.class);
        
        Application application = new Application();
        application.setInboundRoot(router);
        
        component.getDefaultHost().attach("", application);
        component.start();
    }
}
