package SimulacionIO;

public class Consulta{

    boolean muerto;
    double tiempoCola;
    double tiempoVida;
    tipoConsulta tConsulta;
    public enum tipoConsulta{
        select, update, join, ddl;
    }


    public Consulta(double numAelatorio){

         muerto = false;
         if(numAelatorio >= 0.0 && numAelatorio <= 0.30){
             tConsulta = tipoConsulta.select;
         }
         else if(numAelatorio >= 0.31 && numAelatorio <= 0.55){
             tConsulta = tipoConsulta.update;
         }
         else if(numAelatorio >= 0.56 && numAelatorio <= 0.80){
             tConsulta = tipoConsulta.join;
         }
         else if(numAelatorio >= 0.56 && numAelatorio <= 1.00){
             tConsulta = tipoConsulta.ddl;
         }
         tiempoVida = 0;
    }
    public void matarConsulta(){
        muerto = true;
    }

    public tipoConsulta getTConsulta(){
        return tConsulta;
    }
}
 
