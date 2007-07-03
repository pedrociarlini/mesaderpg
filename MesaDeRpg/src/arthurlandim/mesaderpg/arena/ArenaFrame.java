package arthurlandim.mesaderpg.arena;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

import pedrociarlini.mesaderpg.model.JogadorVO;

public class ArenaFrame extends JFrame implements ArenaInterface {

    /**
     * 
     */
    private static final long serialVersionUID = -7587352830855485212L;

    ArenaCanvas canvas;

    private JPanel panelComandos;

    private JButton btInserir;

    private JPanel principalPane;

	public ArenaFrame() {
        super();
        initialize();
    }

    private void initialize() {
        this.setContentPane(getPrincipalPane());
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        this.setTitle("Arena de jogadores");
        setSize(633, 284);
        setVisible(true);
    }

    /**
     * This method initializes principalPane
     * 
     * @return javax.swing.JPanel
     */
    private JPanel getPrincipalPane() {
        if (principalPane == null) {
            BorderLayout borderLayout = new BorderLayout(1, 0);
            principalPane = new JPanel();
            principalPane.setLayout(borderLayout);
            principalPane.add(getCanvas(), BorderLayout.CENTER);

            principalPane.add(getPanelComandos(), BorderLayout.SOUTH);

        }
        return principalPane;
    }

    private JPanel getPanelComandos() {
        if (panelComandos == null) {
            GridLayout gridLayout = new GridLayout(1, 3);
            gridLayout.setColumns(3);
            panelComandos = new JPanel();
            panelComandos.setLayout(gridLayout);
            panelComandos.add(getBtInserir());
        }
        return panelComandos;
    }

    public static void main(String arg[]) {
        new ArenaFrame();
    }

    public void adicionarJogador(JogadorVO jogador) {
        canvas.adicionarJogador(jogador);
    }

    public void removerJogador(JogadorVO jogador) {
        canvas.removerJogador(jogador);

    }

    public JButton getBtInserir() {
        if (btInserir == null) {
            btInserir = new JButton();
            btInserir.setText("Inserir Jogador");
            btInserir.addActionListener(new java.awt.event.ActionListener() {

                public void actionPerformed(java.awt.event.ActionEvent e) {
                }
            });
        }
        return btInserir;
    }

    public ArenaCanvas getCanvas() {
        if (canvas == null) {
            canvas = new ArenaCanvas();
        }
        return canvas;
    }
} // @jve:decl-index=0:visual-constraint="20,-19"
