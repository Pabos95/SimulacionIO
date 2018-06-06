package SimulacionIO;
import javax.swing.*;
public class Interfaz extends JFrame{
    public Interfaz(){

    }
    public static void main(String[] args) {
        Interfaz miAplicacion = new Interfaz();
        miAplicacion.setBounds(10,10,400,400);
        miAplicacion.pack();
        miAplicacion.setVisible(true);
        numeroCorridas = new JTextField();
        modoLento = new JTextField();
    }
}
