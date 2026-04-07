import java.util.ArrayList;

public class FakeArchivoVentas implements Entities.GestionArchivo<String> {
    private ArrayList<String> datos = new ArrayList<>();

    public FakeArchivoVentas(String ruta) {
        	validarDato(ruta);
        	// No se utiliza la ruta en el fake, pero se valida para mantener la consistencia con la clase real
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
    public void eliminarArchivo(String ruta) {
        throw new RuntimeException("eliminar el archivoFake por ruta no implementada");
    }

    @Override
    public String buscar(int id) {
        throw new RuntimeException("buscar por Id de ventas no implementada");
    }

    @Override
    public java.util.ArrayList<String> listar() {
        return  datos;
    }

    private void validarDato(String dato){
        if(dato==null || dato.isEmpty())throw new IllegalArgumentException("El dato no puede ser nulo o vacío.");
    }
}
