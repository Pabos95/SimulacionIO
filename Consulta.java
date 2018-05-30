package SimulacionIO;
public class Consulta{
    bool activo;
    float tiempoCola;
    float tiempoTotal;

    public enum tipoConsulta{
        select, update, join, ddl;
    }
    public Consulta(float numAelatorio){
     if(numAelatorio >= 0.0 && umAealatorio <= 0.30){
         tipoConsulta = select
     }
     else if(numAelatorio >= 0.31 && numAelatorio <= 0.55){
         tipoConsulta = update;
     }
     else if(numAelatorio >= 0.56 && numAelatorio <= 0.80){
         tipoConsulta = join;
     }
     else if(numAelatorio >= 0.56 && numAelatorio <= 1.00){
         tipoConsulta = ddl;
     }
    }
}