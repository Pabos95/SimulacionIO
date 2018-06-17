package Modulo;
import java.util.*;
import SimulacionIO.*;
import Estadisticos.*;
class Modulo{
    int tamFinalCola;
    int tamActualCola;
    int consultasEnProceso; 
    int capacidadMaxima;
    Queue<Consulta> colaConsultas;
    EstadisticosModulo estadisticosMod;
    GeneradoraValoresAelatorios generador;
   public void procesarLlegada(){
 
   }
   public void procesarSalida(){

   }
   public void procesarTimeOut(){

   }
   public int capacidadRestante(){
    return (capacidadMaxima - consultasEnProceso);
}
}