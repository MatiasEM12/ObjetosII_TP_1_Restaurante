package Backend;

import Entities.Venta;

import java.util.List;

public interface VentaDAO {

    void create(Venta venta);

    void update(Venta venta);

    void remove(String id);

    void remove(Venta venta);

    Venta find(Integer codigo);

    List<Venta> findAll();
}
