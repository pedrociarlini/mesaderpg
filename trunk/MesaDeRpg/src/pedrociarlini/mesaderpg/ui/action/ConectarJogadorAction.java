package pedrociarlini.mesaderpg.ui.action;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JLabel;
import javax.swing.JList;

import pedrociarlini.mesaderpg.business.JogadoresBusiness;
import pedrociarlini.mesaderpg.model.JogadorVO;
import pedrociarlini.mesaderpg.net.Conexao;
import pedrociarlini.mesaderpg.ui.JanelaConectarJogador;
import pedrociarlini.mesaderpg.ui.JogadorComponent;
import pedrociarlini.mesaderpg.ui.util.MensagensUtil;


public class ConectarJogadorAction extends AbstractAction {
    
    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    
    public static final String JOGADOR_LIST = "JOGADOR_LIST";
    
    public static final String JOGADOR_VO = "KEY_JOGADOR_VO";
    
    public ConectarJogadorAction() {
        putValue(Action.NAME, "ConectarJogador");
        putValue(Action.MNEMONIC_KEY, KeyEvent.VK_J);
        putValue(Action.LONG_DESCRIPTION, "Conecta um jogador que esteja na rede.");
    }

    public void actionPerformed(ActionEvent ev) {
        JList listaJogadores = (JList) getValue(JOGADOR_LIST);
        JogadorVO jogador = (JogadorVO) getValue(JOGADOR_VO);;
        JogadorVO remoteJogador = null;
        Conexao conn = null;
        try {
            conn = JanelaConectarJogador.showJogadorDialog();
            if(conn != null) {
            	Object msg = (String) conn.receive();
            	if (!JogadoresBusiness.CONEXAO_START.equals(msg)) {
            		throw new Exception("Erro na conexão: Sequência de conexão não esperada.");
            	}
            	conn.send(jogador);
            	msg = (String) conn.receive();
            	if (!JogadoresBusiness.CONEXAO_SUCCESS.equals(msg)) {
            		String msgErro = "Jogador não foi aceito para conexão.";
           			msgErro += "(" + ((Exception)msg).getMessage() + ")";
            		throw new Exception(msgErro);
            	}
            	remoteJogador = (JogadorVO) conn.receive();
                JogadoresBusiness.conectarJogador(remoteJogador);
//                listaJogadores.add(new JogadorComponent(remoteJogador));
              listaJogadores.setListData(getJogadorComponents(JogadoresBusiness.getListaJogadores()));
            }
        } catch (ClassCastException ex) {
        	MensagensUtil.showMensagemErro("Erro durante o handshake com o jogador remoto.");
        } catch (Exception ex) {
        	MensagensUtil.showMensagemErro(ex.getMessage());
        }
    }
    
    private JogadorComponent[] getJogadorComponents(Object[] jogadores) {
    	JogadorComponent[] result = new JogadorComponent[jogadores.length];
    	
    	for (int i=0; i<result.length; i++) {
    		result[i] = new JogadorComponent((JogadorVO)jogadores[i]);
    	}
    	
    	return result;
    	
    	
    }
}
