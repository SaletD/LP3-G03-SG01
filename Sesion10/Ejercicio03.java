public class ComparadorGenerico {

    // Método genérico para comparar dos objetos usando equals
    public static <T> boolean isEqualTo(T obj1, T obj2) {
        if (obj1 == null && obj2 == null) {
            return true;
        } else if (obj1 == null || obj2 == null) {
            return false;
        }
        return obj1.equals(obj2);
    }

    public static void main(String[] args) {
        // Ejemplos de uso del método isEqualTo con diferentes tipos
        System.out.println(isEqualTo(10, 10));            // true
        System.out.println(isEqualTo(10, 5));             // false
        System.out.println(isEqualTo("Hola", "Hola"));    // true
        System.out.println(isEqualTo("Hola", "Mundo"));   // false
        System.out.println(isEqualTo(3.14, 3.14));         // true
        System.out.println(isEqualTo(3.14, 2.71));         // false
        System.out.println(isEqualTo(null, null));         // true
        System.out.println(isEqualTo(null, "No nulo"));   // false
    }
}
