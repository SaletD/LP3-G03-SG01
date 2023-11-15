import java.util.Arrays;

public class IntercambioElementos {

    // Método genérico para intercambiar elementos en un arreglo
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
        // Ejemplo de uso con un array de enteros
        Integer[] arrayEnteros = {1, 2, 3, 4, 5};
        System.out.println("Antes del intercambio: " + Arrays.toString(arrayEnteros));

        // Intercambiar elementos en posiciones 1 y 3
        intercambiarElementos(arrayEnteros, 1, 3);

        System.out.println("Después del intercambio: " + Arrays.toString(arrayEnteros));

        // Ejemplo de uso con un array de cadenas
        String[] arrayCadenas = {"Uno", "Dos", "Tres", "Cuatro", "Cinco"};
        System.out.println("Antes del intercambio: " + Arrays.toString(arrayCadenas));

        // Intercambiar elementos en posiciones 0 y 4
        intercambiarElementos(arrayCadenas, 0, 4);

        System.out.println("Después del intercambio: " + Arrays.toString(arrayCadenas));
    }
}
