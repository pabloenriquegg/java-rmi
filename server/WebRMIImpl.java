package server;

import java.rmi.server.UnicastRemoteObject;
import java.rmi.RemoteException;
import interfaces.WebRMI;
import java.io.*;
import java.net.*;
import java.util.*;
import org.jsoup.*;
import org.jsoup.nodes.*;
import org.jsoup.select.*;

public class WebRMIImpl extends UnicastRemoteObject implements WebRMI {

    public WebRMIImpl() throws RemoteException {
        super();
    }


    public String consultarWeb(String url) throws RemoteException {
        try {
            URL website = new URL(url);
            BufferedReader in = new BufferedReader(new InputStreamReader(website.openStream()));
            StringBuilder content = new StringBuilder();
            String inputLine;

            while ((inputLine = in.readLine()) != null) {
                content.append(inputLine).append("\n");
            }
            in.close();

            String fileName = "webContent.txt";
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
                writer.write(content.toString());
            }
            return fileName;
        } catch (Exception e) {
            throw new RemoteException("Error al consultar la web", e);
        }
    }


    public boolean borrarDatos(String fileName) throws RemoteException {
        File file = new File(fileName);
        return file.delete();
    }


    public List<String> consultarWebLinks(String url) throws RemoteException {
        try {
            Document doc = Jsoup.connect(url).get();
            Elements links = doc.select("a[href]");
            List<String> linkList = new ArrayList<>();

            for (Element link : links) {
                linkList.add(link.attr("abs:href"));
            }
            return linkList;
        } catch (Exception e) {
            throw new RemoteException("Error al consultar enlaces", e);
        }
    }
}
