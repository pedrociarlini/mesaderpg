package pedrociarlini.mesaderpg.model;

public class JogadorVOTest {
	public static void main(String[] args) {
		testEquals();
	}
	
	private static void testEquals() {
		JogadorVO j1, j2, j3;
		j1 = new JogadorVO("pedro", false);
		j2 = new JogadorVO("pEDRo", true);
		j3 = new JogadorVO("pED Ro", true);
		System.out.println(j1.equals(j2));
		System.out.println(j2.equals(j3));
	}
}
