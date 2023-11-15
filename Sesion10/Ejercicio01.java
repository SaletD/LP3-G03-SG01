import java.util.Arrays;

class ImprimirArray {
    // Método genérico para imprimir cualquier tipo de array
    public static <T> void imprimirArray(T[] array) {
        System.out.println("Array contiene:");
        int contador = 0;
        for (T elemento : array) {
            System.out.print(elemento + "\t");
            contador++;
            // Agregar un salto de línea después de imprimir los primeros cuatro elementos
            if (contador % 4 == 0) {
                System.out.println(); // Salto de línea
            }
        }
        System.out.println("\n");
    }

    // Método específico para imprimir arrays de tipo String en formato tabular ordenado
    public static void imprimirArray(String[] array) {
        System.out.println("Array de cadenas contiene:");
        int contador = 0;
        for (String elemento : array) {
            System.out.print(elemento + "\t");
            contador++;
            if (contador % 4 == 0){
                System.out.println();
            }
        }
        System.out.println("\n");
    }
}

-------------------------------
  
public class Main {
    public static void main(String[] args) {
        // Ejemplo de uso con un array de enteros
        Integer[] arrayEnteros = {1, 2, 3, 4, 5, 6, 7, 8};
        ImprimirArray.imprimirArray(arrayEnteros);

        // Ejemplo de uso con un array de cadenas
        String[] arrayCadenas = {"Uno", "Dos", "Tres", "Cuadro", "Cinco", "Seis", "Siete", "Ocho"};
        ImprimirArray.imprimirArray(arrayCadenas);
    }
}
