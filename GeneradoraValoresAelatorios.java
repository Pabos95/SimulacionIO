import java.util.Random;
public class GeneradoraValoresAelatorios{
    Random r;
    public GeneradoraValoresAelatorios(){
        r = new Random(Math.random() * 10000);
        }
public float generarValorDistribuicionNormal(){ //utiliza el método de convolución
         float nuevoValor = 0;
         for(int i = 1; i <= 12; i++){

        }
         return nuevoValor;
        }
public float generarNumeroAelatorio(){ //genera un número entre 0 y 1
           return double.toFloat(r.nextDouble());
        }
        }