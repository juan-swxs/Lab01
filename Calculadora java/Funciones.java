
public class Funciones{

    public static Double additon(Double x, Double y){
        return x + y;
    }

    public static Double remaind(Double x, Double y){
        return x - y;
    }

    public static Double multiply(Double x, Double y){
        return x * y;
    }

    public static Double split(Double x, Double y){
        return x/y;
    }

    public static Double Power(Double x, Double y){
        return Math.pow(x,y);
    }
    
    public static Double Sen(Double x){
        Double value = Math.toRadians(x);
        return Math.sin(value);
        
    }

    public static Double Cos(Double x){
        Double value = Math.toRadians(x);
        return Math.cos(value);
    }

    public static Double radical(Double x){
        return Math.sqrt(x);
    }

    public static Double tang(Double x){
        Double value = Math.toRadians(x);
        return Math.tan(value);
    }

    public static Double Ln(Double x){

        Double value = Math.log10(x);
        return value;
    }

    public static Double Antsen(Double x){
        return Math.asin(x);
    }

    public static Double Antcon(Double x){
        return Math.acos(x);
    }

    public static Double AntTangh(Double x){
        return Math.atan(x);
    }
}
