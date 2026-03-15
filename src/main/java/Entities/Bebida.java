package Entities;

public class Bebida extends Producto {

    private Boolean disponible;


    public Bebida(String nombre, Double precio, Boolean disponible) {




        super (nombre, precio);
        validarDisponible(disponible);
        this.disponible = disponible;

    }

    //VALIDACIONES


    private void validarDisponible(Boolean disponible){
        if(disponible==null){
            throw new IllegalArgumentException("La disponibilidad de la bebida no puede ser nula.");
        }
    }




}
