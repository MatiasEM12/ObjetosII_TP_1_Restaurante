import java.util.ArrayList;

public class FakeArchivoVentas extends Entities.GestionArchivo<String> {
    private ArrayList<String> datos = new ArrayList<>();

    public FakeArchivoVentas(String ruta) {
        super(ruta);
    }

    @Override
    public void crear(String dato) {
        datos.add(dato);
    }

    @Override
    public void modificar(String dato) {
        throw new RuntimeException("Modificación de ventas no implementada");
    }

    @Override
    public void eliminar(int id) {
        throw new RuntimeException("eliminar por Id de ventas no implementada");
    }

    @Override
    public String buscar(int id) {
        throw new RuntimeException("buscar por Id de ventas no implementada");
    }

    @Override
    public java.util.ArrayList<String> listar() {
        return  datos;
    }
}
