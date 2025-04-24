package com.ferchoo.conversor;

import java.io.FileInputStream;
import java.net.URI;
import java.net.URL;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Properties;

public class ConexionAPI {
    private static String API_KEY;

    static {
        try{
            Properties props = new Properties();
            props.load(new FileInputStream("/src/config.properties"));
            API_KEY = props.getProperty("API_KEY");
        } catch (Exception e) {
            System.err.println(" Error al cargar la API key: " + e.getMessage());
        }
    }

    private static final String BASE_URL = "https://v6.exchangerate-api.com/v6/" + API_KEY + "/latest/";

    public static String obtenerTazasDeCambio(String monedaBase) throws Exception {
        URL url = new URL(BASE_URL + monedaBase);
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(String.valueOf(url)))
                .build();

        HttpResponse<String> response = client
                .send(request, HttpResponse.BodyHandlers.ofString());

        return response.body();
    }
}
