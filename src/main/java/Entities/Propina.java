package Entities;

public enum Propina {

    DOS(0.02),
    TRES(0.03),
    CINCO(0.05);

    private final double porcentaje;

    Propina(double porcentaje) {
        this.porcentaje = porcentaje;
    }

    public double calcularSobre(double monto) {
        return monto * porcentaje;
    }

    public double getPorcentaje() {
        return porcentaje;
    }
}
