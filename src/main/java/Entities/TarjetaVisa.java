package Entities;

public class TarjetaVisa extends Tarjeta {

    private static final double DESCUENTO_TOTAL_BEBIDAS = 0.03;

    public TarjetaVisa(Long numeroTarjeta){
        super(numeroTarjeta);
    }


    @Override
    public double calcularDescuento(Pedido pedido) {
        return pedido.obtenerSubTotalBebidas() * DESCUENTO_TOTAL_BEBIDAS;
    }
}
