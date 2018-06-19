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
    tiempoActual = 0.0;
    iteracionActual = 1;
  }
  public Consulta generarConsulta(){
    double numAelatorio = gen.generarNumeroAelatorio();
    Consulta c = new Consulta(numAelatorio,tiempoActual);
    return c;
  }
  public void procesarSimulacion(){
  while(iteracionActual <= cantidadCorridas){
  }
 */   while(no hayamos hecho la cantidad de simulaciones)
    *   *Creacion e inicializacion de todos los modulos
    *   while(el tiempo de simulacion no haya llegado al indicado, o algun otra condicion que se agregue como extra
    *     generarConsulta
    *     modAdminClientes.procesarLlegada(consulta)
    *     modAdminClientes.procesarSalida(consulta)
    *     controlarTimeout
    *     modAdminProcesos.procesarLlegada(consulta)
    *     modAdminProcesos.procesarSalida(consulta)
    *     controlarTimeout
    *     .
    *     .
    *     .
    *      controlarTimeout
    *     modAdminClientes.procesarLlegada(consulta)
    *     modAdminClientes.procesarSalida(consulta)
    *     AnalizarConsulta(consulta) Se encargaría de ver si se murió o logró pasar el proceso, tiempo de vida, tiempo en cola, tipo de consulta. . .
    *                                 Podría devovler una especie de estructura de datos para eventualmente pasarselo a estadísticas
    *     actualizarTimpoActual
    *       Si el tiempo de la consulta que llegó al final es mayor o igual al tiempo actual
    *       tiempoactual = timpode la consulta*/
  }
}
