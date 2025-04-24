import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean salir = false;

        // Lista monedas
        String[] monedas = {"USD", "EUR", "JPY", "GBP", "MXN", "BRL", "CNY", "COP"};

        // Menu recurrente

        do {
            System.out.println("\n++++ Conversor de Monedas ++++");
            System.out.println("(1) Convertir moneda");
            System.out.println("(2) Convertir a multiples monedas");
            System.out.println("(0) Salir");
            System.out.print("Seleccione una opción: ");

            int opcion = sc.nextInt();

            switch (opcion) {
                case 0:
                    salir = true;
                    System.out.println("¡Hasta luego!");
                    break;
                case 1:
                    covertirMoneda(sc, monedas, false);
                    break;
                case 2:
                    covertirMoneda(sc, monedas, true);
                    break;
                default:
                    System.out.println("❌ Opción invalida. Intente de nuevo.");
            }
        } while (!salir);

        sc.close();
    }

    private static void covertirMoneda(Scanner sc, String[] monedas, boolean multiples) {
        try {
            //Mostrar monedas disponibles
            System.out.println("\nMonedas disponible: ");
            for (int i = 0; i < monedas.length; i++) {
                System.out.printf("%d. %s%n", i + 1, monedas[i]);
            }

            //Selección de moneda origen
            System.out.print("Seleccione moneda origen(número): ");
            int indexOrigen = sc.nextInt() - 1;
            String monedaOrigen = monedas[indexOrigen];

            //Selección moneda destino
            System.out.print("Seleccione moneda destino(número): ");
            int indexDestino = sc.nextInt() - 1;
            String monedaDestino = monedas[indexDestino];

            //Monto
            System.out.print("Dígite monto a convertir: ");
            double monto = sc.nextDouble();

            //Llamado a la ConexionAPI y convertir
            String json = ConexionAPI.obtenerTazasDeCambio(monedaOrigen);
            double resultado = Conversor.convertir(json, monedaOrigen, monedaDestino, monto);

            //Mostrar resultado
            System.out.printf("\n%.2f %s = %.2f %s%n", monto, monedaOrigen, resultado, monedaDestino);

        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}
