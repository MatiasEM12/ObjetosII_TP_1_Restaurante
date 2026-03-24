import Backend.VentaDAOJDBC;
import Entities.*;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AccesoTest {


    @Test
    public void acceso(){

        var venta= new Venta(LocalDateTime.now(), 100.00);
        var ventaDAO = new VentaDAOJDBC();
        ventaDAO.create(venta);


    }


}

