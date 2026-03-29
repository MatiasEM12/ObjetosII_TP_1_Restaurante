package Entities;

public class Plato  extends Producto {


    private Double precioPlato;

    private Boolean disponible;


    public Plato(String nombre,  Double precio, Boolean disponible) {

        super (nombre);
        validarPrecio(precio);
        validarDisponible( disponible);
        precioPlato=precio;
        this.disponible = disponible;

    }

    @Override
    public Double getPrecioPlato() {
        return this.precioPlato;
    }

    @Override
    public Double getPrecioBebida() {
        return 0.0;
    }

    //VALIDACIONES


    private void validarDisponible(Boolean disponible){
        if(disponible==null)throw new IllegalArgumentException("La disponibilidad del plato no puede ser nula.");

    }

    private void validarPrecio(Double precio){
        if(precio==null || precio <0) throw new IllegalArgumentException("El precio no puede ser nulo ni menor a 0");
    }












}




    







