package tarealp2;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<ImpactoEcológico> objetos = new ArrayList<ImpactoEcológico>();
        objetos.add(new Edificio(1000, 50));
        objetos.add(new Auto(10, 100));
        objetos.add(new Bicicleta(0, 50));

        for (ImpactoEcológico objeto : objetos) {
            System.out.println("Objeto: " + objeto.getClass().getSimpleName());
            System.out.println("Impacto ecológico: " + objeto.obtenerImpactoEcológico() + " GEI");
        }
    }
}
