package Service;

import java.io.Serializable;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

import Model.message;

public class Chating extends UnicastRemoteObject implements IChating, Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	ArrayList<message> messages = new ArrayList<>();

    public Chating() throws RemoteException {
        super();    
    }
    
    public void createMessage(String msg,String idS) throws RemoteException {
    	message mesg = new message(msg,idS);
    }

    @Override
    public synchronized void sendMessage(message msg) throws RemoteException {
        messages.add(msg);
    }

    @Override
    public synchronized ArrayList<message> readMessage() throws RemoteException {
        for(message m : messages){
            System.out.println(m.getID_sender()+ " : " + m.getMessage());
        }
        return messages;
    }
    
    @Override
    public void clear() throws RemoteException{
        for(message m : messages){
            messages.remove(m);
        }
        
    }

	
}
