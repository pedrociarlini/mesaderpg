package pedrociarlini.mesaderpg.ui.action;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.util.Random;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class RolarDadosAction extends AbstractAction {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    
    public final static String PANEL_SAIDA = "PANEL_SAIDA";

    public final String JOGADORES = "JOGADORES";

    public RolarDadosAction() {
        putValue(Action.NAME, "Rolar dados");
        // putValue(Action.SMALL_ICON, );
        putValue(Action.MNEMONIC_KEY, KeyEvent.VK_R);
        putValue(Action.LONG_DESCRIPTION,
                "Rola os dados para os jogadores selecionados.");
    }

    public void actionPerformed(ActionEvent ev) {
        int quantidadeDados = Integer.parseInt(JOptionPane.showInputDialog(
                "Escolha a quantidade de dados a rolar", "Quantidade"));
        Container panelSaida = (Container)getValue(PANEL_SAIDA);
        Random r = new Random();
        JLabel label;
        for (int i = 0; i < quantidadeDados; i++) {
            label = new JLabel("" + (r.nextInt(10) + 1));
            label.setForeground(Color.RED);
            label.setFont(new Font("Verdana", Font.BOLD, 24));
            panelSaida.add(label);
        }
        panelSaida.validate();
    }
}
