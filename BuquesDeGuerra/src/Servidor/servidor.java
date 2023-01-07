package Servidor;

import java.net.ServerSocket;
import java.net.Socket;
import java.util.LinkedList;

public class servidor {

    private final int puerto = 2027;
    private final int noConexiones = 2;
    private LinkedList<Socket> usuarios = new LinkedList<Socket>();
    private Boolean turno = true;

    public static void main(String[] args) {
        servidor server = new servidor();
        server.IniciarServidor();
    }

    public void IniciarServidor() {
        try {

            ServerSocket servidor = new ServerSocket(puerto, noConexiones);
            System.out.println("ESPERANDO CONEXION CON LOS JUGADORES");
            while (true) {
                Socket cliente = servidor.accept();
                Runnable run = new HiloServidor(cliente, usuarios);
                Thread hilo = new Thread(run);
                hilo.start();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
