package tarealp1;

class Circulo extends FiguraBidimensional {
    private double radio;

    public Circulo(double radio) {
        this.radio = radio;
    }

    public double obtenerArea() {
        return Math.PI * radio * radio;
    }

    public String descripcion() {
        return "Círculo de radio " + radio;
    }
}
