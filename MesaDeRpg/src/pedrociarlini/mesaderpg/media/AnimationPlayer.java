package pedrociarlini.mesaderpg.media;


public class AnimationPlayer {
	public static void main(String[] args) {
		/*
        try {
			String file;
			file = "file://"
					+ "C:\\Pedro\\downloads\\mrkite.mp3"
							.replaceAll("\\\\", "/");
        */
			/*file = "file://"
				+ "C:\\Pedro\\Pessoal\\Music\\EtCircensis\\V005.WAV"
						.replaceAll("\\\\", "/");
			*/
			/*
			file = "file://"
				+ "C:/Pedro/Meus arquivos recebidos/EmergencyLanding.in.a.hightway.avi"
						.replaceAll("\\\\", "/");
			*/
			// Manager.setHint(Manager.LIGHTWEIGHT_RENDERER, true);
            /*
			Player p = Manager.createRealizedPlayer(new URL(file));
			for (Control control : p.getControls()) {
				System.out.println(control);
			}
			JFrame janela = new JFrame("Teste de player");
			JPanel panel = new JPanel();
			janela.getContentPane().add(panel);
			janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			panel.setLayout(new BorderLayout(10, 10));
			if (p.getVisualComponent() != null) {
				panel.add(p.getVisualComponent(), BorderLayout.CENTER);
			}
			panel.add(p.getControlPanelComponent(), BorderLayout.SOUTH);
			final GainControl gainControl = p.getGainControl();
			final JLabel labelVolume = new JLabel("" + gainControl.getLevel());
			panel.add(labelVolume, BorderLayout.WEST);
			
			JSlider slider = new JSlider(0, 1000);
			slider.setOrientation(JSlider.VERTICAL);
			slider.addChangeListener(new ChangeListener(){
				public void stateChanged(ChangeEvent e) {
					gainControl.setDB(((JSlider)e.getSource()).getValue()/1000);
					labelVolume.setText(""+gainControl.getLevel()/1000);
					
				}
			});
			panel.add((Component)p.getControls()[3], BorderLayout.EAST);
			janela.setSize(400, 300);
			janela.setVisible(true);
			p.start();
		} catch (NoPlayerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (CannotRealizeException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        */
	}
}
