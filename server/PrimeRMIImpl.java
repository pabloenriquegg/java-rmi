package server;

import java.rmi.server.UnicastRemoteObject;
import java.rmi.RemoteException;
import interfaces.PrimeRMI;


public class PrimeRMIImpl extends UnicastRemoteObject implements PrimeRMI {

    public PrimeRMIImpl() throws RemoteException {
        super();
    }


    public boolean isPrime(int number) throws RemoteException {
        if (number <= 1) return false;
        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) return false;
        }
        return true;
    }
}
