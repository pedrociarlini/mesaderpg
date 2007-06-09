package pedrociarlini.mesaderpg.ui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;

import pedrociarlini.mesaderpg.business.JogadoresBusiness;
import pedrociarlini.mesaderpg.business.ServidorBusiness;
import pedrociarlini.mesaderpg.ui.action.ConectarJogadorAction;
import pedrociarlini.mesaderpg.ui.action.ConfigurarJogadorAction;
import pedrociarlini.mesaderpg.ui.action.ConfigurarServidorAction;
import pedrociarlini.mesaderpg.ui.action.RolarDadosAction;
import pedrociarlini.mesaderpg.ui.action.VisualizarArenaAction;
import pedrociarlini.mesaderpg.util.MessagesUtil;

public class JanelaPrincipal extends JFrame {

	private static final long serialVersionUID = 1L;

	private JPanel principalPane = null;

	private JMenu menuVisualizar = null;

	private JMenuItem menuItemArena = null;

	private JMenu menuConfigurar = null;

	private JMenuItem menuItemJogador = null;

	private JMenuItem menuItemChat = null;

	private JMenuBar menuBarPrincipal = null;

	private JMenuItem menuItemServidor = null;

	private JMenu menuConectar = null;

	private JPanel panelStatus = null;

	private JSplitPane splitPane = null;

	private JEditorPane editorPaneMensagens = null;

	private JSplitPane splitPanePrincipal = null;

	private JPanel panelResultados = null;

	private PanelJogadores panelJogadores = null;

	private ConfigurarJogadorAction configurarJogadorAction = null; // @jve:decl-index=0:visual-constraint="708,71"

	private VisualizarArenaAction visualizarArenaAction = null; // @jve:decl-index=0:visual-constraint="716,10"

	private JScrollPane scrollPane = null;

	private JMenuItem menuItemConectarJogador = null;

	private ConectarJogadorAction conectarJogadorAction = null; // @jve:decl-index=0:visual-constraint="714,126"

	private ConfigurarServidorAction configurarServidorAction = null; // @jve:decl-index=0:visual-constraint="705,172"

	private PanelServidorStatus panelServidorStatus = null;

	/**
	 * This is the default constructor
	 */
	public JanelaPrincipal() {
		// TODO Implementar classe de barra de status.
		super();
		initialize();
	}

	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private void initialize() {
		this.setSize(626, 441);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setJMenuBar(getMenuBarPrincipal());
		this.setContentPane(getPrincipalPane());
		this
				.setTitle(MessagesUtil
						.getString("JanelaPrincipal.application.name")
						+ MessagesUtil
								.getString("JanelaPrincipal.application.version")); //$NON-NLS-1$ //$NON-NLS-2$
	}

	/**
	 * This method initializes principalPane
	 * 
	 * @return javax.swing.JPanel
	 */
	private JPanel getPrincipalPane() {
		if (principalPane == null) {
			principalPane = new JPanel();
			principalPane.setLayout(new BorderLayout());
			principalPane.add(getPanelStatus(), BorderLayout.SOUTH);
			principalPane.add(getSplitPanePrincipal(), BorderLayout.CENTER);
		}
		return principalPane;
	}

	/**
	 * This method initializes menuConfigurar
	 * 
	 * @return javax.swing.JMenu
	 */
	private JMenu getMenuConfigurar() {
		if (menuConfigurar == null) {
			menuConfigurar = new JMenu();
			menuConfigurar.setText(MessagesUtil
					.getString("JanelaPrincipal.menu.configurar")); //$NON-NLS-1$
			menuConfigurar.add(getMenuItemJogador());
			menuConfigurar.add(getMenuItemServidor());
		}
		return menuConfigurar;
	}

	/**
	 * This method initializes menuConfigurar
	 * 
	 * @return javax.swing.JMenu
	 */
	private JMenu getMenuVisualizar() {
		if (menuVisualizar == null) {
			menuVisualizar = new JMenu();
			menuVisualizar.setText(MessagesUtil
					.getString("JanelaPrincipal.menu.visualizar")); //$NON-NLS-1$
			menuVisualizar.add(getMenuItemArena());
		}
		return menuVisualizar;
	}

	/**
	 * This method initializes menuItemJogador
	 * 
	 * @return javax.swing.JMenuItem
	 */
	private JMenuItem getMenuItemArena() {
		if (menuItemArena == null) {
			menuItemArena = new JMenuItem();
			menuItemArena.setAction(getVisualizarArenaAction());
			menuItemArena.setText(MessagesUtil
					.getString("JanelaPrincipal.menu.item.arena")); //$NON-NLS-1$
		}
		return menuItemArena;
	}

