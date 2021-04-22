package DVMarket;

import static DVMarket.Consola.*;

public class Principal {

    public static void main(String[] args) {
        
        DVMarket market = new DVMarket();
        System.out.println("Bienvenido a DVMarket");
        cargarItems(market);
        menuPrincipal(market);

    }

    
    public static void cargarItems(DVMarket market) {
        market.agregarProducto(new Producto("Fideos Marolio 500g", 40.0));          //CODIGO 1001 
        market.agregarProducto(new Producto("Agua Glaciar 6l", 190.0));             //CODIGO 1002 
        market.agregarProducto(new Producto("Bizcochueo Royal 500g", 135.0));       //CODIGO 1003 
        market.agregarProducto(new Producto("Puré de tomate Molto 200g", 30.0));    //CODIGO 1004 
        market.agregarProducto(new Producto("Galletitas 9deOro 180g", 71.0));       //CODIGO 1005 
        market.agregarProducto(new Producto("Aceite Natura 1.5l", 350.0));          //CODIGO 1006 
        market.agregarProducto(new Producto("Leche entera Sancor 1l", 45.0));       //CODIGO 1007 
        market.agregarProducto(new Producto("Café Nescafe 170g", 360.0));           //CODIGO 1008 
        market.agregarProducto(new Producto("Arroz Gallo 1kg", 93.0));              //CODIGO 1009 
        market.agregarProducto(new Producto("Harina 000 Marolio 1kg", 38.0));       //CODIGO 1010 
    }
    
}
