package Entities;

public class Comensal {

    private String nombre;
    private Integer dni;
    private Tarjeta tarjeta;

    public Comensal(String nombre, Integer dni, Tarjeta tarjeta) {
        validarNombre(nombre);
        validarDni(dni);
        validarTarjeta(tarjeta);

        this.nombre = nombre;
        this.dni = dni;
        this.tarjeta = tarjeta;
    }

    //VALIDACIONES

    private void validarNombre(String nombre){
        if(nombre==null || nombre.trim().isEmpty()){
            throw new IllegalArgumentException("El nombre no puede ser nulo o vacío.");
        }
    }

    private void validarDni(Integer dni){
        if(dni==null || dni.longValue() !=8){
            throw new IllegalArgumentException("El DNI debe ser un número de 8 dígitos.");
        }
    }

    private void validarTarjeta(Tarjeta tarjeta){
        if(tarjeta==null){
            throw new IllegalArgumentException("La tarjeta no puede ser nula.");
        }
    }
}