	/**
	 * This method initializes menuItemJogador
	 * 
	 * @return javax.swing.JMenuItem
	 */
	private JMenuItem getMenuItemChat() {
		if (menuItemChat == null) {
			menuItemChat = new JMenuItem();
			menuItemChat.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					String nome = ((JogadorComponent) getPanelJogadores()
							.getListJogadores().getSelectedValue())
							.getJogador().getNome();
					JanelaChat chat = new JanelaChat(JogadoresBusiness.getJogador(nome));
				}
			});
			menuItemChat.setText("Chat");
		}
		return menuItemChat;
	}

	/**
	 * This method initializes menuItemJogador
	 * 
	 * @return javax.swing.JMenuItem
	 */
	private JMenuItem getMenuItemJogador() {
		if (menuItemJogador == null) {
			menuItemJogador = new JMenuItem();
			menuItemJogador.setAction(getConfigurarJogadorAction());
			menuItemJogador.setText(MessagesUtil
					.getString("JanelaPrincipal.menu.item.jogador")); //$NON-NLS-1$
			getConfigurarJogadorAction().putValue(
					ConfigurarJogadorAction.JOGADOR_VO,
					JogadoresBusiness.getJogadorLocal());
		}
		return menuItemJogador;
	}

	/**
	 * This method initializes menuBarPrincipal
	 * 
	 * @return javax.swing.JMenuBar
	 */
	private JMenuBar getMenuBarPrincipal() {
		if (menuBarPrincipal == null) {
			menuBarPrincipal = new JMenuBar();
			menuBarPrincipal.add(getMenuConfigurar());
			menuBarPrincipal.add(getMenuConectar());
			menuBarPrincipal.add(getMenuVisualizar());
		}
		return menuBarPrincipal;
	}

	/**
	 * This method initializes menuItemServidor
	 * 
	 * @return javax.swing.JMenuItem
	 */
	private JMenuItem getMenuItemServidor() {
		if (menuItemServidor == null) {
			menuItemServidor = new JMenuItem();
			menuItemServidor.setAction(getConfigurarServidorAction());
			menuItemServidor.setText("Servidor"); //$NON-NLS-1$
			getConfigurarServidorAction().putValue(
					ConfigurarServidorAction.SERVIDOR_VO,
					ServidorBusiness.getConfiguracaoServidor());
		}
		return menuItemServidor;
	}

	/**
	 * This method initializes menuConectar
	 * 
	 * @return javax.swing.JMenu
	 */
	private JMenu getMenuConectar() {
		if (menuConectar == null) {
			menuConectar = new JMenu();
			menuConectar.setText(MessagesUtil
					.getString("JanelaPrincipal.menu.conectar")); //$NON-NLS-1$
			menuConectar.add(getMenuItemConectarJogador());
			menuConectar.add(getMenuItemChat());
		}
		return menuConectar;
	}

	/**
	 * This method initializes panelStatus
	 * 
	 * @return javax.swing.JPanel
	 */
	private JPanel getPanelStatus() {
		if (panelStatus == null) {
			FlowLayout flowLayout1 = new FlowLayout();
			flowLayout1.setAlignment(java.awt.FlowLayout.LEFT);
			flowLayout1.setVgap(0);
			flowLayout1.setHgap(0);
			panelStatus = new JPanel();
			panelStatus.setLayout(flowLayout1);
			panelStatus.setPreferredSize(new Dimension(5, 25));
			panelStatus.add(getPanelServidorStatus(), null);
		}
		return panelStatus;
	}

	/**
	 * This method initializes splitPane
	 * 
	 * @return javax.swing.JSplitPane
	 */
	private JSplitPane getSplitPane() {
		if (splitPane == null) {
			splitPane = new JSplitPane();
			splitPane.setOrientation(JSplitPane.VERTICAL_SPLIT);
			splitPane.setPreferredSize(new Dimension(300, 118));
			splitPane.setDividerLocation(100);
			splitPane.setBottomComponent(getPanelResultados());
			splitPane.setTopComponent(getScrollPane());
			splitPane.setOneTouchExpandable(true);
		}
		return splitPane;
	}

	/**
	 * This method initializes editorPaneMensagens
	 * 
	 * @return javax.swing.JEditorPane
	 */
	private JEditorPane getEditorPaneMensagens() {
		if (editorPaneMensagens == null) {
			editorPaneMensagens = new JEditorPane();
			editorPaneMensagens.setPreferredSize(new Dimension(50, 50));
			editorPaneMensagens.setEnabled(true);
			editorPaneMensagens
					.setText("Em breve aqui poderemos trocar mensagens."); //$NON-NLS-1$
		}
		return editorPaneMensagens;
	}

	/**
	 * This method initializes splitPanePrincipal
	 * 
	 * @return javax.swing.JSplitPane
	 */
	private JSplitPane getSplitPanePrincipal() {
		if (splitPanePrincipal == null) {
			splitPanePrincipal = new JSplitPane();
			splitPanePrincipal.setContinuousLayout(true);
			splitPanePrincipal.setDividerLocation(150);
			splitPanePrincipal.setOneTouchExpandable(true);
			splitPanePrincipal.setRightComponent(getSplitPane());
			splitPanePrincipal.setLeftComponent(getPanelJogadores());
		}
		return splitPanePrincipal;
	}

	/**
	 * This method initializes panelResultados
	 * 
	 * @return javax.swing.JPanel
	 */
	JPanel getPanelResultados() {
		if (panelResultados == null) {
			FlowLayout flowLayout = new FlowLayout();
			flowLayout.setAlignment(java.awt.FlowLayout.LEFT);
			flowLayout.setVgap(10);
			flowLayout.setHgap(10);
			panelResultados = new JPanel();
			panelResultados.setLayout(flowLayout);
		}
		return panelResultados;
	}

	/**
	 * This method initializes panelJogadores
	 * 
	 * @return pedrociarlini.rolardados.ui.PanelJogadores
	 */
	public PanelJogadores getPanelJogadores() {
		if (panelJogadores == null) {
			panelJogadores = new PanelJogadores();
			panelJogadores.getRolarDadosAction().putValue(
					RolarDadosAction.PANEL_SAIDA, getPanelResultados());
		}
		return panelJogadores;
	}

	/**
	 * This method initializes configurarJogadorAction
	 * 
	 * @return pedrociarlini.rolardados.ui.action.ConfigurarJogadorAction
	 */
	private ConfigurarJogadorAction getConfigurarJogadorAction() {
		if (configurarJogadorAction == null) {
			configurarJogadorAction = new ConfigurarJogadorAction();
		}
		return configurarJogadorAction;
	}

	/**
	 * This method initializes visualizarArenaAction
	 * 
	 * @return pedrociarlini.rolardados.ui.action.VisualizarArenaAction
	 */
	private VisualizarArenaAction getVisualizarArenaAction() {
		if (visualizarArenaAction == null) {
			visualizarArenaAction = new VisualizarArenaAction();
		}
		return visualizarArenaAction;
	}

	/**
	 * This method initializes scrollPane
	 * 
	 * @return javax.swing.JScrollPane
	 */
	private JScrollPane getScrollPane() {
		if (scrollPane == null) {
			scrollPane = new JScrollPane();
			scrollPane.setViewportView(getEditorPaneMensagens());
		}
		return scrollPane;
	}

	/**
	 * This method initializes menuItemConectarJogador
	 * 
	 * @return javax.swing.JMenuItem
	 */
	private JMenuItem getMenuItemConectarJogador() {
		if (menuItemConectarJogador == null) {
			menuItemConectarJogador = new JMenuItem();
			menuItemConectarJogador.setAction(getConectarJogadorAction());
			menuItemConectarJogador.setText("Jogador");
			getConectarJogadorAction().putValue(
					ConectarJogadorAction.JOGADOR_VO,
					JogadoresBusiness.getJogadorLocal());
			getConectarJogadorAction().putValue(
					ConectarJogadorAction.JOGADOR_LIST,
					getPanelJogadores().getListJogadores());
		}
		return menuItemConectarJogador;
	}

	/**
	 * This method initializes conectarJogadorAction
	 * 
	 * @return pedrociarlini.mesaderpg.ui.action.ConectarJogadorAction
	 */
	private ConectarJogadorAction getConectarJogadorAction() {
		if (conectarJogadorAction == null) {
			conectarJogadorAction = new ConectarJogadorAction();
		}
		return conectarJogadorAction;
	}

	/**
	 * This method initializes configurarServidorAction
	 * 
	 * @return pedrociarlini.mesaderpg.ui.action.ConfigurarServidorAction
	 */
	private ConfigurarServidorAction getConfigurarServidorAction() {
		if (configurarServidorAction == null) {
			configurarServidorAction = new ConfigurarServidorAction();
		}
		return configurarServidorAction;
	}

	/**
	 * This method initializes panelServidorStatus
	 * 
	 * @return pedrociarlini.mesaderpg.ui.PanelServidorStatus
	 */
	private PanelServidorStatus getPanelServidorStatus() {
		if (panelServidorStatus == null) {
			panelServidorStatus = new PanelServidorStatus();
			panelServidorStatus.setListJogadores(getPanelJogadores()
					.getListJogadores());
		}
		return panelServidorStatus;
	}
} // @jve:decl-index=0:visual-constraint="26,5"
