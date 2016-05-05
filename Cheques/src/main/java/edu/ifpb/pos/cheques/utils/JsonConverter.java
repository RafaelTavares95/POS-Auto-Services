/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.ifpb.pos.cheques.utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import edu.ifpb.pos.cheques.entities.Cheque;

/**
 *
 * @author Rafael
 */
public class JsonConverter {

    public static Cheque convertToCheque(String json) {
        Gson gson = new GsonBuilder().setDateFormat("dd/MM/yyyy").create();
        Cheque c  = gson.fromJson(json, Cheque.class);
        return c;
    }
    
    public static String convertToJson(Object obj) {
        Gson gson = new GsonBuilder().setDateFormat("dd/MM/yyyy").create();
        return gson.toJson(obj);
    }
}
