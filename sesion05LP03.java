// ejercicio 1
public class Persona {
    private int numeroCuenta;
    private char tipoCliente;
    private String nombres;
    private double saldo;

    // Constructor
    public Persona(char tipoCliente, String nombres) {
        this.tipoCliente = tipoCliente;
        this.nombres = nombres;

        // Asignar el número de cuenta según el tipo de cliente
        if (tipoCliente == 'C') {
            this.numeroCuenta = 1000;
        } else if (tipoCliente == 'B') {
            this.numeroCuenta = 5000;
        } else if (tipoCliente == 'E') {
            this.numeroCuenta = 8000;
        } else {
            // Si no se especifica un tipo válido, asignar por defecto 'C'
            this.tipoCliente = 'C';
            this.numeroCuenta = 1000;
        }

        this.saldo = 50.0; // Saldo mínimo inicial
    }

    // Getter y Setter
    public int getNumeroCuenta() {
        return numeroCuenta;
    }

    public char getTipoCliente() {
        return tipoCliente;
    }

    public String getNombres() {
        return nombres;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        if (saldo >= 50) {
            this.saldo = saldo;
        } else {
            System.out.println("El saldo mínimo permitido es 50 soles.");
        }
    }

    // Método para depositar dinero
    public void depositar(double cantidad) {
        if (cantidad > 0) {
            saldo += cantidad;
            System.out.println("Se depositaron " + cantidad + " soles en la cuenta.");
        } else {
            System.out.println("La cantidad a depositar debe ser mayor que 0.");
        }
    }

    // Método para retirar dinero
    public void retirar(double cantidad) {
        if (saldo - cantidad >= 50) {
            saldo -= cantidad;
            System.out.println("Se retiraron " + cantidad + " soles de la cuenta.");
        } else {
            System.out.println("Saldo insuficiente. El saldo mínimo permitido es 50 soles.");
        }
    }

    // Método toString
    @Override
    public String toString() {
        return "Cliente: " + numeroCuenta + "\n" +
               "Tipo: " + tipoCliente + "\n" +
               "Nombres: " + nombres + "\n" +
               "No Cuenta: " + tipoCliente + numeroCuenta + "\tSaldo: " + saldo;
    }
}

public class TestComposicion {
    public static void main(String[] args) {
        // Crear una persona con tipo de cliente B y nombres Oscar Gutierrez
        Persona persona1 = new Persona('B', "Oscar Gutierrez");

        // Realizar operaciones de depósito y retiro
        persona1.depositar(2500.0);
        persona1.retirar(1000.0);

        // Imprimir la información de la persona
        System.out.println(persona1.toString());
    }
}




















// ejercicio 2
class Motor {
    private int numeroMotor;
    private int rpm;

    public Motor(int numeroMotor, int rpm) {
        this.numeroMotor = numeroMotor;
        this.rpm = rpm;
    }

    public int getNumeroMotor() {
        return numeroMotor;
    }

    public int getRpm() {
        return rpm;
    }

    @Override
    public String toString() {
        return "No. Motor : " + numeroMotor + "\nRPM : " + rpm;
    }
}

class Automovil {
    private String placa;
    private int noPuertas;
    private String marca;
    private String modelo;
    private Motor motor; // Relación de agregación con Motor

    public Automovil(String placa, int noPuertas, String marca, String modelo) {
        this.placa = placa;
        this.noPuertas = noPuertas;
        this.marca = marca;
        this.modelo = modelo;
    }

    public Automovil(String placa, int noPuertas, String marca, String modelo, Motor motor) {
        this.placa = placa;
        this.noPuertas = noPuertas;
        this.marca = marca;
        this.modelo = modelo;
        this.motor = motor;
    }

    public String getPlaca() {
        return placa;
    }

    public int getNoPuertas() {
        return noPuertas;
    }

    public String getMarca() {
        return marca;
    }

    public String getModelo() {
        return modelo;
    }

    public Motor getMotor() {
        return motor;
    }

    @Override
    public String toString() {
        if (motor != null) {
            return "Automovil con motor\n" +
                   "Placa : " + placa + "\n" +
                   "No. Motor : " + motor.getNumeroMotor() + "\n" +
                   "No. Puertas : " + noPuertas + "\n" +
                   "Marca : " + marca + "\n" +
                   "Modelo : " + modelo + "\n" +
                   motor.toString();
        } else {
            return "Automovil sin motor\n" +
                   "Placa : " + placa + "\n" +
                   "No. Puertas : " + noPuertas + "\n" +
                   "Marca : " + marca + "\n" +
                   "Modelo : " + modelo;
        }
    }
}

public class TestAgregacion {
    public static void main(String[] args) {
        Motor motor1 = new Motor(3728, 1000);
        Automovil automovil1 = new Automovil("VH742", 5, "Nissan", "Versa", motor1);

        Automovil automovil2 = new Automovil("AU398", 3, "Toyota", "Corolla");

        System.out.println(automovil1.toString());
        System.out.println("\n");
        System.out.println(automovil2.toString());
    }
}














//EJERCICIO 3
import java.util.ArrayList;
import java.util.List;

class Cliente {
    private String nombre;
    private char tipoCliente;
    private Cuenta cuenta;

    public Cliente(String nombre, char tipoCliente, Cuenta cuenta) {
        this.nombre = nombre;
        this.tipoCliente = tipoCliente;
        this.cuenta = cuenta;
    }

    public String getNombre() {
        return nombre;
    }

    public char getTipoCliente() {
        return tipoCliente;
    }

    public Cuenta getCuenta() {
        return cuenta;
    }

