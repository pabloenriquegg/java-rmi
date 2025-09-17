package interfaces;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface PrimeRMI extends Remote {
    boolean isPrime(int number) throws RemoteException;
}

