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
  VentanaEjecucion ventana;
  public Simulacion(double tMax,int numCorridas,int numConexionesConcurrentesMaximo,int numProcesosEjecucionTransacciones, int numProcesosEjecucionConsultas, int segundosParaTimeOut, boolean slow){
    tiempoMaximo = tMax;
    cantidadCorridas = numCorridas;
    /*Falta asignar los otros valores, p, m , t*/
    k = numConexionesConcurrentesMaximo;
    n = numProcesosEjecucionConsultas;
    tiempoActual = 0.0;
    iteracionActual = 1;
    modoLento = slow;
  }
  public Consulta generarConsulta(){
    double numAelatorio = gen.generarNumeroAelatorio();
    Consulta c = new Consulta(numAelatorio,tiempoActual);
    return c;
  }
  public void procesarSimulacion() {

      while (iteracionActual <= cantidadCorridas) {
          modAdminClientes = new ModAdministracionClientes(k); //Revisar que todo esté bien y claro
          modAdminConexiones = new ModAdministracionConexiones();
          modAdminConsultas = new ModAdministracionConsultas(n, m);
          modAdminProcesos = new ModAdministracionProcesos();
          modAdminTransacciones = new ModAdministracionTransacciones(p);
          double num = gen.generarNumeroAelatorio();
          Consulta consultaActual = new Consulta(num, 0);
          Evento e = new Evento();
          List listaEventos = new ArrayList<Consulta>(200);
          consultaActual.setTipoEvento(Evento.tipoEvento.llegadaModuloAdministracionClientes);
          listaEventos.add(consultaActual);//El evento por default es entrada al modulo adm clientes y la consulta si es aleatoria
          while (tiempoActual < tiempoMaximo) {
              consultaActual = generarConsulta();
              consultaActual.setTipoEvento(Evento.tipoEvento.llegadaModuloAdministracionClientes);
              consultaActual = (Consulta) listaEventos.get(0); //Tomamos el primer valor de la lista
              listaEventos.remove(0); //Sacamos de la lista el primer elemento
              switch (consultaActual.tipoEvento) {
                  case llegadaModuloAdministracionClientes:
                      modAdminClientes.procesarLlegada(consultaActual);
                      if(!consultaActual.getMuerto()){//Si fue admitida
                          consultaActual.setTipoEvento(Evento.tipoEvento.salidaModuloAdministracionClientes);
                          listaEventos.add(consultaActual);//Hay que implementar esto para que agregue por orden de prioridad
                                                            //Primero por tiempo y luego por el tipo de consulta, por ahora agrega al final
                      }
                      break;

                  case salidaModuloAdministracionClientes:
                      modAdminClientes.procesarSalida(consultaActual);
                      if(consultaActual.getTiempoVida() == 0){
                          consultaActual.setTipoEvento(Evento.tipoEvento.llegadaModuloAdministracionProcesos);
                          listaEventos.add(consultaActual);//OJO QUE NO AGREGA POR EL TIEMPO, SOLO AL FINAL A LO CERDO
                          //agregarElemento(consultaActual)*/
                      }
                      else{//Enviar datos al usuario, cerrar la conexion

                      }



                      break;

                  case llegadaModuloAdministracionProcesos:
                      modAdminProcesos.procesarLlegada(consultaActual);


                      break;


                  case salidaModuloAdministracionProcesos:
                      modAdminProcesos.procesarSalida(consultaActual);

                      break;

                  case llegadaModuloProcesamientoConsultas:
                      modAdminConsultas.procesarLlegada(consultaActual);
                      break;

                  case salidaModuloProcesamientoConsultas:
                      modAdminConsultas.procesarSalida(consultaActual);
                      break;

                  case llegadaModuloTransacciones:
                      modAdminTransacciones.procesarLlegada(consultaActual);
                      break;

                  case salidaModuloTransacciones:
                      modAdminTransacciones.procesarSalida(consultaActual);
                      break;


                  case llegadaModuloAdministracionConexiones:
                      modAdminConexiones.procesarLlegada(consultaActual);
                      break;

                  case salidaModuloAdministracionConexiones:
                      modAdminConexiones.procesarSalida(consultaActual);
                      break;

              }
                //Se podría sacar parte de la info guardada en cada modulo para presentarla al usuario
          }

          //Actualizar estadísticas por cada corrida
      }
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