    @Override
    public String toString() {
        return "Nombre: " + nombre + "\n" +
               "Tipo de Cliente: " + tipoCliente + "\n" +
               cuenta.toString();
    }
}

class Cuenta {
    private int numeroCuenta;
    private double saldo;

    public Cuenta(int numeroCuenta, double saldo) {
        this.numeroCuenta = numeroCuenta;
        this.saldo = saldo;
    }

    public int getNumeroCuenta() {
        return numeroCuenta;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    @Override
    public String toString() {
        return "Número de Cuenta: " + numeroCuenta + "\n" +
               "Saldo: " + saldo;
    }
}

class Banco {
    private List<Cliente> clientes = new ArrayList<>();

    public void agregarCliente(Cliente cliente) {
        clientes.add(cliente);
    }

    public Cliente darBajaCliente(String nombre) {
        Cliente clienteAEliminar = null;
        for (Cliente cliente : clientes) {
            if (cliente.getNombre().equals(nombre)) {
                clienteAEliminar = cliente;
                break;
            }
        }
        if (clienteAEliminar != null) {
            clientes.remove(clienteAEliminar);
        }
        return clienteAEliminar;
    }

    public void clienteTipo(char tipo) {
        System.out.println("Clientes de tipo " + tipo + ":");
        for (Cliente cliente : clientes) {
            if (cliente.getTipoCliente() == tipo) {
                System.out.println(cliente.toString());
                System.out.println();
            }
        }
    }
}

public class TestAsociacion {
    public static void main(String[] args) {
        Banco banco = new Banco();

        Cuenta cuenta1 = new Cuenta(1001, 2500.0);
        Cliente cliente1 = new Cliente("Cliente1", 'C', cuenta1);

        Cuenta cuenta2 = new Cuenta(2002, 3500.0);
        Cliente cliente2 = new Cliente("Cliente2", 'B', cuenta2);

        Cuenta cuenta3 = new Cuenta(3003, 4500.0);
        Cliente cliente3 = new Cliente("Cliente3", 'E', cuenta3);

        banco.agregarCliente(cliente1);
        banco.agregarCliente(cliente2);
        banco.agregarCliente(cliente3);

        // Mostrar clientes de tipo C
        banco.clienteTipo('C');

        // Dar de baja un cliente y mostrar los clientes de tipo B
        Cliente clienteEliminado = banco.darBajaCliente("Cliente2");
        System.out.println("Cliente eliminado: " + clienteEliminado.getNombre() + "\n");

        banco.clienteTipo('B');
    }
}





//EJERCICIO 4
class Asalariado {
    private String nombre;
    private long dni;
    private int diasVacaciones;
    private double salarioBase;

    public Asalariado(String nombre, long dni, int diasVacaciones, double salarioBase) {
        this.nombre = nombre;
        this.dni = dni;
        this.diasVacaciones = diasVacaciones;
        this.salarioBase = salarioBase;
    }

    public String getNombre() {
        return nombre;
    }

    public long getDni() {
        return dni;
    }

    public int getDiasVacaciones() {
        return diasVacaciones;
    }

    public double getSalarioBase() {
        return salarioBase;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setDni(long dni) {
        this.dni = dni;
    }

    public void setDiasVacaciones(int diasVacaciones) {
        this.diasVacaciones = diasVacaciones;
    }

    public double getSalario() {
        return salarioBase;
    }

    @Override
    public String toString() {
        return "Empleado Asalariado\n" +
               "Dni : " + dni + "\n" +
               "Nombre : " + nombre + "\n" +
               "Vacaciones : " + diasVacaciones + " días" + "\n" +
               "Salario : " + salarioBase + "\n";
    }
}

class EmpleadoProduccion extends Asalariado {
    private String turno;

    public EmpleadoProduccion(String nombre, long dni, int diasVacaciones, double salarioBase, String turno) {
        super(nombre, dni, diasVacaciones, salarioBase);
        this.turno = turno;
    }

    public String getTurno() {
        return turno;
    }

    public void setTurno(String turno) {
        this.turno = turno;
    }

    @Override
    public double getSalario() {
        return getSalarioBase() * 1.15; // Incremento del 15% para empleados de producción
    }

    @Override
    public String toString() {
        return super.toString() +
               "Empleado de Producción\n" +
               "Turno : " + turno + "\n" +
               "Salario : " + getSalario() + "\n";
    }
}

class EmpleadoDistribucion extends Asalariado {
    private String zona;

    public EmpleadoDistribucion(String nombre, long dni, int diasVacaciones, double salarioBase, String zona) {
        super(nombre, dni, diasVacaciones, salarioBase);
        this.zona = zona;
    }

    public String getZona() {
        return zona;
    }

    public void setZona(String zona) {
        this.zona = zona;
    }

    @Override
    public double getSalario() {
        return getSalarioBase() * 1.10; // Incremento del 10% para empleados de distribución
    }

    @Override
    public String toString() {
        return super.toString() +
               "Empleado de Distribución\n" +
               "Zona : " + zona + "\n" +
               "Salario : " + getSalario() + "\n";
    }
}

public class TestHerencia {
    public static void main(String[] args) {
        Asalariado empleado1 = new Asalariado("Juan Perez", 27339187, 5, 3500.0);
        EmpleadoProduccion empleado2 = new EmpleadoProduccion("Rocio Fernandez", 35289129, 10, 4000.0, "Tarde");
        EmpleadoDistribucion empleado3 = new EmpleadoDistribucion("Deny Cruz", 02718935, 0, 3800.0, "Centro");

        System.out.println(empleado1.toString());
        System.out.println(empleado2.toString());
        System.out.println(empleado3.toString());
    }
}
