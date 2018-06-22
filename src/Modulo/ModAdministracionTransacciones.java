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
    double timeSalida;
    boolean flagDDL;
    GeneradoraValoresAelatorios gen;
    PriorityQueue<Consulta> colaSentencias;
    double tiempoEjecucion;
    Consulta sentenciaDDLEnEspera;
    
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
                  switch(consulta.getTConsulta()){
                        case ddl:
                            if(consultasActuales == 1){//Si la sentencia DDL es la única en el módulo
                                timeSalida = consulta.getTiempoActual() + consultasActuales * 0.03; //Procesar ejecución de DDL, 1 * 0.03
                                consulta.setTiempoActual(consulta.getTiempoActual() + timeSalida);
                                consulta.setTiempoVida(consulta.getTiempoVida() + timeSalida);
                                sentenciaDDLEnEspera = null;
                            }
                            else{
                                flagDDL = true;
                                sentenciaDDLEnEspera = consulta;
                                
                            }
                            break;
                        case update:
                            timeSalida = consulta.getTiempoActual() + (consultasActuales * 0.03);
                            consulta.setTiempoActual(consulta.getTiempoActual() + timeSalida);
                            consulta.setTiempoVida(consulta.getTiempoVida() + timeSalida);
                            //cargar bloques es Bloques * 1/10 pero UPDATE carga 0 bloques, es decir no hay que hacer ninguna operación
                            break;
                        case join:
                            timeSalida = consulta.getTiempoActual() + (consultasActuales * 0.03);
                            int bloques = (int)gen.generarValorDistribuicionUniforme(1.0, 64.0);
                            timeSalida = timeSalida + 1/10 * bloques;
                            consulta.setTiempoActual(consulta.getTiempoActual() + timeSalida);
                            consulta.setTiempoVida(consulta.getTiempoVida() + timeSalida);
                            consulta.setBloques(bloques);
                            break;
                        case select:
                            timeSalida = consulta.getTiempoActual() + tiempoEjecucion;
                            timeSalida = timeSalida + 1/10 * 1; //bloques = 1
                            consulta.setTiempoActual(consulta.getTiempoActual() + timeSalida);
                            consulta.setTiempoVida(consulta.getTiempoVida() + timeSalida);
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
        if (!flagDDL && colaSentencias.peek() != null){ //Hay más en la cola
            Consulta c = colaSentencias.remove();  
            c.setTiempoCola(c.getTiempoCola() + (consulta.getTiempoActual() - c.getTiempoActual()));
            c.setTiempoVida(c.getTiempoVida() +(consulta.getTiempoActual() - c.getTiempoActual()));
            c.setTiempoActual(c.getTiempoActual() + (consulta.getTiempoActual() - c.getTiempoActual()));
            procesarLlegada(c);
            agregarEvento(c);
        
        }
      
    }

    @Override
    public void procesarTimeOut(Consulta consulta) {

    }
    public int getTamActualCola(){
        return this.tamActualCola;
    }
    public void restarConeccionesActivas(){
        --consultasActuales;
    }
}
