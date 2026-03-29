package Backend;

import Entities.Venta;

import java.util.List;

public abstract class VentaDAO {

    protected VentaDAO(){

    }

    public abstract void create(Venta venta);

    public abstract void update(Venta venta);

    public abstract void remove(String id);

    public abstract void remove(Venta venta);

    public abstract Venta find(String codigo);

    public abstract List<Venta> findAll();
}
