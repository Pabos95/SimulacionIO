/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modulo;

import SimulacionIO.*;
import SimulacionIO.Consulta;
import static SimulacionIO.Simulacion.agregarEvento;
import java.util.PriorityQueue;

public class ModAdministracionTransacciones extends Modulo {  
    int p;
    boolean flagDDL;
    GeneradoraValoresAelatorios gen;
    PriorityQueue<Consulta> colaSentencias;
    double timeEjecucion;
    Consulta sentenciaDDLEnEspera;
    
    public ModAdministracionTransacciones(int tam){
        flagDDL = false;
        p = tam;
        gen = new GeneradoraValoresAelatorios();
        colaSentencias = new PriorityQueue<Consulta>(100, new ComparadorConsultas());
	consultasActuales = 0;
    }

    @Override
    public void procesarLlegada(Consulta consulta) { //Se agrega la consulta a la cola y la clase ComparadorConsultas se encarga de asignar la prioridad
      //Si hay consultasActuales cantidad de consultas siendo procesadas el resto tienen que ser enviadas a la cola
        if (consultasActuales < p) {
              if(!flagDDL){//Si no se ha detectado ninguna sentencia DDL
                  //Se procesan consultas
                  ++consultasActuales;
                  timeEjecucion = 0;
                  switch(consulta.getTConsulta()){
                        case ddl:
                            if(consultasActuales == 1){//Si la sentencia DDL es la única en el módulo
                                timeEjecucion = consultasActuales * 0.03;
                                consulta.setTiempoActual(consulta.getTiempoActual() + timeEjecucion);
                                consulta.setTiempoVida(consulta.getTiempoVida() + timeEjecucion);
                                sentenciaDDLEnEspera = null;
                            }
                            else{
                                flagDDL = true;
                                sentenciaDDLEnEspera = consulta;
                                
                            }
                            break;
                        case update:
                            timeEjecucion = consultasActuales * 0.03;
                            consulta.setTiempoActual(consulta.getTiempoActual() + timeEjecucion);
                            consulta.setTiempoVida(consulta.getTiempoVida() + timeEjecucion);
                            //cargar bloques es Bloques * 1/10 pero UPDATE carga 0 bloques, es decir no hay que hacer ninguna operación
                            break;
                        case join:
                            int bloques = (int)gen.generarValorDistribuicionUniforme(1.0, 64.0);
                            timeEjecucion = consultasActuales * 0.03;
                            timeEjecucion += timeEjecucion + 0.1 * bloques;
                            consulta.setTiempoActual(consulta.getTiempoActual() + timeEjecucion);
                            consulta.setTiempoVida(consulta.getTiempoVida() + timeEjecucion);
                            consulta.setBloques(bloques);
                            break;
                        case select:
                            timeEjecucion = consultasActuales * 0.03;
                            timeEjecucion += timeEjecucion + 0.1 * 1; //bloques = 1
                            consulta.setTiempoActual(consulta.getTiempoActual() + timeEjecucion);
                            consulta.setTiempoVida(consulta.getTiempoVida() + timeEjecucion);
                            break;
                    }      
        
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
         
        
        --consultasActuales;
        
        if(flagDDL && consultasActuales == 1){
            sentenciaDDLEnEspera.setTiempoVida(sentenciaDDLEnEspera.getTiempoVida() + (consulta.getTiempoActual() - sentenciaDDLEnEspera.getTiempoActual()));
            sentenciaDDLEnEspera.setTiempoActual(consulta.getTiempoActual() + sentenciaDDLEnEspera.getTiempoVida());
            flagDDL = false;
            --consultasActuales;
            Consulta aux = sentenciaDDLEnEspera;
            procesarLlegada(aux);
            agregarEvento(aux);
        }
        //Se pregunta por la cola
        if (!flagDDL && !colaSentencias.isEmpty()){ //Hay más en la cola
            Consulta c = colaSentencias.remove();  
            c.setTiempoCola(c.getTiempoCola() + (consulta.getTiempoActual() - c.getTiempoActual()));
            c.setTiempoVida(c.getTiempoVida() +(consulta.getTiempoActual() - c.getTiempoActual()));
            c.setTiempoActual(c.getTiempoActual() + (consulta.getTiempoActual() - c.getTiempoActual()));
            procesarLlegada(c);
            agregarEvento(c);
        
        }
      
    }
    
    public int getTamActualCola(){
        return this.tamActualCola;
    }
    public void restarConexionesActivas(){
        --consultasActuales;
    }
}
