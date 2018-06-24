package SimulacionIO;
import java.util.Random;

public class GeneradoraValoresAleatorios{
    Random r;
    public GeneradoraValoresAleatorios(){      
        r = new Random();
    }
    
    //m=1       (o-)^2 = 0.01
    public double generarValorDistribuicionNormal(double media, double varianza){ //utiliza el método de convolución para generar un valor aelatorio con distribuición uniforme
        double nuevoValor = 0;
        for(int i = 0; i <= 11; i++){
            nuevoValor += generarNumeroAleatorio();
        }
        nuevoValor -= 6;
        nuevoValor = media + (nuevoValor*Math.sqrt(varianza));
        nuevoValor = Math.round(nuevoValor * Math.pow(10, 4)); //Redondear el valor a 4 decimales
        nuevoValor = nuevoValor/Math.pow(10, 4);
        return nuevoValor;
    }
    public double generarValorDistribuicionExponencial(double lambda){
        
        double nuevoValor = 0;
        double r = generarNumeroAleatorio();
        nuevoValor = (-1/lambda)*(Math.log(1-r)); 
        nuevoValor = Math.round(nuevoValor * Math.pow(10, 4)); //Redondear el valor a 4 decimales
        nuevoValor = nuevoValor/Math.pow(10, 4);
        return nuevoValor;

    }
    public double generarValorDistribuicionUniforme(double a, double b){
        double nuevoValor = a + (b - a)*generarNumeroAleatorio();
        nuevoValor = Math.round(nuevoValor * Math.pow(10, 4)); //Redondear el valor a 4 decimales
        nuevoValor = nuevoValor/Math.pow(10, 4);
        return nuevoValor;
    }
    public double generarNumeroAleatorio(){ //genera un número entre 0 y 1 
        double x = r.nextDouble();
        x = Math.round(x * Math.pow(10, 4)); //Redondear el valor a 4 decimales
        x = x/Math.pow(10, 4);
        return x;
    }
}

