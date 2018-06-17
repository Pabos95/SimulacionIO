package SimulacionIO;
import java.util.*;
import Modulo.*;
import Estadisticos.*;
public class Simulacion{
  int iteracionActual;
  double tiempoMaximo;  //tiempo maximo de la simulacion
  int cantidadCorridas;// cantidad de corridas que se van a ejecutar de la simulación
  int k; // numero maximo de conexiones concurrentes que puede administrar el sistema
  int n; //numero de procesos disponibles para el procesamiento de consultas. concurrentes que puede manejar el sistema.
  int p; //numero de procesos disponibles para la ejecución de transacciones
  int m; //numero de procesos disponibles para la ejecución de consultas
  int t; //cantidad de segundos para el timeout de las conexiones
  boolean modoLento;// true si la conexión está en modoLento y falso en caso contrario
  List <Evento> listaEventos;
  ArrayList <Consulta> consultas; //almacena las consultas de la simulacion para al final de una corrida poder calcular el tiempo de vida promedio
  ArrayList <EstadisticosModulo> estadisticasModulo;
  double tiempoActual;
  GeneradoraValoresAelatorios gen;
  public Simulacion(double tMax,int numCorridas,int numConexionesConcurrentesMaximo,int numProcesosEjecucionTransacciones, int numProcesosEjecucionConsultas, int segundosParaTimeOut){
    tiempoMaximo = tMax;
    cantidadCorridas = numCorridas;
    k = numConexionesConcurrentesMaximo;
    n = numProcesosEjecucionConsultas;
  }
  public Consulta generarConsulta(){
    double numAelatorio = gen.generarNumeroAelatorio();
    Consulta c = new Consulta(numAelatorio);
    return c;
  }
  public void ejecutarSimulacion(){
  Consulta c;
  while(iteracionActual <= cantidadCorridas){
    while(tiempoActual <tiempoMaximo){
    c = generarConsulta();
    }
  }
  iteracionActual++;
  }
}
