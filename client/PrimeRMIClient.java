package client;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import interfaces.PrimeRMI;



public class PrimeRMIClient {
    public static void main(String[] args) {
        try {
            //Para localizar el registro rmi
            Registry registry = LocateRegistry.getRegistry("localhost", 1098);

            //obtener el servicio remoto
            PrimeRMI primeService = (PrimeRMI) registry.lookup("PrimeService");

            //comprovación de varios numeros para saber si son primos o no
            int[] testNumbers = {2, 3, 4, 5, 7,  17, 18, 19, 20, 29, 31, 53, 57, 63, 87, 92};

            for (int number : testNumbers) {
                boolean isPrime = primeService.isPrime(number);
                System.out.println("¿" + number + " es primo? " + isPrime);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
