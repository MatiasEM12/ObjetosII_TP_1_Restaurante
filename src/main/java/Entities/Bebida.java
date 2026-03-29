package Entities;

public class Bebida extends Producto {

    private Boolean disponible;
    private Double precioBebida;

    public Bebida(String nombre, Double precio, Boolean disponible) {


        super (nombre);
        validarPrecio(precio);
        validarDisponible(disponible);

        this.precioBebida=precio;
        this.disponible = disponible;

    }


    //VALIDACIONES


    private void validarDisponible(Boolean disponible){
        if(disponible==null)throw new IllegalArgumentException("La disponibilidad de la bebida no puede ser nula.");

    }

    @Override
    public Double getPrecioPlato() {
        return 0.0;
    }

    @Override
    public Double getPrecioBebida() {
        return this.precioBebida;
    }

    private void validarPrecio(Double precio){
        if(precio==null||precio<0) throw new IllegalArgumentException("El precio no puede ser nullo o menor a 0");
    }
}