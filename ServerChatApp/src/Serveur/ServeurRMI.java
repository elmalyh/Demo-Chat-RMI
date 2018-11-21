package Serveur;
import java.net.MalformedURLException;
import java.rmi.AlreadyBoundException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import Service.Chating;
import Service.IChating;

public class ServeurRMI {
	public static void main(String[] args) throws  RemoteException, MalformedURLException, AlreadyBoundException {
        try {
            System.out.println("Starting Server");
            LocateRegistry.createRegistry(1090);
            IChating chat = new Chating();
            Naming.rebind("rmi://localhost:1090/chating", chat); 
            System.out.println("Server Started");
        } catch (RemoteException ex) {
            ex.printStackTrace();
        } 
    }
}
