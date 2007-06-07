package pedrociarlini.mesaderpg.business;

import pedrociarlini.mesaderpg.model.ServidorVO;

public class ServidorBusiness {
	
	static ServidorVO configuracaoServidor = new ServidorVO();

	public static ServidorVO getConfiguracaoServidor() {
		return configuracaoServidor;
	}

	public static void setConfiguracaoServidor(ServidorVO servidor) {
		configuracaoServidor = servidor;
	}

}
