package pedrociarlini.mesaderpg.net;

import java.util.Arrays;

import org.apache.uima.internal.util.SerializationUtils;

import pedrociarlini.mesaderpg.net.trabalho.Message;

public class TrabalhoTeste {
	public static void main(String[] args) {
		byte[] aux = new byte[8], target = new byte[] { 2, 3, 4, 5, 21, 14, 14 };
		Message m1 = new Message();
		m1.setBytes(target);
		try {
			aux = SerializationUtils.serialize(m1);
			aux = SerializationUtils.serialize(m1);
			System.out.println(Arrays.toString(aux));
			String s = new String(aux);
			System.out.println(s);

			Message m = (Message) SerializationUtils.deserialize(aux);
			System.out.println(m);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
