package Entities;

import java.time.LocalDate;

public class Tarjeta {

    private Integer numeroTarjeta;
    private String titular;
    private String marcaTarjeta;
    private String tipoTarjeta;
    private LocalDate fechaVencimiento;

    public Tarjeta(Integer numeroTarjeta, String titular, String marcaTarjeta, String tipoTarjeta, LocalDate fechaVencimiento) {
        validarNumeroTarjeta(numeroTarjeta);
        validarTitular(titular);
        validarMarcaTarjeta(marcaTarjeta);
        validarTipoTarjeta(tipoTarjeta);
        validarFechaVencimiento(fechaVencimiento);

        this.numeroTarjeta = numeroTarjeta;
        this.titular = titular;
        this.marcaTarjeta = marcaTarjeta;
        this.tipoTarjeta = tipoTarjeta;
        this.fechaVencimiento = fechaVencimiento;
    }


    //VALIDACIONES

    private void validarNumeroTarjeta(Integer numeroTarjeta){
        if(numeroTarjeta==null || numeroTarjeta.toString().length() != 16){
            throw new IllegalArgumentException("El número de tarjeta debe ser un número de 16 dígitos.");
        }
    }

    private void validarTitular(String titular){
        if(titular==null || titular.trim().isEmpty()){
            throw new IllegalArgumentException("El titular no puede ser nulo o vacío.");
        }
    }

    private void validarMarcaTarjeta(String marcaTarjeta){
        if(marcaTarjeta==null || marcaTarjeta.trim().isEmpty()){
            throw new IllegalArgumentException("La marca de la tarjeta no puede ser nula o vacía.");
        }
    }

    private void validarTipoTarjeta(String tipoTarjeta){
        if(tipoTarjeta==null || tipoTarjeta.trim().isEmpty()){
            throw new IllegalArgumentException("El tipo de tarjeta no puede ser nulo o vacío.");
        }
    }

    private void validarFechaVencimiento(LocalDate fechaVencimiento){
        if(fechaVencimiento==null || fechaVencimiento.isBefore(LocalDate.now())){
            throw new IllegalArgumentException("La fecha de vencimiento no puede ser nula o anterior a la fecha actual.");
        }
    }



}
