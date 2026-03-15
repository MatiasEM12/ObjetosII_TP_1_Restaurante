package Entities;

public class TarjetaMastercad implements TarjetaCredito {

    private static final double DESCUENTO_TOTAL_PLATOS = 0.03;

    @Override
    public double calcularDescuento(Pedido pedido) {
        return pedido.obtenerTotalPlatos() * DESCUENTO_TOTAL_PLATOS;
    }
}
