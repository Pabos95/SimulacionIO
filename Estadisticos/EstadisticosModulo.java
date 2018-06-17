package Estadisticos;
import SimulacionIO.*;
/**
 *
 * @author Pabos95
 */
public class EstadisticosModulo {
    private double tamañoPromedioCola; //Lq del modulo
    private double promedioConsultasSiendoServidas; //Ls del modulo
    private double promedioConsultasEnModulo; //L del modulo
    private double tiempoPromedioServicio; // Ws del modulo
    private double tiempoPromedioEnCola; //  Wq del modulo
    private double tiempoPromedio; // W del modulo
    private double sumatoriaTiempoServicio;//sumatorio de los tiempos de servicio de todas las consultas que han sido atendidas en el modulo
    private double sumatoriaTiempoCola;
    private double sumatoriaConsultasEnCola;
    private double sumatoriaConsultasSiendoAtendidas;
    private double lambda;
    private double mu; //tasa de servicio del modulo 
    private double rho; // tasa de ocupación del modulo
    private int consultasServidas;
    private int consultasPasadasEnCola; //cantidad de consultas que han pasado por la cola del modulo
    private double probabilidadOcio; //probabilidad de que el sistema esté ocioso
    public EstadisticosModulo(){ //constructor de la clase, inicializa todos los datos en 0
        tamañoPromedioCola = 0;
        promedioConsultasSiendoServidas = 0;
        promedioConsultasEnModulo = 0;
        tiempoPromedioServicio = 0;
        tiempoPromedioEnCola = 0;
        tiempoPromedio = 0;
        sumatoriaTiempoServicio = 0;
        sumatoriaTiempoCola = 0;
        sumatoriaConsultasEnCola = 0;
        sumatoriaConsultasSiendoAtendidas = 0;
        lambda = 0;
        consultasServidas = 0;
        consultasPasadasEnCola = 0;
        rho = 0;
        mu = 0;
    }
    public double getTamañoPromedioCola(){
        return tamañoPromedioCola;
    }
    public double getPromedioConsultasSiendoServidas(){
        return promedioConsultasSiendoServidas;
    }
    public double getTiempoPromedioEnCola(){
        return tiempoPromedioEnCola;
    }
    public double getTiempoPromedioServicio(){
        return tiempoPromedioServicio;
    }
    public double getLambda(){
        return lambda;
    }
    public double getRho(){
        return rho;
    }
    public void actualizarTiempoPromedioServicio(double tiempoServicio){
        sumatoriaTiempoServicio += tiempoServicio;
        tiempoPromedioServicio = sumatoriaTiempoServicio/consultasServidas;
    }
    public void actualizarTiempoPromedioCola(double tiempoEnCola){
        sumatoriaTiempoCola += tiempoEnCola;
        tiempoPromedioEnCola = sumatoriaTiempoCola/consultasPasadasEnCola;
    }
    public void aumentarConsultasServidas(){
        consultasServidas++;
    }
    public void aumentarConsultasEnCola(){
        consultasPasadasEnCola++;
    }
    public void actualizarLambda(){
        lambda = promedioConsultasEnModulo/tiempoPromedio;
        actualizarRho();
    }
    public void actualizarPromedioConsultasEnModulo(){
        promedioConsultasEnModulo = tamañoPromedioCola + promedioConsultasSiendoServidas;
        actualizarLambda();
    }
    public void actualizarRho(){
        rho = lambda/mu;
    }
    public void actualizarTiempoPromedio(){
        tiempoPromedio = tiempoPromedioEnCola + tiempoPromedioServicio;
        actualizarLambda();
    }
    public void actualizarMu(){
        mu = 1/tiempoPromedioServicio;
        actualizarRho();
        actualizarProbabilidadOcio();
    }
    public void actualizarProbabilidadOcio(){
        probabilidadOcio = 1 - rho;
    }
}
