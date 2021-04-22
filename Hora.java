package DVMarket;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class Hora {
    private int hs; 
    private int min; 
    private int seg;
    
    Hora(int h, int m, int s){
        this.hs = h;
        this.min = m;
        this.seg = s;
    }

    @Override
    public String toString() {
        return (hs+":"+min+":"+seg);
    }
    
    public static Hora HoraActual() {
        Calendar date = new GregorianCalendar();
        int h = date.get(Calendar.HOUR_OF_DAY);
        int m = date.get(Calendar.MINUTE);
        int s = date.get(Calendar.SECOND);
        Hora actual = new Hora(h, m, s);
        return actual;
    }
    
}
