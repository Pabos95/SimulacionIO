package SimulacionIO;
import java.util.Random;
public class GeneradoraValoresAelatorios{
    Random r;
    public GeneradoraValoresAelatorios(){
        r = new Random();
        }
    public double generarValorDistribuicionNormal(double media, double varianza){ //utiliza el mÃ©todo de convoluciÃ³n para generar un valor aelatorio con distribuiciÃ³n uniforme
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
    public double generarValorDistribuicionUniforme(double a, double b){
        double nuevoValor = a + (b - a)*generarNumeroAelatorio();
        return nuevoValor;
    }
    public double generarNumeroAelatorio(){ //genera un nÃºmero entre 0 y 1
               return r.nextDouble();
            }
}