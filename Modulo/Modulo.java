package Modulo;
import java.util.*;
import SimulacionIO.*;
import Estadisticos.*;

abstract class Modulo {
    int tamFinalCola;
    int tamActualCola;
    int consultasActuales;
    List<Consulta> colaConsultas;
    EstadisticosModulo estadisticosMod;
    GeneradoraValoresAelatorios generador;

    public abstract void procesarLlegada(Consulta consulta);

    public abstract void procesarSalida(Consulta consulta);

    public abstract void procesarTimeOut(Consulta consulta);

}