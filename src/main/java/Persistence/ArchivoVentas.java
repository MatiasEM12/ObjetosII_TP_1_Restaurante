package Persistence;

import Entities.GestionArchivo;

import java.io.*;
import java.util.ArrayList;

public class ArchivoVentas extends GestionArchivo<String> {

    private File archivo;

    public ArchivoVentas(String ruta){
        super(ruta);
        this.archivo = new File(ruta);
    }
    @Override
    public void crear(String dato) {

        try{
            if(!archivo.exists()){
                archivo.createNewFile();
            }

            ArrayList<String> ventas = listar();
            if(ventas.contains(dato)){
               throw new IllegalArgumentException("La venta ya existe en el archivo.");
            }

            FileWriter writer = new FileWriter(archivo, true);
            writer.write(dato + System.lineSeparator());
            writer.close();
        }catch (Exception e){
            throw  new RuntimeException("Error al escribir la venta en el archivo", e);
        }

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
    public ArrayList<String> listar() {
        ArrayList<String> ventas = new ArrayList<>();

        if (!archivo.exists()) {
            return ventas;
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(archivo))) {
            String linea;
            while ((linea = reader.readLine()) != null) {
                ventas.add(linea);
            }
        } catch (IOException e) {
            throw new RuntimeException("Error al leer inscripciones", e);
        }

        return ventas;

    }


    private void validarDato(String dato){
        if(dato==null || dato.isEmpty())throw new IllegalArgumentException("El dato no puede ser nulo o vacío.");
    }
}
