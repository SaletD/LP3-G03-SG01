package ejerciciobanco;
public class TestAsociacion{
    public static void main(String[] args) {
        Banco banco = new Banco("Mi Banco");

        Persona persona1 = new Persona('A', "Juan", "Perez");
        Persona persona2 = new Persona('B', "Maria", "Gomez");
        Persona persona3 = new Persona('A', "Pedro", "Ramirez");

        banco.agregarCliente(persona1);
        banco.agregarCliente(persona2);
        banco.agregarCliente(persona3);

        boolean encontrado = banco.buscarCliente(persona1);
        System.out.println("¿Es Juan Perez cliente del banco? " + (encontrado ? "Sí" : "No"));

        System.out.println(banco);
    }
}
