package SimulacionIO;
class Simulacion{
  int iteracionActual;
  int tiempoMaximo;  //tiempo maximo de la simulacion
  int k; // numero maximo de conexiones concurrentes que puede administrar el sistema
  int n; //numero de procesos disponibles para el procesamiento de consultas. concurrentes que puede manejar el sistema.
  int p; //numero de procesos disponibles para la ejecución de transacciones
  int m; //numero de procesos disponibles para la ejecución de consultas
  int t; //cantidad de segundos para el timeout de las conexiones
  bool modoLento// true si la conexión está en modoLento y falso en caso contrario
  public Simulacion(int numCorridas,int numConexionesConcurrentesMaximo){

  }
  public void ejecutarSimulacion(){

  }
}
