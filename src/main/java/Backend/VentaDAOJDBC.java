package Backend;

import Entities.Venta;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class VentaDAOJDBC implements  VentaDAO {
    @Override
    public void create(Venta venta) {
        if(venta ==null) throw new IllegalArgumentException("La venta no puede ser nula.");

        final String SQL= "INSERT INTO ventas (hora_pago, venta) VALUES (?,?)";

        try(Connection conn = ConnectionManager.getConnection();
            PreparedStatement st = conn.prepareStatement(SQL)){
            st.setString(1, formatoHoraPago(venta.getHoraPago()));
            st.setDouble(2, venta.getVenta());
            st.executeUpdate();


        } catch (RuntimeException | SQLException e) {
            throw new RuntimeException(e+ "Error al crear la venta en la base de datos.");
        }finally {
            ConnectionManager.disconnect();
        }
    }

    @Override
    public void update(Venta venta) {

    }

    @Override
    public void remove(String id) {

    }

    @Override
    public void remove(Venta venta) {

    }

    @Override
    public Venta find(Integer codigo) {
        return null;
    }

    @Override
    public List<Venta> findAll() {
        return List.of();
    }

    private String formatoHoraPago(LocalDateTime hora){
        LocalDateTime dateTime = hora;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
       return  dateTime.format(formatter);
    }
}
