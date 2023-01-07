package Servidor;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;
import java.util.LinkedList;

public class HiloServidor implements Runnable {

    private Socket socket;
    private DataOutputStream out;
    private DataInputStream in;
    private LinkedList<Socket> usuarios = new LinkedList<Socket>();

    public HiloServidor(Socket soc, LinkedList users) {
        socket = soc;
        usuarios = users;
    }

    @Override
    public void run() {
        System.out.println("hola");
    }
}
