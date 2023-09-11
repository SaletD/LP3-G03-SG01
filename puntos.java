import java.util.ArrayList;
import java.util.Scanner;
class Tcompu{
    private String nombT;
    private String proT;
    private String identi;
    private static ArrayList<Main> lista = new ArrayList<>();
    public Main(String nomT, String proT, String identi){
        this.nombT=nombT;
        this.proT=proT;
        this.identi=identi;
    }
    public String getNombT(){
        return nombT;
    }
    public void setNombT(String nombT){
        this.nombT=nombT;
    }
    public String getProT(){
        return proT;
    }
    public void setProT(String proT){
        this.proT=proT;
    }
    public String getIdenti(){
        return identi;
    }
    public void setIdenti(String identi){
        this.identi=identi;
    }   
}
class computadores{
    private String marca;
    private String cantmemoria;
    private String carac;
    private String sistema;
    private String precio;
    private static ArrayList<Main> lista = new ArrayList<>();
    public Main(String marca, String cantmemoria, String carac, String sistema, String precio){
        this.marca=marca;
        this.cantmemoria=cantmemoria;
        this.carac=carac;
        this.sistema=sistema;
        this.precio=precio;
    }
    public String getMarca(){
        return marca;
    }
    public void seMarca(String marca){
        this.marca=marca;
    }
    public String getCanti(){
        return cantmemoria;
    }
    public void setCanti(String cantmemoria){
        this.cantmemoria=cantmemoria;
    }
    public String getCarac(){
        return carac;
    }
    public void setCarac(String carac){
        this.carac=carac;
    }
    public String getSis(){
        return sistema;
    }
    public void setSis(String sistema){
        this.sistema=sistema;
    } 
    public String getPre(){
        return precio;
    }
    public void setPre(String precio){
        this.precio=precio;
    }
}
public class Main{
	public static void main(String[] args) {
	    Scanner sn = new Scanner(System.in);
	    boolean salir=false;
	    int opcion;
	    do{
	       System.out.println("--------Menu---------");
	       System.out.println("1. Agregar un computador a la tienda");
	       System.out.println("5. Salir");
	       System.out.println("Elige una opción");
	       opcion=sn.nextInt();
	       switch (opcion){
	           case 1:
	               Agregar();
	               break;
	           case 2:
	               salir=true;
	               break;
	           default:
	           System.out.println("Tienes que meter un valor entre 1 y 5");
	}
	}while (!salir);
	System.out.println("--------FIN--------");
}
public static void Añadir(){
    Scanner scanner = new Scanner(System.in);
    System.out.print("Ingrese marca del computador: ");
    String marca=scanner.nextLine();
}
