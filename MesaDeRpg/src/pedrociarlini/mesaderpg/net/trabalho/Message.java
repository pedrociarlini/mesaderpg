package pedrociarlini.mesaderpg.net.trabalho;

import java.io.Serializable;
import java.util.Arrays;

import trabalho.IMessage;

/**
 * Representa uma mensagem que será enviada ou foi recebida.
 * @author Pedro Ciarlini
 *
 */
public class Message implements IMessage, Serializable {
    
    /**
	 * 
	 */
	private static final long serialVersionUID = 12L;
	
	/**
     * Bytes da mensagem.
     */
    private byte[] bytes;

    /**
     * Retorna o conteúdo dos dados da mensagem.
     */
    public byte[] getBytes() {
        return bytes;
    }

    /**
     * Retorna a quantidade de bytes que foram salvos.
     */
    public int setBytes(byte[] b) {
        bytes = new byte[b.length];
        System.arraycopy(b, 0, bytes, 0, b.length);
        return bytes.length;
    }
    
    @Override
    public String toString() {
    	return "Message[ bytes: " + Arrays.toString(bytes) + "]";
    }
}