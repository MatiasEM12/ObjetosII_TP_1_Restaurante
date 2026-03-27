package Entities;

public abstract class Tarjeta  implements TarjetaCredito {

    protected Long numeroTarjeta;

    public Tarjeta(Long numeroTarjeta) {
        validarNumeroTarjeta(numeroTarjeta);
        this.numeroTarjeta = numeroTarjeta;
    }


    //VALIDACIONES

    void validarNumeroTarjeta(Long numeroTarjeta){
        if(numeroTarjeta == null || numeroTarjeta.toString().length() != 16){
            throw new IllegalArgumentException("El número de tarjeta debe tener 16 dígitos.");
        }

    }
}
