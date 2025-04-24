package com.ferchoo.conversor;

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

            //Validar entrada
            int opcion = leerEntero(sc);

            switch (opcion) {
                case 0:
                    salir = true;
                    System.out.println("¡Hasta luego!");
                    break;
                case 1:
                    convertirMoneda(sc, monedas, false);
                    break;
                case 2:
                    convertirMoneda(sc, monedas, true);
                    break;
                default:
                    System.out.println("❌ Opción invalida. Intente de nuevo.");
            }
        } while (!salir);
        sc.close();
    }

    private static void convertirMoneda(Scanner sc, String[] monedas, boolean multiples) {
        try {
            //Mostrar monedas disponibles
            System.out.println("\nMonedas disponibles: ");
            for (int i = 0; i < monedas.length; i++) {
                System.out.printf("%d. %s%n", i + 1, monedas[i]);
            }

            //Selección de moneda origen
            System.out.print("Seleccione moneda origen (número): ");
            int indexOrigen = leerEnteroEnRango(sc, 1, monedas.length) - 1;
            String monedaOrigen = monedas[indexOrigen];

            if (!multiples) {
                //Selección moneda destino
                System.out.print("Seleccione moneda destino (número): ");
                int indexDestino = sc.nextInt() - 1;
                String monedaDestino = monedas[indexDestino];

                //Monto
                System.out.print("Dígite monto a convertir: ");
                double monto = leerDouble(sc);

                //Llamado a la com.ferchoo.conversor.ConexionAPI y convertir
                String json = ConexionAPI.obtenerTazasDeCambio(monedaOrigen);
                double resultado = Conversor.convertir(json, monedaOrigen, monedaDestino, monto);

                //Mostrar resultado
                System.out.printf("\n%.2f %s = %.2f %s%n", monto, monedaOrigen, resultado, monedaDestino);
            } else {
                // Conversion multiples monedas

                System.out.print("Seleccione monedas destino (separadas por coma, ej: 2,4,5): ");
                String[] selecciones = sc.next().split(",");
                String[] monedasDestino = new String[selecciones.length];

                for (int i = 0; i < selecciones.length; i++) {
                    int index = Integer.parseInt(selecciones[i].trim()) - 1;
                    monedasDestino[i] = monedas[index];
                }

                //Monto
                System.out.print("Dígite monto a convertir: ");
                double monto = leerDouble(sc);

                //Llamado a la ConexionAPI y convertir
                String json = ConexionAPI.obtenerTazasDeCambio(monedaOrigen);
                Conversor.convertirAMultiple(json, monedaOrigen, monedasDestino, monto);

            }

        } catch (Exception e) {
            System.err.println("❌ Error: " + e.getMessage());
        }
    }

    // Validacion de entradqs

    private static int leerEntero(Scanner scn) {

        while (!scn.hasNextInt()) {
            System.out.print("❌ Ingrese un número válido: ");
            scn.next(); // Limpia entrada incorrecta
        }
        int n = scn.nextInt();
        scn.nextLine(); // Limpia Buffer
        return n;
    }

    private static int leerEnteroEnRango(Scanner scn, int min, int max) {
        int n;
        do {
            n = leerEntero(scn);
            if (n < min || n > max) {
                System.out.printf("❌ Ingrese un número entre %d y %d: ", min, max);
            }
        } while (n < min || n > max);
        return n;
    }

    private static double leerDouble(Scanner scn) {
        while (!scn.hasNextDouble()) {
            System.out.print("❌ Ingrese un monto válido: ");
            scn.next();
        }
        double n = scn.nextDouble();
        scn.nextLine(); // Limpia Buffer
        return n;
    }

}
