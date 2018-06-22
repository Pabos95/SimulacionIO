package Modulo;


import SimulacionIO.Consulta;

import java.util.*;

public class ModAdministracionClientes extends Modulo {
    int k;
    int consultasRechazadas;

    public ModAdministracionClientes(int tam) {
        k = tam;
    }

    @Override
    public void procesarLlegada(Consulta consulta) {//Puede ser cuando entra por primera vez o justo antes  de salir
        if (consultasActuales < k) {
            consulta.setMuerto(false);
            ++consultasActuales;
        }
        else {//Hemos llegado al máximo
            ++consultasRechazadas;
        }
    }

    //Falta de implementar
    /*public void procesarLlegada(Consulta c, int bloques){

    }*/

    @Override
    public void procesarSalida(Consulta consulta) {
        if(consulta.getTiempoVida() == 0){//En caso que esté entrando al DBMS

        }
        else{//Cuando esté a punto de salir del DBMS, osea enviando los datos

        }
    }

    @Override
    public void procesarTimeOut(Consulta consulta) {

    }

    public void restarConeccionesActivas(){
        --consultasActuales;
    }
    public int getTamActualCola(){
        return tamActualCola;
    }
}
