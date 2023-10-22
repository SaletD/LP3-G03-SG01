package ejerherencia;
public class TestHerencia {
    public static void main(String[] args){
        Asalariado e1 = new Asalariado("Manuel Cortina", 12345678, 28);
        EmpleadoProduccion e2 = new EmpleadoProduccion("Juan Mota", 55333222, 30, "noche");
        EmpleadoDistribucion e3 = new EmpleadoDistribucion("Antonio Camino", 55333222, 30, "Granada");

        System.out.println("Nombre del empleado 1: " + e1.getNombre());
        System.out.println("Nombre del empleado 2: " + e2.getNombre());
        System.out.println("Turno del empleado 2: " + e2.getTurno());
        System.out.println("Nombre del empleado 3: " + e3.getNombre());
        System.out.println("Región del empleado 3: " + e3.getRegion());
    }    
}
