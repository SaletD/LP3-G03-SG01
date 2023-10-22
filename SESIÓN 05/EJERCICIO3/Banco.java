import java.util.Arrays;

public class Banco {
    private String nombre;
    private Persona clientes[];

    public Banco(String nombre) {
        this(nombre, 20);
    }

    public Banco(String nombre, int numCli) {
        this.nombre = nombre;
        this.clientes = new Persona[numCli];
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Persona[] getClientes() {
        return clientes;
    }

    public void setClientes(Persona[] clientes) {
        this.clientes = clientes;
    }

    public void agregarCliente(Persona persona) {
        if (buscarCliente(persona)) {
            System.out.println("El cliente ya existe en el banco.");
            return;
        }

        for (int i = 0; i < clientes.length; i++) {
            if (clientes[i] == null) {
                clientes[i] = persona;
                System.out.println("Cliente agregado exitosamente.");
                return;
            }
        }

        System.out.println("El banco ha alcanzado su capacidad máxima de clientes.");
    }

    public boolean buscarCliente(Persona persona) {
        for (Persona cliente : clientes) {
            if (cliente != null && cliente.equals(persona))
                return true;
        }
        return false;
    }

    public Persona darBajaCliente(Persona persona) {
        for (int i = 0; i < clientes.length; i++) {
            if (clientes[i] != null && clientes[i].equals(persona)) {
                Persona clienteEliminado = clientes[i];
                clientes[i] = null;

                for (int j = i; j < clientes.length - 1; j++) {
                    if (clientes[j + 1] != null) {
                        clientes[j] = clientes[j + 1];
                        clientes[j + 1] = null;
                    }
                }

                System.out.println("Cliente " + persona.getNombre() + " eliminado exitosamente.");
                return clienteEliminado;
            }
        }
        System.out.println("Cliente " + persona.getNombre() + " no encontrado en el banco.");
        return null;
    }

    public void clienteTipo(char tipo) {
        System.out.println("Clientes de tipo '" + tipo + "':");
        for (Persona cliente : clientes) {
            if (cliente != null && cliente.getTipo() == tipo) {
                System.out.println(cliente.toString());
            }
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Nombre del Banco: ").append(nombre).append("\n");
        sb.append("Clientes: \n");
        for (Persona cliente : clientes) {
            if (cliente != null) {
                sb.append(cliente.toString()).append("\n");
            }
        }
        return sb.toString();
    }
}
