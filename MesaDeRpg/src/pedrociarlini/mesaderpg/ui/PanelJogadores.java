package pedrociarlini.mesaderpg.ui;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JPanel;

import pedrociarlini.mesaderpg.ui.action.RolarDadosAction;

public class PanelJogadores extends JPanel {

    private static final long serialVersionUID = 1L;

    private JPanel panelBotoes = null;

    private JButton buttonEnviarMensagem = null;

    private JButton buttonRolarDados = null;

    private JList listJogadores = null;

    private RolarDadosAction rolarDadosAction = null;  //  @jve:decl-index=0:visual-constraint="236,15"

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
        this.add(getPanelBotoes(), BorderLayout.SOUTH);
        this.add(getListJogadores(), BorderLayout.CENTER);
    }

    /**
     * This method initializes panelBotoes
     * 
     * @return javax.swing.JPanel
     */
    private JPanel getPanelBotoes() {
        if (panelBotoes == null) {
            GridBagConstraints gridBagConstraints1 = new GridBagConstraints();
            gridBagConstraints1.gridx = 0;
            gridBagConstraints1.fill = GridBagConstraints.HORIZONTAL;
            gridBagConstraints1.gridy = 1;
            GridBagConstraints gridBagConstraints = new GridBagConstraints();
            gridBagConstraints.fill = GridBagConstraints.HORIZONTAL;
            panelBotoes = new JPanel();
            panelBotoes.setLayout(new GridBagLayout());
            panelBotoes.add(getButtonEnviarMensagem(), gridBagConstraints);
            panelBotoes.add(getButtonRolarDados(), gridBagConstraints1);
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
            buttonEnviarMensagem.setText("Enviar mensagem");
            buttonEnviarMensagem.setFont(new Font("Dialog", Font.BOLD, 10));
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
            buttonRolarDados.setAction(getRolarDadosAction());
            buttonRolarDados.setFont(new Font("Dialog", Font.BOLD, 10));
            buttonRolarDados.setText("Rolar dados");
        }
        return buttonRolarDados;
    }

    /**
     * This method initializes listJogadores
     * 
     * @return javax.swing.JList
     */
    public JList getListJogadores() {
        if (listJogadores == null) {
            listJogadores = new JList();
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

} // @jve:decl-index=0:visual-constraint="10,10"
