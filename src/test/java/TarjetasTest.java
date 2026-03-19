import Entities.*;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class TarjetasTest {


    @Test
    void costoTarjetaVisa(){

        var tarjetaVisa = new TarjetaVisa(4532015112830366L);
        var pedido= new Pedido( tarjetaVisa, Propina.DOS);

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

        var tarjetaMartedcard = new TarjetaMastercard(4532015112830367L);
        var pedido= new Pedido(tarjetaMartedcard, Propina.DOS);

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
        var tarjetaComarcaPlus = new TarjetaComarcaPlus(4532015112830362L);
        var pedido= new Pedido(tarjetaComarcaPlus, Propina.DOS);

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
        var tarjetaViedma = new TarjetaViedma(4532015112830361L);
        var pedido= new Pedido( tarjetaViedma, Propina.DOS);

        ArrayList<Item> items = new ArrayList<>();
        items.add(new Item(new Bebida("Coca-Cola", 100.00,true), 2));
        items.add(new Item(new Plato("Hamburguesa", 200.00,true), 1));
        pedido.agregarItems(items);
        pedido.confirmarPedido();
        var pagar= pedido.calcularTotal();

        assertEquals(408, pagar, 0.001);
    }




}


