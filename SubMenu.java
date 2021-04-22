package DVMarket;

public enum SubMenu {
    CARGAR_ITEM,
    BORRAR_ITEM,
    VER_ITEMS_ACTUALES,
    CONFIRMAR_COMPRA,
    CANCELAR_COMPRA;
    
    @Override
       public String toString() {
           String name = "";
           switch (ordinal()) {
           case 0:
               name = "1. Cargar ítem";
               break;
           case 1:
               name = "2. Borrar ítem";
               break;
           case 2:
               name = "3. Ver ítems actuales";
               break;
           case 3:
               name = "4. Confirmar compra";
               break;
           case 4:
               name = "5. Cancelar compra";
               break;
           }
           return name;
       }
}
