package Entities;

public abstract  class Producto  {

    private String nombre;
    private Double precio;

    public Producto(String nombre, Double precio) {
        validarNombre(nombre);
        validarPrecio(precio);

        this.nombre = nombre;
        this.precio = precio;
    }

    public Double getPrecio() {
        return precio;
    }

    public double subtotalComoBebida(double subtotal) {
        return 0;
    }

    public double subtotalComoPlato(double subtotal) {
        return 0;
    }

    public abstract boolean correspondeA(CriterioItem criterio);
    //VALIDACIONES

    private void validarNombre(String nombre) {
        if (nombre == null || nombre.trim().isEmpty()) {
            throw new IllegalArgumentException("El nombre del producto no puede ser nulo o vacío.");
        }
    }

    private void validarPrecio(Double precio) {
        if (precio == null || precio < 0) {
            throw new IllegalArgumentException("El precio del producto debe ser un número positivo.");
        }
    }
}
