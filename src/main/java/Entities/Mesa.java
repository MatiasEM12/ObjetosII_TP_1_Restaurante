package Entities;

import java.util.ArrayList;

public class Mesa {

    private Integer capacidad;
    private Integer numeroMesa;
    private ArrayList<Pedido> historialPedidos= new ArrayList<>();
    private Boolean estaOcupada=false;

    public Mesa(Integer capacidad, Integer numeroMesa) {

        validarCapacidad(capacidad);
        validarNumeroMesa(numeroMesa);

        this.capacidad = capacidad;
        this.numeroMesa = numeroMesa;

    }


    public void ocuparMesa(){
        if(estaOcupada){
            throw new IllegalStateException("La mesa ya está ocupada.");
        }
        estaOcupada=true;
    }

    public void liberarMesa(){
        if(!estaOcupada){
            throw new IllegalStateException("La mesa ya está libre.");
        }
        estaOcupada=false;

    }
    public void agregarPedido(Pedido pedido){
        if(!estaOcupada)throw new IllegalStateException("La mesa debe estar ocupada para agregar un pedido.");
        validarPedido(pedido);
        historialPedidos.add(pedido);
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

    private void validarPedido(Pedido pedido){
        if(pedido==null){
            throw new IllegalArgumentException("El pedido no puede ser nulo.");
        }
    }
}
