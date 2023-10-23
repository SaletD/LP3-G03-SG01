package tarealp1;

class Tetraedo extends FiguraTridimensional {
    private double arista;

    public Tetraedo(double arista) {
        this.arista = arista;
    }

    public double obtenerArea() {
        return Math.sqrt(3) * arista * arista;
    }

    public double obtenerVolumen() {
        return Math.sqrt(2) / 12 * arista * arista * arista;
    }

    public String descripcion() {
        return "Tetraedo de arista " + arista;
    }
}
