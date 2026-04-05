package Backend;

import Entities.Venta;

import java.util.List;

public interface VentaDAO {



    public  void create(Venta venta);

    public  void update(Venta venta);

    public  void remove(String id);

    public  void remove(Venta venta);

    public  Venta find(String codigo);

    public  List<Venta> findAll();

    public  void truncateTabla();
}
