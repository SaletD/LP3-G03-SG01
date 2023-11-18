import java.util.Arrays;
import java.util.Scanner;

public class Ejer02ses10 {

    
    public static <T> void intercambiarElementos(T[] array, int indice1, int indice2) {
        if (indice1 < 0 || indice1 >= array.length || indice2 < 0 || indice2 >= array.length) {
            System.out.println("Índices fuera de rango. No se puede intercambiar elementos.");
            return;
        }

        T temp = array[indice1];
        array[indice1] = array[indice2];
        array[indice2] = temp;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        /*
        Integer[] arrayEnteros = {1, 2, 3, 4, 5};
        System.out.println("Antes del intercambio: " + Arrays.toString(arrayEnteros));

        
        System.out.print("Ingrese el primer índice: ");
        int indice1 = scanner.nextInt();
        System.out.print("Ingrese el segundo índice: ");
        int indice2 = scanner.nextInt();

        
        intercambiarElementos(arrayEnteros, indice1, indice2);

        System.out.println("Después del intercambio: " + Arrays.toString(arrayEnteros));
        */
        
        // ejemplo con strings
        
        
        String[] arrayCadenas = {"Uno", "Dos", "Tres", "Cuatro", "Cinco"};
        System.out.println("Antes del intercambio: " + Arrays.toString(arrayCadenas));

        // Solicitar al usuario los índices a intercambiar
        System.out.println("Introduce el primer índice: ");
        int indice1 = scanner.nextInt();
        System.out.println("Introduce el segundo índice: ");
        int indice2 = scanner.nextInt();

        // Intercambiar elementos según los índices proporcionados por el usuario
        intercambiarElementos(arrayCadenas, indice1, indice2);

        System.out.println("Después del intercambio: " + Arrays.toString(arrayCadenas));
    }
}
