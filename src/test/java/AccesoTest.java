import Backend.VentaDAOJDBC;
import Entities.*;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class AccesoTest {


    @Test
    public void acceso(){

        var venta= new Venta(LocalDateTime.now(), 100.00);
        var ventaDAO = new VentaDAOJDBC();

        try {
            ventaDAO.create(venta);

            var ventaAccedida = ventaDAO.find(venta.getId());
            assertNotNull(ventaAccedida, "La venta accedida no debe ser nula.");
            ventaDAO.remove(venta.getId());
        }catch (RuntimeException e){
            throw new RuntimeException(e+ "Error al acceder a la venta en la base de datos.");
        }
    }


}

