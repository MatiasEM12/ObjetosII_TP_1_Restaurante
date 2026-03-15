package Entities;

public class TarjetaComarcaPlus implements TarjetaCredito {

    private static final double DESCUENTO_TOTAL_PEDIDO = 0.02;

    @Override
    public double calcularDescuento(Pedido pedido) {
        return pedido.obtenerSubTotal() * DESCUENTO_TOTAL_PEDIDO;
    }
}
