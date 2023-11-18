import java.util.Arrays;

public class CopiarArreglo {

    public static void main(String[] args) {
        // Ejemplo con arreglos de tipo String
        String[] arrayStrings1 = {"a", "b", "c"};
        String[] arrayStrings2 = {"b", "c", "d"};
        String[] resultStrings = copyArray(arrayStrings1, arrayStrings2);
        System.out.println(Arrays.toString(resultStrings));

        // Ejemplo con arreglos de tipo Producto
        Producto[] arrayProductos1 = {new Producto(1, "Producto1"), new Producto(2, "Producto2")};
        Producto[] arrayProductos2 = {new Producto(2, "Producto2"), new Producto(3, "Producto3")};
        Producto[] resultProductos = copyArray(arrayProductos1, arrayProductos2);
        System.out.println(Arrays.toString(resultProductos));

        // Ejemplo con arreglos de tipo Persona
        Persona[] arrayPersonas1 = {new Persona("Juan", 25), new Persona("Ana", 30)};
        Persona[] arrayPersonas2 = {new Persona("Ana", 30), new Persona("Carlos", 22)};
        Persona[] resultPersonas = copyArray(arrayPersonas1, arrayPersonas2);
        System.out.println(Arrays.toString(resultPersonas));
    }

    public static <T> T[] copyArray(T[] array1, T[] array2) {
        int length = array1.length + array2.length;
        T[] resultArray = Arrays.copyOf(array1, length);
        int resultIndex = array1.length;

        for (T element : array2) {
            if (!containsElement(resultArray, resultIndex, element)) {
                resultArray[resultIndex] = element;
                resultIndex++;
            }
        }

        return Arrays.copyOf(resultArray, resultIndex);
    }

    private static <T> boolean containsElement(T[] array, int length, T element) {
        for (int i = 0; i < length; i++) {
            if (array[i] != null && array[i].equals(element)) {
                return true;
            }
        }
        return false;
    }

    // Clase Producto
    static class Producto {
        int id;
        String nombre;

        public Producto(int id, String nombre) {
            this.id = id;
            this.nombre = nombre;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) return true;
            if (obj == null || getClass() != obj.getClass()) return false;
            Producto producto = (Producto) obj;
            return id == producto.id && nombre.equals(producto.nombre);
        }

        @Override
        public int hashCode() {
            return Objects.hash(id, nombre);
        }

        @Override
        public String toString() {
            return "Producto{id=" + id + ", nombre='" + nombre + '\'' + '}';
        }
    }

    // Clase Persona
    static class Persona {
        String nombre;
        int edad;

        public Persona(String nombre, int edad) {
            this.nombre = nombre;
            this.edad = edad;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) return true;
            if (obj == null || getClass() != obj.getClass()) return false;
            Persona persona = (Persona) obj;
            return edad == persona.edad && nombre.equals(persona.nombre);
        }

        @Override
        public int hashCode() {
            return Objects.hash(nombre, edad);
        }

        @Override
        public String toString() {
            return "Persona{nombre='" + nombre + "', edad=" + edad + '}';
        }
    }
}
