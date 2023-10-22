package ejerciciobanco;
import java.util.Objects;

public class Persona {
    private char tipo;
    private String nombre;
    private String apellido;

    public Persona(char tipo, String nombre, String apellido) {
        this.tipo = tipo;
        this.nombre = nombre;
        this.apellido = apellido;
    }

    public char getTipo() {
        return tipo;
    }

    public void setId(char tipo) {
        this.tipo = tipo;
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

    @Override
    public String toString() {
        return "Información de la persona: \n" +
               "Nombre: " + getNombre() + "\n" +
               "Apellido: " + getApellido() + "\n" +
               "Tipo: " + getTipo() + "\n";
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null || getClass() != obj.getClass())
            return false;
        Persona persona = (Persona) obj;
        return tipo == persona.tipo &&
               Objects.equals(nombre, persona.nombre) &&
               Objects.equals(apellido, persona.apellido);
    }
}
