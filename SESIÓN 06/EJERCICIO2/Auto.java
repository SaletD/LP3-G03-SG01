package tarealp2;

class Auto implements ImpactoEcológico {
    private double emisionesCO2;
    private double distanciaRecorrida;

    public Auto(double emisionesCO2, double distanciaRecorrida) {
        this.emisionesCO2 = emisionesCO2;
        this.distanciaRecorrida = distanciaRecorrida;
    }

    public double obtenerImpactoEcológico() {
        return (emisionesCO2 * 1000) / distanciaRecorrida;
    }
}
