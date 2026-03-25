package Persistence;

import Entities.Venta;

public class ArchivoApi implements ApiRestaurante {

     ArchivoVentas  archivoV= new ArchivoVentas();

    public ArchivoApi(){

    }

    @Override
    public void persistirVenta(Venta venta) {
        archivoV.crear(venta.toString());
    }


}
