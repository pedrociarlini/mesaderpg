package pedrociarlini.mesaderpg.model;

import java.io.Serializable;

public class ServidorVO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 2459953689727673910L;
	
	private int porta;
	
	private int backLog;
	
	public ServidorVO() {
	}
	
	public ServidorVO(int porta, int backLog) {
		setPorta(porta);
		setBackLog(backLog);
	}

	public int getBackLog() {
		return backLog;
	}

	public void setBackLog(int backLog) {
		this.backLog = backLog;
	}

	public int getPorta() {
		return porta;
	}

	public void setPorta(int porta) {
		this.porta = porta;
	}

}
