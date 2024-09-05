import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

public class BucketSort {
    // Metodo para realizar Bucket Sort
    public static void bucketSort(String[] arr) {
        ArrayList<String>[] buckets = new ArrayList[27]; 

        for (int i = 0; i < buckets.length; i++) {
            buckets[i] = new ArrayList<>();
        }

        for (String s : arr) {
            if (s == null) continue;  // Evitar valores null

            char firstChar = s.toLowerCase().charAt(0);

            if (firstChar >= 'a' && firstChar <= 'z') {
                int bucketIndex = firstChar - 'a'; 
                buckets[bucketIndex].add(s);
            } else {
                buckets[26].add(s);
            }
        }

        for (ArrayList<String> bucket : buckets) {
            Collections.sort(bucket);
        }

        int index = 0;
        for (ArrayList<String> bucket : buckets) {
            for (String s : bucket) {
                arr[index++] = s;
            }
        }
    }

    // leer las primeras 'n' palabras del archivo
    public static String[] leerPalabras(String filename, int numPalabras) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(filename), "ISO-8859-1"));
        String[] palabras = new String[numPalabras];
        int count = 0;

        String linea;
        while ((linea = reader.readLine()) != null && count < numPalabras) {
            if (!linea.trim().isEmpty()) {  // línea no esté vacía
                palabras[count++] = linea;
            }
        }
        reader.close();
        return palabras;
    }

    public static void main(String[] args) throws IOException {
        String filename = "C:\\Users\\slopezm13\\Desktop\\EDyA_Práctica0_ComplejidadAlgoritmica\\palabras\\palabras.es";

        // tiempo total 
        long tiempoTotalInicio = System.currentTimeMillis();

        // 25 veces
        for (int corrida = 1; corrida <= 25; corrida++) {
            int numPalabras = corrida * 10000; // Incremento 
            String[] palabras = leerPalabras(filename, numPalabras);

            long inicio = System.currentTimeMillis();

            bucketSort(palabras);

            long fin = System.currentTimeMillis();

            double tiempoSegundos = (fin - inicio) / 1000.0;

            System.out.println(corrida + ". Número de palabras: " + numPalabras + " - Tiempo (Bucket Sort): " + tiempoSegundos + " segundos");
        }

        long tiempoTotalFin = System.currentTimeMillis();
        double tiempoTotalSegundos = (tiempoTotalFin - tiempoTotalInicio) / 1000.0;

        System.out.println("Tiempo total de ejecución para las 25 corridas: " + tiempoTotalSegundos + " segundos");
    }
}
