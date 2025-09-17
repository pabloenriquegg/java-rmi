package server;

import java.rmi.server.UnicastRemoteObject;
import java.rmi.RemoteException;
import interfaces.CountRMI;


public class CountRMIImpl extends UnicastRemoteObject implements CountRMI {
    private int sum;

    public CountRMIImpl() throws RemoteException {
        this.sum = 0;
    }


    public int sum() throws RemoteException {
        return this.sum;
    }


    public void sum(int _val) throws RemoteException {
        this.sum = _val;
    }

   
    public int increment() throws RemoteException {
        this.sum++;
        return this.sum;
    }
    
}
