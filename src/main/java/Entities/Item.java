package Entities;

public class Item  {

    private Producto producto;
    private Integer cantidad;

    public Item(Producto producto, Integer cantidad) {
        validarProducto(producto);
        validarCantidad(cantidad);

        this.producto = producto;
        this.cantidad = cantidad;

    }




    public Producto getProducto() {
        return producto;
    }

    public Double obtenerSubTotal(){
        return this.subTotalBebida()+this.subTotalPlato();
    }
    public Double subTotalBebida() {
        return producto.getPrecioBebida() * this.cantidad;
    }

    public double subTotalPlato() {
        return producto.getPrecioPlato() * this.cantidad;
    }
    //VALIDACIONES

    private void validarProducto(Producto producto) {
        if (producto == null) throw new IllegalArgumentException("El producto no puede ser nulo.");

    }

    private void validarCantidad(Integer cantidad) {
        if (cantidad == null || cantidad <= 0) throw new IllegalArgumentException("La cantidad debe ser un número entero positivo.");

    }

}
