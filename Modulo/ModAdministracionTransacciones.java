/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modulo;

import SimulacionIO.*;
import java.util.PriorityQueue;

/**
 *
 * @author Pabos95
 */
public class ModAdministracionTransacciones extends Modulo {
    ModAdministracionTransacciones(){
        PriorityQueue<Consulta> colaSentencias = new PriorityQueue<Consulta>(10, new ComparadorConsultas());
    }

    @Override
    public void procesarLlegada(Consulta consulta) {

    }

    @Override
    public void procesarSalida(Consulta consulta) {

    }

    @Override
    public void procesarTimeOut(Consulta consulta) {

    }
}
