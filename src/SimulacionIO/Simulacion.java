package SimulacionIO;
import java.util.*;
import Modulo.*;
import Estadisticos.*;
import Interfaz.*;
import javafx.util.Pair;



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
  VentanaEjecucion estadoSimulacion;
  public static List<Consulta> listaEventos; //Contiene la lista de los eventos por ejecutar
  ArrayList <Consulta> consultas; //almacena las consultas de la simulacion para al final de una corrida poder calcular el tiempo de vida promedio
  ArrayList <EstadisticosModulo> estadisticasModulo;
  ArrayList <EstadisticosIteracion> estadisticosIteracion;
  EstadisticosGenerales eg;
  GeneradoraValoresAelatorios gen;
  //VentanaEjecucion ventana; creo que ya no se va a usar esta ventana
  VentanaEjecucion ve;
  public Simulacion(double tMax,int numCorridas,int numConexionesConcurrentesMaximo,int numProcesosProcesamientoConsultasConcurrentes,int numProcesosEjecucionTransacciones,int numProcesosEjecucionConsultas , int segundosParaTimeOut, boolean slow){
    estadisticasModulo = new ArrayList<EstadisticosModulo>(20);
    estadisticosIteracion = new ArrayList<EstadisticosIteracion>(20);
    tiempoMaximo = tMax;
    cantidadCorridas = numCorridas;
    consultas = new ArrayList<Consulta>(20);
    k = numConexionesConcurrentesMaximo;
    n = numProcesosProcesamientoConsultasConcurrentes;
    p = numProcesosEjecucionTransacciones;
    m = numProcesosEjecucionConsultas;
    t = segundosParaTimeOut;
    tiempoActual = 0.0;
    iteracionActual = 1;
    modoLento = slow;
    gen = new GeneradoraValoresAelatorios();
    System.out.println("funciono constructor de simulacion"); 
  }
  public Consulta generarConsulta(){
    double numAelatorio = gen.generarNumeroAleatorio();
    Consulta c = new Consulta(numAelatorio,tiempoActual);    
    return c;
  }
 
    
    public void procesarSimulacion() {           
        int ind = 0; // se usa para recorrer los arrayList
        double num = 0;
        EstadisticosIteracion estIt; //los Estadisticos de la iteracion actual
        ListIterator itEstadisticosIteracion;
        while (iteracionActual <= cantidadCorridas) {           
            System.out.println("Iteración actual :" + iteracionActual);          
            modAdminClientes = new ModAdministracionClientes(k); //Revisar que todo esté bien y claro
            modAdminConsultas = new ModAdministracionConsultas(n, m);
            modAdminProcesos = new ModAdministracionProcesos();
            modAdminTransacciones = new ModAdministracionTransacciones(p);
            tiempoActual = 0;
            estIt = new EstadisticosIteracion();
            estadisticosIteracion.add(estIt);
            num = gen.generarNumeroAleatorio();
            Consulta consultaActual = new Consulta(num, 0);
           
            consultas.add(consultaActual);
            System.out.println("Random para consulta es: " + num);
            System.out.println("TIPO ES: " + consultaActual.getTConsulta());
            listaEventos = new ArrayList<>(200);
            consultaActual.setTipoEvento(Evento.tipoEvento.llegadaModuloAdministracionClientes);
            agregarEvento(consultaActual); //En tiempo 0
          while (tiempoActual < tiempoMaximo) {              
              System.out.println("Estamos ejecutando por el tiempo determinado");
              num = gen.generarNumeroAleatorio();
              /*
              Se cortó la parte de agregar arribos nuevos
              */
                            
              consultaActual = (Consulta) listaEventos.get(0); //Tomamos el primer valor de la lista
              listaEventos.remove(0); //Sacamos de la lista el primer elemento
              if(modoLento == true){
                   try {
            Thread.sleep((1000)); //Espera 1 segundo
        } catch(InterruptedException ex) {
            Thread.currentThread().interrupt();
        }

              }
              tiempoActual = consultaActual.getTiempoActual(); 
              System.out.println("Tiempo actual " + tiempoActual);
              System.out.println("Tamano cola mod admin procesos: "+ String.valueOf(modAdminProcesos.getTamActualCola()));
              this.actualizarVentana();
              switch (consultaActual.tipoEvento) {
                  case llegadaModuloAdministracionClientes:             
                        modAdminClientes.procesarLlegada(consultaActual);             
                       // System.out.println("¡Se procesó bien la llegada al modulo de clientes!");
                        if(!consultaActual.getMuerto()){//Si fue admitida
                            consultaActual.setTipoEvento(Evento.tipoEvento.salidaModuloAdministracionClientes);
                            agregarEvento(consultaActual);
                            System.out.println("La consulta pasa al módulo de adminisracion de procesos");
                        }
                        else if(!consultaActual.getMuerto() && consultaActual.getTiempoVida() != 0){
                            agregarEvento(consultaActual);
                        }
                        this.actualizarVentana();
                        consultaActual = new Consulta(num, tiempoActual + gen.generarValorDistribuicionExponencial(0.5));                       
                        System.out.println("Random para consulta es: " + num);
                        System.out.println("TIPO ES: " + consultaActual.getTConsulta());
                        consultaActual.setTipoEvento(Evento.tipoEvento.llegadaModuloAdministracionClientes); //Seleccionamos su tipo como arribo al primer módulo
                        agregarEvento(consultaActual); //Se agrega a la lista
                      // ventana.setBackground(Color.RED); //Para prueba unicamente, si llega hasta la linea 82 la ventana se pone roja
                      
                        break;

                  case salidaModuloAdministracionClientes:                                  
                      modAdminClientes.procesarSalida(consultaActual);
                    //   ventana.setBackground(Color.BLACK); //Para prueba unicamente, si llega hasta la linea 95 la ventana se pone de fondo negro           
                      System.out.println("¡Procesar salida de ModClientes perfecto!");
                      this.actualizarVentana();
                      break;

                  case llegadaModuloAdministracionProcesos:           
                      modAdminProcesos.procesarLlegada(consultaActual);                                  
                      System.out.println("¡Aleluta se pudo procesar la llegada a ModProcesos!");
                      if(consultaActual.getTipoEvento() == Evento.tipoEvento.salidaModuloAdministracionProcesos){
                          agregarEvento(consultaActual);
                      }
                      this.actualizarVentana();
                      //En caso contrario no se agrega nada porque entró a la cola
                       //ventana.setBackground(Color.blue); //Para prueba unicamente, si llega hasta la linea 107 la ventana se pone de fondo azul
                      break;


                  case salidaModuloAdministracionProcesos:                                   
                      modAdminProcesos.procesarSalida(consultaActual);                                  
                      System.out.println("¡Muy bien se pudo procesar la salida de ModProcesos!");
                      if(!Timeout(consultaActual)){
                          consultaActual.setTipoEvento(Evento.tipoEvento.llegadaModuloProcesamientoConsultas);
                          agregarEvento(consultaActual);
                      }
                      else{
                          modAdminClientes.restarConexionesActivas(); //Así libera recursos para la próxima conección
                      }
                      // ventana.setBackground(Color.CYAN); //Para prueba unicamente, si llega hasta la linea 121 la ventana se pone de fondo cyan
                      this.actualizarVentana();
                      break;

                  case llegadaModuloProcesamientoConsultas:  
                      modAdminConsultas.procesarLlegada(consultaActual); //Desde el modulo de procesos                                                                 
                      System.out.println("Procesar la llegada a consultas funciono");
                      if(consultaActual.getTipoEvento() == Evento.tipoEvento.salidaModuloProcesamientoConsultas){
                          agregarEvento(consultaActual);
                      }
                    /*   ventana.setBackground(Color.ORANGE); //Para prueba unicamente, si llega hasta la linea 128 la ventana se pone de fondo negro*/
                      this.actualizarVentana();
                      break;

                  case salidaModuloProcesamientoConsultas:                                                                                  
                      modAdminConsultas.procesarSalida(consultaActual);//Antes de ir a transacciones y datos                                                                 
                      System.out.println("Todo bien procesando la salida de consultas");
                      if(Timeout(consultaActual)){
                            modAdminClientes.restarConexionesActivas();
                      }
                      else {
                            consultaActual.setTipoEvento(Evento.tipoEvento.llegadaModuloTransacciones);
                            agregarEvento(consultaActual);
                      }
                      this.actualizarVentana();
                      break;

                  case llegadaModuloTransacciones:        
                      modAdminTransacciones.procesarLlegada(consultaActual);                                                                 
                      System.out.println("oh wow sirvio procesar la llegada a trans{acciones"); 
                      if(consultaActual.getTipoEvento()== Evento.tipoEvento.salidaModuloTransacciones){
                           agregarEvento(consultaActual);
                      }
                      //Si no significa que está en la cola
                      this.actualizarVentana();
                      break;

                  case salidaModuloTransacciones:                                                                 
                      modAdminTransacciones.procesarSalida(consultaActual);                                                                 
                      System.out.println("¡procesar salida de transacciones exitosa yass!");
                       if(Timeout(consultaActual)){
                            modAdminClientes.restarConexionesActivas();
                       }
                        else {
                            consultaActual.setTipoEvento(Evento.tipoEvento.llegada2ModuloProcesamientoConsultas);
                            agregarEvento(consultaActual);
                      }
                      this.actualizarVentana(); 
                      break;
                      
                  case llegada2ModuloProcesamientoConsultas:                                                                                
                      modAdminConsultas.procesarLlegada2(consultaActual);                                  
                      System.out.println("¡ok ok ok se proceso la llegada2 de consultas!");
                      if(consultaActual.getTipoEvento() == Evento.tipoEvento.salida2ModuloProcesamientoConsultas){
                          agregarEvento(consultaActual);
                      }
                      //En caso contrario, la consulta fue agregada a la cola del módulo
                      this.actualizarVentana();
                      break;
                                           
                  case salida2ModuloProcesamientoConsultas:                                  
                      modAdminConsultas.procesarSalida2(consultaActual);                                  
                      System.out.println(">>>>Procesar salida2 de consultas salio bien");
                      if(Timeout(consultaActual)){
                          modAdminClientes.restarConexionesActivas();
                      }
                      else{
                          consultaActual.setTipoEvento(Evento.tipoEvento.llegadaModuloAdministracionClientes);
                          agregarEvento(consultaActual);
                      }
                      this.actualizarVentana();
                      break;
                      
              }
              
                //Se podría sacar parte de la info guardada en cada modulo para presentarla al usuario
          }

          //Actualizar estadísticas por cada corrida
       itEstadisticosIteracion =estadisticosIteracion.listIterator();
       for(int i = 0; i <= iteracionActual -1; i++){
        ind = itEstadisticosIteracion.nextIndex();
       }
       ++iteracionActual;
      }
      estIt = estadisticosIteracion.get(ind);
      estIt.calcularTiempoPromedioVida(consultas); 
      System.out.println("Simulacion finalizada"); //Para prueba unicamente
  }
  

  public boolean Timeout(Consulta c){
      boolean retorno = false;
      if(c.getTiempoVida() >= t){
          retorno = true;
      }
      return retorno;
  }
  public void setVentana(VentanaEjecucion vent){
      this.estadoSimulacion = vent;
      estadoSimulacion.setSize(640,511);
  }

 public void actualizarVentana(){ //aqui se muestra cada evento de la simulacion, el tamaño de las colas ect
     estadoSimulacion.actualizarTiempoActual(tiempoActual);
     estadoSimulacion.actualizarLongitudModAdministracionProcesos(modAdminProcesos.getTamActualCola());
     estadoSimulacion.actualizarLongitudModAdministracionConsultas(modAdminConsultas.getTamActualCola());
     estadoSimulacion.actualizarLongitudModAdministracionTransacciones(modAdminTransacciones.getTamActualCola());
     estadoSimulacion.actualizarNumConexionesDescartadas(modAdminClientes.getConsultasRechazadas());
     estadoSimulacion.actualizarLongitudColaEjecucionModAdmConsultas(modAdminConsultas.getTamActualColaEjecutar());
 }

  public static void agregarEvento(Consulta c) {
      if (listaEventos.isEmpty()) {//En caso que la cola esté vacía
          listaEventos.add(0,c);
      } else {
          Iterator it = listaEventos.iterator();
          Consulta aux;
          boolean campo = false;
          int espacio = 0;
          while (it.hasNext() && !campo) {
              aux = (Consulta) it.next();
              if (aux.getTiempoActual() <= c.getTiempoActual()) {
                  ++espacio;
              } else {
                  campo = true;
              }
          }
          listaEventos.add(espacio, c);
      }
  }
}


