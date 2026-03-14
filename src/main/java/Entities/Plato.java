package Entities;

public class Plato {

    private String nombre;
    private String descripcion;
    private Double precio;
    private Integer tiempoPreparacion;
    private Boolean disponible;
    private String categoria;

    public Plato(String nombre, String descripcion, Double precio, Integer tiempoPreparacion, Boolean disponible, String categoria) {
        validarNombre(nombre);
        validarDescripcion(descripcion);
        validarPrecio(precio);
        validarTiempoPreparacion(tiempoPreparacion);
        validarDisponible(disponible);
        validarCategoria(categoria);

        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precio = precio;
        this.tiempoPreparacion = tiempoPreparacion;
        this.disponible = disponible;
        this.categoria = categoria;
    }


    //VALIDACIONES

    private void validarNombre(String nombre){
        if(nombre==null || nombre.trim().isEmpty()){
            throw new IllegalArgumentException("El nombre del plato no puede ser nulo o vacío.");
        }
    }

    private void validarDescripcion(String descripcion){
        if(descripcion==null || descripcion.trim().isEmpty()){
            throw new IllegalArgumentException("La descripción del plato no puede ser nula o vacía.");
        }
    }

    private void validarPrecio(Double precio){
        if(precio==null || precio <= 0){
            throw new IllegalArgumentException("El precio del plato debe ser un número positivo.");
        }
    }

    private void validarTiempoPreparacion(Integer tiempoPreparacion){
        if(tiempoPreparacion==null || tiempoPreparacion <= 0){
            throw new IllegalArgumentException("El tiempo de preparación del plato debe ser un número positivo.");
        }
    }

    private void validarDisponible(Boolean disponible){
        if(disponible==null){
            throw new IllegalArgumentException("La disponibilidad del plato no puede ser nula.");
        }
    }

    private void validarCategoria(String categoria){
        if(categoria==null || categoria.trim().isEmpty()){
            throw new IllegalArgumentException("La categoría del plato no puede ser nula o vacía.");
        }
    }



    






}
