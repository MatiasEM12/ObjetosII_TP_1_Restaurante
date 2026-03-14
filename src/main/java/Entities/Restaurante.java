package Entities;

import java.util.ArrayList;

public class Restaurante {
    public static final int MAX_MESAS = 10;
    public static final int DESCUENTO_VISA_TOTAL_BEBIDAS= 3;
    public static final int DESCUENTO_MASTERCARD_TOTAL_PLATO= 2;
    public static final int DESCUENTO_COMARCAPLUS_TOTAL=2;


    private String nombre;
    private ArrayList<Mesa> mesas= new ArrayList<>(MAX_MESAS);


    public Restaurante(String nombre, ArrayList<Mesa> mesas) {
        validarNombre(nombre);
        validarMesas(mesas);

        this.nombre = nombre;
        this.mesas = mesas;
    }

    //VALIDACIONES

    private void validarNombre(String nombre) {
        if (nombre == null || nombre.trim().isEmpty()) {
            throw new IllegalArgumentException("El nombre del restaurante no puede ser nulo o vacío.");
        }
    }

   private void validarMesas(ArrayList<Mesa> mesas) {
        if (mesas == null || mesas.isEmpty()) {
            throw new IllegalArgumentException("El restaurante debe tener al menos una mesa.");
        }

        if(mesas.size() > MAX_MESAS){
            throw new IllegalArgumentException("El restaurante no puede tener más de 10 mesas.");
        }
    }
}
