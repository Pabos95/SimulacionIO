/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SimulacionIO;
import java.util.*;
/**
 *
 * @author Pabos95
 */
public class ComparadorConsultas implements Comparator<Consulta> {
   public ComparadorConsultas(){
        
    }
    public int compare(Consulta c1, Consulta c2){
        int prioridadC1 = 0;
        int prioridadC2 = 0;
        int resultado = 0;
        switch(c1.tConsulta){
            case ddl:
                prioridadC1= 1;
                break;
            case update:
                prioridadC1 = 2;
                break;
            case join:
                prioridadC1 = 3;
                break;
            case select:
                prioridadC1 = 4;
                break;
        }
        switch(c2.tConsulta){
            case ddl:
                prioridadC2= 1;
                break;
            case update:
                prioridadC2 = 2;
                break;
            case join:
                prioridadC2 = 3;
                break;
            case select:
                prioridadC2 = 4;
                break;
        }
        if(prioridadC1 == prioridadC2){
            return 0;
        }
        else{
            return prioridadC1 - prioridadC2;
        }
    }
}
