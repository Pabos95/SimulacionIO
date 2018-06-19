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
        if(consulta.getMuerto()) {//Si viene muerta significa que llegó al timeout
            //matarconsulta y hacer cositas
        }else if(0 == consulta.getTiempoVida()){//Si acaba de ingresar al DBMS, se agrega si hay campo o se mata si no hay
            agregarConsulta(consulta);
        }
        else {//Cuando trae los bloques de datos
            //Procesar los datos
        }
    }

    @Override
    public void procesarSalida(Consulta consulta) {
        if(!consulta.getMuerto()){//La Salida importa solo cuando se van a pasar datos al usuario o cuando pase el siguiente mod
            if( 0 == consulta.getTiempoVida()){//Si se admitió en el DBMS por primera vez

            }
            else{//Mandar datos al usuario /quedar como muerta en false y que al final de simulacion se cuente como consulta exitosa

            }
        }
    }

    @Override
    public void procesarTimeOut(Consulta consulta) {

    }
}