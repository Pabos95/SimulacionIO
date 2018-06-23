package SimulacionIO;
import java.util.*;
import Modulo.*;
import Estadisticos.*;
import Interfaz.*;
import javafx.util.Pair;
import java.awt.Color;

public class Simulacion {    
  ModAdministracionClientes modAdminClientes;
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
  double tiempoActual;
  boolean modoLento;// true si la conexión está en modoLento y falso en caso contrario

  public static List<Consulta> listaEventos; //Contiene la lista de los eventos por ejecutar
  ArrayList <Consulta> consultas; //almacena las consultas de la simulacion para al final de una corrida poder calcular el tiempo de vida promedio
  ArrayList <EstadisticosModulo> estadisticasModulo;
  ArrayList <EstadisticosIteracion> estadisticosIteracion;
  EstadisticosGenerales eg;
  GeneradoraValoresAelatorios gen;
  VentanaEjecucion ventana;
  public Simulacion(double tMax,int numCorridas,int numConexionesConcurrentesMaximo,int numProcesosProcesamientoConsultasConcurrentes,int numProcesosEjecucionTransacciones,int numProcesosEjecucionConsultas , int segundosParaTimeOut, boolean slow,VentanaEjecucion vent){
      
    tiempoMaximo = tMax;
    cantidadCorridas = numCorridas;
    k = numConexionesConcurrentesMaximo;
    n = numProcesosProcesamientoConsultasConcurrentes;
    p = numProcesosEjecucionTransacciones;
    m = numProcesosEjecucionConsultas;
    t = segundosParaTimeOut;
    tiempoActual = 0.0;
    iteracionActual = 1;
    modoLento = slow;
    gen = new GeneradoraValoresAelatorios();
     this.ventana = vent;
    System.out.println("funciono constructor de simulacion"); 
  }
  public Consulta generarConsulta(){
    double numAelatorio = gen.generarNumeroAleatorio();
    Consulta c = new Consulta(numAelatorio,tiempoActual);
    return c;
  }
  public void procesarSimulacion() {  
   double num = 0;
     Random a;    
      System.out.println("So far so good");
      EstadisticosIteracion estIt = new EstadisticosIteracion();
      while (iteracionActual <= cantidadCorridas) {
          System.out.println("Iteración actual :" + iteracionActual);
          a = new Random();
          modAdminClientes = new ModAdministracionClientes(k); //Revisar que todo esté bien y claro
          modAdminConsultas = new ModAdministracionConsultas(n, m);
          modAdminProcesos = new ModAdministracionProcesos();
          modAdminTransacciones = new ModAdministracionTransacciones(p);
          tiempoActual = 0;
          System.out.println("check: Instancia de modulos");
          num = a.nextDouble();
          Consulta consultaActual = new Consulta(num, 0);
          listaEventos = new ArrayList<>(200);
          consultaActual.setTipoEvento(Evento.tipoEvento.llegadaModuloAdministracionClientes);
          System.out.println("check: Primer evento");
          agregarEvento(consultaActual); //En tiempo 0
          System.out.println("check: se agregó el primer evento");

          while (tiempoActual < tiempoMaximo) {
              System.out.println("Estamos ejecutando por el tiempo determinado");
              consultaActual = generarConsulta(); //Creamos un nuevo arribo en cada iteracion             
              System.out.println("¡Se generó la consulta!");
              consultaActual.setTipoEvento(Evento.tipoEvento.llegadaModuloAdministracionClientes); //Seleccionamos su tipo como arribo al primer módulo
              agregarEvento(consultaActual); //Se agrega a la lista
              System.out.println("check: se agregó evento dentro del ciclo");
              consultaActual = (Consulta) listaEventos.get(0); //Tomamos el primer valor de la lista
              listaEventos.remove(0); //Sacamos de la lista el primer elemento
              tiempoActual = consultaActual.getTiempoActual(); //El tiempo actual no se esta actualizando bien, nunca pasa de 0
              System.out.println("Tiempo actual " + String.valueOf(tiempoActual));
              switch (consultaActual.tipoEvento) {
                  case llegadaModuloAdministracionClientes:
                        modAdminClientes.procesarLlegada(consultaActual);
                        if(!consultaActual.getMuerto()){//Si fue admitida
                            consultaActual.setTipoEvento(Evento.tipoEvento.salidaModuloAdministracionClientes);
                            agregarEvento(consultaActual);
                        }
                        else{
                            agregarEvento(consultaActual);
                        }
                      // ventana.setBackground(Color.RED); //Para prueba unicamente, si llega hasta la linea 82 la ventana se pone roja
                      break;

                  case salidaModuloAdministracionClientes:
                      
                      modAdminClientes.procesarSalida(consultaActual);
                    //   ventana.setBackground(Color.BLACK); //Para prueba unicamente, si llega hasta la linea 95 la ventana se pone de fondo negro

                      break;

                  case llegadaModuloAdministracionProcesos:

                      modAdminProcesos.procesarLlegada(consultaActual);
                      if(consultaActual.getTipoEvento() == Evento.tipoEvento.salidaModuloAdministracionProcesos){
                          agregarEvento(consultaActual);
                      }
                      //En caso contrario no se agrega nada porque entró a la cola
                       //ventana.setBackground(Color.blue); //Para prueba unicamente, si llega hasta la linea 107 la ventana se pone de fondo azul
                      break;


                  case salidaModuloAdministracionProcesos:
                      modAdminProcesos.procesarSalida(consultaActual);
                      if(!Timeout(consultaActual)){
                          consultaActual.setTipoEvento(Evento.tipoEvento.llegadaModuloProcesamientoConsultas);
                          agregarEvento(consultaActual);
                      }
                      else{
                          modAdminClientes.restarConeccionesActivas(); //Así libera recursos para la próxima conección
                      }
                      // ventana.setBackground(Color.CYAN); //Para prueba unicamente, si llega hasta la linea 121 la ventana se pone de fondo cyan
                      break;

                  case llegadaModuloProcesamientoConsultas:
                      

                      modAdminConsultas.procesarLlegada(consultaActual); //Desde el modulo de procesos
                      if(consultaActual.getTipoEvento() == Evento.tipoEvento.salidaModuloProcesamientoConsultas){
                          agregarEvento(consultaActual);
                      }
                       ventana.setBackground(Color.ORANGE); //Para prueba unicamente, si llega hasta la linea 128 la ventana se pone de fondo negro
                       

                      break;

                  case salidaModuloProcesamientoConsultas:
                      
                      modAdminConsultas.procesarSalida(consultaActual);//Antes de ir a transacciones y datos
                      if(Timeout(consultaActual)){
                            modAdminClientes.restarConeccionesActivas();
                      }
                      else {
                            consultaActual.setTipoEvento(Evento.tipoEvento.llegadaModuloTransacciones);
                      }

                      break;

                  case llegadaModuloTransacciones:
                      modAdminTransacciones.procesarLlegada(consultaActual);
                      agregarEvento(consultaActual);
                      break;

                  case salidaModuloTransacciones:
                      modAdminTransacciones.procesarSalida(consultaActual);
                       if(Timeout(consultaActual)){
                            modAdminClientes.restarConeccionesActivas();
                      }
                        else {
                            consultaActual.setTipoEvento(Evento.tipoEvento.llegada2ModuloProcesamientoConsultas);
                            agregarEvento(consultaActual);
                      }
                      break;
                      
                  case llegada2ModuloProcesamientoConsultas:
                      modAdminConsultas.procesarLlegada2(consultaActual);
                      if(consultaActual.getTipoEvento() == Evento.tipoEvento.salida2ModuloProcesamientoConsultas){
                          agregarEvento(consultaActual);
                      }
                      //En caso contrario, la consulta fue agregada a la cola del módulo
                      
                      break;
                      
                      
                  case salida2ModuloProcesamientoConsultas:
                      modAdminConsultas.procesarSalida2(consultaActual);
                      if(Timeout(consultaActual)){
                          modAdminClientes.restarConeccionesActivas();
                      }
                      else{
                          consultaActual.setTipoEvento(Evento.tipoEvento.llegadaModuloAdministracionClientes);
                      }
                      
                      break;
                      
                      
                      
                      
                  

              }
                //Se podría sacar parte de la info guardada en cada modulo para presentarla al usuario
          }

          //Actualizar estadísticas por cada corrida
      }
      System.out.println("Simulacion finalizada"); //Para prueba unicamente
  }


