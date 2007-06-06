package pedrociarlini.mesaderpg.net;


public class ConexaoFactory {
    
    /**
     * Usado para criar uma instância de <code>Conexao</code>.
     * @return Uma instância de um tipo de conexão que será usada em toda 
     * a aplcação.
     */
    public static Conexao createConexaoInstance() {
        // Conexão do trabalho do Nabor.
        return new ConexaoTrabalho();
    }
}
