import java.util.Scanner;

public class Contacts {
    private Dictionary<String, Person> contacts;

    public Contacts() {
        contacts = new Dictionary<>();
    }

    public void addContact(String dni, Person person) {
        contacts.add(dni, person);
        System.out.println("Contacto agregado exitosamente.");
    }

    public boolean deleteContact(String dni) {
        boolean deleted = contacts.delete(dni);
        if (deleted) {
            System.out.println("Contacto eliminado exitosamente.");
        } else {
            System.out.println("Contacto con DNI '" + dni + "' no encontrado.");
        }
        return deleted;
    }

    public void displayContacts() {
        System.out.println("Lista de Contactos:");
        System.out.println(contacts);
    }

    public static void main(String[] args) {
        Contacts contactsManager = new Contacts();
        boolean exit = false;

        while (!exit) {
            System.out.println("\nMenú de Contactos:");
            System.out.println("1. Agregar Contacto");
            System.out.println("2. Eliminar Contacto");
            System.out.println("3. Mostrar Contactos");
            System.out.println("4. Salir");

            int choice = getUserChoice();

            switch (choice) {
                case 1:
                    System.out.print("Ingrese el DNI del contacto: ");
                    String dni = getUserInput();
                    System.out.print("Ingrese el nombre del contacto: ");
                    String name = getUserInput();
                    System.out.print("Ingrese el número de teléfono del contacto: ");
                    String phoneNumber = getUserInput();

                    Person newPerson = new Person(name, phoneNumber);
                    contactsManager.addContact(dni, newPerson);
                    break;
                case 2:
                    System.out.print("Ingrese el DNI del contacto a eliminar: ");
                    String dniToDelete = getUserInput();
                    contactsManager.deleteContact(dniToDelete);
                    break;
                case 3:
                    contactsManager.displayContacts();
                    break;
                case 4:
                    exit = true;
                    System.out.println("Saliendo del programa. ¡Hasta luego!");
                    break;
                default:
                    System.out.println("Opción inválida. Por favor, ingrese un número entre 1 y 4.");
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
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }
}







import java.util.ArrayList;
import java.util.Iterator;

public class Dictionary<K, V> {
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







public class Person {
    private String name;
    private String phoneNumber;

    public Person(String name, String phoneNumber) {
        this.name = name;
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString() {
        return "Nombre: " + name + ", Teléfono: " + phoneNumber;
    }
}







