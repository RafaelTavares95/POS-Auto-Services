/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.ifpb.pos.pecas.basico.entities;

import java.io.Serializable;
import java.util.List;

/**
 *
 * @author Rafael
 */
public class Peca implements Serializable {
    private Long codigo;
    private String nome;
    private String setor;
    private Double valor;
    private List<Long> veiculos;
    private List<Long> fornecedores;
    private Integer qtdeEmEstoque;
    
    
    public Long getCodigo() {
        return codigo;
    }

    public void setCodigo(Long codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSetor() {
        return setor;
    }

    public void setSetor(String setor) {
        this.setor = setor;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public List<Long> getVeiculos() {
        return veiculos;
    }

    public void setVeiculos(List<Long> veiculos) {
        this.veiculos = veiculos;
    }

    public List<Long> getFornecedores() {
        return fornecedores;
    }

    public void setFornecedores(List<Long> fornecedores) {
        this.fornecedores = fornecedores;
    }
    
    public Integer getQtdeEmEstoque() {
        return qtdeEmEstoque;
    }

    public void setQtdeEmEstoque(Integer qtdeEmEstoque) {
        this.qtdeEmEstoque = qtdeEmEstoque;
    }
}