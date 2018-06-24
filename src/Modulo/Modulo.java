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
    GeneradoraValoresAelatorios gen;

    public abstract void procesarLlegada(Consulta consulta);

    public abstract void procesarSalida(Consulta consulta);
    public abstract int getTamActualCola();
    public abstract void restarConexionesActivas();
}