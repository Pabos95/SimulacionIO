package Modulo;

import Estadisticos.EstadisticosModulo;
import SimulacionIO.Consulta;
import SimulacionIO.Evento;
import static SimulacionIO.Simulacion.agregarEvento;

import java.util.*;

public class ModAdministracionClientes extends Modulo {
    int k;
    int consultasRechazadas;
    public ModAdministracionClientes(int tam) {
        k = tam;
        estadisticosMod = new EstadisticosModulo();
    }

    @Override
    public void procesarLlegada(Consulta consulta) {//Puede ser cuando entra por primera vez o justo antes  de salir
        if(consulta.getTiempoVida() == 0){
            if (consultasActuales < k) {
            consulta.setMuerto(false);
            ++consultasActuales;
            estadisticosMod.actualizarLambda();
            }
        else {//Hemos llegado al máximo
            ++consultasRechazadas;
            }
        }
        else{//Último paso antes de llevar los datos al cliente
            double r = consulta.getBloques() / 64;
            consulta.setTiempoActual(r + consulta.getTiempoActual());
            consulta.setTiempoVida(r + consulta.getTiempoVida());
            consulta.setTipoEvento(Evento.tipoEvento.salidaModuloAdministracionClientes);
            
        }
    }

    @Override
    public void procesarSalida(Consulta consulta) {
        if(consulta.getTiempoVida() == 0){
            consulta.setTipoEvento(Evento.tipoEvento.llegadaModuloAdministracionProcesos);
            agregarEvento(consulta);
        }
        else{
            //Como ya entregamos los bloques al cliente, cerramos la conexion y admitimos una nueva sentencia
            --consultasActuales;
        }
    }

    @Override
    public int getTamActualCola(){
        return colaConsultas.size();
    }
    
    public void restarConexionesActivas(){
        --consultasActuales;
    }
    
   
    public int getConsultasRechazadas(){
        return consultasRechazadas;
    }
}
