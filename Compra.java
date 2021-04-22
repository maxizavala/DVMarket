package DVMarket;

import java.util.ArrayList;
import static DVMarket.Funciones.*;

public class Compra {
    private int ID;
    private ArrayList<Producto> items;
    private Estado estado;
    private Fecha fecha;
    private Hora hora;
    private static int COUNT_ID = 0;

    public Compra() {
        this.ID = Compra.obtenerID();
        this.items = new ArrayList<>();
        this.estado = Estado.PENDIENTE;
        this.fecha = Fecha.FechaDehoy();
        this.hora = Hora.HoraActual();
    }
    
    private static int obtenerID() {
        Compra.COUNT_ID++;
        return Compra.COUNT_ID;
    }
    
    public void cargarItem(DVMarket m) {
        int item;
        System.out.println("Ingrese el código del producto o '0' para finalizar");
        do {
            item = esNumero();
            Producto prod = m.buscarProducto(item);
            if (item != 0 && prod == null) {
                System.out.println("Código incorrecto");
            }
            else if (item != 0 && prod != null) {
                agregarItem(prod);
            }
        } while (item != 0);
    }
    
    private void agregarItem(Producto prod) {
        System.out.println("Ingrese una cantidad de 1 a 99..");
        int cant = validarOpcion(99, "Debe ingresar una cantidad válida.");
        for (int i = 0; i < cant; i++) {
            this.items.add(prod);
        }
        System.out.println(prod.getDetalle()+" x"+cant+" - AGREGADO\n"
                + "Ingrese el código del producto o '0' para finalizar");
    }
    
    public Producto eliminarItem() {
        Producto prod = null;
        if (this.items.size() > 0) {
            System.out.println("Ingrese el código del producto a eliminar");
            int codigo = esNumero();
            prod = buscarProductoEnLista(codigo, this.items);
            if (prod != null) {
                this.items.remove(prod);
                System.out.println(prod+" - ELIMINADO");
                mensaje("Presiones Enter para continuar...");
            }
            else {
                System.out.println("Código incorrecto");
            }
        }
        else {
            System.out.println("Aún no hay productos que se puedan eliminar.");
        }
        return prod;
    }
    
    public void confirmarCompra() {
        if (this.items.size() > 0) {
            this.setEstado(Estado.CONFIRMADA);
            Ticket factura = new Ticket(this.fecha, this.hora, this.montoTotal(), this.agruparItems(), this.arrayCantPorItem());
            System.out.println(factura);
        }
        else {
            System.out.println("No se ha podido confirmar la copra.\nPrimero debe ingresar productos.");
        }
        mensaje("Presione Enter para continuar..");
    }
    
    public void cancelarCompra() {
        this.setEstado(Estado.CANCELADA);
        mensaje("COMPRA CANCELADA - Presione Enter para continuar..");
    }

    private void setEstado(Estado estado) {
        this.estado = estado;
    }
    
    private double montoTotal() {
        double total = 0;
        for (Producto item : items) {
            total += item.getPrecio();
        }
        return total;
    }
    
    public void verCompraAgrupada() {
        ArrayList<Producto> itemsAgrupados = agruparItems();
        if (itemsAgrupados.size() > 0) {
            System.out.println("Items actuales:");
            for (Producto item : itemsAgrupados) {
                System.out.println("\t" + item + " $" + item.getPrecio() + "\n\tCantidad: " + 
                        cantPorItem(item) + "\tSubtotal: $" + subtotalPorItem(item));
            }
           mensaje("Presione Enter para continuar.."); 
        }
        else {
            System.out.println("No hay items cargados");
        }
    }
    
    private ArrayList<Producto> agruparItems() {
        ArrayList<Producto> itemsAgrupados = new ArrayList<>();
        for (Producto item : this.items) {
            if (buscarProductoEnLista(item.getId(), itemsAgrupados) == null) {
                itemsAgrupados.add(item);
            }
        }
        return itemsAgrupados;
    }
    
    private int cantPorItem(Producto p) {
        int cant = 0;
        for (Producto item : this.items) {
            if (item == p) {
                cant++;
            }
        }
        return cant;
    }
    
    private int[] arrayCantPorItem() {
        ArrayList<Producto> itemsAgrupados = agruparItems();
        int[] cantPorItem = new int[itemsAgrupados.size()];
        for (int i = 0; i < itemsAgrupados.size(); i++) {
            Producto item = itemsAgrupados.get(i);
            int cant = cantPorItem(item);
            cantPorItem[i] = cant;
        }
        return cantPorItem;
    }
    
    private double subtotalPorItem(Producto p) {
        double precio = p.getPrecio();
        int cant = cantPorItem(p);
        return precio*cant;
    }
    
    private Producto buscarProductoEnLista(int codigo, ArrayList<Producto> lista) {
        int i = 0;
        Producto productoEncontrado = null;
        while (i < lista.size() && productoEncontrado == null) {
            Producto p = lista.get(i);
            if (p.getId() == codigo) {
                productoEncontrado = p;
            }
            i++;
        }
        return productoEncontrado;
    }

    @Override
    public String toString() {
        return "#" + ID + " " + fecha + " " + hora + " $" + montoTotal();
    }

}
