package server;

import interfaces.CountRMI;
import interfaces.WebRMI;
import interfaces.PrimeRMI;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class RMIServer {
    public static void main(String[] args) {
        try {
            CountRMI count = new CountRMIImpl();
            WebRMI web = new WebRMIImpl();
            PrimeRMI prime = new PrimeRMIImpl();

            Registry registry = LocateRegistry.createRegistry(1098);
            registry.rebind("CountService", count);
            registry.rebind("WebService", web);
            registry.rebind("PrimeService", prime);

            System.out.println("Servidor RMI listo en el puerto 1098.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

