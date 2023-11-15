public class EjercicioArrays {

    // Método genérico para imprimir un arreglo
    public static <T> void imprimirArray(T[] arreglo) {
        for (T elemento : arreglo) {
            System.out.print(elemento + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        // Ejemplos de uso del método imprimirArray con diferentes tipos de objetos
        Integer[] arrEnteros = {1, 2, 3, 4, 5};
        Double[] arrDobles = {1.5, 2.5, 3.5, 4.5, 5.5};
        Float[] arrFloats = {1.1f, 2.2f, 3.3f, 4.4f, 5.5f};
        Boolean[] arrBooleanos = {true, false, true, false, true};

        Persona[] arrPersonas = {
                new Persona("123456", "Juan Pérez", "Calle A"),
                new Persona("789012", "María López", "Calle B")
        };

        // Imprimir arreglos de diferentes tipos
        System.out.println("Arreglo de enteros:");
        imprimirArray(arrEnteros);

        System.out.println("Arreglo de dobles:");
        imprimirArray(arrDobles);

        System.out.println("Arreglo de floats:");
        imprimirArray(arrFloats);

        System.out.println("Arreglo de booleanos:");
        imprimirArray(arrBooleanos);

        System.out.println("Arreglo de personas:");
        imprimirArray(arrPersonas);
    }
}

class Persona {
    private String dni;
    private String nombres;
    private String direccion;

    public Persona(String dni, String nombres, String direccion) {
        this.dni = dni;
        this.nombres = nombres;
        this.direccion = direccion;
    }

    @Override
    public String toString() {
        return "Persona{" +
                "dni='" + dni + '\'' +
                ", nombres='" + nombres + '\'' +
                ", dirección='" + direccion + '\'' +
                '}';
    }
}
