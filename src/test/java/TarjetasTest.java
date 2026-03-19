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



    }
    @Test
    void costoTarjetaMastercard(){

    }

    @Test
    void costoTarjetaComarcaPlus(){

    }

    @Test
    void costoTarjetaViedma(){

    }




}


