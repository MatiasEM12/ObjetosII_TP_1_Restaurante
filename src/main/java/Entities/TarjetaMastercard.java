package Entities;

public class TarjetaMastercard implements TarjetaCredito {

    private static final double DESCUENTO_TOTAL_PLATOS = 0.03;

    @Override
    public double calcularDescuento(Pedido pedido) {
        return pedido.obtenerSubTotalPlatos() * DESCUENTO_TOTAL_PLATOS;
    }
}
