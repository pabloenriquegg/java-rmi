package interfaces;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

public interface WebRMI extends Remote {
    String consultarWeb(String url) throws RemoteException;
    boolean borrarDatos(String fileName) throws RemoteException;
    List<String> consultarWebLinks(String url) throws RemoteException;
}
