/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SimulacionIO;

public class Evento {

    tipoEvento tipo;

    public Evento(){
        tipo = tipoEvento.llegadaModuloAdministracionClientes;
    }
    public enum tipoEvento{
        llegadaModuloAdministracionClientes,salidaModuloAdministracionClientes,
        llegadaModuloProcesamientoConsultas, salidaModuloProcesamientoConsultas,
        llegadaModuloAdministracionProcesos,salidaModuloAdministracionProcesos,
        llegadaModuloTransacciones, salidaModuloTransacciones,
        llegada2ModuloProcesamientoConsultas, salida2ModuloProcesamientoConsultas
        
    }

    public void setTipoEvento(tipoEvento type){
        tipo = type;
    }
    public  tipoEvento getTipoEvento(){
        return tipo;
    }
}
