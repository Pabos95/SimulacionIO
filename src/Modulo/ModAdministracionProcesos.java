/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modulo;


import SimulacionIO.Consulta;
import SimulacionIO.GeneradoraValoresAelatorios;

import java.util.Iterator;

public class ModAdministracionProcesos extends Modulo {

    boolean systemCall;
    double timeWhereGonnaBeFree;
    double n;
    GeneradoraValoresAelatorios gen;

    public ModAdministracionProcesos(){
        systemCall = false;
        gen = new GeneradoraValoresAelatorios();

    }
    public void agregarConsulta (Consulta c){//Se usa para agregar consultas desde el controlador, según se requiere en particular por cada módulo
        //En ese lugar, se preguntarán las condiciones: colaVacia, mod Ocupado, timeOut....

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
    @Override
    public void procesarLlegada(Consulta consulta) {
        if(!consulta.getMuerto()){//Si está muerto significa que no fue admitido en el módulo pasado
            if(!systemCall) {
                systemCall = true;
                timeWhereGonnaBeFree = consulta.getTiempoActual() + gen.generarValorDistribuicionNormal(1.0, 0.01);
            }
            else{
                //Agregar a la cola
				agregarConsulta(consulta);
            }
        }
    }

    @Override
    public void procesarSalida(Consulta consulta) {
        //Preguntar por el timeWhereGonnaBeFree
        //Preguntar por la cola
        //Pensar que hacer con la consulta que va a salir como parámetro
    }

    @Override
    public void procesarTimeOut(Consulta consulta) {

    }
}
