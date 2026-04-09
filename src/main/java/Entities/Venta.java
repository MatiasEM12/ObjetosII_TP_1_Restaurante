package Entities;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

public class Venta {

    private static int cont=0;
    private final String id;
    private LocalDateTime horaPago;
    private Double pago=0.0;

    public Venta(LocalDateTime horaPago, Double pago) {
        validarPago(pago);
        validarHoraPago(horaPago);

        cont++;
        this.id= "V" + String.format("%05d", cont);


        this.horaPago = horaPago;
        this.pago = pago;
    }

    public Venta(String id,LocalDateTime horaPago, Double pago) {
        validarPago(pago);
        validarHoraPago(horaPago);
        validarID(id);

        this.id=id;
        this.horaPago = horaPago;
        this.pago = pago;
    }


    private void validarPago(Double pago){
        if(pago==null || pago<0)throw new IllegalArgumentException("El pago debe ser un valor positivo.");
    }

    private void validarHoraPago(LocalDateTime horaPago){
        if(horaPago==null)throw new IllegalStateException("La hora de pago no puede ser nula.");
    }

    private void validarID(String id){
        if(id==null || id.isEmpty()) throw new IllegalArgumentException("El ID de la venta no puede ser nulo o vacío.");
    }

    public String toString(){
        if(this.horaPago==null || this.pago==0.0) throw new IllegalStateException("El pedido no ha sido pagado aún, no se puede generar la información de venta.");

        DateTimeFormatter formato = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String fechaString = horaPago.format(formato);

        return  horaPago+" || " +  String.valueOf(this.pago);
    }

    public LocalDateTime horaPago() {
        return this.horaPago;
    }

    public Double pago() {
        return this.pago;
    }

    public String id(){
        return this.id;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Venta venta = (Venta) o;
        return Objects.equals(id, venta.id) && Objects.equals(horaPago, venta.horaPago) && Objects.equals(pago, venta.pago);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, horaPago, pago);
    }
}
