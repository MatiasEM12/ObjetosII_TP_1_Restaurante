import Entities.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TarjetasTest {


    @Test
    void costoTarjetaVisa(){

        var tarjetaVisa = new TarjetaVisa();
        var pedido= new Pedido( tarjetaVisa, Propina.DOS);



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


