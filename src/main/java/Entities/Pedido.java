package Entities;

import java.util.ArrayList;
import java.util.Arrays;

public class Pedido {



    private ArrayList<Item> items;
    private Boolean confirmado;
    private Double propina;
    private TarjetaCredito tarjeta;

    public Pedido(ArrayList<Item> items, TarjetaCredito tarjeta, Double propina, Boolean confirmado) {

        validarItems(items);
        validarTarjeta(tarjeta);
        validarPropina(propina);
        validarConfirmacion(confirmado );

        this.items = items;
        this.confirmado = confirmado;
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

    public double obtenerTotalBebidas() {
        double total = 0;
        for (Item item : items) {
            if (item.getProducto() instanceof Bebida) {
                total += item.obtenerSubtotal();
            }
        }
        return total;
    }

    public double obtenerTotalPlatos() {
        double total = 0;
        for (Item item : items) {
            if (item.getProducto() instanceof Plato) {
                total += item.obtenerSubtotal();
            }
        }
        return total;
    }


    public double obtenerTotal(){
        double total = 0;
        for (Item item : items) {
            total += item.obtenerSubtotal();
        }
        return total;

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

    private void validarPropina(Double propina){
        if(propina==null || propina < 0){
            throw new IllegalArgumentException("La propina debe ser un número positivo o cero.");
        }

        if (Arrays.stream(Propina.values()).noneMatch(p -> p.getPorcentaje() == propina)) {
            throw new IllegalArgumentException("La propina debe corresponder a uno de los valores permitidos del enum Propina.");
        }

    }

    private void validarConfirmacion(Boolean confirmado){
        if(confirmado==null){
            throw new IllegalArgumentException("El estado de confirmación no puede ser nulo.");
        }
    }



}
