package DVMarket;

public enum MenuPrincipal {
    NUEVA_COMPRA, 
    VER_COMPRAS, 
    SALIR;
    
    @Override
       public String toString() {
           String name = "";
           switch (ordinal()) {
           case 0:
               name = "1. Nueva Compra";
               break;
           case 1:
               name = "2. Ver Compras";
               break;
           case 2:
               name = "3. Salir";
               break;
           }
           return name;
       }

}
