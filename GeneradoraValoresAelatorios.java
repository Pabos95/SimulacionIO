package SimulacionIO;
import java.util.Random;
public class GeneradoraValoresAelatorios{
    Random r;
    public GeneradoraValoresAelatorios(){
        r = new Random();
        }
public double generarValorDistribuicionNormal(double media, double varianza){ //utiliza el método de convolución para generar un valor aelatorio con distribuición uniforme
         double nuevoValor = 0;
         for(int i = 0; i <= 11; i++){
               nuevoValor += generarNumeroAelatorio();
        }
         nuevoValor -= 6;
         nuevoValor = media + (nuevoValor*Math.sqrt(varianza));
         return nuevoValor;
        }
public double generarValorDistribuicionExponencial(double media){
    double nuevoValor = 0;
    return nuevoValor;
}
public double generarValorDistribuicionUniforme(double a, double b){ // utiliza el método de la transformación inversa para generar un valor aelatorio con distribuición uniforme
    double nuevoValor = a + (b - a)*generarNumeroAelatorio();
    return nuevoValor;
}
public double generarNumeroAelatorio(){ //genera un número entre 0 y 1
           return r.nextDouble();
        }
        }
