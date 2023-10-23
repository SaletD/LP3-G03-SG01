package tarealp2;

class Bicicleta implements ImpactoEcológico {
    private double emisionesCO2;
    private double distanciaRecorrida;

    public Bicicleta(double emisionesCO2, double distanciaRecorrida) {
        this.emisionesCO2 = emisionesCO2;
        this.distanciaRecorrida = distanciaRecorrida;
    }

    public double obtenerImpactoEcológico() {
        return (emisionesCO2 * 1000) / distanciaRecorrida;
    }
}
