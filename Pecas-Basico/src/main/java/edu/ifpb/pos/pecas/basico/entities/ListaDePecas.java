/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.ifpb.pos.pecas.basico.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Rafael
 */
public class ListaDePecas implements Serializable{
    private List<Peca> lista;
    public ListaDePecas() {
        this.lista = new ArrayList<>();
    }

    public List<Peca> getLista() {
        return lista;
    }

    public void setLista(List<Peca> lista) {
        this.lista = lista;
    }
}
