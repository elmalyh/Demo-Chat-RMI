package Model;
import java.io.Serializable;

public class message implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String message;
	private String ID_sender;
	
	public message(String message, String iD_sender) {
		super();
		this.message = message;
		ID_sender = iD_sender;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getID_sender() {
		return ID_sender;
	}
	public void setID_sender(String iD_sender) {
		ID_sender = iD_sender;
	}
    
}
