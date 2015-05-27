
public class ConversorDolares3 {

	private static VentanaConversorDolares3 vcd3;
	private static float valorConversionDolares = 1.25f;
	private static float valorConversionLibras = 0.73f;
	private static float valorConversionYens = 131.103f;
	
	public static void main(String[] args) {
		vcd3 = new VentanaConversorDolares3(valorConversionDolares,valorConversionLibras,valorConversionYens);
		vcd3.setVisible(true);

	}

}
