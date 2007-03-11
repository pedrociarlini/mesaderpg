package pedrociarlini.mesaderpg.net.event;

import java.util.EventObject;

public class DataEvent extends EventObject {
    
    private Object receivedData;

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public DataEvent(Object source) {
		super(source);
	}

    public DataEvent(Object source, Object data) {
        this(source);
        setReceivedData(data);
    }

    public Object getReceivedData() {
        return receivedData;
    }

    
    public void setReceivedData(Object receivedData) {
        this.receivedData = receivedData;
    }
}