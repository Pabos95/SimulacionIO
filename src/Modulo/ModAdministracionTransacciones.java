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
    GeneradoraValoresAelatorios gen;
    PriorityQueue<Consulta> colaSentencias;
    double tiempoEjecucion;
    
    public ModAdministracionTransacciones(int tam){
        p = tam;
        gen = new GeneradoraValoresAelatorios();
        PriorityQueue<Consulta> colaSentencias = new PriorityQueue<Consulta>(10, new ComparadorConsultas());
		consultasActuales = 0;
        timeSalida = 0;
        tiempoEjecucion = p * 0.03;
    }

    @Override
    public void procesarLlegada(Consulta consulta) { //Se agrega la consulta a la cola y la clase ComparadorConsultas se encarga de asignar la prioridad
      //Si hay p cantidad de consultas siendo procesadas el resto tienen que ser enviadas a la cola
      if (consultasActuales < p) { 
        //Se procesan consultas 
        consultasActuales = consultasActuales + 1;                   
        switch(consulta.getTConsulta()){           
            case ddl:
                if (consultasActuales == 0){                       
                    timeSalida = consulta.getTiempoActual() + tiempoEjecucion; //Procesar ejecución de DDL
                    //cargar bloques es Bloques * 1/10 pero DDL carga 0 bloques, es decir no hay que hacer ninguna operación
                }
                break;               
            case update:
                timeSalida = consulta.getTiempoActual() + tiempoEjecucion;
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
        
        consultasActuales = consultasActuales - 1; //Se terminó de procesar
              
      } else {
        colaSentencias.add(consulta);
      }
    }

    @Override
    public void procesarSalida(Consulta consulta) {
        //Se pregunta por la cola
        if (colaSentencias.peek() != null){ //Hay más en la cola
            Consulta c = colaSentencias.remove();           
            procesarLlegada(c);
        
        }
      
    }

    @Override
    public void procesarTimeOut(Consulta consulta) {

    }
}
