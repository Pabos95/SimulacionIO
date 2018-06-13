package SimulacionIO;
public class Consulta{
    public enum tipoConsulta{
        select, update, join, ddl;
    }
    boolean activo;
    float tiempoCola;
    float tiempoTotal;
    tipoConsulta consulta;
    public Consulta(float numAelatorio){
     if(numAelatorio >= 0.0 && numAelatorio <= 0.30){
         consulta = tipoConsulta.select;
     }
     else if(numAelatorio >= 0.31 && numAelatorio <= 0.55){
         consulta = tipoConsulta.update;
     }
     else if(numAelatorio >= 0.56 && numAelatorio <= 0.80){
         consulta = tipoConsulta.join;
     }
     else if(numAelatorio >= 0.56 && numAelatorio <= 1.00){
         consulta = tipoConsulta.ddl;
     }
    }
}