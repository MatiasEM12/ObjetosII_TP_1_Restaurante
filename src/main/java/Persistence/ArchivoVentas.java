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

            FileWriter writer = new FileWriter(archivo, true);
            writer.write(dato + System.lineSeparator());
        }catch (Exception e){
            System.out.println("Error al crear el archivo: " + e.getMessage());
        }

    }

    @Override
    public java.util.ArrayList<String> listar() {
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
