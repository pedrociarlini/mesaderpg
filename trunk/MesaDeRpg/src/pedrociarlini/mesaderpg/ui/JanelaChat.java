package pedrociarlini.mesaderpg.ui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import pedrociarlini.mesaderpg.business.JogadoresBusiness;
import pedrociarlini.mesaderpg.model.ChatMensagemVO;
import pedrociarlini.mesaderpg.model.JogadorVO;
import pedrociarlini.mesaderpg.ui.util.MensagensUtil;

public class JanelaChat extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Guarda um mapa onde a chave é o nome de um jogador e o valor é uma janela
	 * de chat para esse jogador.
	 * 
	 * <pre>
	 * chats = {nomeJogador =&gt; JanelaChat, ...}
	 * </pre>
	 */
	private static Map<String, JanelaChat> chats = new HashMap<String, JanelaChat>();

	private JButton btEnviar;

	private JTextArea taLog;

	private JPanel panelComandos;

	private JScrollPane paneLog;

	private JogadorVO jogadorRemoto;

	private JPanel principalPane;

	private JScrollPane scrollPaneMsg = null;

	private JTextArea taMensagem = null;

	public JanelaChat() {
		super();
		initialize();
	}

	public JanelaChat(JogadorVO jogador) {
		super();
		initialize();
		this.jogadorRemoto = jogador;
		setTitle("Chat com " + jogadorRemoto.getNome());
		chats.put(jogador.getNome(), this);
	}

	private void initialize() {
		setTitle("Chat...");
		setSize(400, 200);

		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setContentPane(getPrincipalPane());
		// setVisible(true);
	}

	/**
	 * This method initializes principalPane
	 * 
	 * @return javax.swing.JPanel
	 */
	private JPanel getPrincipalPane() {
		if (principalPane == null) {
			BorderLayout borderLayout = new BorderLayout();
			borderLayout.setHgap(2);
			principalPane = new JPanel();
			principalPane.setLayout(borderLayout);
			principalPane.add(getPanelComandos(), BorderLayout.SOUTH);
			principalPane.add(getPaneLog(), BorderLayout.CENTER);
		}
		return principalPane;
	}

	public JButton getBtEnviar() {
		if (btEnviar == null) {
			btEnviar = new JButton("Enviar");
			// btEnviar.addActionListener(this);
		}
		return btEnviar;
	}

    /*
	public void actionPerformed(ActionEvent arg0) {
		try {
			ChatMensagemVO msg = new ChatMensagemVO(textMensagem.getText(),
					JogadoresBusiness.getJogadorLocal().getNome());
			jogadorRemoto.getConn().send(msg);
			textMensagem.setText("");
			appendMensagem(msg);
		} catch (IOException e) {
			MensagensUtil.showMensagemErro("Erro ao enviar mensagem: "
					+ e.getMessage());
		}
	}
	*/

	public static JanelaChat getChat(String jogadorNome) {
		return chats.get(jogadorNome);
	}

	public void appendMensagem(ChatMensagemVO mensagem) {
		taLog.append("\n" + mensagem.getJogadorNome() + " diz: "
				+ mensagem.getMensagem());
	}

	@Override
	public void dispose() {
		chats.remove(jogadorRemoto.getNome());
		super.dispose();
	}

	public JPanel getPanelComandos() {
		if (panelComandos == null) {
			panelComandos = new JPanel(new BorderLayout(3, 3));
			panelComandos.setPreferredSize(new Dimension(75, 50));
			panelComandos.add(getBtEnviar(), BorderLayout.EAST);
			panelComandos.add(getScrollPaneMsg(), BorderLayout.CENTER);
		}
		return panelComandos;
	}

	public JTextArea getTaLog() {
		if (taLog == null) {
			taLog = new JTextArea();
			taLog.setEditable(false);
		}
		return taLog;
	}

	public JScrollPane getPaneLog() {
		if (paneLog == null) {
			paneLog = new JScrollPane();
			paneLog.setViewportView(getTaLog());
		}
		return paneLog;
	}

	/**
	 * This method initializes scrollPaneMsg	
	 * 	
	 * @return javax.swing.JScrollPane	
	 */
	private JScrollPane getScrollPaneMsg() {
		if (scrollPaneMsg == null) {
			scrollPaneMsg = new JScrollPane();
			scrollPaneMsg.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
			scrollPaneMsg.setViewportView(getTaMensagem());
		}
		return scrollPaneMsg;
	}

	/**
	 * This method initializes taMensagem	
	 * 	
	 * @return javax.swing.JTextArea	
	 */
	private JTextArea getTaMensagem() {
		if (taMensagem == null) {
			taMensagem = new JTextArea();
		}
		return taMensagem;
	}
}
