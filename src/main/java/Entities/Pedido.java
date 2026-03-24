package Entities;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;

public class Pedido {



    private ArrayList<Item> items;
    private Boolean confirmado=false;
    private Propina propina;
    private Tarjeta tarjeta;

    private Venta venta;

    public Pedido( Tarjeta tarjeta, Propina propina) {


        validarTarjeta(tarjeta);
        validarPropina(propina);


        this.items = new ArrayList<>();
        this.propina = propina;
        this.tarjeta = tarjeta;
    }

    public Pedido( Tarjeta tarjeta, Propina propina, Venta venta,ArrayList<Item> items,Boolean confirmado ) {


        validarTarjeta(tarjeta);
        validarPropina(propina);
        validarItems(items);
        validarConfirmacion(confirmado);
        validarVenta(venta);

        this.items = items;
        this.confirmado = confirmado;
        this.propina = propina;
        this.tarjeta = tarjeta;
        this.venta=venta;
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


    public double obtenerSubtotalSegun(CriterioItem criterio) {
        return items.stream()
                .filter(item -> item.correspondeA(criterio))
                .mapToDouble(Item::obtenerSubtotal)
                .sum();
    }

    public double obtenerSubTotalBebidas() {
        return obtenerSubtotalSegun(new SoloBebidas());
    }

    public double obtenerSubTotalPlatos() {
        return obtenerSubtotalSegun(new SoloPlatos());
    }

    public double obtenerSubTotal() {
        return items.stream()
                .mapToDouble(Item::obtenerSubtotal)
                .sum();
    }


    public double calcularTotal(){

        if(!confirmado) throw new IllegalStateException("El pedido debe estar confirmado para calcular el total.");

        double subTotal = obtenerSubTotal();

        double descuento = tarjeta.calcularDescuento(this);

        double totalConDescuento = subTotal - descuento;

        double propinaCalculada = propina.calcularSobre(totalConDescuento);

        Double pago= totalConDescuento + propinaCalculada;
        this.venta= new Venta (LocalDateTime.now(),pago);

        return pago;

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

    private void validarVenta(Venta venta){
        if(venta==null)throw new IllegalStateException("La venta no puede ser nula al crear un pedido con venta.");
    }

    public String toStringVenta(){
        if(this.venta==null) throw new IllegalStateException("El pedido no ha sido pagado aún, no se puede generar la información de venta.");

        return  this.venta.toString();
    }
}