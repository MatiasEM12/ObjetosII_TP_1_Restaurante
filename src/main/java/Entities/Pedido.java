package Entities;

import java.util.ArrayList;
import java.util.Arrays;

public class Pedido {



    private ArrayList<Item> items;
    private Boolean confirmado=false;
    private Propina propina;
    private TarjetaCredito tarjeta;

    public Pedido(ArrayList<Item> items, TarjetaCredito tarjeta, Propina propina) {

        validarItems(items);
        validarTarjeta(tarjeta);
        validarPropina(propina);


        this.items = items;
        this.propina = propina;
        this.tarjeta = tarjeta;
    }

    public void confirmarPedido(){
        if(items.isEmpty()){
            throw new IllegalStateException("El pedido debe contener al menos un item para ser confirmado.");
        }

        if(confirmado) throw new IllegalStateException("El pedido ya ha sido confirmado.");

        confirmado=true;
    }

    public void agregarItem(Item item){
        if(item==null){
            throw new IllegalArgumentException("El item no puede ser nulo.");
        }

        if(confirmado) throw new IllegalStateException("No se pueden agregar items a un pedido ya confirmado.");

        items.add(item);
    }

    public void agregarItems(ArrayList<Item> nuevosItems){
        if(nuevosItems==null || nuevosItems.isEmpty()){
            throw new IllegalArgumentException("La lista de items no puede ser nula o vacía.");
        }

        if(confirmado) throw new IllegalStateException("No se pueden agregar items a un pedido ya confirmado.");

        items.addAll(nuevosItems);
    }
    public double obtenerSubTotalBebidas() {
        double total = 0;
        for (Item item : items) {
            if (item.getProducto() instanceof Bebida) {
                total += item.obtenerSubtotal();
            }
        }
        return total;
    }

    public double obtenerSubTotalPlatos() {
        double total = 0;
        for (Item item : items) {
            if (item.getProducto() instanceof Plato) {
                total += item.obtenerSubtotal();
            }
        }
        return total;
    }


    public double obtenerSubTotal(){
        double total = 0;
        for (Item item : items) {
            total += item.obtenerSubtotal();
        }
        return total;

    }

    public double calcularTotal(){

        double subTotal = obtenerSubTotal();
        double descuento = tarjeta.calcularDescuento(this);
        double propinaCalculada = propina.calcularPropina(subTotal);

        return subTotal - descuento + propinaCalculada;

    }
    //VALIDACIONES

    private void validarItems(ArrayList<Item> items){
        if(items==null || items.isEmpty()){
            throw new IllegalArgumentException("El pedido debe contener al menos un item.");
        }
    }

    private void validarTarjeta(TarjetaCredito tarjeta){
        if(tarjeta==null){
            throw new IllegalArgumentException("El pedido debe tener una tarjeta asociada.");
        }
    }

    private void validarPropina(Propina propina){
        if(propina==null){
            throw new IllegalArgumentException("El pedido debe tener una propina asociada.");
        }
    }

    private void validarConfirmacion(Boolean confirmado){
        if(confirmado==null){
            throw new IllegalArgumentException("El estado de confirmación no puede ser nulo.");
        }
    }



}
