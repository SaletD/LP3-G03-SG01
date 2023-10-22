import java.util.Scanner;

public class Main {
    private static Persona[] personas = new Persona[5];
    private static int indice = 0;
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        boolean salir = false;
        while (!salir) {
            System.out.println("xxxxxxxxxx Menú xxxxxxxxxx");
            System.out.println("1. Añadir cliente");
            System.out.println("2. Realizar retiro");
            System.out.println("3. Realizar depósito");
            System.out.println("4. Ver información de cliente");
            System.out.println("5. Salir");
            System.out.print("Ingrese una opción: ");
            int opcion = input.nextInt();
            input.nextLine();
            switch (opcion) {
                case 1:
                    agregarCliente(input);
                    break;
                case 2:
                    realizarRetiro(input);
                    break;
                case 3:
                    realizarDeposito(input);
                    break;
                case 4:
                    mostrarInformacionCliente(input);
                    break;
                case 5:
                    salir = true;
                    break;
                default:
                    System.out.println("Opción inválida. Por favor, ingrese un valor válido");
                    break;
            }
        }
    }
    private static void agregarCliente(Scanner input) {
        if (indice < personas.length) {
            System.out.print("Ingrese el nombre del cliente: ");
            String nombre = input.nextLine();
            System.out.print("Ingrese el apellido del cliente: ");
            String apellido = input.nextLine();
            System.out.print("Ingrese el tipo de cliente (C/B/E): ");
            char tipoCliente = input.nextLine().charAt(0);
            Persona persona;
            if (tipoCliente == ' ') {
                persona = new Persona(nombre, apellido);
            } else {
                persona = new Persona(nombre, apellido, tipoCliente);
            }
            personas[indice] = persona;
            indice++;
            System.out.println("Cliente añadido exitosamente.");
        } else {
            System.out.println("La lista de clientes está llena.");
        }
    }
    private static void realizarRetiro(Scanner scanner) {
        System.out.print("Ingrese el nombre del cliente: ");
        String nombre = scanner.nextLine();
        System.out.print("Ingrese el apellido del cliente: ");
        String apellido = scanner.nextLine();
        System.out.print("Ingrese el monto a retirar: ");
        double monto = scanner.nextDouble();
        scanner.nextLine();
        Persona cliente = buscarCliente(nombre, apellido);
        if (cliente != null) {
            cliente.getCuenta().retirar(monto);
        } else {
            System.out.println("Cliente no encontrado");
        }
    }
    private static void realizarDeposito(Scanner scanner) {
        System.out.print("Ingrese el nombre del cliente: ");
        String nombre = scanner.nextLine();
        System.out.print("Ingrese el apellido del cliente: ");
        String apellido = scanner.nextLine();
        System.out.print("Ingrese el monto a depositar: ");
        double monto = scanner.nextDouble();
        scanner.nextLine();
        Persona cliente = buscarCliente(nombre, apellido);
        if (cliente != null) {
            cliente.getCuenta().depositar(monto);
        } else {
            System.out.println("Cliente no encontrado");
        }
    }
    private static void mostrarInformacionCliente(Scanner scanner) {
        System.out.print("Ingrese el nombre del cliente: ");
        String nombre = scanner.nextLine();
        System.out.print("Ingrese el apellido del cliente: ");
        String apellido = scanner.nextLine();
        Persona cliente = buscarCliente(nombre, apellido);
        if (cliente != null) {
            System.out.println("Información del cliente: ");
            System.out.println("ID: " + cliente.getId());
            System.out.println("Tipo de Cliente: " + cliente.getTipoCliente());
            System.out.println("Nombre: " + cliente.getNombre() + " " + cliente.getApellido());
            System.out.println("Número de Cuenta: " + cliente.getCuenta().getNumeroCuenta());
            System.out.println("Saldo: " + cliente.getCuenta().getSaldo());
        } else {
            System.out.println("Cliente no encontrado");
        }
    }
    private static Persona buscarCliente(String nombre, String apellido) {
        for (Persona persona : personas) {
            if (persona != null && persona.getNombre().equalsIgnoreCase(nombre) && persona.getApellido().equalsIgnoreCase(apellido)) {
                return persona;
            }
        }
        return null;
    }
}
class Persona {
    private String nombre;
    private String apellido;
    private Cuenta cuenta;
    private char tipoCliente;
    private static int id = 1;
    private static int contadorCliente = 1000;
    private static int contadorBanca = 5000;
    private static int contadorEmpresarial = 8000;
    public Persona(String nombre, String apellido, char tipoCliente) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.tipoCliente = tipoCliente;
        String numeroCuenta;
        if (this.tipoCliente == 'C') {
            numeroCuenta = "C" + contadorCliente;
            contadorCliente++;
        } else if (this.tipoCliente == 'B') {
            numeroCuenta = "B" + contadorBanca;
            contadorBanca++;
        } else {
            numeroCuenta = "E" + contadorEmpresarial;
            contadorEmpresarial++;
        }
        this.cuenta = new Cuenta(numeroCuenta);
        id++;
    }
    public Persona(String nombre, String apellido) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.tipoCliente = 'C';
        String numeroCuenta = "C" + contadorCliente;
        contadorCliente++;
        this.cuenta = new Cuenta(numeroCuenta);
        id++;
    }
    public int getId() {
        return id;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getApellido() {
        return apellido;
    }
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
    public char getTipoCliente() {
        return tipoCliente;
    }
    public void setTipoCliente(char tipoCliente) {
        this.tipoCliente = tipoCliente;
    }
    public Cuenta getCuenta() {
        return cuenta;
    }
    public String toString() {
        return "ID: " + getId() + "\n" +
                "Tipo de Cliente: " + getTipoCliente() + "\n" +
                "Nombre: " + getNombre() + " " + getApellido() + "\n" +
                "Número de Cuenta: " + cuenta.getNumeroCuenta() + "\n" +
                "Saldo: " + cuenta.getSaldo();
    }
}
class Cuenta {
    private String numeroCuenta;
    private double saldo;

    public Cuenta(String numeroCuenta, double saldo) {
        this.numeroCuenta = numeroCuenta;
        if (saldo < 50) {
            this.saldo = 50;
        } else {
            this.saldo = saldo;
        }
    }
    public Cuenta(String numeroCuenta) {
        this(numeroCuenta, 50);
    }
    public String getNumeroCuenta() {
        return numeroCuenta;
    }
    public void setNumeroCuenta(String numeroCuenta) {
        this.numeroCuenta = numeroCuenta;
    }
    public double getSaldo() {
        return saldo;
    }
    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }
    public void retirar(double monto) {
        if (saldo - monto >= 50) {
            saldo -= monto;
            System.out.println("Retiro exitoso. Nuevo saldo del cliente: " + getSaldo());
        } else {
            System.out.println("No se puede retirar el monto especificado: El saldo no puede ser menos de 50.");
        }
    }
    public void depositar(double monto) {
        saldo += monto;
        System.out.println("Depósito satisfactorio. Nuevo saldo del cliente: " + getSaldo());
    }
}
