package Backend;

import Entities.Venta;

import java.sql.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class VentaDAOJDBC implements  VentaDAO {
    @Override
    public void create(Venta venta) {
        if(venta ==null) throw new IllegalArgumentException("La venta no puede ser nula.");

        final String SQL= "INSERT INTO ventas (id,hora_pago, pago) VALUES (?,?,?)";

        try(Connection conn = ConnectionManager.getConnection();
            PreparedStatement st = conn.prepareStatement(SQL)){
            st.setString(1, venta.getId());
            st.setTimestamp(2, Timestamp.valueOf(venta.getHoraPago()));
            st.setDouble(3, venta.getPago());
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
            if(id == null || id.isEmpty()) throw new IllegalArgumentException("El ID de la venta no puede ser nulo o vacío.");

            final String SQL= "DELETE FROM ventas WHERE id = ?";

            try(Connection conn = ConnectionManager.getConnection();
                PreparedStatement st = conn.prepareStatement(SQL)){

                st.setString(1, id);
                st.executeUpdate();

            }catch(RuntimeException | SQLException e){
                throw new RuntimeException(e + "Error al eliminar la venta de la base de datos.");

            }finally{
                ConnectionManager.disconnect();
            }

    }

    @Override
    public void remove(Venta venta) {

    }

    @Override
    public Venta find(String codigo) {
        if(codigo == null || codigo.isEmpty()) throw new IllegalArgumentException("El código de la venta no puede ser nulo o vacío.");
        Venta venta=null;
        final String SQL= "SELECT * FROM ventas WHERE id = ?";

        try(Connection conn = ConnectionManager.getConnection();
            PreparedStatement st = conn.prepareStatement(SQL)){

            st.setString(1, codigo);
            ResultSet rs = st.executeQuery();

            if(!rs.next()){
                return  null;
            }
            Timestamp ts = rs.getTimestamp("hora_pago");
            LocalDateTime fechaHora = ts.toLocalDateTime();
            return new Venta( rs.getString("id"),fechaHora, rs.getDouble("pago"));
        }catch(RuntimeException | SQLException e){
            throw new RuntimeException(e + "Error al buscar la venta en la base de datos.");

        }finally{
            ConnectionManager.disconnect();
        }


    }

    @Override
    public List<Venta> findAll() {
        return List.of();
    }


}
