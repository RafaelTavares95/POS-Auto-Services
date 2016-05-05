/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.ifpb.pos.pecas.basico.services;

import edu.ifpb.pos.pecas.basico.entities.ListaDePecas;
import edu.ifpb.pos.pecas.basico.entities.Peca;
import java.rmi.RemoteException;
import javax.jws.WebService;


/**
 *
 * @author Rafael
 */
@WebService
public interface PecaService {
    public void addPeca(Peca p) throws RemoteException;
    public void editPeca(Peca p) throws RemoteException;
    public void removePeca(Long pecaId) throws RemoteException;
    public Peca getPeca(Long pecaId) throws RemoteException;
    public ListaDePecas listPecas() throws RemoteException;
}
