package SimulacionIO;
public class Consulta{
    public enum tipoConsulta{
        select, update, join, ddl;
    }
    boolean activo;
    float tiempoCola;
    float tiempoTotal;
    tipoConsulta tConsulta;
    public Consulta(float numAelatorio){
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
    }
}