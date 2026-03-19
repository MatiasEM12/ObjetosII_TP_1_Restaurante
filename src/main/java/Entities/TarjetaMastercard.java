package Entities;

public class TarjetaMastercard extends Tarjeta{

    private static final double DESCUENTO_TOTAL_PLATOS = 0.02;

    public TarjetaMastercard(Long numeroTarjeta){
        super(numeroTarjeta);
    }

    @Override
    public double calcularDescuento(Pedido pedido) {
        return pedido.obtenerSubTotalPlatos() * DESCUENTO_TOTAL_PLATOS;
    }
}
