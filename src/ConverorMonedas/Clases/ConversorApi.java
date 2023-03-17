package ConverorMonedas.Clases;

import java.io.*;
import okhttp3.*;
import org.json.*;

public class ConversorApi {

	public static double converor(String from, String to, double value) throws IOException {
		OkHttpClient client = new OkHttpClient().newBuilder().build();

		Request request = new Request.Builder()
				.url("https://api.apilayer.com/currency_data/convert?to=" + to + "&from=" + from + "&amount=" + value
						+ "")
				.addHeader("apikey", "sYxJqm8A7hNbi9VfuNaFpGlVvLu0Y0OC")

				.build();
		Response response = client.newCall(request).execute();
		// System.out.println(response.body().string());

		String responseBody = response.body().string();

		// Parseamos la respuesta JSON para obtener el valor de la conversión
		JSONObject jsonResponse = new JSONObject(responseBody);

		double conversionResult = jsonResponse.getDouble("result");
		return conversionResult;

	}
}
