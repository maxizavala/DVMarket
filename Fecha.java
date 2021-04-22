package DVMarket;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class Fecha {
    private int dia; 
    private int mes; 
    private int anio;
    
    Fecha(int d, int m, int a){
        this.dia = d;
        this.mes = m;
        this.anio = a;
    }

    @Override
    public String toString() {
        return (dia+"/"+mes+"/"+anio);
    }
    
    public static Fecha FechaDehoy() {
        Calendar date = new GregorianCalendar();
        int anio = date.get(Calendar.YEAR);
        int mes = date.get(Calendar.MONTH);
        int dia = date.get(Calendar.DAY_OF_MONTH);
        Fecha hoy = new Fecha(dia, mes, anio);
        return hoy;
    }
}
