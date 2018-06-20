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
    int contador = 0; //cantidad de consultas que est�n siendo procesadas
    GeneradoraValoresAelatorios gen;
    PriorityQueue<Consulta> colaSentencias;
    
    public ModAdministracionTransacciones(int tam){
        p = tam;
        gen = new GeneradoraValoresAelatorios();
        PriorityQueue<Consulta> colaSentencias = new PriorityQueue<Consulta>(10, new ComparadorConsultas());
    }

    @Override
    public void procesarLlegada(Consulta consulta) { //Se agrega la consulta a la cola y la clase ComparadorConsultas se encarga de asignar la prioridad
      //Si hay p cantidad de consultas siendo procesadas el resto tienen que ser enviadas a la cola
      if (contador < p) { 
        //Se procesan consultas 
        contador = contador + 1;
              
      } else {
        colaSentencias.add(consulta);
      }
    }

    public void procesarLlegada(Consulta consulta, double B) { //Se agrega la consulta a la cola y la clase ComparadorConsultas se encarga de asignar la prioridad

    }


    @Override
    public void procesarSalida(Consulta consulta) {
      
    }

    @Override
    public void procesarTimeOut(Consulta consulta) {

    }
}
