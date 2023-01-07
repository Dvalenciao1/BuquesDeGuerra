package buquesdeguerra;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;

public class cliente implements Runnable {

    private Socket cliente;
    private DataOutputStream out;
    private DataInputStream in;

    private int puerto = 2027;
    private String host = "localhost";

    //Variables del frame 
    private String mensaje;
    private VentanaPrincipal frame;

    private boolean turno;

    public cliente(VentanaPrincipal frame) {
        try {
            this.frame = frame;

            cliente = new Socket(host, puerto);
            in = new DataInputStream(cliente.getInputStream());
            out = new DataOutputStream(cliente.getOutputStream());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        try {

            mensaje = in.readUTF();

            while (true) {
                //Recibimos el mensaje
                mensaje = in.readUTF();

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
