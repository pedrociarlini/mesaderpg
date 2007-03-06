package pedrociarlini.rolardados.ui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridBagLayout;

import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JSplitPane;

import pedrociarlini.rolardados.model.JogadorVO;
import pedrociarlini.rolardados.ui.action.RolarDadosAction;
import java.awt.FlowLayout;
import pedrociarlini.rolardados.ui.action.ConfigurarJogadorAction;

public class JanelaPrincipal extends JFrame {

    private static final long serialVersionUID = 1L;

    private JPanel principalPane = null;

    private JMenu menuConfigurar = null;

    private JMenuItem menuItemJogador = null;

    private JMenuBar menuBarPrincipal = null;

    private JMenuItem menuItemConexao = null;

    private JMenu menuConectar = null;

    private JPanel panelStatus = null;

    private JSplitPane splitPane = null;

    private JEditorPane editorPaneMensagens = null;

    private JSplitPane splitPanePrincipal = null;

    private JPanel panelResultados = null;

    private PanelJogadores panelJogadores = null;

    private ConfigurarJogadorAction configurarJogadorAction = null; // @jve:decl-index=0:visual-constraint="624,2"

    private JogadorVO jogador; // @ijv

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
        this.setSize(578, 441);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setJMenuBar(getMenuBarPrincipal());
        this.setContentPane(getPrincipalPane());
        this.setTitle("RolarDados");
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
            menuConfigurar.setText("Configurar");
            menuConfigurar.add(getMenuItemJogador());
            menuConfigurar.add(getMenuItemConexao());
        }
        return menuConfigurar;
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
            menuItemJogador.setText("Jogador");
            getConfigurarJogadorAction().putValue(
                    ConfigurarJogadorAction.JOGADOR_VO, this.jogador);
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
        }
        return menuBarPrincipal;
    }

    /**
     * This method initializes menuItemConexao
     * 
     * @return javax.swing.JMenuItem
     */
    private JMenuItem getMenuItemConexao() {
        if (menuItemConexao == null) {
            menuItemConexao = new JMenuItem();
            menuItemConexao.setText("Conexão");
        }
        return menuItemConexao;
    }

    /**
     * This method initializes menuConectar
     * 
     * @return javax.swing.JMenu
     */
    private JMenu getMenuConectar() {
        if (menuConectar == null) {
            menuConectar = new JMenu();
            menuConectar.setText("Conectar");
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
            panelStatus = new JPanel();
            panelStatus.setLayout(new GridBagLayout());
            panelStatus.setPreferredSize(new Dimension(5, 25));
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
            splitPane.setTopComponent(getEditorPaneMensagens());
            splitPane.setBottomComponent(getPanelResultados());
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
            editorPaneMensagens.setPreferredSize(new Dimension(448, 80));
            editorPaneMensagens.setEnabled(false);
            editorPaneMensagens
                    .setText("Em breve aqui poderemos trocar mensagens.");
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
    private PanelJogadores getPanelJogadores() {
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
} // @jve:decl-index=0:visual-constraint="26,5"
