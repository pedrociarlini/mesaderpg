package pedrociarlini.mesaderpg.ui;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import pedrociarlini.mesaderpg.model.JogadorVO;

import java.awt.Font;

public class JanelaConfigurarJogador extends JDialog implements ActionListener {

    private static final long serialVersionUID = 1L;

    private JPanel jContentPane = null;

    private JTextField textFieldNome = null;

    private JLabel labelNome = null;

    private JButton buttonOk = null;

    private JPanel panelBotoes = null;

    private JButton buttonCancelar = null;

    private JCheckBox checkBoxMestre = null;

    private JogadorVO jogadorVO;

    private JLabel labelFicha = null;

    /**
     * This is the default constructor
     */
    public JanelaConfigurarJogador() {
        super();
        initialize();
    }

    /**
     * This method initializes this
     * 
     * @return void
     */
    private void initialize() {
        this.setSize(459, 200);
        this.setContentPane(getJContentPane());
        this.setTitle("Configurar Jogador");
    }

    /**
     * This method initializes jContentPane
     * 
     * @return javax.swing.JPanel
     */
    private JPanel getJContentPane() {
        if (jContentPane == null) {
            GridBagConstraints gridBagConstraints4 = new GridBagConstraints();
            gridBagConstraints4.gridx = 0;
            gridBagConstraints4.gridwidth = 2;
            gridBagConstraints4.gridy = 2;
            labelFicha = new JLabel();
            labelFicha
                    .setText("Vale a pena configurar esalvar a ficha também? "
                            + "pedrociarlini@gmail.com");
            labelFicha.setFont(new Font("Dialog", Font.PLAIN, 10));
            GridBagConstraints gridBagConstraints3 = new GridBagConstraints();
            gridBagConstraints3.gridx = 0;
            gridBagConstraints3.gridwidth = 2;
            gridBagConstraints3.gridy = 1;
            GridBagConstraints gridBagConstraints = new GridBagConstraints();
            gridBagConstraints.gridx = -1;
            gridBagConstraints.gridy = -1;
            GridBagConstraints gridBagConstraints2 = new GridBagConstraints();
            gridBagConstraints2.gridx = 0;
            gridBagConstraints2.gridwidth = 2;
            gridBagConstraints2.fill = GridBagConstraints.HORIZONTAL;
            gridBagConstraints2.gridy = 3;
            GridBagConstraints gridBagConstraints11 = new GridBagConstraints();
            gridBagConstraints11.gridx = 0;
            gridBagConstraints11.insets = new Insets(5, 5, 5, 5);
            gridBagConstraints11.gridy = 0;
            labelNome = new JLabel();
            labelNome.setText("Nome:");
            GridBagConstraints gridBagConstraints1 = new GridBagConstraints();
            gridBagConstraints1.gridx = 1;
            gridBagConstraints1.fill = GridBagConstraints.HORIZONTAL;
            gridBagConstraints1.insets = new Insets(5, 5, 5, 5);
            gridBagConstraints1.gridwidth = 1;
            gridBagConstraints1.gridy = 0;
            jContentPane = new JPanel();
            jContentPane.setLayout(new GridBagLayout());
            jContentPane.add(getTextFieldNome(), gridBagConstraints1);
            jContentPane.add(labelNome, gridBagConstraints11);
            jContentPane.add(getPanelBotoes(), gridBagConstraints2);
            jContentPane.add(getCheckBoxMestre(), gridBagConstraints3);
            jContentPane.add(labelFicha, gridBagConstraints4);
        }
        return jContentPane;
    }

    /**
     * This method initializes textFieldNome
     * 
     * @return javax.swing.JTextField
     */
    private JTextField getTextFieldNome() {
        if (textFieldNome == null) {
            textFieldNome = new JTextField();
            textFieldNome.setPreferredSize(new Dimension(150, 20));
        }
        return textFieldNome;
    }

    /**
     * This method initializes buttonOk
     * 
     * @return javax.swing.JButton
     */
    private JButton getButtonOk() {
        if (buttonOk == null) {
            buttonOk = new JButton();
            buttonOk.setText("Ok");
            buttonOk.addActionListener(this);
        }
        return buttonOk;
    }

    /**
     * This method initializes panelBotoes
     * 
     * @return javax.swing.JPanel
     */
    private JPanel getPanelBotoes() {
        if (panelBotoes == null) {
            panelBotoes = new JPanel();
            panelBotoes.setLayout(new FlowLayout());
            panelBotoes.add(getButtonOk(), null);
            panelBotoes.add(getButtonCancelar(), null);
        }
        return panelBotoes;
    }

    /**
     * This method initializes buttonCancelar
     * 
     * @return javax.swing.JButton
     */
    private JButton getButtonCancelar() {
        if (buttonCancelar == null) {
            buttonCancelar = new JButton();
            buttonCancelar.setText("Cancelar");
            buttonCancelar.addActionListener(this);
        }
        return buttonCancelar;
    }

    /**
     * This method initializes checkBoxMestre
     * 
     * @return javax.swing.JCheckBox
     */
    private JCheckBox getCheckBoxMestre() {
        if (checkBoxMestre == null) {
            checkBoxMestre = new JCheckBox();
            checkBoxMestre.setText("Mestre");
        }
        return checkBoxMestre;
    }

    public static JogadorVO showJogadorDialog() {
        JanelaConfigurarJogador janela = new JanelaConfigurarJogador(); // @ivj
        janela.setModal(true);
        janela.setVisible(true);
        return janela.jogadorVO;
    } // @ijv

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == getButtonOk()) {
            this.jogadorVO = new JogadorVO(getTextFieldNome().getText(),
                    getCheckBoxMestre().isSelected());
            dispose();
        }
        else if (e.getSource() == getButtonCancelar()) {
            dispose();
        }
    }

} // @jve:decl-index=0:visual-constraint="10,10"
