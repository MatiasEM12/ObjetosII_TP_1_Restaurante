package Entities;

import java.util.ArrayList;

public class Mesa {

    private Integer capacidad;
    private Integer numeroMesa;
    private ArrayList<Comensal> comensales;

    public Mesa(Integer capacidad, Integer numeroMesa) {

        validarCapacidad(capacidad);
        validarNumeroMesa(numeroMesa);

        this.capacidad = capacidad;
        this.numeroMesa = numeroMesa;
        this.comensales = new ArrayList<>(capacidad);
    }

    public void agregarComensal(Comensal comensal) {

        validarComensal(comensal);
        if (comensales.size() < capacidad) {
            comensales.add(comensal);
        } else {
            throw new IllegalStateException("La mesa está llena. No se pueden agregar más comensales.");
        }
    }

    public void agregarComensales(ArrayList<Comensal> comensales) {
        validarComensales(comensales);
        if (this.comensales.size() + comensales.size() <= capacidad) {
            this.comensales.addAll(comensales);
        } else {
            throw new IllegalStateException("La mesa no tiene suficiente capacidad para agregar a todos los comensales.");
        }
    }


    //VALIDACIONES

    private void validarCapacidad(Integer capacidad){
        if(capacidad==null|| capacidad<=0){
            throw new IllegalArgumentException("La capacidad debe ser un número positivo.");
        }
    }

    private void validarNumeroMesa(Integer numeroMesa){
        if(numeroMesa==null|| numeroMesa<=0){
            throw new IllegalArgumentException("El número de mesa debe ser un número positivo.");
        }
    }

    private void validarComensal(Comensal comensal){
        if(comensal==null){
            throw new IllegalArgumentException("El comensal no puede ser nulo.");
        }
    }

    private void validarComensales(ArrayList<Comensal> comensales){
        if(comensales==null || comensales.isEmpty()){
            throw new IllegalArgumentException("La lista de comensales no puede ser nula o vacía.");
        }
    }
}
