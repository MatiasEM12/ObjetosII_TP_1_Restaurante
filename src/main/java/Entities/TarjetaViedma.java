package Entities;

public class TarjetaViedma extends Tarjeta {

    public TarjetaViedma(Long numeroTarjeta){
        super(numeroTarjeta);
    }


    @Override
    public double calcularDescuento(Pedido pedido) {
        return 0;
    }
}

