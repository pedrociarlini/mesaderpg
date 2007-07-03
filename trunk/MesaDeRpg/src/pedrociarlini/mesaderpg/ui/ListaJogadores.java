package pedrociarlini.mesaderpg.ui;

import java.awt.Component;
import java.util.ArrayList;
import java.util.List;

import javax.swing.AbstractListModel;
import javax.swing.JList;

public class ListaJogadores extends JList {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7906213362926605471L;
	
	ListaJogadoresModel modelo = new ListaJogadoresModel();
	
	public ListaJogadores() {
		super();
		setModel(modelo);
	}
	
	@Override
	public Component add(Component comp) {
		return super.add(comp);
	}
	
	public void inseirJogador(JogadorComponent jogador) {
		modelo.adicionarJogador(jogador);
	}
	
	public void removerJogador(JogadorComponent jogador) {
		modelo.removerJogador(jogador);
	}

	public class ListaJogadoresModel extends AbstractListModel {
		
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		private List<JogadorComponent> jogadores = new ArrayList<JogadorComponent>();

		public Object getElementAt(int index) {
			return jogadores.get(index);
		}

		public int getSize() {
			return jogadores.size();
		}
		
		public void adicionarJogador(JogadorComponent j) {
			jogadores.add(j);
		}
		
		public void removerJogador(JogadorComponent j) {
			jogadores.remove(j);
		}
	}
}
