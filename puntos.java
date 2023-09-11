import java.util.ArrayList;
import java.util.Scanner;
class Tienda{
    private String nombT;
    private String proT;
    private String identi;
    private static ArrayList<Computadores> computadores = new ArrayList<>();
    public Tienda(String nombT, String proT, String identi){
        this.nombT=nombT;
        this.proT=proT;
        this.identi=identi;
    }
    public void añadir(Computadores computador) {
        computadores.add(computador);
    }
}
class Computadores{
    private String marca;
    private String cantmemoria;
    private String carac;
    private String sistema;
    private String precio;
    public Computadores(String marca, String cantmemoria, String carac, String sistema, String precio){
        this.marca=marca;
        this.cantmemoria=cantmemoria;
        this.carac=carac;
        this.sistema=sistema;
        this.precio=precio;
    }
    public String getMarca(){
        return marca;
    }
    public void setMarca(String marca){
        this.marca=marca;
    }
}
public class Main{
	public static void main(String[] args) {
	    Scanner sn = new Scanner(System.in);
	    boolean salir=false;
	    int opcion;
	    Tienda tienda=new Tienda("Java Tienda", "Salet Bravo", "12345");
	    do{
	       System.out.println("--------Menu---------");
	       System.out.println("1. Agregar un computador a la tienda");
	       System.out.println("2. Eliminar un computador de la tienda");
	       System.out.println("5. Salir");
	       System.out.println("Elige una opción");
	       opcion=sn.nextInt();
	       switch (opcion){
	           case 1:
	               Agregar(tienda);
	               break;
	           case 2:
	               if (!computador.isEmpty()){
	                   Eliminar(tienda);
	               } else{
	                 System.out.println("Desbes agreagar una computadora primero");  
	               }
	           case 3:
	               salir=true;
	               break;
	           default:
	           System.out.println("Tienes que meter un valor entre 1 y 5");
	}
	}while (!salir);
	System.out.println("--------FIN--------");
}
public static void Agregar(Tienda tienda){
    Scanner scanner = new Scanner(System.in);
    System.out.print("Ingrese marca del computador: ");
    String marca=scanner.nextLine();
    System.out.print("Ingrese cantidad de memoria: ");
    String cantmemoria=scanner.nextLine();
    System.out.print("Ingrese caracteristicas del procesador: ");
    String carac=scanner.nextLine();
    System.out.print("Ingrese sistema operativo: ");
    String sistema=scanner.nextLine();
    System.out.print("Ingrese precio del computador: ");
    String precio=scanner.nextLine();
    Computadores nuevo=new Computadores(marca,cantmemoria,carac,sistema,precio);
    tienda.añadir(nuevo);
    System.out.println("¡Se añadió el computador correctamente!");
}
public static void Eliminar(Tienda tienda){
    Scanner scanner = new Scanner(System.in);
    boolean encontrar=false;
    System.out.print("Ingrese marca del computador: ");
    String bmarca=scanner.nextLine();
    ArrayList<Computadores> Eliminar=new ArrayList();
    for (Tienda computador:agenda){
        if (computador.getMarca().equals(bmarca)){
            Eliminar.add(computador);
        }
        if(encontrar){
           for (Tienda contacto:Eliminar){
               computadores.remove(computador);
           }
        }
        System.out.println("Se elimino correctamente!");
    }
    if (!encontrar){
        System.out.println("No se encontro");
    }
    
}
}
