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
	       System.out.println("2. Buscar Contacto");
	       System.out.println("3. Modificar Contacto");
	       System.out.println("4. Borrar Contacto");
	       System.out.println("5. Mostrar Contactos");
	       System.out.println("6. Salir");
	       System.out.println("Elige una opción");
	       opcion=sn.nextInt();
	       switch (opcion){
	           case 1:
	               Añadir();
	               break;
	           case 2:
	               if (!agenda.isEmpty()){
	                      Buscar();
	                  }else{
	                      System.out.println("Debes añadir un contacto primero");
	                  }
	                  break;
	           case 3:
	               if (!agenda.isEmpty()){
	                      Modificar();
	                  }else{
	                      System.out.println("Debes añadir un contacto primero");
	                  }
	                  break;
	           case 4:
	               if (!agenda.isEmpty()){
	                      Borrar();
	                  }else{
	                      System.out.println("Debes añadir un contacto primero");
	                  }
	                  break;
	           case 5:
	               if (!agenda.isEmpty()){
	                      Mostrar();
	                  }else{
	                      System.out.println("Debes añadir un contacto primero");
	                  }
	                  break;	           
	           case 6:
	               salir=true;
	               break;
	           default:
	           System.out.println("Tienes que meter un valor entre 1 y 6");
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
public static void Buscar(){
    Scanner scanner = new Scanner(System.in);
    boolean encontrar=false;
    System.out.print ("Ingrese el nombre del contacto: ");
    String nombusqueda=scanner.nextLine();
    for (Main contacto:agenda){
        if(contacto.getNombre().equals(nombusqueda)){
            System.out.println("Se econtro al contacto "+nombusqueda+" correctamente!");
            encontrar=true;
            break;
        }
    }
    if(!encontrar){
        System.out.println("No se econtro al contacto "+nombusqueda);
    }
}
public static void Modificar(){
    Scanner scanner = new Scanner(System.in);
    boolean encontrar=false;
    System.out.print ("Ingrese el nombre del contacto: ");
    String nvnombre = "";
    String nvtelefono = "";
    String nvdireccion = "";
    String nomcontacto=scanner.nextLine();
    for (Main contacto:agenda){
        if (contacto.getNombre().equals(nomcontacto)){
            System.out.println("¿Del contacto "+nomcontacto+" que desea modificar?");
            System.out.println("1. Nombre");
            System.out.println("2. Telefono");
            System.out.println("3. Direccion");
            System.out.println("4. Los 3 datos");
            int opc=scanner.nextInt();
            scanner.nextLine();
            switch(opc){
                case 1:
                    System.out.print ("Ingrese el nuevo nombre del contacto: ");
                    nvnombre=scanner.nextLine();
                    contacto.setNombre(nvnombre);
                    break;
                case 2:
                    System.out.print ("Ingrese el nuevo telefono del contacto: ");
                    nvtelefono=scanner.nextLine();
                    contacto.setTelefono(nvtelefono);
                    break;
                case 3:
                    System.out.print ("Ingrese la nueva direccion del contacto: ");
                    nvdireccion=scanner.nextLine();
                    contacto.setDireccion(nvdireccion);
                    break;
                case 4:
                    System.out.print ("Ingrese el nuevo nombre del contacto: ");
                    nvnombre=scanner.nextLine();
                    System.out.print ("Ingrese el nuevo telefono del contacto: ");
                    nvtelefono=scanner.nextLine();
                    System.out.print ("Ingrese la nueva direccion del contacto: ");
                    nvdireccion=scanner.nextLine();
                    contacto.setTelefono(nvtelefono);
                    contacto.setNombre(nvnombre);
                    contacto.setDireccion(nvdireccion);
                    break;
                default:
                System.out.print ("Ingrese un número entre 1-4");
            }
            encontrar=true;
            System.out.println("Contacto modificado correctamente");
            break;
        }
    }
    if (!encontrar){
        System.out.println("No se encontró al contacto " + nomcontacto);
    }
}
public static void Borrar(){
    Scanner scanner = new Scanner(System.in);
    boolean encontrar=false;
    System.out.print ("Ingrese el nombre del contacto: ");
    String nomborrar=scanner.nextLine();
    ArrayList<Main> Borrar = new ArrayList<>();
    for (Main contacto:agenda){
            if (contacto.getNombre().equals(nomborrar)){
                Borrar.add(contacto);
                encontrar=true;
            }
    }
        if (encontrar){
            for (Main contacto:Borrar) {
                agenda.remove(contacto);
        }
        System.out.println("Contacto borrado correctamente!");
    }
    if (!encontrar){
        System.out.println("No se encontró al contacto " + nomborrar);
    }
}
public static void Mostrar(){
    System.out.println("--------AGENDA--------");
    for (Main contacto:agenda){
        System.out.println("Nombre: "+contacto.getNombre());
        System.out.println("Telefono: "+contacto.getTelefono());
        System.out.println("Direccion: "+contacto.getDireccion());
        System.out.println("-----------------");
    }
}
}
