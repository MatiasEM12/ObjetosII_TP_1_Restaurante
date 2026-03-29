package Backend;

import Entities.Venta;

import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class VentaDAOJDBC implements  VentaDAO{


    @Override
    public void create(Venta venta) {

        if(venta==null)throw  new IllegalArgumentException("La venta es nulla,no se puede persistir");

        final String SQL="INSERT INTO ventas (id,hora_pago,pago) VALUES (?,?,?)";

        try(Connection conn=ConnectionManager.getConnection();
            PreparedStatement st= conn.prepareStatement(SQL)){

            st.setString(1,venta.getId());
            st.setTimestamp(2, Timestamp.valueOf(venta.getHoraPago()));
            st.setDouble(3,venta.getPago());

            st.executeUpdate();


        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally{
            ConnectionManager.disconnect();
        }
    }

    @Override
    public void update(Venta venta) {
        throw  new RuntimeException("update venta no implementado");
    }

    @Override
    public void remove(String id) {
        throw  new RuntimeException("remove por id venta no implementado");
    }

    @Override
    public void remove(Venta venta) {
        throw  new RuntimeException("remove por venta no implementado");
    }

    @Override
    public Venta find(String codigo) {
        throw  new RuntimeException("find venta no implementado");
    }

    @Override
    public List<Venta> findAll() {
        List<Venta>ventas= new ArrayList<>();
        final String SQL="SELECT * FROM ventas ";

        try(Connection conn=ConnectionManager.getConnection();
            Statement statement = conn.createStatement();
            ResultSet rs = statement.executeQuery(SQL)){

            while(rs.next()) {

                Timestamp ts = rs.getTimestamp("hora_pago");
                LocalDateTime fechaHora = ts.toLocalDateTime();
                var venta= new Venta( rs.getString("id"), fechaHora ,   rs.getDouble("pago") );

                ventas.add(venta);


            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally{
            ConnectionManager.disconnect();
        }

        return ventas;
    }

}
