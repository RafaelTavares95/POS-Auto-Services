/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.ifpb.pos.controlepecas.intermediario.utils;

import edu.ifpb.pos.pecas.basico.services.PecaService;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;

/**
 *
 * @author Rafael
 */
public class ServiceReader {
    public static PecaService getService(){
        URL url = null;
        try {
            url = new URL("http://localhost:8000/pecas?wsdl");
        } catch (MalformedURLException ex) {
            Logger.getLogger(ServiceReader.class.getName()).log(Level.SEVERE, null, ex);
        }
        QName qName=new QName("http://services.basico.pecas.pos.ifpb.edu/", 
                "PecaServiceImplService");
        Service service=Service.create(url,qName);
        return service.getPort(PecaService.class);
    }
}
