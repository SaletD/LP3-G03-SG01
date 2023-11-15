public class MinimoDemo {

    // Método genérico para encontrar el mínimo entre cuatro elementos
    public static <T extends Comparable<T>> T minimo(T a, T b, T c, T d) {
        T min = a;

        if (b.compareTo(min) < 0) {
            min = b;
        }

        if (c.compareTo(min) < 0) {
            min = c;
        }

        if (d.compareTo(min) < 0) {
            min = d;
        }

        return min;
    }

    public static void main(String[] args) {
        // Ejemplos de uso del método minimo con diferentes tipos de objetos
        Integer minEntero = minimo(5, 2, 8, 4);
        System.out.println("Mínimo entero: " + minEntero);

        Double minDoble = minimo(3.5, 1.2, 4.8, 2.1);
        System.out.println("Mínimo doble: " + minDoble);

        String minString = minimo("manzana", "naranja", "banana", "uva");
        System.out.println("Mínimo string: " + minString);

        Persona minPersona = minimo(
                new Persona("123", "Juan"),
                new Persona("456", "Ana"),
                new Persona("789", "Carlos"),
                new Persona("123", "Pedro")
        );
        System.out.println("Mínimo persona: " + minPersona);
    }
}

class Persona implements Comparable<Persona> {
    private String dni;
    private String nombre;

    public Persona(String dni, String nombre) {
        this.dni = dni;
        this.nombre = nombre;
    }

    @Override
    public int compareTo(Persona otraPersona) {
        // Comparar personas por nombres en orden alfabético
        return this.nombre.compareTo(otraPersona.nombre);
    }

    @Override
    public String toString() {
        return "Persona{" +
                "dni='" + dni + '\'' +
                ", nombre='" + nombre + '\'' +
                '}';
    }
}
