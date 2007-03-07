package pedrociarlini.mesaderpg.model;

import java.io.Serializable;
import java.net.Socket;

public class JogadorVO implements Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    private boolean mestre;

    private String nome;

    private Socket conn;

    public JogadorVO(String text, boolean isMestre) {
        setNome(nome);
        setMestre(isMestre);
    }

    public boolean isMestre() {
        return mestre;
    }

    public void setMestre(boolean mestre) {
        this.mestre = mestre;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Socket getConn() {
        return conn;
    }

    public void setConn(Socket conn) {
        this.conn = conn;
    }

    /**
     * Constructs a <code>String</code> with all attributes
     * in name = value format.
     *
     * @return a <code>String</code> representation 
     * of this object.
     */
    public String toString()
    {
        final String TAB = "    ";
        
        String retValue = "";
        
        retValue = "JogadorVO ( "
            + super.toString() + TAB
            + "mestre = " + this.mestre + TAB
            + "nome = " + this.nome + TAB
            + "conn = " + this.conn + TAB
            + " )";
    
        return retValue;
    }
}