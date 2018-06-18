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
    GeneradoraValoresAelatorios gen;
    
    ModAdministracionTransacciones(){
        gen = new GeneradoraValoresAelatorios();
        PriorityQueue<Consulta> colaSentencias = new PriorityQueue<Consulta>(10, new ComparadorConsultas());
    }

    @Override
    public void procesarLlegada(Consulta consulta) { //Se agrega la consulta a la cola según su prioridad
      String name = consulta.getTipoConsulta();
      if (name.equals("ddl")) {
        
      } else if (name.equals("update")){
        
      } else if (name.equals("join")){
        
      } else if (name.equals("select")){
        
      }
    }

    @Override
    public void procesarSalida(Consulta consulta) {

    }

    @Override
    public void procesarTimeOut(Consulta consulta) {

    }
}
