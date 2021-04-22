package DVMarket;

public class Producto {
    private int id;
    private String nombre;
    private double precio;
    private static int COUNT_ID = 1000;

    public Producto(String nombre, double precio) {
        this.nombre = nombre;
        this.precio = precio;
        this.id = Producto.obtenerID();
    }

    public int getId() {
        return id;
    }

    public double getPrecio() {
        return precio;
    }
    
    public String getDetalle() {
        return this.nombre+" $"+this.precio;
    }
    
    private static int obtenerID() {
        Producto.COUNT_ID++;
        return Producto.COUNT_ID;
    }

    @Override
    public String toString() {
        return "#" + id + " " + nombre;
    }
    
}

    