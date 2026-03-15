package Entities;

import java.util.ArrayList;
import java.util.Arrays;

public class Pedido {



    private ArrayList<Item> items;
    private Boolean confirmado=false;
    private Propina propina;
    private TarjetaCredito tarjeta;

    public Pedido( TarjetaCredito tarjeta, Propina propina) {


        validarTarjeta(tarjeta);
        validarPropina(propina);


        this.items = new ArrayList<>();
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
        return obtenerSubTotalBebidas() + obtenerSubTotalPlatos();


    }


    public double calcularTotal(){

        if(!confirmado) throw new IllegalStateException("El pedido debe estar confirmado para calcular el total.");

        double subTotal = obtenerSubTotal();

        double descuento = tarjeta.calcularDescuento(this);

        double totalConDescuento = subTotal - descuento;

        double propinaCalculada = propina.calcularSobre(totalConDescuento);

        return totalConDescuento + propinaCalculada;
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
