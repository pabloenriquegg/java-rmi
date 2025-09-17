package client;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import interfaces.CountRMI;



public class CountRMIClient {
    public static void main(String[] args) {
        try {
            //Para localizar el registro RMI
            Registry registry = LocateRegistry.getRegistry("localhost", 1098);

            //se obtiene el servicio remoto
            CountRMI countService = (CountRMI) registry.lookup("CountService");

            //invocación del método increment mil veces
            long startTime = System.currentTimeMillis();
            for (int i = 0; i < 1000; i++) {
                countService.increment();
            }
            long endTime = System.currentTimeMillis();

            //Se obtine el valor de sum
            int finalSum = countService.sum();
            System.out.println("Valor final de sum: " + finalSum);

            //tiempo promedio de las respuesta
            long totalTime = endTime - startTime;
            System.out.println("Tiempo total: " + totalTime + " ms");
            System.out.println("Tiempo promedio por operacion: " + (totalTime / 1000.0) + " ms");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

