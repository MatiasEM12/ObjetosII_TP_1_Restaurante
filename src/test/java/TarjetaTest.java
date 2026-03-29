import Entities.*;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class TarjetaTest {


    @Test
    void costoTarjetaVisa(){
        var fakeVentaDao= new FakeVentadaDAOJDBC();
        var tarjetaVisa = new TarjetaVisa(4532015112830366L);
        var pedido= new Pedido( tarjetaVisa, Propina.DOS,fakeVentaDao);

        ArrayList<Item> items = new ArrayList<>();
        items.add(new Item(new Bebida("Coca-Cola", 100.00,true), 2));
        items.add(new Item(new Plato("Hamburguesa", 200.00,true), 1));
        pedido.agregarItems(items);
        pedido.confirmarPedido();
        var pagar= pedido.calcularTotal();

        assertEquals(401.88, pagar, 0.001);

    }
    @Test
    void costoTarjetaMastercard(){
        var fakeVentaDao= new FakeVentadaDAOJDBC();
        var tarjetaMartedcard = new TarjetaMastercard(4532015112830367L);
        var pedido= new Pedido(tarjetaMartedcard, Propina.DOS,fakeVentaDao);

        ArrayList<Item> items = new ArrayList<>();
        items.add(new Item(new Bebida("Coca-Cola", 100.00,true), 2));
        items.add(new Item(new Plato("Hamburguesa", 200.00,true), 1));
        pedido.agregarItems(items);
        pedido.confirmarPedido();
        var pagar= pedido.calcularTotal();

        assertEquals(403.92, pagar, 0.001);
    }

    @Test
    void costoTarjetaComarcaPlus(){
        var fakeVentaDao= new FakeVentadaDAOJDBC();
        var tarjetaComarcaPlus = new TarjetaComarcaPlus(4532015112830362L);
        var pedido= new Pedido(tarjetaComarcaPlus, Propina.DOS,fakeVentaDao);

        ArrayList<Item> items = new ArrayList<>();
        items.add(new Item(new Bebida("Coca-Cola", 100.00,true), 2));
        items.add(new Item(new Plato("Hamburguesa", 200.00,true), 1));
        pedido.agregarItems(items);
        pedido.confirmarPedido();
        var pagar= pedido.calcularTotal();

        assertEquals(399.84, pagar, 0.001);
    }

    @Test
    void costoTarjetaViedma(){
        var fakeVentaDao= new FakeVentadaDAOJDBC();
        var tarjetaViedma = new TarjetaViedma(4532015112830361L);
        var pedido= new Pedido( tarjetaViedma, Propina.DOS,fakeVentaDao);

        ArrayList<Item> items = new ArrayList<>();
        items.add(new Item(new Bebida("Coca-Cola", 100.00,true), 2));
        items.add(new Item(new Plato("Hamburguesa", 200.00,true), 1));
        pedido.agregarItems(items);
        pedido.confirmarPedido();
        var pagar= pedido.calcularTotal();

        assertEquals(408, pagar, 0.001);
    }


    @Test
    void accesoVentas(){
        var fakeVentaDao= new FakeVentadaDAOJDBC();
        var tarjetaViedma = new TarjetaViedma(4532015112830322L);
        var pedido= new Pedido( tarjetaViedma, Propina.DOS,fakeVentaDao);

        ArrayList<Item> items = new ArrayList<>();
        items.add(new Item(new Bebida("Coca-Cola", 100.00,true), 2));
        items.add(new Item(new Plato("Hamburguesa", 200.00,true), 1));
        pedido.agregarItems(items);
        pedido.confirmarPedido();
        var pagar= pedido.calcularTotal();

        List<Venta>ventas = fakeVentaDao.findAll();

        assertTrue(ventas.contains(pedido.getVenta()));

    }





}






