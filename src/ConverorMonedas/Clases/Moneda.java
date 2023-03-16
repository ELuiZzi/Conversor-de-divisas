package ConverorMonedas.Clases;

import java.util.ArrayList;
import java.util.List;

public abstract class Moneda {

	public Moneda(String link) {
		cargarMoneda(link);
	}

	/*
	 * 
	 * */
	private static List<String> tipoCambio = new ArrayList<String>();

	public static void addMoneda(String key) {
		tipoCambio.add(key);
	}

	public abstract void cargarMoneda(String link);

	public String valor(int key) {
		return Moneda.tipoCambio.get(key);
	}

	public String conversor(int key) {
		return Moneda.tipoCambio.get(key);

	}

	public static List<String> getTipoCambio() {

		return Moneda.tipoCambio;

	}
	
	public static void resetListaTipoCambio() {
		tipoCambio.clear();
	}
	


}
