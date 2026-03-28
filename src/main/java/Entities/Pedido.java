package Entities;


import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;

public class Pedido {


    private GestionArchivo<String> api;
    private ArrayList<Item> items;
    private Boolean confirmado=false;
    private Propina propina;
    private Tarjeta tarjeta;

    private Venta venta;



    public Pedido( Tarjeta tarjeta, Propina propina, GestionArchivo<String> api) {


        validarTarjeta(tarjeta);
        validarPropina(propina);

        this.api=api;
        this.items = new ArrayList<>();
        this.propina = propina;
        this.tarjeta = tarjeta;
    }

    public Pedido( Tarjeta tarjeta, Propina propina, Venta venta,ArrayList<Item> items,Boolean confirmado ) {


        validarTarjeta(tarjeta);
        validarPropina(propina);
        validarItems(items);
        validarConfirmacion(confirmado);


        this.venta=venta;
        this.items = items;
        this.confirmado = confirmado;
        this.propina = propina;
        this.tarjeta = tarjeta;


    }


    public void confirmarPedido(){
        if(items.isEmpty())throw new IllegalStateException("El pedido debe contener al menos un item para ser confirmado.");


        validarConfirmacion(confirmado);


        confirmado=true;
    }

    public void agregarItem(Item item){
        if(item==null)throw new IllegalArgumentException("El item no puede ser nulo.");


        if(confirmado) throw new IllegalStateException("No se pueden agregar items a un pedido ya confirmado.");

        items.add(item);
    }

    public void agregarItems(ArrayList<Item> nuevosItems){
       validarItems(nuevosItems);

        if(confirmado) throw new IllegalStateException("No se pueden agregar items a un pedido ya confirmado.");

        items.addAll(nuevosItems);
    }




    public double obtenerSubTotalBebidas() {

        return items.stream().mapToDouble(Item::subTotalBebida).sum();
    }

    public double obtenerSubTotalPlatos() {
        return items.stream().mapToDouble(Item::subTotalPlato).sum();
    }

    public double obtenerSubTotal() {
        return items.stream()
                .mapToDouble(Item::obtenerSubTotal)
                .sum();
    }


    public double calcularTotal(){

        if(!confirmado) throw new IllegalStateException("El pedido debe estar confirmado para calcular el total.");

        double subTotal = obtenerSubTotal();

        double descuento = tarjeta.calcularDescuento(this);

        double totalConDescuento = subTotal - descuento;

        double propinaCalculada = propina.calcularSobre(totalConDescuento);

        Double pago =totalConDescuento + propinaCalculada;
        this.venta= new Venta(LocalDateTime.now(), pago);

        api.crear(venta.toString());

        return pago;

    }

    public Venta getVenta() {
        if(this.venta==null) throw new IllegalStateException("El pedido no ha sido pagado aún, no se puede obtener la información de venta.");
        return this.venta;
    }
    //VALIDACIONES

    private void validarItems(ArrayList<Item> items){
        if(items==null || items.isEmpty())throw new IllegalArgumentException("El pedido debe contener al menos un item.");

    }

    private void validarTarjeta(Tarjeta tarjeta){
        if(tarjeta==null)throw new IllegalArgumentException("El pedido debe tener una tarjeta asociada.");

    }

    private void validarPropina(Propina propina){
        if(propina==null || !Arrays.stream(Propina.values()).anyMatch(p -> p.equals(propina))){
            throw new IllegalArgumentException("El pedido debe tener una propina válida asociada.");
        }
    }

    private void validarConfirmacion(Boolean confirmado){
        if(confirmado==null)throw new IllegalArgumentException("El estado de confirmación no puede ser nulo.");


        if(confirmado) throw new IllegalStateException("El pedido ya ha sido confirmado.");
    }

    private void validarVenta(Double venta){
        if(venta==null || venta<0)throw new IllegalArgumentException("La venta debe ser un valor positivo.");
    }

    private void validarHoraPago(LocalDateTime horaPago){
        if(horaPago==null)throw new IllegalStateException("La hora de pago no puede ser nula.");
    }
    public String toStringVenta(){
        if(this.venta==null) throw new IllegalStateException("El pedido no ha sido pagado aún, no se puede generar la información de venta.");



        return  venta.toString();
    }
}
