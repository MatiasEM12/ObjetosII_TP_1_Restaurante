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

    public ArrayList<Plato> getPlatos() {
        return platos;
    }

    public ArrayList <Bebida> getBebidas() {
        return bebidas;
    }

    public ArrayList <Producto> obtenerProductos() {
        ArrayList<Producto> productos = new ArrayList<>();
        productos.addAll(platos);
        productos.addAll(bebidas);
        return productos;
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
