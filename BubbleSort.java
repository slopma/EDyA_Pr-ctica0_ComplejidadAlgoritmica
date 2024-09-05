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
        String filename = "C:\\Users\\slopezm13\\Desktop\\EDyA_Práctica0_ComplejidadAlgoritmica\\palabras\\palabras.es"; // Cambia esta ruta por la correcta

        // Medimos el tiempo total para todas las corridas
        long tiempoTotalInicio = System.currentTimeMillis();

        // Recorremos 25 corridas, empezando con 10,000 palabras
        for (int corrida = 1; corrida <= 25; corrida++) {
            int numPalabras = corrida * 10000; // Incremento de 10,000 palabras
            String[] palabras = leerPalabras(filename, numPalabras);

            // Tomamos el tiempo antes de empezar cada corrida
            long inicio = System.currentTimeMillis();

            // Ejecutamos Bubble Sort
            bubbleSort(palabras);

            // Tomamos el tiempo al finalizar cada corrida
            long fin = System.currentTimeMillis();

            // Calculamos el tiempo total en segundos
            double tiempoSegundos = (fin - inicio) / 1000.0;

            // Imprimimos el número de la corrida y el tiempo
            System.out.println(corrida + ". Número de palabras: " + numPalabras + " - Tiempo (Bubble Sort): " + tiempoSegundos + " segundos");
        }

        // Calculamos el tiempo total de las 25 corridas
        long tiempoTotalFin = System.currentTimeMillis();
        double tiempoTotalSegundos = (tiempoTotalFin - tiempoTotalInicio) / 1000.0;

        // Imprimimos el tiempo total de ejecución
        System.out.println("Tiempo total de ejecución para las 25 corridas: " + tiempoTotalSegundos + " segundos");
    }
}
