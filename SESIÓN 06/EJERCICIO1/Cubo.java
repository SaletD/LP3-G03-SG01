package tarealp1;

class Cubo extends FiguraTridimensional {
    private double lado;

    public Cubo(double lado) {
        this.lado = lado;
    }

    public double obtenerArea() {
        return 6 * lado * lado;
    }

    public double obtenerVolumen() {
        return lado * lado * lado;
    }

    public String descripcion() {
        return "Cubo de lado " + lado;
    }
}
