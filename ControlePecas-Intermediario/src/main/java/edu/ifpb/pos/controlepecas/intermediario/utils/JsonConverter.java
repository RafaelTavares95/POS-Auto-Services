/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.ifpb.pos.controlepecas.intermediario.utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import edu.ifpb.pos.pecas.basico.entities.Peca;

/**
 *
 * @author Rafael
 */
public class JsonConverter {
    public static Peca convertToPeca(String json) {
        Gson gson = new GsonBuilder().create();
        Peca p = gson.fromJson(json, Peca.class);
        return p;
    }
    
    public static Qtde convertToQtde(String json) {
        Gson gson = new GsonBuilder().create();
        Qtde q = gson.fromJson(json, Qtde.class);
        return q;
    }
    
    public static String convertToJson(Object obj) {
        Gson gson = new GsonBuilder().create();
        return gson.toJson(obj);
    }
}