  public boolean Timeout(Consulta c){
      boolean retorno = false;
      if(c.getTiempoVida() >= t){
          retorno = true;
      }
      return retorno;
  }


 /*public void actualizarVentana(){ //aqui se muestra cada evento de la simulacion, el tamaño de las colas ect
     ventana.actualizarTiempoActual(tiempoActual);
     ventana.actualizarLongitudModAdministracionClientes(modAdminClientes.getTamActualCola());
     ventana.actualizarLongitudModAdministracionProcesos(modAdminProcesos.getTamActualCola());
     ventana.actualizarLongitudModAdministracionConsultas(modAdminConsultas.getTamActualCola());
     ventana.actualizarNumConexionesDescartadas(modAdminClientes.getConsultasRechazadas());
  }*/

  public static void agregarEvento(Consulta c) {
      //listaEventos.add(c);
      if (listaEventos.isEmpty()) {//En caso que la cola esté vacía
          listaEventos.add(0,c);
      } else {
          Iterator it = listaEventos.iterator();
          Consulta aux;
          boolean campo = false;
          int espacio = 0;
          while (it.hasNext()) {
          //while (it.hasNext() && !campo) {
              aux = (Consulta) it.next();
              if (aux.getTiempoActual() <= c.getTiempoActual()) {
                  ++espacio;
              } else {
                  campo = true;
              }
          }
          listaEventos.add(espacio, c);
          /*if (campo) {
              listaEventos.add(espacio, c);
          } else {
              listaEventos.add(++espacio, c);
          }*/
      }

  }
}


