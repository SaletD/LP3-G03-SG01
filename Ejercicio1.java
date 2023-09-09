import java.util.ArrayList;
import java.util.Scanner;
public class Main{
    private String nombre;
    private String telefono;
    private String direccion;
    private static ArrayList<Main> agenda = new ArrayList<>();
    public Main(String nombre, String telefono, String direccion){
        this.nombre=nombre;
        this.telefono=telefono;
        this.direccion=direccion;
    }
    public String getNombre(){
        return nombre;
    }
    public void setNombre(String nombre){
        this.nombre=nombre;
    }
    public String getTelefono(){
        return telefono;
    }
    public void setTelefono(String telefono){
        this.telefono=telefono;
    }
    public String getDireccion(){
        return direccion;
    }
    public void setDireccion(String direccion){
        this.direccion=direccion;
    }
	public static void main(String[] args) {
	    Scanner sn = new Scanner(System.in);
	    
	    boolean salir=false;
	    int opcion;
	    do{
	       System.out.println("--------Menu---------");
	       System.out.println("1. Añadir");
	       System.out.println("7. Salir");
	       System.out.println("Elige una opción");
	       opcion=sn.nextInt();
	       switch (opcion){
	           case 1:
	               Añadir();
	               break;
	           case 2:
	               salir=true;
	               break;
	           default:
	           System.out.println("Tienes que meter un valor entre 1 y 7");
	    }
	}while (!salir);
	System.out.println("--------FIN--------");
}
public static void Añadir(){
    Scanner scanner = new Scanner(System.in);
    System.out.print("Ingrese el nombre del contacto: ");
    String nombre=scanner.nextLine();
    System.out.print("Ingrese el telefono  del contacto: ");
    String telefono=scanner.nextLine();
    System.out.print("Ingrese la dirección del contacto: ");
    String direccion=scanner.nextLine();
    Main nuevo=new Main(nombre,telefono,direccion);
    agenda.add(nuevo);
    System.out.println("¡Se añadió el contacto "+nombre+" correctamente!");
}
}
