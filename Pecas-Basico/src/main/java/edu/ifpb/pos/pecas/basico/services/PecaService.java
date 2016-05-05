/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.ifpb.pos.pecas.basico.services;

import edu.ifpb.pos.pecas.basico.entities.ListaDePecas;
import edu.ifpb.pos.pecas.basico.entities.Peca;
import java.rmi.RemoteException;
import java.util.List;
import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;

/**
 *
 * @author Rafael
 */
@WebService
@SOAPBinding(style = SOAPBinding.Style.RPC)
public interface PecaService {
    @WebMethod
    public void addPeca(Peca p) throws RemoteException;
    @WebMethod
    public void editPeca(Peca p) throws RemoteException;
    @WebMethod
    public void removePeca(Long pecaId) throws RemoteException;
    @WebMethod
    public Peca getPeca(Long pecaId) throws RemoteException;
    @WebMethod
    public ListaDePecas listPecas() throws RemoteException;
}
