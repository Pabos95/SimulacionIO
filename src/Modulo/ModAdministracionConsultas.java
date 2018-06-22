package Modulo;
import java.util.*;
import SimulacionIO.*;
import Estadisticos.*;
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
            if(campo) {
                colaEjecutar.add(espacio, c);
            }
            else{
                colaEjecutar.add(++espacio,c);
            }
        }
    }

    @Override
    public void procesarLlegada(Consulta consulta) {
        if (consultasActuales < n){ //Hay al menos un proceso disponible para atender la consulta que viene
            ++consultasActuales;
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

        //Se procesan consultas haciendo etapas de validación
        timeEjecucion = 0; //Se resetea
        timeEjecucion = 1/10; //Duración de validación Léxica
        timeEjecucion +=  gen.generarValorDistribuicionUniforme(0.0, 1.0); //Duración de validación Sintáctica
        timeEjecucion +=  gen.generarValorDistribuicionUniforme(0.0, 2.0); //Duración de validación Semántica
        timeEjecucion +=  gen.generarValorDistribuicionExponencial(0.7); //Verificación de permisos
        //Optimización de consultas
        if ((consulta.getTConsulta().compareTo(Consulta.tipoConsulta.ddl) == 0) ||  //No son de read-only
                (consulta.getTConsulta().compareTo(Consulta.tipoConsulta.update) == 0)){  //No son de read-only
            timeEjecucion +=  1/4;
        } else { //Son read-only
            timeEjecucion +=  0.1;
        }
        consulta.setTiempoVida(consulta.getTiempoVida() + timeEjecucion);
        consulta.setTiempoActual(consulta.getTiempoActual() + timeEjecucion);
        consulta.setTipoEvento(Evento.tipoEvento.llegadaModuloTransacciones);

        if(colaConsultas.isEmpty()){
            --consultasActuales;
        }
        else{

        }
    }

    public void procesarLlegada(Consulta consulta, double B) { //Cuando la llegada viene del modulo de Transacciones
        //Puede manejar m consultas en ejecución
        if (sentenciasEjecucion < m){
            switch(consulta.getTConsulta()){           
                case ddl:                         
                    timeEjecucion = consulta.getTiempoActual() + 0.5; //Procesar ejecución de DDL                                        
                break;               
                case update:
                    timeEjecucion = consulta.getTiempoActual() + 1;                    
                break;               
                case join:
                    timeEjecucion = consulta.getTiempoActual() + (Math.pow(B, 2) * 0.001); //Recordar que B^2 son milisegundos por lo que hay que pasarlos a segundos                
                break;               
                case select:
                    timeEjecucion = consulta.getTiempoActual() + (Math.pow(B, 2) * 0.001);
                break;                   
            }

        } else {
            agregarConsultaEjecutar(consulta);
        }
        timeEjecucion  = 0;
    }
	
    @Override
    public void procesarTimeOut(Consulta consulta) {

    }
    public int getTamActualCola(){
        return this.tamActualCola;
    }
}
