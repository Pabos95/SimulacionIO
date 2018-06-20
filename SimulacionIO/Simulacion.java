package SimulacionIO;
import java.util.*;
import Modulo.*;
import Estadisticos.*;
import Interfaz;
public class Simulacion{
  ModAdministracionClientes modAdminClientes;
  ModAdministracionConexiones modAdminConexiones;
  ModAdministracionConsultas modAdminConsultas;
  ModAdministracionProcesos modAdminProcesos;
  ModAdministracionTransacciones modAdminTransacciones;
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
  Interfaz ventana;
  public Simulacion(double tMax,int numCorridas,int numConexionesConcurrentesMaximo,int numProcesosEjecucionTransacciones, int numProcesosEjecucionConsultas, int segundosParaTimeOut){
    tiempoMaximo = tMax;
    cantidadCorridas = numCorridas;
    k = numConexionesConcurrentesMaximo;
    n = numProcesosEjecucionConsultas;
    tiempoActual = 0.0;
    iteracionActual = 1;
  }
  public Consulta generarConsulta(){
    double numAelatorio = gen.generarNumeroAelatorio();
    Consulta c = new Consulta(numAelatorio,tiempoActual);
    return c;
  }
  public void procesarSimulacion(){
   Consulta cActual;/*
  while(iteracionActual <= cantidadCorridas){
    modClientes = new ModAdministracionClientes();
    modAdminConexiones = new ModAdministracionConexiones();
    modAdminConsultas = new ModAdministracionConsultas();
    modAdminProcesos = new ModAdministracionProcesos();
    modAdminTransacciones = new ModAdministracionTransacciones();
    while(tiempoActual < tiempoMaximo){
      cActual = generarConsulta();
      modAdminClientes.procesarLlegada(cActual);
      modAdminClientes.procesarLlegada(cActual);
      verificarTimeOut(cActual);
      modAdminProcesos.procesarLlegada(cActual);
      modAminProcesos.procesarLlegada(cActual);
      verificarTimeOut(cActual);
    }
  }
 */ /*Hacer lista de todos los eventos con su modulo
 *   elemento = lista.sacar elemento()
 *   switch (elemento.tipoEvento()):
 *    case: entradamodulo 1{
 *
 *    aux = procesarEntrada();
 *    if (null != aux)
 *      agregaraLISTA(aux);
 *    }
 *    breack;
 *    case salidamodulo 1{
 *
 *
 *    }
 *    breack;*/
  }
  public void actualizarVentena(){ //aqui se muestra cada evento de la simulacion, el tamaño de las colas ect.
  }
}
