public class App {
    public static void main(String[] args) {
        Integer[] intArray = {1, 2, 3, 4, 5};
        Double[] doubleArray = {1.1, 2.2, 3.3, 4.4, 5.5};
        Character[] charArray = {'H', 'O', 'L', 'A'};

        try {
            System.out.printf("Array integerArray contiene:%n");
            imprimirArray(intArray, 1, 4);

            System.out.printf("%nArray doubleArray contiene:%n");
            imprimirArray(doubleArray, 0, 3);

            System.out.printf("%nArray charArray contiene:%n");
            imprimirArray(charArray, 0, 10); // Aquí se prueba una excepción con límites fuera de rango
        } catch (LimiteInvalidoException e) {
            System.out.println(e.getMessage());
        }
    }

    // Sobrecarga del método imprimirArray para imprimir una porción designada del arreglo
    public static void imprimirArray(Integer[] inputArray, int limiteInferior, int limiteSuperior) throws LimiteInvalidoException {
        validarLimites(inputArray.length, limiteInferior, limiteSuperior);

        for (int i = limiteInferior; i <= limiteSuperior; i++) {
            System.out.printf("%s ", inputArray[i]);
        }
        System.out.println();
    }

    // Sobrecarga del método imprimirArray para imprimir una porción designada del arreglo
    public static void imprimirArray(Double[] inputArray, int limiteInferior, int limiteSuperior) throws LimiteInvalidoException {
        validarLimites(inputArray.length, limiteInferior, limiteSuperior);

        for (int i = limiteInferior; i <= limiteSuperior; i++) {
            System.out.printf("%s ", inputArray[i]);
        }
        System.out.println();
    }

    // Sobrecarga del método imprimirArray para imprimir una porción designada del arreglo
    public static void imprimirArray(Character[] inputArray, int limiteInferior, int limiteSuperior) throws LimiteInvalidoException {
        validarLimites(inputArray.length, limiteInferior, limiteSuperior);

        for (int i = limiteInferior; i <= limiteSuperior; i++) {
            System.out.printf("%s ", inputArray[i]);
        }
        System.out.println();
    }

    // Método para validar los límites
    private static void validarLimites(int longitudArray, int limiteInferior, int limiteSuperior) throws LimiteInvalidoException {
        if (limiteInferior < 0 || limiteInferior >= longitudArray || limiteSuperior < 0 || limiteSuperior >= longitudArray || limiteInferior > limiteSuperior) {
            throw new LimiteInvalidoException("Límites invalidos");
        }
    }
}

// Excepción personalizada LimiteInvalidoException
class LimiteInvalidoException extends Exception {
    public LimiteInvalidoException(String mensaje) {
        super(mensaje);
    }
}
