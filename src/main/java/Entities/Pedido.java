package Entities;

import java.util.ArrayList;

public class Pedido {

    public static final Integer PROPINA_BAJA=2;
    public static final Integer PROPINA_MEDIA=3;
    public static final Integer PROPINA_ALTA=5;

    private ArrayList<Item> items;
    private Boolean confirmado;
    private Double propina;
    private Tarjeta tarjeta;

    public Pedido(ArrayList<Item> items, Tarjeta tarjeta) {
        validarItems(items);
        validarTarjeta(tarjeta);

        this.items = items;
        this.confirmado = false;
        this.propina = 0.0;
        this.tarjeta = tarjeta;
    }
}
