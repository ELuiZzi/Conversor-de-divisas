package clases;

import java.text.DecimalFormat;

public class Redondear {
	
	
	public static double reducirDecimales(double numero) {
		DecimalFormat numDecimales = new DecimalFormat("#.####");
		
		return Double.parseDouble(numDecimales.format(numero));
	}
		
	
}
