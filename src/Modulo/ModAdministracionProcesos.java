/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modulo;


import SimulacionIO.Consulta;
import SimulacionIO.Evento;
import SimulacionIO.GeneradoraValoresAelatorios;
import java.util.*;

import static SimulacionIO.Simulacion.agregarEvento;


public class ModAdministracionProcesos extends Modulo {

    boolean systemCall;
    GeneradoraValoresAelatorios gen;

    public ModAdministracionProcesos(){
        systemCall = false;
        gen = new GeneradoraValoresAelatorios();
        colaConsultas = new ArrayList<>();

    }
    public void agregarConsulta (Consulta c){//Agrega consultas en orden FIFO, considerando los tiempos en los que arribaron

        if(colaConsultas.isEmpty()){//En caso que la cola esté vacía
            colaConsultas.add(c);
        }
        else{
            Iterator it =  colaConsultas.iterator();
            Consulta aux;
            boolean campo = false;
            int espacio = 0;
            while (it.hasNext()) {
            //while (it.hasNext() && !campo) {
                aux = (Consulta)it.next();
                if(aux.getTiempoActual() <= c.getTiempoActual()){
                    ++espacio;
                }
                else{
                    campo = true;
                }
            }
            colaConsultas.add(espacio, c);
            /*if(campo) {
                colaConsultas.add(espacio, c);
            }
            else{
                colaConsultas.add(++espacio,c);
            }*/
        }

    }
    
    
    public void procesarLlegada(Consulta consulta) {
        if(!systemCall) {
            systemCall = true;
            
             //Procesa la salida de la consulta que llega como parámetro
            GeneradoraValoresAelatorios g = new GeneradoraValoresAelatorios();
            double valor = g.generarValorDistribuicionNormal(1.0,0.01);
            consulta.setTiempoActual(consulta.getTiempoActual() + valor);
            consulta.setTiempoVida( consulta.getTiempoVida() + valor);
            consulta.setTipoEvento(Evento.tipoEvento.salidaModuloAdministracionProcesos);
        }
        else{
            agregarConsulta(consulta);
        }
    }

    @Override
    public void procesarSalida(Consulta consultaSaliente) {

        systemCall = false;
        //Si hay alguien en cola se debe proveer del recurso
        if(!colaConsultas.isEmpty()){
            Consulta c = colaConsultas.get(0);
            colaConsultas.remove(0);
            c.setTiempoCola(c.getTiempoCola() + (consultaSaliente.getTiempoActual() - c.getTiempoActual()));
            c.setTiempoVida(c.getTiempoVida() + c.getTiempoCola());
            c.setTiempoActual(c.getTiempoActual() + c.getTiempoCola());
            procesarLlegada(c);//Así se procesará adecuadamente
            agregarEvento(c); //Se agrega para que en un futuro se procese su salida
        }
            

    }

    public int getTamActualCola(){
        return colaConsultas.size();
    }
    public void restarConexionesActivas(){
        --consultasActuales;
    }
}
/*Hay que actualizar los estadísticos
* El timeout se trabaja en simulación, cuando está a punto de salir de un módulo*/
