
public class Conversor {

	private static VentanaConversor vc;
	private static float valorConversion=1.25f;
	
	public static void main(String[] args) {
		vc = new VentanaConversor(valorConversion);
		vc.setVisible(true);
	}

}
