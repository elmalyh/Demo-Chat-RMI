package Service;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import Model.message;

public interface IChating extends Remote{
	 public void sendMessage(message message) throws RemoteException;
	    public ArrayList<message> readMessage() throws RemoteException;
	    public void clear() throws RemoteException;
}
