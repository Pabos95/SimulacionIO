/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Pabos95
 */
package SimulacionIO;
public class ParametrosSimulacion {
    Boolean slow;
    double duracion;
    int corridas;
     int paramK; // numero maximo de conexiones concurrentes que puede administrar el sistema
  int paramN; //numero de procesos disponibles para el procesamiento de consultas. concurrentes que puede manejar el sistema.
  int paramP; //numero de procesos disponibles para la ejecución de transacciones
  int paramM; //numero de procesos disponibles para la ejecución de consultas
  int paramT; //cantidad de segundos para el timeout de las conexiones
  Simulacion s;
    public ParametrosSimulacion(){
        
    }
    public void setCorridas(int num){
        corridas = num;
    }
    public void setSlow(Boolean l){
        slow = l;
    }
    public void setDuracion(double num){
        duracion = num;
    }
    public void setParamK(int num){
        paramK = num;
    }
    public void setParamN(int num){
        paramN = num;
    }
    public void setParamP(int num){
        paramP = num;
    }
    public void setParamM(int num){
        paramM = num;
    }
    public void setParamT(int num){
        paramT = num;
    }
    public Simulacion getSimulacion(){
        s = new Simulacion(duracion,corridas,paramK,paramN, paramP, paramM,paramT,slow);
        return s;
    }
}
