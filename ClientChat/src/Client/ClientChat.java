package Client;

import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.Scanner;

import Model.message;
import Service.IChating;

public class ClientChat {
	public static void main(String[] args)  throws Exception, RemoteException, NotBoundException{
		Scanner clavier = new Scanner(System.in);
		System.out.print("Veuillez Entrer votre nom : ");
		String user = clavier.nextLine();
		System.out.println(user+" a rejoint la conversation\n");
		IChating chat= (IChating)Naming.lookup("rmi://localhost:1090/chating");
		while(true){
			try {
				for(message m : chat.readMessage()){
					System.out.println(m.getID_sender()+" : "+m.getMessage());
				}
				System.out.print("Entrer votre message : ");
				String m = clavier.nextLine();
				if(m.equals("exit")){
					for(message msg : chat.readMessage()){
						chat.readMessage().remove(msg);
					}
					break;
				}
				else{
					chat.sendMessage(new message(m,user));
				}
			} catch ( Exception e) {
				e.printStackTrace();
			}
		}
		
	}
}
