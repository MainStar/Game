package GameServer.Server;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server extends Thread {

    private boolean checkSocket = true;
    ObjectInputStream input;

    String clientName;

    private int port = 7777;
    private String ip = "127.0.0.1";
    private ServerSocket ss;
    private Socket socket;

    public void run(){

        try {

            while (checkSocket == true){

                ss = new ServerSocket(port);
                System.out.println("GameServer started!");
                socket = ss.accept();
                input = new ObjectInputStream(socket.getInputStream());
                clientName = String.valueOf(input.read());
                System.out.println("To Server connected: " + clientName);
                ServerListener serverListener = new ServerListener(socket, clientName);
                serverListener.setName(clientName);
                serverListener.start();

            }

            socket.close();
            ss.close();
            setDaemon(false);


        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void stopServer(){
        checkSocket = false;
    }
}
