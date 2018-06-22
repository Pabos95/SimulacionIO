/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modulo;

import SimulacionIO.*;
import SimulacionIO.Consulta;
import java.util.PriorityQueue;

public class ModAdministracionTransacciones extends Modulo {  
    int p;
    double timeSalida;
    boolean flagDDL;
    GeneradoraValoresAelatorios gen;
    PriorityQueue<Consulta> colaSentencias;
    double tiempoEjecucion;
    
    public ModAdministracionTransacciones(int tam){
        flagDDL = false;
        p = tam;
        gen = new GeneradoraValoresAelatorios();
        PriorityQueue<Consulta> colaSentencias = new PriorityQueue<Consulta>(100, new ComparadorConsultas());
		consultasActuales = 0;
        timeSalida = 0;
        //tiempoEjecucion = consultasActuales * 0.03;
    }

    @Override
    public void procesarLlegada(Consulta consulta) { //Se agrega la consulta a la cola y la clase ComparadorConsultas se encarga de asignar la prioridad
      //Si hay consultasActuales cantidad de consultas siendo procesadas el resto tienen que ser enviadas a la cola
        if (consultasActuales < p) {
              if(!flagDDL){//Si no se ha detectado ninguna sentencia DDL
                  //Se procesan consultas
                  ++consultasActuales;
                  consulta.setTipoEvento(Evento.tipoEvento.salidaModuloTransacciones);
                  //Al llegar a salida se efectuan todas las operaciones necesarias
              }
              else{
                  colaSentencias.add(consulta);
              }
        }
      else {
        colaSentencias.add(consulta);
      }
    }

    @Override
    public void procesarSalida(Consulta consulta) {
         switch(consulta.getTConsulta()){
            case ddl:
                flagDDL = true;
                timeSalida = consulta.getTiempoActual() + tiempoEjecucion; //Procesar ejecución de DDL
                //cargar bloques es Bloques * 1/10 pero DDL carga 0 bloques, es decir no hay que hacer ninguna operación

                break;
            case update:
                timeSalida = consulta.getTiempoActual() + (consultasActuales * 0.03);
                //cargar bloques es Bloques * 1/10 pero UPDATE carga 0 bloques, es decir no hay que hacer ninguna operación
                break;
            case join:
                timeSalida = consulta.getTiempoActual() + tiempoEjecucion;
                timeSalida = timeSalida + 1/10 * (int)gen.generarValorDistribuicionUniforme(1.0, 64.0);
                break;
            case select:
                timeSalida = consulta.getTiempoActual() + tiempoEjecucion;
                timeSalida = timeSalida + 1/10 * 1;
                break;
        }      
        
        
        
        //Se pregunta por la cola
        if (colaSentencias.peek() != null){ //Hay más en la cola
            Consulta c = colaSentencias.remove();           
            procesarLlegada(c);
        
        }
      
    }

    private void recargarModulo(){
        
        
    }
    @Override
    public void procesarTimeOut(Consulta consulta) {

    }
    public int getTamActualCola(){
        return this.tamActualCola;
    }
}
