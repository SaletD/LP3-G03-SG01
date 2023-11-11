public class Alumno extends Persona {
    private Fecha fechaInscripcion;

    public void setFechaInscripcion(Fecha fechaInscripcion) {
        this.fechaInscripcion = fechaInscripcion;
    }

    public Fecha getFechaInscripcion() {
        return fechaInscripcion;
    }

    @Override
    public String toString() {
        return "Alumno [nombre=" + getNombre() + ", edad=" + getEdad() + ", fechaInscripcion=" + fechaInscripcion + "]";
    }
}



----------------------


import java.io.Serializable;

public class Fecha implements Serializable {
    private int dia;
    private int mes;
    private int año;

    @Override
    public String toString() {
        return "Fecha [dia=" + dia + ", mes=" + mes + ", año=" + año + "]";
    }
}


----------------------

import java.io.Serializable;

public class Persona implements Serializable {
    protected String nombre;
    protected int edad;

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public int getEdad() {
        return edad;
    }

    @Override
    public String toString() {
        return "Persona [nombre=" + nombre + ", edad=" + edad + "]";
    }
}

----------------------

import java.io.*;

public class SerializacionEjemplo {

    public static void main(String[] args) {
        
        Alumno alumno1 = new Alumno();
        alumno1.setNombre("Juan");
        alumno1.setEdad(20);
        alumno1.setFechaInscripcion(new Fecha());

        Alumno alumno2 = new Alumno();
        alumno2.setNombre("Maria");
        alumno2.setEdad(22);
        alumno2.setFechaInscripcion(new Fecha());

        Alumno alumno3 = new Alumno();
        alumno3.setNombre("Pedro");
        alumno3.setEdad(21);
        alumno3.setFechaInscripcion(new Fecha());

        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("alumnos.dat"))) {
            out.writeObject(alumno1);
            out.writeObject(alumno2);
            out.writeObject(alumno3);
            System.out.println("Datos de los alumnos serializados y guardados en el archivo.");
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream("alumnos.dat"))) {
            Alumno alumnoLeido1 = (Alumno) in.readObject();
            Alumno alumnoLeido2 = (Alumno) in.readObject();
            Alumno alumnoLeido3 = (Alumno) in.readObject();

            System.out.println("Datos del alumno 1: " + alumnoLeido1);
            System.out.println("Datos del alumno 2: " + alumnoLeido2);
            System.out.println("Datos del alumno 3: " + alumnoLeido3);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}


----------------------
