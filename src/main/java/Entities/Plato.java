package Entities;

public class Plato  extends Producto {



    private Boolean disponible;


    public Plato(String nombre,  Double precio, Boolean disponible) {


        super (nombre, precio);
        validarDisponible( disponible);
        this.disponible = disponible;

    }

    @Override
    public boolean correspondeA(CriterioItem criterio) {
        return criterio.cumpleParaPlato(this);
    }

    @Override
    public double subtotalComoPlato(double subtotal) {
        return subtotal;
    }

    //VALIDACIONES


    private void validarDisponible(Boolean disponible){
        if(disponible==null){
            throw new IllegalArgumentException("La disponibilidad del plato no puede ser nula.");
        }
    }





    






}
