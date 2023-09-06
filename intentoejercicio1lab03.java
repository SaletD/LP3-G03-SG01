import java.util.Scanner;
public class Contacto {
    private String nombre;
    private String telefono;
    private String direccion;
    public Contacto(String nombre, String telefono, String direccion){
        this.nombre=nombre;
        this.telefono=telefono;
        this.direccion=direccion;
    }
    public String getNombre(){
        return nombre;
    }
    public void setNombre(String nombre){
        this.nombre=nombre
    }
    public String getTelefono(){
        return telefono;
    }
    public void setTelefono(String telefono){
        this.telefono=telefono
    }
    public String getDireccion(){
        return direccion;
    }
    public void setDireccion(String direccion){
        this.direccion=direccion
    }
}
public static void main(String[] args){
    Scanner sn = new Scanner(System.in);
    int opcion;
    do{
        System.out.println("--------Menu---------");
        System.out.println("1. Añadir");
        System.out.println("7. Salir");
        System.out.println("Elige una opción");
        opcion=sn.nextInt();
        switch (opcion){
            case 1:
                break;
            case 2:
                salir=true;
                break;
        }
    }while (!salir);
    System.out.println("--------FIN--------");
}
public static string Añadir{
  
}
 
