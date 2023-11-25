import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    private static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) {
        Dictionary<String, Integer> dictionary = new Dictionary<>();
        boolean exit = false;

        while (!exit) {
            System.out.println("\nMenú:");
            System.out.println("1. Agregar Par");
            System.out.println("2. Eliminar Par");
            System.out.println("3. Obtener Valor");
            System.out.println("4. Mostrar Diccionario");
            System.out.println("5. Salir");

            int choice = getUserChoice();

            switch (choice) {
                case 1:
                    System.out.print("Ingrese la clave: ");
                    String key = getUserInput();
                    System.out.print("Ingrese el valor: ");
                    int value = Integer.parseInt(getUserInput());
                    dictionary.add(key, value);
                    System.out.println("Par agregado exitosamente.");
                    break;
                case 2:
                    System.out.print("Ingrese la clave a eliminar: ");
                    String keyToDelete = getUserInput();
                    boolean deleted = dictionary.delete(keyToDelete);
                    if (deleted) {
                        System.out.println("Par eliminado exitosamente.");
                    } else {
                        System.out.println("Par con la clave '" + keyToDelete + "' no encontrado.");
                    }
                    break;
                case 3:
                    try {
                        System.out.print("Ingrese la clave para obtener el valor: ");
                        String keyToGetValue = getUserInput();
                        int retrievedValue = dictionary.getValue(keyToGetValue);
                        System.out.println("Valor: " + retrievedValue);
                    } catch (ObjectNotFoundException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 4:
                    System.out.println(dictionary);
                    break;
                case 5:
                    exit = true;
                    System.out.println("Saliendo del programa. ¡Hasta luego!");
                    break;
                default:
                    System.out.println("Opción inválida. Por favor, ingrese un número entre 1 y 5.");
            }
        }
    }

    private static int getUserChoice() {
        System.out.print("Ingrese su elección: ");
        try {
            return Integer.parseInt(getUserInput());
        } catch (NumberFormatException e) {
            return -1;
        }
    }

    private static String getUserInput() {
        try {
            return reader.readLine();
        } catch (Exception e) {
            throw new RuntimeException("Error al leer la entrada del usuario", e);
        }
    }
}







import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

class Dictionary<K, V> {
    private ArrayList<Pair<K, V>> pairs;

    public Dictionary() {
        pairs = new ArrayList<>();
    }

    public void add(K key, V value) {
        pairs.add(new Pair<>(key, value));
    }

    public boolean delete(K key) {
        Iterator<Pair<K, V>> iterator = pairs.iterator();
        while (iterator.hasNext()) {
            Pair<K, V> pair = iterator.next();
            if (pair.getKey().equals(key)) {
                iterator.remove();
                return true;
            }
        }
        return false;
    }

    public V getValue(K key) throws ObjectNotFoundException {
        for (Pair<K, V> pair : pairs) {
            if (pair.getKey().equals(key)) {
                return pair.getValue();
            }
        }
        throw new ObjectNotFoundException("Object with key '" + key + "' does not exist.");
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        for (Pair<K, V> pair : pairs) {
            result.append(pair).append("\n");
        }
        return result.toString();
    }
}









class Pair<K, V> {
    private K key;
    private V value;

    public Pair(K key, V value) {
        this.key = key;
        this.value = value;
    }

    public K getKey() {
        return key;
    }

    public V getValue() {
        return value;
    }

    @Override
    public String toString() {
        return "(" + key + ", " + value + ")";
    }
}

class ObjectNotFoundException extends Exception {
    public ObjectNotFoundException(String message) {
        super(message);
    }
}
