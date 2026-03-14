package Entities;

import java.util.ArrayList;

public class Menu {


    private ArrayList<Plato> platos;
    private ArrayList <Bebida> bebidas;

    public Menu() {
        this.platos = new ArrayList<>();
        this.bebidas = new ArrayList<>();
    }

    public Menu( ArrayList<Plato> platos, ArrayList<Bebida> bebidas) {
        validarPlatos(platos);
        validarBebidas(bebidas);

        this.platos = platos;
        this.bebidas = bebidas;

    }


    //VALIDACIONES

    private void validarPlatos(ArrayList<Plato> platos) {
        if (platos == null || platos.isEmpty()) {
            throw new IllegalArgumentException("El menú debe contener al menos un plato.");
        }
    }

    private void validarBebidas(ArrayList<Bebida> bebidas) {
        if (bebidas == null || bebidas.isEmpty()) {
            throw new IllegalArgumentException("El menú debe contener al menos una bebida.");
        }
    }
}
