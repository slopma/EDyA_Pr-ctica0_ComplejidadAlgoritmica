import java.io.*;

public class BubbleSort {
    // Método para realizar Bubble Sort
    public static void bubbleSort(String[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] != null && arr[j + 1] != null && arr[j].compareTo(arr[j + 1]) > 0) {
                    String temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    public static String[] leerPalabras(String filename, int numPalabras) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(filename), "ISO-8859-1"));
        String[] palabras = new String[numPalabras];
        int count = 0;

        String linea;
        while ((linea = reader.readLine()) != null && count < numPalabras) {
            if (!linea.trim().isEmpty()) {  
                palabras[count++] = linea;
            }
        }
        reader.close();
        return palabras;
    }

    public static void main(String[] args) throws IOException {
        String filename = "C:\\Users\\slopezm13\\Desktop\\EDyA_Práctica0_ComplejidadAlgoritmica\\palabras\\palabras.es"; 

        long tiempoTotalInicio = System.currentTimeMillis();

        for (int corrida = 1; corrida <= 25; corrida++) {
            int numPalabras = corrida * 10000; 
            String[] palabras = leerPalabras(filename, numPalabras);

            long inicio = System.currentTimeMillis();

            bubbleSort(palabras);

            long fin = System.currentTimeMillis();

            double tiempoSegundos = (fin - inicio) / 1000.0;

            System.out.println(corrida + ". Número de palabras: " + numPalabras + " - Tiempo (Bubble Sort): " + tiempoSegundos + " segundos");
        }

        long tiempoTotalFin = System.currentTimeMillis();
        double tiempoTotalSegundos = (tiempoTotalFin - tiempoTotalInicio) / 1000.0;

        System.out.println("Tiempo total de ejecución para las 25 corridas: " + tiempoTotalSegundos + " segundos");
    }
}
