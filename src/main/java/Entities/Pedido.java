package Entities;

import java.util.ArrayList;

public class Pedido {

    public static final Integer PROPINA_BAJA=2;
    public static final Integer PROPINA_MEDIA=3;
    public static final Integer PROPINA_ALTA=5;

    private ArrayList<Item> items;
    private Boolean confirmado;
    private Integer propina;
    private Tarjeta tarjeta;

    public Pedido(ArrayList<Item> items, Tarjeta tarjeta, Integer propina, Boolean confirmado) {

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

    //VALIDACIONES

    private void validarItems(ArrayList<Item> items){
        if(items==null || items.isEmpty()){
            throw new IllegalArgumentException("El pedido debe contener al menos un item.");
        }
    }

    private void validarTarjeta(Tarjeta tarjeta){
        if(tarjeta==null){
            throw new IllegalArgumentException("El pedido debe tener una tarjeta asociada.");
        }
    }

    private void validarPropina(Integer propina){
        if(propina==null || (propina!=PROPINA_BAJA && propina!=PROPINA_MEDIA && propina!=PROPINA_ALTA)){
            throw new IllegalArgumentException("La propina debe ser 2, 3 o 5.");
        }

    }

    private void validarConfirmacion(Boolean confirmado){
        if(confirmado==null){
            throw new IllegalArgumentException("El estado de confirmación no puede ser nulo.");
        }
    }


}
