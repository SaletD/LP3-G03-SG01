public class BuscarElemento {

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
                        // ... (resto del código)
                        break;
                    case "nombresycarrera":
                        // ... (resto del código)
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
        Producto[] productos = {
                new Producto("001", "Laptop", 1200.0),
                new Producto("002", "Teléfono", 500.0),
                new Producto("003", "Tablet", 300.0)
        };

        int posicionProducto = buscarElemento(productos, "codigo", "002");
        System.out.println("Producto encontrado en la posición: " + posicionProducto);
    }
}



--------------------------

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


--------------------------


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


-------------------------

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
