package Entities;

public class Plato  extends Producto {



    private Boolean disponible;


    public Plato(String nombre,  Double precio, Boolean disponible) {


        super (nombre, precio);
        validarDisponible( disponible);
        this.disponible = disponible;

    }


    //VALIDACIONES


    private void validarDisponible(Boolean disponible){
        if(disponible==null){
            throw new IllegalArgumentException("La disponibilidad del plato no puede ser nula.");
        }
    }





    






}
