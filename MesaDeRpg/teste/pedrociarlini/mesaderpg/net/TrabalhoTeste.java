package pedrociarlini.mesaderpg.net;

import java.util.Arrays;

import pedrociarlini.mesaderpg.net.trabalho.Message;
import pedrociarlini.mesaderpg.net.trabalho.TransmissionUtils;


public class TrabalhoTeste {
    public static void main(String[] args) {
        byte[] aux = new byte[8], target = new byte[]{2, 3, 4, 5};
        aux = TransmissionUtils.getObjectBytes(new Message());
        System.out.println(Arrays.toString(aux));
        String s = new String(aux);
        System.out.println(s);
    }
}
