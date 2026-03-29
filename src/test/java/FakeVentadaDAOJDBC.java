import Backend.VentaDAO;
import Entities.Venta;

import java.util.ArrayList;
import java.util.List;

public class FakeVentadaDAOJDBC implements VentaDAO {

    List<Venta>ventas;

    public FakeVentadaDAOJDBC(){
        ventas= new ArrayList<>();
    }

    @Override
    public void create(Venta venta) {
        if(venta==null) throw new IllegalArgumentException("Venta nula no se puede persistir");

        ventas.add(venta);
    }

    @Override
    public void update(Venta venta) {
        throw  new RuntimeException("update venta  fake no implementado");
    }

    @Override
    public void remove(String id) {
        throw  new RuntimeException("remove por id venta fake no implementado");
    }

    @Override
    public void remove(Venta venta) {
        throw  new RuntimeException("remove por venta fake no implementado");
    }

    @Override
    public Venta find(String codigo) {
        throw  new RuntimeException("find venta fake no implementado");
    }

    @Override
    public List<Venta> findAll() {
        return this.ventas;
    }
}
