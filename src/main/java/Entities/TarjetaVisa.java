package Entities;

public class TarjetaVisa implements  TarjetaCredito {

    private static final double DESCUENTO_TOTAL_BEBIDAS = 0.03;

    @Override
    public double calcularDescuento(Pedido pedido) {
        return pedido.obtenerTotalBebidas() * DESCUENTO_TOTAL_BEBIDAS;
    }
}
