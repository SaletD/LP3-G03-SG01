import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CopiarArreglo {

    // Método genérico para copiar dos arreglos sin elementos repetidos
    public static <T> T[] copyArray(T[] array1, T[] array2) {
        Set<T> set = new HashSet<>();

        // Agregar elementos del primer arreglo
        set.addAll(Arrays.asList(array1));

        // Agregar elementos del segundo arreglo
        set.addAll(Arrays.asList(array2));

        // Crear un nuevo arreglo con los elementos sin repetir
        return set.toArray(Arrays.copyOf(array1, 0));
    }

    public static void main(String[] args) {
        // Ejemplos de uso del método copyArray con diferentes tipos de objetos
        String[] arrStrings1 = {"uno", "dos", "tres"};
        String[] arrStrings2 = {"dos", "tres", "cuatro"};

        Producto[] arrProductos1 = {
                new Producto("001", "Laptop", 1200.0),
                new Producto("002", "Teléfono", 500.0)
        };
        Producto[] arrProductos2 = {
                new Producto("002", "Teléfono", 500.0),
                new Producto("003", "Tablet", 300.0)
        };

        Persona[] arrPersonas1 = {
                new Persona("123", "Juan"),
                new Persona("456", "María")
        };
        Persona[] arrPersonas2 = {
                new Persona("789", "Carlos"),
                new Persona("123", "Juan") // Persona repetida
        };

        // Copiar arreglos de Strings
        String[] resultadoStrings = copyArray(arrStrings1, arrStrings2);
        System.out.println("Arreglo de Strings sin repetidos: " + Arrays.toString(resultadoStrings));

        // Copiar arreglos de Productos
        Producto[] resultadoProductos = copyArray(arrProductos1, arrProductos2);
        System.out.println("Arreglo de Productos sin repetidos: " + Arrays.toString(resultadoProductos));

        // Copiar arreglos de Personas
        Persona[] resultadoPersonas = copyArray(arrPersonas1, arrPersonas2);
        System.out.println("Arreglo de Personas sin repetidos: " + Arrays.toString(resultadoPersonas));
    }
}

class Producto {
    private String codigo;
    private String descripcion;
    private double precio;

    public Producto(String codigo, String descripcion, double precio) {
        this.codigo = codigo;
        this.descripcion = descripcion;
        this.precio = precio;
    }

    @Override
    public String toString() {
        return "Producto{" +
                "codigo='" + codigo + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", precio=" + precio +
                '}';
    }
}

class Persona {
    private String dni;
    private String nombre;

    public Persona(String dni, String nombre) {
        this.dni = dni;
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "Persona{" +
                "dni='" + dni + '\'' +
                ", nombre='" + nombre + '\'' +
                '}';
    }
}
