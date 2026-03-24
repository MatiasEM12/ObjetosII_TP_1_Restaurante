package Entities;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Venta {
    private LocalDateTime horaPago;
    private Double venta=0.0;

    public Venta(LocalDateTime horaPago, Double venta) {
        validarVenta(venta);
        validarHoraPago(horaPago);
        this.horaPago = horaPago;
        this.venta = venta;
    }


    private void validarVenta(Double venta){
        if(venta==null || venta<0)throw new IllegalArgumentException("La venta debe ser un valor positivo.");
    }

    private void validarHoraPago(LocalDateTime horaPago){
        if(horaPago==null)throw new IllegalStateException("La hora de pago no puede ser nula.");
    }

    public String toString(){
        if(this.horaPago==null || this.venta==0.0) throw new IllegalStateException("El pedido no ha sido pagado aún, no se puede generar la información de venta.");

        DateTimeFormatter formato = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String fechaString = horaPago.format(formato);

        return  horaPago+" || " +  String.valueOf(this.venta);
    }

    public LocalDateTime getHoraPago() {
        return this.horaPago;
    }

    public Double getVenta() {
        return this.venta;
    }
}
