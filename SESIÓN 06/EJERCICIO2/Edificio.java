package tarealp2;

class Edificio implements ImpactoEcológico {
    private double consumoEnergético;
    private double emisionesCO2;

    public Edificio(double consumoEnergético, double emisionesCO2) {
        this.consumoEnergético = consumoEnergético;
        this.emisionesCO2 = emisionesCO2;
    }

    public double obtenerImpactoEcológico() {
        return (emisionesCO2 * 1000) / consumoEnergético;
    }
}
