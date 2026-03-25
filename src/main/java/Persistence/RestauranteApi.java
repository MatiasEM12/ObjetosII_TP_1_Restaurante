package Persistence;

import Entities.Pedido;
import Entities.Venta;

public class RestauranteApi implements ApiRestaurante {

     ArchivoVentas  archivoV= new ArchivoVentas();

    @Override
    public void persistirVenta(Venta venta) {
        archivoV.crear(venta.toString());
    }

    @Override
    public void cobrar(Pedido pedido) {
        pedido.calcularTotal();
        this.persistirVenta(pedido.getVenta);
    }
}
