package Modulo;


import SimulacionIO.Consulta;

import java.util.*;

public class ModAdministracionClientes extends Modulo {
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
        if(consulta.getMuerto() && consulta.getTiempoVida() != 0) {//Si viene muerta significa que llegó al timeout
            //matarconsulta y hacer cositas
        }else if(0 == consulta.getTiempoVida()){//Si acaba de ingresar al DBMS, se agrega si hay campo o se mata si no hay
            agregarConsulta(consulta);
        }
        else {//Cuando trae los bloques de datos
            //Procesar los datos y no tiene timeout
        }
    }

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
}