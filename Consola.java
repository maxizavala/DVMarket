package DVMarket;

import static DVMarket.Funciones.*;

public class Consola {
    public static void menuPrincipal(DVMarket market) {
        int opcion1;
        do {
            verMenuPrincipal(); //MENU PRINCIPAL
            opcion1 = validarOpcion(MenuPrincipal.values().length, "Debe ingresar una opción válida.");
            switch (opcion1) {
                case 1: subMenu(market); //MENU PRINCIPAL - NUEVA COMPRA
                    break;
                case 2: market.getCompras(); //MENU PRINCIPAL - VER COMPRAS
                    break;
                case 3: System.out.println("Saliendo..."); //MENU PRINCIPAL - SALIR
                    break;
            }
        } while (opcion1 != 3);
    }
    
    public static void subMenu(DVMarket market) {
        int opcion2;
        Compra c = market.nuevaCompra();
        do {
            verSubMenu(); // SUBMENU
            opcion2 = validarOpcion(SubMenu.values().length, "Debe ingresar una opción válida.");
            switch (opcion2) {
                case 1: market.cargarItemEnCompra(c); //SUBMENU - CARGAR ITEM
                break;
                case 2: market.borrarItemDeCompra(c); //SUBMENU - BORRAR ITEM
                break;
                case 3: market.verItemsDeCompra(c); //SUBMENU - VER ITEMS ACTUALES
                break;
                case 4: market.confirmarCompra(c); //SUBMENU - CONFIRMAR COMPRA
                break;
                case 5: market.cancelarCompra(c); //SUBMENU - CANCELAR COMPRA
                break;
                    }
        } while (opcion2 != 4 && opcion2 != 5);
    }
    
    public static void verMenuPrincipal() {
        System.out.println("Menu Principal. Seleccione una opción.");
        for (int i = 0; i < MenuPrincipal.values().length; i++) {
            System.out.println("\t" + MenuPrincipal.values()[i]);
        }
    }

    public static void verSubMenu() {
        System.out.println("Nueva Compra. Seleccione una opción.");
        for (int i = 0; i < SubMenu.values().length; i++) {
            System.out.println("\t" + SubMenu.values()[i]);
        }
    }
}
