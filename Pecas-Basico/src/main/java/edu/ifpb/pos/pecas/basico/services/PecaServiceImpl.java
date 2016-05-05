/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.ifpb.pos.pecas.basico.services;

import edu.ifpb.pos.pecas.basico.dao.DAO;
import edu.ifpb.pos.pecas.basico.dao.DAOJPA;
import edu.ifpb.pos.pecas.basico.entities.ListaDePecas;
import edu.ifpb.pos.pecas.basico.entities.Peca;
import java.rmi.RemoteException;
import java.util.List;
import javax.jws.WebService;

/**
 *
 * @author Rafael
 */
@WebService(endpointInterface = "edu.ifpb.pos.pecas.basico.services.PecaService")
public class PecaServiceImpl implements PecaService{
    private DAO<Peca> dao;

    public PecaServiceImpl() {
        dao = new DAOJPA<>();
    }

    @Override
    public void addPeca(Peca p) throws RemoteException {
        dao.salvar(p);
    }

    @Override
    public void editPeca(Peca p) throws RemoteException {
        Peca pc = dao.buscar(p.getCodigo(), Peca.class);
        pc.setNome(p.getNome());
        pc.setSetor(p.getSetor());
        pc.setValor(p.getValor());
        pc.setVeiculos(p.getVeiculos());
        pc.setFornecedores(p.getFornecedores());
        pc.setQtdeEmEstoque(p.getQtdeEmEstoque());
        dao.atualizar(pc);
    }

    @Override
    public void removePeca(Long pecaId) throws RemoteException {
        Peca p = dao.buscar(pecaId, Peca.class);
        dao.excluir(p);
    }

    @Override
    public Peca getPeca(Long pecaId) throws RemoteException {
        return dao.buscar(pecaId, Peca.class);
    }

    @Override
    public ListaDePecas listPecas() throws RemoteException {
        List<Peca> list= dao.consultaLista("p.list", null);
//        for (Peca peca : list) {
//            System.out.println(peca.getNome());
//        }
//        
//        Peca[] p = list.toArray(new Peca[list.size()]);
//        
//        for (int i = 0; i < p.length; i++) {
//            Peca peca = p[i];
//            System.out.println(peca.getSetor());
//        }
        ListaDePecas l = new ListaDePecas();
        l.setLista(list);
        return l;
    }
    
}
