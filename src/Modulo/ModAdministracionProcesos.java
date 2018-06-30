/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modulo;

import Estadisticos.EstadisticosModulo;
import SimulacionIO.Consulta;
import SimulacionIO.Evento;
import SimulacionIO.GeneradoraValoresAleatorios;
import java.util.*;

import static SimulacionIO.Simulacion.agregarEvento;


public class ModAdministracionProcesos extends Modulo {

    boolean systemCall;
    int tamFinalCola;
    public ModAdministracionProcesos(){
        systemCall = false;
        gen = new GeneradoraValoresAleatorios();
        colaConsultas = new ArrayList<>();
        tamFinalCola = 0;
        estadisticosMod = new EstadisticosModulo();
    }
    public void agregarConsulta (Consulta c){//Agrega consultas en orden FIFO, considerando los tiempos en los que arribaron

        if(colaConsultas.isEmpty()){//En caso que la cola esté vacía
            estadisticosMod.aumentarConsultasEnCola();
            colaConsultas.add(c);
            tamFinalCola++;
        }
        else{
            Iterator it =  colaConsultas.iterator();
            Consulta aux;
            boolean campo = false;
            int espacio = 0;
            while (it.hasNext() && !campo) {
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
        }

    }
    
    
    public void procesarLlegada(Consulta consulta) {
        if(!systemCall) {
            systemCall = true;
            
             //Procesa la salida de la consulta que llega como parámetro
            GeneradoraValoresAleatorios g = new GeneradoraValoresAleatorios();
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
            estadisticosMod.actualizarTiempoPromedioCola(c.getTiempoCola());
            estadisticosMod.actualizarPromedioConsultasEnModulo();
            colaConsultas.remove(c);
            c.setTiempoCola(c.getTiempoCola() + (consultaSaliente.getTiempoActual() - c.getTiempoActual())); //Tiempo en cola total de una consulta por todos los modulos
            c.setTiempoVida(c.getTiempoVida() + (consultaSaliente.getTiempoActual() - c.getTiempoActual())); //Hay que agregar solo el tiempo en cola de este modulo
            c.setTiempoActual(c.getTiempoActual() + (consultaSaliente.getTiempoActual() - c.getTiempoActual()));
            procesarLlegada(c);//Así se procesará adecuadamente
            agregarEvento(c); //Se agrega para que en un futuro se procese su salida
        }
            

    }
    public double getTamPromedioCola(){
        return estadisticosMod.getTamPromedioCola();
    }
    @Override
    public int getTamActualCola(){
        return colaConsultas.size();
    }
}
