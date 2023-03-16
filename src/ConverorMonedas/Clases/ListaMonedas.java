package ConverorMonedas.Clases;

import java.io.*;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import okhttp3.*;

public class ListaMonedas {

	public static void cargarMonedas() throws IOException {
		Moneda.resetListaTipoCambio();
		OkHttpClient client = new OkHttpClient().newBuilder().build();

		Request request = new Request.Builder().url("https://api.apilayer.com/currency_data/list")
				.addHeader("apikey", "QbauOc7WIJNHa6Jfj74IGbXvmOYGBIoj").build();

		Response response = client.newCall(request).execute();

		String listaMonedas = response.body().string();

		Gson gson = new Gson();
		JsonObject jsonObject = gson.fromJson(listaMonedas, JsonObject.class);
		JsonElement currencies = jsonObject.getAsJsonObject("currencies");

		for (String abbreviation : ((JsonObject) currencies).keySet()) {
			Moneda.addMoneda(abbreviation);
		}
	}

	public static void main(String[] args) throws IOException {

	}

}
