package tarealp1;

class Cuadrado extends FiguraBidimensional {
    private double lado;

    public Cuadrado(double lado) {
        this.lado = lado;
    }

    public double obtenerArea() {
        return lado * lado;
    }

    public String descripcion() {
        return "Cuadrado de lado " + lado;
    }
}
