package SimulacionIO;
import java.util.*;
import Modulo.*;
import Estadisticos.*;
import Interfaz.*;
import javafx.util.Pair;

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
    /*Falta asignar los otros valores, p, m , t*/
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
          modAdminClientes = new ModAdministracionClientes(k); //Revisar que todo esté bien y claro
          modAdminConexiones = new ModAdministracionConexiones();
          modAdminConsultas = new ModAdministracionConsultas(n,m);
          modAdminProcesos = new ModAdministracionProcesos();
          modAdminTransacciones = new ModAdministracionTransacciones(p);
          double num = gen.generarNumeroAelatorio();
          Consulta consultaActual = new Consulta(num,0);
          Evento e = new Evento();
          List listaEventos = new ArrayList<Consulta>(200);
          consultaActual.setTipoEvento(Evento.tipoEvento.llegadaModuloAdministracionClientes);
          listaEventos.add(consultaActual);//El evento por default es entrada al modulo adm clientes y la consulta si es aleatoria
          while(tiempoActual < tiempoMaximo){
              consultaActual = generarConsulta();
              consultaActual.setTipoEvento(Evento.tipoEvento.llegadaModuloAdministracionClientes);
              consultaActual = (Consulta)listaEventos.get(0);

          }
      }
  /*Hacer lista de todos los eventos con su modulo
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

/* DESPUES LO USARÉ PARA METER DATOS A LA LISTA DE EVENTOS O LISTA DE CONSULTAS

* public void agregarConsulta (Consulta c){//Se usa para agregar consultas desde el controlador, según se requiere en particular por cada módulo
+                                            //En ese lugar, se preguntarán las condiciones: colaVacia, mod Ocupado, timeOut....
+
+        if(colaConsultas.isEmpty()){//En caso que la cola esté vacía
+            colaConsultas.add(c);
+        }
+        else{
+            Iterator it =  colaConsultas.iterator();
+            Consulta aux;
+            boolean campo = false;
+            int espacio = 0;
+            while(it.hasNext() && !campo){
+                aux = (Consulta)it.next();
+                if(aux.getTiempoCola() <= c.getTiempoCola()){
+                    ++espacio;
+                }
+                else{
+                    campo = true;
+                }
+            }
+            if(campo) {
+                colaConsultas.add(espacio, c);
+            }
+            else{
+                colaConsultas.add(++espacio,c);
+            }
+        }
+
+    }*/
