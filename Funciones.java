package DVMarket;

import java.util.Scanner;

public class Funciones {
    
    public static void mensaje(String mensaje) {
        System.out.println(mensaje);
        Scanner entrada = new Scanner(System.in);
        entrada.nextLine();
    }
    
    private static String entrada() {
        Scanner entrada = new Scanner(System.in);
        String dato = entrada.nextLine();
        return dato;
    }
    
    private static String hayDato() {
        String dato = entrada();
        while (dato.equals("")) {
            System.out.println("Debe ingresar algo");
            dato = entrada();
        }
        return dato;
    }
    
    public static int esNumero() {
        String dato = hayDato();
        while (!dato.matches("[0-9]*")) {
            System.out.println("Debe ingresar un numero");
            dato = hayDato();
        }
        int num = Integer.parseInt(dato);
        return num;
    }
    
    public static int validarOpcion(int limite, String msj) {
        int num = esNumero();
        while (num < 1 || num > limite) {
            System.out.println(msj);
            num = esNumero();
        }
        return num; 
    }
    
}
