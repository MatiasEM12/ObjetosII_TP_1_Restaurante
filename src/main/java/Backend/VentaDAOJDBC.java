package Backend;

import Entities.Venta;

import java.util.List;

public class VentaDAOJDBC implements  VentaDAO{


    @Override
    public void create(Venta venta) {

        if(venta==null)throw  new IllegalArgumentException("La venta es nulla,no se puede persistir");

        final String SQL="";
    }

    @Override
    public void update(Venta venta) {

    }

    @Override
    public void remove(String id) {

    }

    @Override
    public void remove(Venta venta) {

    }

    @Override
    public Venta find(String codigo) {
        return null;
    }

    @Override
    public List<Venta> findAll() {
        return List.of();
    }
}
