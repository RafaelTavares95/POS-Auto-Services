/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.ifpb.pos.pecas.basico;

import edu.ifpb.pos.pecas.basico.services.PecaServiceImpl;
import javax.xml.ws.Endpoint;

/**
 *
 * @author Rafael
 */
public class Publisher {
    public static void main(String[] args) {
        Endpoint.publish("http://localhost:8000/pecas",new PecaServiceImpl() );
    }
    
}
