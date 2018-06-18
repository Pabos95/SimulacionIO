package Modulo;


import SimulacionIO.Consulta;

import java.util.*;

class ModAdministracionClientes extends Modulo{
    int k;
    int consultasRechazadas;

    public ModAdministracionClientes(int tam){
        k = tam;
        colaConsultas = new ArrayList<Consulta>(k);
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
                if(aux.getTiempoCola() <= c.getTiempoCola()){
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

    }

    @Override
    public void procesarSalida(Consulta consulta) {

    }

    @Override
    public void procesarTimeOut(Consulta consulta) {

    }
    public boolean colaVacia(){
        return colaConsultas.isEmpty();
    }
}