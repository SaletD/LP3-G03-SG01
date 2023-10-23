package tarealp1;

class Esfera extends FiguraTridimensional {
    private double radio;

    public Esfera(double radio) {
        this.radio = radio;
    }

    public double obtenerArea() {
        return 4 * Math.PI * radio * radio;
    }

    public double obtenerVolumen() {
        return 4.0 / 3.0 * Math.PI * radio * radio * radio;
    }

    public String descripcion() {
        return "Esfera de radio " + radio;
    }
}
