import Entities.*;
import Persistence.ArchivoVentas;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class TarjetasTest {


    @Test
    void costoTarjetaVisa(){
        var fakeArchivoVentas = new FakeArchivoVentas("ventasFake.txt");
        var tarjetaVisa = new TarjetaVisa(4532015112830366L);
        var pedido= new Pedido( tarjetaVisa, Propina.DOS,fakeArchivoVentas);

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
        var fakeArchivoVentas = new FakeArchivoVentas("ventasFake.txt");
        var tarjetaMartedcard = new TarjetaMastercard(4532015112830367L);
        var pedido= new Pedido(tarjetaMartedcard, Propina.DOS,fakeArchivoVentas);

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
        var fakeArchivoVentas = new FakeArchivoVentas("ventasFake.txt");
        var tarjetaComarcaPlus = new TarjetaComarcaPlus(4532015112830362L);
        var pedido= new Pedido(tarjetaComarcaPlus, Propina.DOS,fakeArchivoVentas);

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
        var fakeArchivoVentas = new FakeArchivoVentas("ventasFake.txt");
        var tarjetaViedma = new TarjetaViedma(4532015112830361L);
        var pedido= new Pedido( tarjetaViedma, Propina.DOS,fakeArchivoVentas);

        ArrayList<Item> items = new ArrayList<>();
        items.add(new Item(new Bebida("Coca-Cola", 100.00,true), 2));
        items.add(new Item(new Plato("Hamburguesa", 200.00,true), 1));
        pedido.agregarItems(items);
        pedido.confirmarPedido();
        var pagar= pedido.calcularTotal();

        assertEquals(408, pagar, 0.001);
    }


    @Test
    void archivoVentas(){
        var fakeArchivoVentas = new FakeArchivoVentas("ventasFake.txt");
        var tarjetaVisa = new TarjetaVisa(4532015112830111L);
        var pedido= new Pedido( tarjetaVisa, Propina.DOS,fakeArchivoVentas);

        ArrayList<Item> items = new ArrayList<>();
        items.add(new Item(new Bebida("Coca-Cola", 100.00,true), 2));
        items.add(new Item(new Plato("Hamburguesa", 200.00,true), 1));
        pedido.agregarItems(items);
        pedido.confirmarPedido();
        var pagar= pedido.calcularTotal();




        ArrayList<String> ventas= fakeArchivoVentas.listar();
        assertTrue(ventas.contains(pedido.toStringVenta()), "La venta se guardó correctamente en el archivo.");


    }





}







