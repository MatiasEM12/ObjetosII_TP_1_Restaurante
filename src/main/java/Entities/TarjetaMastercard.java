package Entities;

public class TarjetaMastercard implements TarjetaCredito {

    private static final double DESCUENTO_TOTAL_PLATOS = 0.02;

    @Override
    public double calcularDescuento(Pedido pedido) {
        return pedido.obtenerSubTotalPlatos() * DESCUENTO_TOTAL_PLATOS;
    }
}
