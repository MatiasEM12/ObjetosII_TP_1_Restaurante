package Entities;

public class Item {

    private Producto producto;
    private Integer cantidad;

    public Item(Producto producto, Integer cantidad) {
        validarProducto(producto);
        validarCantidad(cantidad);

        this.producto = producto;
        this.cantidad = cantidad;

    }



    public Double obtenerSubtotal() {
        return producto.getPrecio() * cantidad;
    }

    public Producto getProducto() {
        return producto;
    }

    public double subtotalComoBebida() {
        return producto.subtotalComoBebida(obtenerSubtotal());
    }

    public double subtotalComoPlato() {
        return producto.subtotalComoPlato(obtenerSubtotal());
    }
    //VALIDACIONES

    private void validarProducto(Producto producto) {
        if (producto == null) {
            throw new IllegalArgumentException("El producto no puede ser nulo.");
        }
    }

    private void validarCantidad(Integer cantidad) {
        if (cantidad == null || cantidad <= 0) {
            throw new IllegalArgumentException("La cantidad debe ser un número entero positivo.");
        }
    }

    public boolean correspondeA(CriterioItem criterio) {
        return producto.correspondeA(criterio);
    }
}
