package pedrociarlini.mesaderpg.ui;

import java.awt.FlowLayout;
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

import pedrociarlini.mesaderpg.model.ChatMensagemVO;
import pedrociarlini.mesaderpg.model.JogadorVO;
import pedrociarlini.mesaderpg.ui.util.MensagensUtil;

public class JanelaChat extends JFrame implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private static Map<String, JanelaChat> chats = new HashMap<String, JanelaChat>();

	private JButton btEnviar;

	private JTextField textMensagem;

	private JTextArea taLog;

	private JogadorVO jogador;

	public JanelaChat(JogadorVO jogador) {
		this.jogador = jogador;
		chats.put(jogador.getNome(), this);

		btEnviar = new JButton("Enviar");
		btEnviar.addActionListener(this);
		taLog = new JTextArea();
		taLog.setEditable(false);
		textMensagem = new JTextField();
		getContentPane().add(taLog);
		JPanel panelComandos = new JPanel(new FlowLayout(FlowLayout.LEFT));
		panelComandos.add(textMensagem);
		panelComandos.add(btEnviar);
		getContentPane().add(new JScrollPane(taLog));
	}

	public void actionPerformed(ActionEvent arg0) {
		try {
			jogador.getConn().send(
					new ChatMensagemVO(textMensagem.getText(), jogador
							.getNome()));
			textMensagem.setText("");
		} catch (IOException e) {
			MensagensUtil.showMensagemErro("Erro ao enviar mensagem: "
					+ e.getMessage());
		}
	}

	public static JanelaChat getChat(String jogadorNome) {
		return chats.get(jogadorNome);
	}

	public void appendMensagem(ChatMensagemVO mensagem) {
		taLog.append("\n" + mensagem.getJogadorNome() + " diz: "
				+ mensagem.getMensagem());
	}
}
