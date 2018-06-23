package SimulacionIO;

public class Consulta{

    boolean muerto;
    double tiempoCola;
    double tiempoVida;
    double tiempoActual;
    int bloques;
    tipoConsulta tConsulta;
    public enum tipoConsulta{
        select, update, join, ddl;
    }
    Evento.tipoEvento tipoEvento;

    public Consulta(double numAelatorio, double tiempoCreacion){

         muerto = true; //Cuando entra al primer módulo, si se le admite se cambia
         if(numAelatorio >= 0.0 && numAelatorio <= 0.2999){
             tConsulta = tipoConsulta.select;
             bloques = 1;
         }
         else if(numAelatorio >= 0.30 && numAelatorio <= 0.5499){
             tConsulta = tipoConsulta.update;
             bloques = 0;
         }
         else if(numAelatorio >= 0.55 && numAelatorio <= 0.8999){
             tConsulta = tipoConsulta.join;
             bloques = 0;
         }
         else if(numAelatorio >= 0.90 && numAelatorio <= 1.0){
             tConsulta = tipoConsulta.ddl;
             bloques = 0;
         }
         tiempoVida = 0;
         tiempoCola = 0;
         tiempoActual = tiempoCreacion;
    }
    public void matarConsulta(){
        muerto = true;
    }

    public tipoConsulta getTConsulta(){
        return tConsulta;
    }

    public double getTiempoCola(){
        return tiempoCola;
    }
    public void setTiempoCola(double param){
        tiempoCola = param;
    }
    public double getTiempoVida(){
        return tiempoVida;
    }
    public void setTiempoVida(double param){
        tiempoVida = param;
    }
    public double getTiempoActual(){
        tiempoActual = Math.round(tiempoActual * Math.pow(10, 4)); //Redondear el valor a 4 decimales
        tiempoActual = tiempoActual/Math.pow(10, 4);
        return  tiempoActual;
    }
    public void setTiempoActual(double param){
        tiempoActual = param;
    }
    public boolean getMuerto(){
        return muerto;
    }
    public void setMuerto(boolean value){
        muerto = value;
    }
    public String getTipoConsulta(){
        return tConsulta.toString();
    }
    public void setTipoEvento(Evento.tipoEvento t){tipoEvento = t;}
    public Evento.tipoEvento getTipoEvento(){return tipoEvento;}
    
    public void setBloques(int b){bloques = b;}
    public int getBloques(){return bloques;}
}

 
