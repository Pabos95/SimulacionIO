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
    private double[] tamPromedioColaModulo; //Almacena los tamaños promedio de cada modulo de la corrida
    private double tiempoPromedioVida; //Almacena el tiempo promedio de vida de una consulta
    /*0 Modulo AdministracionClientes
    1 Modulo AdministracionConsultas
    2 Modulo Administracion procesos
    3 Modulo Administracion Transacciones
    4 Modulo Administracion Consultas Segunda Pasada*/
    public EstadisticosIteracion(){

        tamPromedioColaModulo = new double[5];
        tamPromedioColaModulo[0] = 0;
        tamPromedioColaModulo[1] = 0;
        tamPromedioColaModulo[2] = 0;
        tamPromedioColaModulo[3] = 0;
        tamPromedioColaModulo[4]  = 0;
    }

    public void agregarTamPromedio(double tamPromedio,int pos){ //se usa para agregar un tamaño promedio al arreglo

        tamPromedioColaModulo[pos] = tamPromedio;
    }
    public double getTiempoPromedioVida(){
        return tiempoPromedioVida;
    }
    public void calcularTiempoPromedioVida(ArrayList <Consulta> listaConsultas){
        double sumatoria = 0;
        Consulta[] arregloConsultas =  new Consulta[listaConsultas.size()];
        for(int i = 0; i <= listaConsultas.size()- 1; i++){
         arregloConsultas[i] = listaConsultas.get(i);
         sumatoria = sumatoria + arregloConsultas[i].getTiempoVida();
        }
        tiempoPromedioVida = sumatoria/listaConsultas.size();
    }
    public double getTamPromedioColaModulo(int ind){
        return tamPromedioColaModulo[ind];
    }
}
