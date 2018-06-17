/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
    private double lambda;
    private int consultasServidas;
    private int consultasPasadasEnCola; //cantidad de consultas que han pasado por la cola del modulo
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
    public void actualizarPromedioConsultasEnModulo(){
        promedioConsultasEnModulo = tamañoPromedioCola + promedioConsultasSiendoServidas;
    }
    public void actualizarTiempoPromedio(){
        tiempoPromedio = tiempoPromedioEnCola + tiempoPromedioServicio;
    }
    public void actualizarLambda(){
        lambda = promedioConsultasEnModulo/tiempoPromedio;
    }
    
}
