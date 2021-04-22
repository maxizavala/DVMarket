package DVMarket;

import java.util.ArrayList;

public class Ticket {
    private int num;
    private Fecha fecha;
    private Hora hora;
    private ArrayList<Producto> items;
    private double total;
    private int[] arrayCant;
    private static int COUNT_NUM = 0;

    public Ticket(Fecha fecha, Hora hora, double total, ArrayList<Producto> items, int[] arrayCant) {
        this.num = Ticket.obtenerNum();
        this.fecha = fecha;
        this.hora = hora;
        this.total = total;
        this.items = items;
        this.arrayCant = arrayCant;
    }
    
    private static int obtenerNum() {
        Ticket.COUNT_NUM++;
        return Ticket.COUNT_NUM;
    }
    
    private String cabeza() {
        return  "DVMarket - MaximilianoZavala SRL \n" + 
                "Ticket nro. "+ this.num + "\t" + this.fecha + " " + this.hora + "\n\n";
    }
    
    private String cuerpo() {
        String listado = "";
        for (int i = 0; i < items.size(); i++) {
            Producto item = items.get(i);
            int cant = arrayCant[i];
            double precio = item.getPrecio();
            double subtotal = precio*cant;
            int chars1 = contarCaracteres(item.toString()+"$"+precio);            
            String esp = espacios(chars1);
            String fila1 = item + esp + "$" + precio + "\n";          
            int chars2 = contarCaracteres("x"+cant+"$"+subtotal);           
            esp = espacios(chars2);           
            String fila2 = "x" + cant + esp + "$" + subtotal + "\n";
            listado += fila1+fila2;
        }
        return listado;
    }
    
    private int contarCaracteres(String fila) {
        int chars = fila.length();
        return chars;
    }
    
    private String espacios(int chars) {
        double espacios = 38-chars;
        String esp = "";
        for (int i = 0; i < espacios; i++) {
            esp += " ";
        }
        return esp;
    }
    
    private String pie() {
        String fila = "Total $" + this.total;
        int chars = contarCaracteres(fila);
        String esp = espacios(chars);
        fila = esp + "Total $" + this.total;
        return  "\n" + fila + "\n";
    }
    
    private String linea() {
        return "--------------------------------------\n";
    }
    
    @Override
    public String toString() {
        return linea()+cabeza()+cuerpo()+pie()+linea();         
    }
    
}
