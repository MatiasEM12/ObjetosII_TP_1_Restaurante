package Entities;

public class Bebida {

    private String nombre;
    private Double precio;
    private String tamaño;
    private String tipo;
    private Boolean esAlcohólica;
    private Boolean disponible;


    public Bebida(String nombre, Double precio, String tamaño, String tipo, Boolean esAlcohólica, Boolean disponible) {
        validarNombre(nombre);
        validarPrecio(precio);
        validarTamaño(tamaño);
        validarTipo(tipo);
        validarEsAlcohólica(esAlcohólica);
        validarDisponible(disponible);

        this.nombre = nombre;
        this.precio = precio;
        this.tamaño = tamaño;
        this.tipo = tipo;
        this.esAlcohólica = esAlcohólica;
        this.disponible = disponible;

    }

    //VALIDACIONES

    private void validarNombre(String nombre){
        if(nombre==null || nombre.trim().isEmpty()){
            throw new IllegalArgumentException("El nombre de la bebida no puede ser nulo o vacío.");
        }
    }

    private void validarPrecio(Double precio){
        if(precio==null || precio <= 0){
            throw new IllegalArgumentException("El precio de la bebida debe ser un número positivo.");
        }
    }

    private void validarTamaño(String tamaño){
        if(tamaño==null || tamaño.trim().isEmpty()){
            throw new IllegalArgumentException("El tamaño de la bebida no puede ser nulo o vacío.");
        }
    }

    private void validarTipo(String tipo){
        if(tipo==null || tipo.trim().isEmpty()){
            throw new IllegalArgumentException("El tipo de bebida no puede ser nulo o vacío.");
        }
    }

    private void validarEsAlcohólica(Boolean esAlcohólica){
        if(esAlcohólica==null){
            throw new IllegalArgumentException("La información sobre si la bebida es alcohólica o no no puede ser nula.");
        }
    }

    private void validarDisponible(Boolean disponible){
        if(disponible==null){
            throw new IllegalArgumentException("La disponibilidad de la bebida no puede ser nula.");
        }
    }




}
