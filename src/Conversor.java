import com.google.gson.*;
import org.json.JSONObject;

public class Conversor {

    public static double convertir(String json, String monedaOrigen, String monedaDestino, double cantidad) {
        JSONObject jsonObject = new JSONObject(json);
        JSONObject tasas = jsonObject.getJSONObject("conversion_rates");

        double tasaOrigen = tasas.getDouble(monedaOrigen);
        double tasaDestino = tasas.getDouble(monedaDestino);

        return cantidad * (tasaDestino / tasaOrigen);
    }

    public static void convertirAMultiple(String json, String monedaOrigen, String[] monedasDestino, double cantidad) {
        JSONObject tasas = new JSONObject(json).getJSONObject("conversion_rates");
        double tasaOrigen = tasas.getDouble(monedaOrigen);

        System.out.println("\nConversiones desde " + monedaOrigen + ":");
        for (String moneda : monedasDestino) {
            double tasaDestino = tasas.getDouble(moneda);
            double resultado = cantidad * (tasaDestino / tasaOrigen);
            System.out.printf("%.2f %s = %.2f %s%n", cantidad, monedaOrigen, resultado, moneda);
        }
    }


}
