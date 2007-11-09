package pedrociarlini.mesaderpg.ui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.BevelBorder;

import pedrociarlini.mesaderpg.ui.action.IniciarChatAction;
import pedrociarlini.mesaderpg.ui.action.RolarDadosAction;
import pedrociarlini.mesaderpg.util.MessagesUtil;

public class PanelJogadores extends JPanel {

	private static final long serialVersionUID = 1L;

	private JPanel panelBotoes = null;

	private JButton buttonEnviarMensagem = null;

	private JButton buttonRolarDados = null;

	private ListaJogadores listJogadores = null;

	private RolarDadosAction rolarDadosAction = null; // @jve:decl-index=0:visual-constraint="236,15"

	private IniciarChatAction iniciarChatAction = null; // @jve:decl-index=0:visual-constraint="240,59"

	private JScrollPane scrollPaneJogadores = null;

	private JButton btTesteComponent = null;

	/**
	 * This is the default constructor
	 */
	public PanelJogadores() {
		super();
		initialize();
	}

	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private void initialize() {
		BorderLayout borderLayout = new BorderLayout();
		borderLayout.setHgap(0);
		borderLayout.setVgap(0);
		this.setLayout(borderLayout);
		this.setSize(154, 224);
		this.add(getScrollPaneJogadores(), BorderLayout.CENTER);
		this.add(getPanelBotoes(), BorderLayout.SOUTH);
	}

	/**
	 * This method initializes panelBotoes
	 * 
	 * @return javax.swing.JPanel
	 */
	private JPanel getPanelBotoes() {
		if (panelBotoes == null) {
			GridLayout gridLayout1 = new GridLayout();
			gridLayout1.setRows(3);
			gridLayout1.setColumns(1);
			panelBotoes = new JPanel();
			panelBotoes.setLayout(gridLayout1);
			panelBotoes.add(getButtonEnviarMensagem(), null);
			panelBotoes.add(getButtonRolarDados(), null);
			panelBotoes.add(getBtTesteComponent(), null);
		}
		return panelBotoes;
	}

	/**
	 * This method initializes buttonEnviarMensagem
	 * 
	 * @return javax.swing.JButton
	 */
	private JButton getButtonEnviarMensagem() {
		if (buttonEnviarMensagem == null) {
			buttonEnviarMensagem = new JButton();
			buttonEnviarMensagem.setAction(getIniciarChatAction());
			buttonEnviarMensagem.setText(MessagesUtil
					.getString("PanelJogadores.button.enviarMensagem")); //$NON-NLS-1$
			buttonEnviarMensagem.setFont(new Font("Dialog", Font.BOLD, 10)); //$NON-NLS-1$
		}
		return buttonEnviarMensagem;
	}

	/**
	 * This method initializes buttonRolarDados
	 * 
	 * @return javax.swing.JButton
	 */
	private JButton getButtonRolarDados() {
		if (buttonRolarDados == null) {
			buttonRolarDados = new JButton();
			buttonRolarDados.setPreferredSize(new Dimension(94, 24));
			buttonRolarDados.setAction(getRolarDadosAction());
			buttonRolarDados.setFont(new Font("Dialog", Font.BOLD, 10)); //$NON-NLS-1$
			buttonRolarDados.setText(MessagesUtil
					.getString("PanelJogadores.button.rolarDados")); //$NON-NLS-1$
		}
		return buttonRolarDados;
	}

	/**
	 * This method initializes listJogadores
	 * 
	 * @return javax.swing.JList
	 */
	public ListaJogadores getListJogadores() {
		if (listJogadores == null) {
			listJogadores = new ListaJogadores();
		}
		return listJogadores;
	}

	/**
	 * This method initializes rolarDadosAction
	 * 
	 * @return pedrociarlini.rolardados.ui.RolarDadosAction
	 */
	RolarDadosAction getRolarDadosAction() {
		if (rolarDadosAction == null) {
			rolarDadosAction = new RolarDadosAction();
		}
		return rolarDadosAction;
	}

	/**
	 * This method initializes iniciarChatAction
	 * 
	 * @return pedrociarlini.mesaderpg.ui.action.IniciarChatAction
	 */
	public IniciarChatAction getIniciarChatAction() {
		if (iniciarChatAction == null) {
			iniciarChatAction = new IniciarChatAction();
			iniciarChatAction.putValue(IniciarChatAction.JLIST_JOGADORES,
					getListJogadores());
		}
		return iniciarChatAction;
	}

	/**
	 * This method initializes scrollPaneJogadores	
	 * 	
	 * @return javax.swing.JScrollPane	
	 */
	private JScrollPane getScrollPaneJogadores() {
		if (scrollPaneJogadores == null) {
			scrollPaneJogadores = new JScrollPane();
			scrollPaneJogadores.setViewportBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED));
			scrollPaneJogadores.setPreferredSize(new Dimension(200, 100));
			scrollPaneJogadores.setViewportView(getListJogadores());
		}
		return scrollPaneJogadores;
	}

	/**
	 * This method initializes btTesteComponent	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getBtTesteComponent() {
		if (btTesteComponent == null) {
			btTesteComponent = new JButton();
			btTesteComponent.setFont(new Font("Dialog", Font.BOLD, 10));
			btTesteComponent.setText("Teste de componente");
			btTesteComponent.setPreferredSize(new Dimension(94, 24));
			btTesteComponent.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					getListJogadores().inseirJogador(
									new JogadorComponent(
											JanelaConfigurarJogador
													.showJogadorDialog()));
				}
			});
		}
		return btTesteComponent;
	}

} // @jve:decl-index=0:visual-constraint="10,10"
