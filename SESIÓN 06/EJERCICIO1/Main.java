package tarealp1;

public class Main {
    public static void main(String[] args) {
        Figura[] figuras = new Figura[6];
        figuras[0] = new Circulo(3);
        figuras[1] = new Cuadrado(4);
        figuras[2] = new Triangulo(5, 2);
        figuras[3] = new Esfera(2);
        figuras[4] = new Cubo(3);
        figuras[5] = new Tetraedo(4);

        for (Figura figura : figuras) {
            System.out.println(figura.descripcion());
            if (figura instanceof FiguraBidimensional) {
                System.out.println("Área: " + ((FiguraBidimensional) figura).obtenerArea());
            } else if (figura instanceof FiguraTridimensional) {
                System.out.println("Área: " + ((FiguraTridimensional) figura).obtenerArea());
                System.out.println("Volumen: " + ((FiguraTridimensional) figura).obtenerVolumen());
            }
            System.out.println();
        }
    }
}
