/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SimulacionIO;

public class Evento {
    public enum tipoEvento{
        llegadaModuloAdministracionClientes,salidaModuloAdministracionClientes,
        llegadaModuloAdministracionConexiones, salidaModuloAdministracionConexiones,
        llegadaModuloProcesamientoConsultas, salidaModuloProcesamientoConsultas,
        llegadaModuloAdministracionProcesos,salidaModuloAdministracionProcesos,
        llegadaModuloTransacciones, salidaModuloTransacciones,
        ,timeOut
    }
    tipoEvento e;
}
