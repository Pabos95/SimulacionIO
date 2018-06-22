package SimulacionIO;
import java.util.Random;

public class GeneradoraValoresAelatorios{
    Random r;
    public GeneradoraValoresAelatorios(){      
        r = new Random();
    }
    //Como sabemos que los valores nunca cambian podría solo devovler el valor
    //m=1       (o-)^2 = 0.01
    public double generarValorDistribuicionNormal(double media, double varianza){ //utiliza el método de convolución para generar un valor aelatorio con distribuición uniforme
        double nuevoValor = 0;
        for(int i = 0; i <= 11; i++){
            nuevoValor += generarNumeroAleatorio();
        }
        nuevoValor -= 6;
        nuevoValor = media + (nuevoValor*Math.sqrt(varianza));
        return nuevoValor;
    }
    public double generarValorDistribuicionExponencial(double lambda){
        double nuevoValor = 0;
        double r = generarNumeroAleatorio();
        nuevoValor = (-1/lambda)*(Math.log(1-r));       
        return nuevoValor;
    }
    public double generarValorDistribuicionUniforme(double a, double b){
        double nuevoValor = a + (b - a)*generarNumeroAleatorio();
        return nuevoValor;
    }
    public double generarNumeroAleatorio(){ //genera un número entre 0 y 1    
        System.out.println("Random es :" + r.nextDouble());
        return r.nextDouble();
    }
}

