public class EstadisticosIteracion{
  /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Estadisticos;
import java.util.*;
import SimulacionIO.*;
/**
 *
 * @author Pabos95
 */
public class EstadisticosIteracion {
    private int numConexionesDescartadas;
    private double[] tamañoPromedioColaModulo; //Almacena los tamaños promedio de cada modulo de la corrida
    private double tiempoPromedioVida; //Almacena el tiempo promedio de vida de una consulta
    /*0 Modulo AdministracionClientes
    1 Modulo AdministracionConexiones
    2 Modulo Administracion consultas
    3 Modulo AdministracionProcesos
    4 Modulo Administracion Transacciones*/
    public EstadisticosIteracion(){
        tamañoPromedioColaModulo = new double[5];       
    }
    public void agregarTamañoPromedio(double tamPromedio,int pos){ //se usa para agregar un tamaño promedio al arreglo
        tamañoPromedioColaModulo[pos] = tamPromedio;
    }
    public void calcularTiempoPromedioVida(ArrayList <Consulta> listaConsultas){
        double sumatoria = 0;
        Consulta [] arregloConsultas = listaConsultas.toArray();
        for(int i = 0; i <= listaConsultas.size()- 1; i++){
         sumatoria += arregloConsultas[i];
        }
        tiempoPromedioVida = sumatoria/arregloConsultas.size();
    }
}
}
