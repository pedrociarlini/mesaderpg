package pedrociarlini.mesaderpg.net.event;

import java.util.EventListener;

public interface DataReceivedListener extends EventListener {
	public void onDataReceived(DataEvent ev);
}