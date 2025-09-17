package interfaces;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface CountRMI extends Remote {
    int sum() throws RemoteException;
    void sum(int _val) throws RemoteException;
    int increment() throws RemoteException;
}
