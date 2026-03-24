package Persistence;

import java.io.*;
import java.util.ArrayList;

public class ArchivoVentas implements GestionArchivo<String> {

    private File archivo;

    public ArchivoVentas(){
        this.archivo = new File("ventas.txt");
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
}
