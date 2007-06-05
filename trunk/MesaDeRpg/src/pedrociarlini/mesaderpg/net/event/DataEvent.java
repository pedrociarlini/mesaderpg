package pedrociarlini.mesaderpg.net.event;

import java.io.Serializable;
import java.util.EventObject;

public class DataEvent extends EventObject {
    
    private Serializable receivedData;

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public DataEvent(Object source) {
		super(source);
	}

    public DataEvent(Object source, Serializable data) {
        this(source);
        setReceivedData(data);
    }

    public Serializable getReceivedData() {
        return receivedData;
    }

    public void setReceivedData(Serializable receivedData) {
        this.receivedData = receivedData;
    }
}