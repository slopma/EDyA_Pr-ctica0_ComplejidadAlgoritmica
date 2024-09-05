import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

public class BucketSort {
    // Metodo para realizar Bucket Sort
    public static void bucketSort(String[] arr) {
        ArrayList<String>[] buckets = new ArrayList[27]; // 26 letras del alfabeto + 1 para caracteres especiales

        // Inicializamos los buckets
        for (int i = 0; i < buckets.length; i++) {
            buckets[i] = new ArrayList<>();
        }

        // Distribuimos las palabras en los buckets según la primera letra
        for (String s : arr) {
            if (s == null) continue;  // Evitar valores null

            char firstChar = s.toLowerCase().charAt(0);

            // Verificamos si la primera letra está entre 'a' y 'z'
            if (firstChar >= 'a' && firstChar <= 'z') {
                int bucketIndex = firstChar - 'a'; // Índice del bucket
                buckets[bucketIndex].add(s);
            } else {
                // Si no empieza con 'a' - 'z', la asignamos al bucket especial (27)
                buckets[26].add(s);
            }
        }

        // Ordenamos cada bucket
        for (ArrayList<String> bucket : buckets) {
            Collections.sort(bucket);
        }

        // Unimos todos los buckets en el arreglo original
        int index = 0;
        for (ArrayList<String> bucket : buckets) {
            for (String s : bucket) {
                arr[index++] = s;
            }
        }
    }

    // Función para leer las primeras 'n' palabras del archivo
    public static String[] leerPalabras(String filename, int numPalabras) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(filename), "ISO-8859-1"));
        String[] palabras = new String[numPalabras];
        int count = 0;

        String linea;
        while ((linea = reader.readLine()) != null && count < numPalabras) {
            if (!linea.trim().isEmpty()) {  // Verificamos que la línea no esté vacía
                palabras[count++] = linea;
            }
        }
        reader.close();
        return palabras;
    }

    public static void main(String[] args) throws IOException {
        // Cambia esta ruta por la correcta
        String filename = "C:\\Users\\slopezm13\\Desktop\\EDyA_Práctica0_ComplejidadAlgoritmica\\palabras\\palabras.es";

        // Medimos el tiempo total para todas las corridas
        long tiempoTotalInicio = System.currentTimeMillis();

        // Recorremos 25 corridas, empezando con 10,000 palabras
        for (int corrida = 1; corrida <= 25; corrida++) {
            int numPalabras = corrida * 10000; // Incremento de 10,000 palabras
            String[] palabras = leerPalabras(filename, numPalabras);

            // Tomamos el tiempo antes de empezar cada corrida
            long inicio = System.currentTimeMillis();

            // Ejecutamos Bucket Sort
            bucketSort(palabras);

            // Tomamos el tiempo al finalizar cada corrida
            long fin = System.currentTimeMillis();

            // Calculamos el tiempo total en segundos
            double tiempoSegundos = (fin - inicio) / 1000.0;

            // Imprimimos el número de la corrida y el tiempo
            System.out.println(corrida + ". Número de palabras: " + numPalabras + " - Tiempo (Bucket Sort): " + tiempoSegundos + " segundos");
        }

        // Calculamos el tiempo total de las 25 corridas
        long tiempoTotalFin = System.currentTimeMillis();
        double tiempoTotalSegundos = (tiempoTotalFin - tiempoTotalInicio) / 1000.0;

        // Imprimimos el tiempo total de ejecución
        System.out.println("Tiempo total de ejecución para las 25 corridas: " + tiempoTotalSegundos + " segundos");
    }
}
