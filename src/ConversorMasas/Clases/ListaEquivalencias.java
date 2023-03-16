package ConversorMasas.Clases;

import java.io.IOException;
import java.util.*;

public class ListaEquivalencias {

	public ListaEquivalencias() {
		cargarMasas();
	}

	private static Map<String, Double> listaMasas = new HashMap<>();
	private static List<String> listaMasasTexto = new ArrayList<>();
	
	

	public static List<String> getListaMasasTexto() {
		return listaMasasTexto;
	}

	public static void cargarMasas() {
		listaMasas.put("lb", 2.20462d);
		listaMasas.put("t", 0.001d);
		listaMasas.put("kg", 1d);
		listaMasas.put("g", 1000d);
		listaMasas.put("oz", 35.274d);

		listaMasasTexto.add("Libra");
		listaMasasTexto.add("Tonelada");
		listaMasasTexto.add("Kilogramo");
		listaMasasTexto.add("Gramo");
		listaMasasTexto.add("Onza");

	}

	private static double convertir(String from, String to, double amount) {

		Double fromValue = listaMasas.get(from);
		Double toValue = listaMasas.get(to);

		return (amount / fromValue) * toValue;
	}

	public static double convertirMasas(String fromText, String toText, double amount) throws IOException{
		cargarMasas();
		String from = null, to = null;

		switch (fromText) {
		case "Libra":
			from = "lb";
			break;

		case "Tonelada":
			from = "t";
			break;
		case "Kilogramo":
			from = "kg";
			break;
		case "Gramo":
			from = "g";
			break;
		case "Onza":
			from = "oz";
			break;
		default:
			break;
		}

		switch (toText) {
		case "Libra":
			to = "lb";
			break;

		case "Tonelada":
			to = "t";
			break;
		case "Kilogramo":
			to = "kg";
			break;
		case "Gramo":
			to = "g";
			break;
		case "Onza":
			to = "oz";
			break;

		default:
			break;
		}

		return convertir(from, to, amount);
	}

}
