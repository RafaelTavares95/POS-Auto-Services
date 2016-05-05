/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.ifpb.pos.pecas.basico.entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

/**
 *
 * @author Rafael
 */
@NamedQueries({
    @NamedQuery(name = "p.list",query = "SELECT p FROM Peca p")    
})
@Entity
public class Peca implements Serializable {
    @Id
    private Long codigo;
    private String nome;
    private String setor;
    private Double valor;
    @ElementCollection
    private List<Long> veiculos;
    @ElementCollection
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
