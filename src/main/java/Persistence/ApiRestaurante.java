package Persistence;

import Entities.Pedido;
import Entities.Venta;

public interface ApiRestaurante {




    public void persistirVenta(Venta venta);

    public void cobrar(Pedido pedido);

}
