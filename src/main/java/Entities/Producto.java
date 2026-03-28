package Entities;

public abstract  class Producto  {


    private String nombre;
    private Double precioPlato=0.0;
    private Double precioBebida=0.0;

    public Producto(String nombre) {
        validarNombre(nombre);

        this.nombre = nombre;
    }

    public Double getPrecioPlato() {
        return precioPlato;
    }

    public Double getPrecioBebida(){
        return precioBebida;
    }



    //VALIDACIONES

    private void validarNombre(String nombre) {
        if (nombre == null || nombre.trim().isEmpty()) throw new IllegalArgumentException("El nombre del producto no puede ser nulo o vacío.");

    }

    private void validarPrecio(Double precio) {
        if (precio == null || precio < 0) throw new IllegalArgumentException("El precio del producto debe ser un número positivo.");
    }
}
