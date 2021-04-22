package DVMarket;

import java.util.ArrayList;
import java.util.Scanner;
import static DVMarket.Funciones.*;

public class DVMarket {
    private ArrayList<Producto> productos;
    private ArrayList<Compra> compras;

    public DVMarket() {
        productos = new ArrayList<>();
        compras = new ArrayList<>();
    }
    
    public Compra nuevaCompra() {
        Compra c = new Compra();
        return c;
    }
    
    public void cargarItemEnCompra(Compra compra) {
        compra.cargarItem(this);
    }
    
    public void borrarItemDeCompra(Compra compra) {
        compra.eliminarItem();
    }
    
    public void verItemsDeCompra(Compra c) {
        c.verCompraAgrupada();
    }
    
    public void confirmarCompra(Compra c) {
        c.confirmarCompra();
        agregarCompra(c);
    }
    
    private void agregarCompra(Compra c) {
        this.compras.add(c);
    }
    
    public void agregarProducto(Producto p) {
        this.productos.add(p);
    }
    
    public void cancelarCompra(Compra c) {
        c.cancelarCompra();
    }
    
    public Producto buscarProducto(int codigo) {
        int i = 0;
        Producto productoEncontrado = null;
        while (i < this.productos.size() && productoEncontrado == null) {
            Producto p = this.productos.get(i);
            if (p.getId() == codigo) {
                productoEncontrado = p;
            }
            i++;
        }
        return productoEncontrado;
    }

    public void getCompras() {
        if (this.compras.size() < 1) {
            System.out.println("No hay compras para mostrar.");
        }
        else {
            System.out.println("Compras:");
            for (Compra compra : compras) {
                System.out.println("\t" + compra);
            }
            mensaje("Presione Enter para continuar..");
        }
        
    }


}
