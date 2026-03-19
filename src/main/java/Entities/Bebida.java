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


    @Override
    public boolean correspondeA(CriterioItem criterio) {
        return criterio.cumpleParaBebida(this);
    }
    @Override
    public double subtotalComoBebida(double subtotal) {
        return subtotal;
    }
}
