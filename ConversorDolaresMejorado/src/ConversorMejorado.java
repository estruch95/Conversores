
public class ConversorMejorado {

	private static VentanaConversorMejorado vcm;
	private static float valorConversion=1.25f;
	
	public static void main(String[] args) {
		vcm = new VentanaConversorMejorado(valorConversion);
		vcm.setVisible(true);

	}

}
