package Backend;

import Entities.Venta;

import java.util.List;

public interface VentaDAO {

    void create(Venta venta);

    void update(Venta venta);

    void remove(String id);

    void remove(Venta venta);

    Venta find(String codigo);

    List<Venta> findAll();
}
