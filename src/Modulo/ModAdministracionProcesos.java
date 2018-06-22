/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modulo;


import SimulacionIO.Consulta;
import SimulacionIO.Evento;
import SimulacionIO.GeneradoraValoresAelatorios;

import java.util.Iterator;

import static SimulacionIO.Simulacion.agregarEvento;
import static SimulacionIO.Simulacion.listaEventos;

public class ModAdministracionProcesos extends Modulo {

    boolean systemCall;
    double timeWhereGonnaBeFree;
    double n;
    GeneradoraValoresAelatorios gen;

    public ModAdministracionProcesos(){
        systemCall = false;
        gen = new GeneradoraValoresAelatorios();

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
            while(it.hasNext() && !campo){
                aux = (Consulta)it.next();
                if(aux.getTiempoActual() <= c.getTiempoActual()){
                    ++espacio;
                }
                else{
                    campo = true;
                }
            }
            if(campo) {
                colaConsultas.add(espacio, c);
            }
            else{
                colaConsultas.add(++espacio,c);
            }
        }

    }
    
    
    public void procesarLlegada(Consulta consulta) {
        if(!systemCall) {
            systemCall = true;
            consulta.setTipoEvento(Evento.tipoEvento.salidaModuloAdministracionProcesos);
        }
        else{
            agregarConsulta(consulta);
        }
    }

    @Override
    public void procesarSalida(Consulta consultaSaliente) {

        //Procesa la salida de la consulta que llega como parámetro
        GeneradoraValoresAelatorios g = new GeneradoraValoresAelatorios();
        double valor = g.generarValorDistribuicionNormal(1.0,0.01);
        consultaSaliente.setTiempoActual(consultaSaliente.getTiempoActual() + valor);
        consultaSaliente.setTiempoVida( consultaSaliente.getTiempoVida() + valor);

        //Si nadie está esperando un sysCall, se libera el recurso
        if(colaConsultas.isEmpty()){
            systemCall = false;
        }
        else{//En caso contrario, se saca un elemento de la cola y se le asigna el siguiente campo
            Consulta c = colaConsultas.get(0);
            colaConsultas.remove(0);
            c.setTiempoCola(c.getTiempoCola() + (consultaSaliente.getTiempoActual() - c.getTiempoActual()));
            c.setTiempoVida(c.getTiempoVida() + c.getTiempoCola());
            c.setTipoEvento(Evento.tipoEvento.salidaModuloAdministracionProcesos);
            agregarEvento(c);
        }


    }

    @Override
    public void procesarTimeOut(Consulta consulta) {

    }
}
/*Hay que actualizar los estadísticos
* El timeout se trabaja en simulación, cuando está a punto de salir de un módulo*/