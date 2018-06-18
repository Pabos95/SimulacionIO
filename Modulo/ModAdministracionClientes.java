package Modulo;


import SimulacionIO.Consulta;

import java.util.*;

class ModAdministracionClientes extends Modulo {
    int k;
    int consultasActuales;
    int consultasRechazadas;

    public ModAdministracionClientes(int tam) {
        k = tam;
    }

    public void agregarConsulta() {//Este sería el primer paso en la simulación
        if (consultasActuales < k) {
            ++k;
        } else {//Hemos llegado al máximo
            ++consultasRechazadas;
        }

    }

    @Override
    public void procesarLlegada(Consulta consulta) {///Puede ser cuando entra por primera vez o justo antes  de salir


    }

    @Override
    public void procesarSalida(Consulta consulta) {

    }

    @Override
    public void procesarTimeOut(Consulta consulta) {

    }
}