package client;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.List;
import interfaces.WebRMI;

import org.jsoup.*;
import org.jsoup.nodes.*;
import org.jsoup.select.*;

public class WebRMIClient {
    public static void main(String[] args) {
        try {
            //localizacion de rmi
            Registry registry = LocateRegistry.getRegistry("localhost", 1098);

            //servicio remoto
            WebRMI webService = (WebRMI) registry.lookup("WebService");

            //se descarga el contenido de una pagina web
            String url = "https://www.futgal.es/pnfg/";
            String fileName = webService.consultarWeb(url);
            System.out.println("Contenido descargado en: " + fileName);

            //listado de enlaces de la web
            List<String> links = webService.consultarWebLinks(url);
            System.out.println("Enlaces encontrados:");
            for (String link : links) {
                System.out.println(link);
            }

            //se borra el archivo descargado
            boolean deleted = webService.borrarDatos(fileName);
            System.out.println("Archivo eliminado: " + deleted);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
