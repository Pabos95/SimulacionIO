package Modulo;


import SimulacionIO.Consulta;

import java.util.*;

class ModAdministracionClientes extends Modulo {
    int k;
    int consultasRechazadas;

    public ModAdministracionClientes(int tam) {
        k = tam;
    }

    public void agregarConsulta(Consulta c) {//Este sería el primer paso en la simulación
        if (consultasActuales < k) {
            c.setMuerto(false);
            ++k;
        } else {//Hemos llegado al máximo
            ++consultasRechazadas;
        }

    }

    @Override
    public void procesarLlegada(Consulta consulta) {//Puede ser cuando entra por primera vez o justo antes  de salir
        if(consulta.getMuerto()){//Si viene muerta significa que es recien viene del usuario
            agregarConsulta(consulta);
        }
        else{//Cuando trae los bloques de datos

        }

    }

    @Override
    public void procesarSalida(Consulta consulta) {

    }

    @Override
    public void procesarTimeOut(Consulta consulta) {

    }
}