
public class DatosGenerales {

	private static float vcDolares = 1.25f;
	private static float vcLibras = 0.73f;
	private static float vcYens = 131.103f;
	private static String tiposMoneda[] ={"DOLARES","LIBRAS","YENS"};

	public DatosGenerales(){
		
	}

	public static float getVcDolares(){
		return vcDolares;
	}
	
	public static float getVcLibras(){
		return vcLibras;
	}
	
	public static float getVcYens(){
		return vcYens;
	}
	
	public static String[] getTiposMoneda(){
		return tiposMoneda;
	}
}
	