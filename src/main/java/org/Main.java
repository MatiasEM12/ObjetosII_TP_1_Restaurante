package org;

import Backend.VentaDAOJDBC;
import Entities.*;


import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        System.out.println("=== SISTEMA DE VENTAS DEL RESTAURANTE ===\n");

        // ========== CREAR PEDIDOS ==========
        System.out.println("=== CREANDO PEDIDOS ===\n");

        ArrayList<Pedido> pedidos = new ArrayList<>();
        var ventaDao = new VentaDAOJDBC();
        var pedidoVisa = new Pedido(new TarjetaVisa(4532015112830366L), Propina.DOS,ventaDao);
        var pedidoMastercard = new Pedido(new TarjetaMastercard(4532015112830367L), Propina.DOS,ventaDao);
        var pedidoComarcaPlus = new Pedido(new TarjetaComarcaPlus(4532015112830362L), Propina.DOS,ventaDao);
        var pedidoViedma = new Pedido(new TarjetaViedma(4532015112830361L), Propina.DOS,ventaDao);

        pedidos.add(pedidoVisa);
        pedidos.add(pedidoMastercard);
        pedidos.add(pedidoComarcaPlus);
        pedidos.add(pedidoViedma);

        System.out.println("Se crearon 4 pedidos con distintos medios de pago.\n");

        // ========== AGREGAR ITEMS ==========
        System.out.println("=== AGREGANDO ITEMS A LOS PEDIDOS ===\n");

        for (Pedido pedido : pedidos) {
            ArrayList<Item> items = new ArrayList<>();
            items.add(new Item(new Bebida("Coca-Cola", 100.00, true), 2));
            items.add(new Item(new Plato("Hamburguesa", 200.00, true), 1));
            pedido.agregarItems(items);
            pedido.confirmarPedido();
        }

        System.out.println("Se agregaron los mismos productos a todos los pedidos:");
        System.out.println("- 2 x Coca-Cola ($100 c/u)");
        System.out.println("- 1 x Hamburguesa ($200)\n");

        // ========== CALCULAR TOTALES ==========
        System.out.println("=== CALCULANDO TOTALES ===\n");

        double totalVisa = pedidoVisa.calcularTotal();
        double totalMastercard = pedidoMastercard.calcularTotal();
        double totalComarcaPlus = pedidoComarcaPlus.calcularTotal();
        double totalViedma = pedidoViedma.calcularTotal();

        System.out.println("Total con Tarjeta Visa: " + totalVisa);
        System.out.println("Total con Tarjeta Mastercard: " + totalMastercard);
        System.out.println("Total con Tarjeta Comarca Plus: " + totalComarcaPlus);
        System.out.println("Total con Tarjeta Viedma: " + totalViedma);
        System.out.println();

        // ========== GUARDAR VENTAS EN LA BASE DE DATOS ==========
        System.out.println("=== PERSISTENCIA DE DATOS ===\n");


        System.out.println("Se realiza en la logica de negocio de Pedido");
        System.out.println();

        // ========== LISTADO DE VENTAS DESDE LA BASE DE DATOS==========
        System.out.println("=== LISTADO DE VENTAS DESDE LA BASE DE DATOS ===\n");
        List<Venta> ventas = ventaDao.findAll();
        if (ventas.isEmpty()) {
            System.out.println("No hay ventas registradas");
        } else {
            for (Venta venta : ventas) {
                System.out.println(venta.toString());
            }
        }

        System.out.println();

        // ========== RESUMEN FINAL ==========
        System.out.println("=== RESUMEN FINAL ===\n");
        System.out.println("Pedidos procesados: " + pedidos.size());
        System.out.println("Total Visa: " + totalVisa);
        System.out.println("Total Mastercard: " + totalMastercard);
        System.out.println("Total Comarca Plus: " + totalComarcaPlus);
        System.out.println("Total Viedma: " + totalViedma);

    }
}