package sesion7p3;

public class AsercionesEjemplo {
    public static void main(String[] args) {
        int velocidadCalculada = calcularVelocidadParticula(300); // Suponemos que la velocidad calculada no puede ser mayor que 300
        
        assert velocidadCalculada <= 300 : "La velocidad calculada es mayor de lo esperado"; // Aserción

        System.out.println("La velocidad calculada es: " + velocidadCalculada);
    }

    public static int calcularVelocidadParticula(int limite) {
        // Simulación de cálculo de velocidad
        int velocidad = (int) (Math.random() * 400); // Generamos un valor aleatorio
        
        return velocidad;
    }
}
