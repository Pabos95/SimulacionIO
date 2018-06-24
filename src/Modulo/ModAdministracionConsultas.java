package Modulo;
import java.util.*;
import SimulacionIO.*;
import Estadisticos.*;

import static SimulacionIO.Simulacion.agregarEvento;


public class ModAdministracionConsultas extends Modulo{
    int n;
    int m;
    double timeEjecucion; //Tiempo de ejecución después de realizar las etapas de validación 
    int tamFinalColaP;
    int tamActualColaP;
    GeneradoraValoresAelatorios gen;
    List<Consulta> colaEjecutar; //Cola para cuando la llegada venga de Modulo de transacciones
    int sentenciasEjecucion; //Contador de cuantas sentencias están siendo ejecutadas

    public ModAdministracionConsultas(int tam, int tam2){
		n = tam;
		m = tam2;
        gen = new GeneradoraValoresAelatorios();
        colaConsultas = new ArrayList<Consulta>(); //Esto podría ser new LinkedList<>() que tiene los mismos métodos que Priority Queue y disciplina FIFO
        colaEjecutar = new ArrayList<Consulta>();
        timeEjecucion = 0;
        sentenciasEjecucion = 0;
        
    }
    
    public void agregarConsulta (Consulta c){ //Se agrega la consulta a una cola con disciplina FIFO,donde importa el orden de llegada
        if(colaConsultas.isEmpty()){//En caso que la cola esté vacía
            colaConsultas.add(c);
        }
        else{
            Iterator it =  colaConsultas.iterator();
            Consulta aux;
            boolean campo = false;
            int espacio = 0;
            while (it.hasNext() && !campo) {
              aux = (Consulta) it.next();
              if (aux.getTiempoActual() <= c.getTiempoActual()) {
                  ++espacio;
              } else {
                  campo = true;
              }
          }
          colaConsultas.add(espacio, c);
        }
        
    }

    public void agregarConsultaEjecutar(Consulta c){
        if(colaEjecutar.isEmpty()){//En caso que la cola esté vacía
            colaEjecutar.add(c);
        }
        else{
            Iterator it =  colaEjecutar.iterator();
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
            colaEjecutar.add(espacio,c);
        }
    }

    @Override
    public void procesarLlegada(Consulta consulta) {
        if (consultasActuales < n){ //Hay al menos un proceso disponible para atender la consulta que viene
            ++consultasActuales;
             //Se procesan consultas haciendo etapas de validación
            timeEjecucion = 0; //Se resetea
            timeEjecucion = 0.1; //Duración de validación Léxica
            timeEjecucion +=  gen.generarValorDistribuicionUniforme(0.0, 1.0); //Duración de validación Sintáctica
            timeEjecucion +=  gen.generarValorDistribuicionUniforme(0.0, 2.0); //Duración de validación Semántica
            timeEjecucion +=  gen.generarValorDistribuicionExponencial(0.7); //Verificación de permisos
            //Optimización de consultas
            if ((consulta.getTConsulta() == Consulta.tipoConsulta.ddl) ||  //No son de read-only
                    (consulta.getTConsulta() == Consulta.tipoConsulta.update)){  //No son de read-only
                timeEjecucion +=  0.25;
            } else { //Son read-only
                timeEjecucion +=  0.1;
            }
            consulta.setTiempoVida(consulta.getTiempoVida() + timeEjecucion);
            consulta.setTiempoActual(consulta.getTiempoActual() + timeEjecucion);
            consulta.setTipoEvento(Evento.tipoEvento.salidaModuloProcesamientoConsultas);
            }
            else {
                //Se agrega a la cola
                agregarConsulta(consulta);
            }

    }
    
    @Override
    public void procesarSalida(Consulta consulta) {//Salida al entrar la primera vez a este módulo
                                                    //Viene del módulo adm de procesos
        --consultasActuales;
        if(!colaConsultas.isEmpty()){
            Consulta c = colaConsultas.get(0);
            colaConsultas.remove(0);
            c.setTiempoCola(c.getTiempoCola() + (consulta.getTiempoActual() - c.getTiempoActual()));
            c.setTiempoVida(c.getTiempoVida() + (consulta.getTiempoActual() - c.getTiempoActual()));
            c.setTiempoActual(c.getTiempoActual() + (consulta.getTiempoActual() - c.getTiempoActual()));
            procesarLlegada(c);
            agregarEvento(c);
        }
    }

    public void procesarLlegada2(Consulta consulta) { //Cuando la llegada viene del modulo de Transacciones
        //Puede manejar m consultas en ejecución
        if (sentenciasEjecucion < m){
            ++sentenciasEjecucion;
            timeEjecucion  = 0;
            switch(consulta.getTConsulta()){
                case ddl:                         
                    timeEjecucion = 0.5; //Procesar ejecución de DDL
                break;      
                
                case update:
                    timeEjecucion = 1;                    
                break;  
                
                case join:
                    timeEjecucion = (Math.pow(consulta.getBloques(), 2) * 0.001); //Recordar que B^2 son milisegundos por lo que hay que pasarlos a segundos                
                break;   
                
                case select:
                    timeEjecucion = (Math.pow(consulta.getBloques(), 2) * 0.001);
                break;   
                
            }
            consulta.setTiempoVida(consulta.getTiempoVida() + timeEjecucion);
            consulta.setTiempoActual(consulta.getTiempoActual() + timeEjecucion);
            consulta.setTipoEvento(Evento.tipoEvento.salida2ModuloProcesamientoConsultas);
        } 
        else {
            agregarConsultaEjecutar(consulta);
        }
       
    }


    public void procesarSalida2(Consulta consulta){//Salir por segunda vez de este módulo
        --sentenciasEjecucion;
        
        if(!colaEjecutar.isEmpty()){
            Consulta c = colaEjecutar.get(0);
            colaEjecutar.remove(0);
            c.setTiempoCola(c.getTiempoCola() + (consulta.getTiempoActual() - c.getTiempoActual()));
            c.setTiempoVida(c.getTiempoVida() + (consulta.getTiempoActual() - c.getTiempoActual()));
            c.setTiempoActual(consulta.getTiempoActual() + (consulta.getTiempoActual() - c.getTiempoActual()));
            procesarLlegada2(c);
            agregarEvento(c);
        }
        
    }
    
    public int getTamActualCola(){
        return colaConsultas.size();
<<<<<<< HEAD
    }
    
    public int getTamActualColaEjecutar(){
        return colaEjecutar.size();
=======
>>>>>>> cd19fca71fb774680a9309a4a046c2dbd1c67abc
    }
    public int getTamActualColaEjecutar(){
        return colaEjecutar.size();
    }
	
    public void restarConexionesActivas(){
        --consultasActuales;
    }
}
