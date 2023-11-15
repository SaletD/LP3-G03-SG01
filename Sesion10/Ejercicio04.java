public class BuscadorElemento {

    // Método genérico para buscar un elemento en un arreglo por su atributo
    public static <T> int buscarElemento(T[] arreglo, String atributoBuscado, String valorBuscado) {
        for (int i = 0; i < arreglo.length; i++) {
            if (arreglo[i] != null) {
                switch (atributoBuscado.toLowerCase()) {
                    case "codigo":
                        if (arreglo[i] instanceof Producto) {
                            Producto producto = (Producto) arreglo[i];
                            if (producto.getCodigo().equals(valorBuscado)) {
                                return i;
                            }
                        }
                        break;
                    case "nombres":
                        if (arreglo[i] instanceof Persona) {
                            Persona persona = (Persona) arreglo[i];
                            if (persona.getNombres().equalsIgnoreCase(valorBuscado)) {
                                return i;
                            }
                        }
                        break;
                    case "nombresycarrera":
                        if (arreglo[i] instanceof Estudiante) {
                            Estudiante estudiante = (Estudiante) arreglo[i];
                            if (estudiante.getNombres().equalsIgnoreCase(valorBuscado) && estudiante.getCarrera().equalsIgnoreCase(valorBuscado)) {
                                return i;
                            }
                        }
                        break;
                    default:
                        System.out.println("Atributo no válido");
                        return -1;
                }
            }
        }
        return -1; // Elemento no encontrado
    }

    public static void main(String[] args) {
        // Ejemplos de uso del método buscarElemento con diferentes tipos de objetos
        Producto[] productos = {
                new Producto("001", "Laptop", 1200.0),
                new Producto("002", "Teléfono", 500.0),
                new Producto("003", "Tablet", 300.0)
        };

        Persona[] personas = {
                new Persona("123456", "Juan Pérez", "Calle A"),
                new Persona("789012", "María López", "Calle B"),
                new Estudiante("456789", "Carlos García", "Calle C", "Ingeniería Informática")
        };

        // Buscar un producto por su código
        int posicionProducto = buscarElemento(productos, "codigo", "002");
        System.out.println("Producto encontrado en la posición: " + posicionProducto);

        // Buscar una persona por sus nombres
        int posicionPersona = buscarElemento(personas, "nombres", "Juan Pérez");
        System.out.println("Persona encontrada en la posición: " + posicionPersona);

        // Buscar un estudiante por sus nombres y carrera
        int posicionEstudiante = buscarElemento(personas, "nombresycarrera", "Carlos García");
        System.out.println("Estudiante encontrado en la posición: " + posicionEstudiante);
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

    public String getCodigo() {
        return codigo;
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

    public String getNombres() {
        return nombres;
    }
}

class Estudiante extends Persona {
    private String carrera;

    public Estudiante(String dni, String nombres, String direccion, String carrera) {
        super(dni, nombres, direccion);
        this.carrera = carrera;
    }

    public String getCarrera() {
        return carrera;
    }
}
