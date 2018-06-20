package Modulo;
import java.util.*;
import SimulacionIO.*;
import Estadisticos.*;
public class ModAdministracionConsultas extends Modulo{
    int n;
    int m;
	double timeSalida; //Tiempo de salida después de realizar las etapas de validación 
    int tamFinalColaP;
    int tamActualColaP;
	GeneradoraValoresAelatorios gen;

	public ModAdministracionConsultas(int tam, int tam2){
	    n = tam;
	    m = tam2;
        gen = new GeneradoraValoresAelatorios();
        timeSalida = 0;
    }
    
    public void agregarConsulta (Consulta c){ //Se agrega la consulta a una cola con disciplina FIFO
        colaConsultas.add(c);
        
    }

    @Override
	public void procesarLlegada(Consulta consulta) {
        if(!consulta.getMuerto()){//Si está muerto significa que no fue admitido en el módulo pasado
            if (consultasActuales < n){ //Hay al menos un proceso disponible para atender la consulta que viene
                //Se procesan consultas haciendo etapas de validación
                timeSalida = consulta.getTiempoActual() + 1/10; //Duración de validación Léxica
                timeSalida = timeSalida + gen.generarValorDistribuicionUniforme(0.0, 1.0); //Duración de validación Sintáctica
                timeSalida = timeSalida + gen.generarValorDistribuicionUniforme(0.0, 2.0); //Duración de validación Semántica
                timeSalida = timeSalida + gen.generarValorDistribuicionExponencial(0.7); //Verificación de permisos
				//Optimización de consultas               
                if ((consulta.getTConsulta().compareTo(Consulta.tipoConsulta.ddl) == 0) ||  //No son de read-only
                        (consulta.getTConsulta().compareTo(Consulta.tipoConsulta.update) == 0)){  //No son de read-only                   
                    timeSalida = timeSalida + 1/4;                   
                } else { //Son read-only
                    timeSalida = timeSalida + 0.1;
                }                  
            } else {
                //Se agrega a la cola
                agregarConsulta(consulta);
            }
        
        }

    }

    @Override
    public void procesarSalida(Consulta consulta) {

    }

    @Override
    public void procesarTimeOut(Consulta consulta) {

    }
}