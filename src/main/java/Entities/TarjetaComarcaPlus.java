package Entities;

public class TarjetaComarcaPlus extends Tarjeta {

    private static final double DESCUENTO_TOTAL_PEDIDO = 0.02;

    public TarjetaComarcaPlus(Long numeroTarjeta) {
        super(numeroTarjeta);
    }
    @Override
    public double calcularDescuento(Pedido pedido) {
        return pedido.obtenerSubTotal() * DESCUENTO_TOTAL_PEDIDO;
    }
}
