package GameServer.Server;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class ServerListener extends Thread {

    String clientName;
    Socket socket;

    private String command;

    ObjectInputStream objectInput;
    ObjectOutputStream objectOut;

    ServerListener(Socket socket, String clientName){
        this.clientName = clientName;
        this.socket = socket;
        serverListener();
    }

    public void serverListener(){

        while (socket.isConnected()){

            try {

                objectInput = new ObjectInputStream(socket.getInputStream());

                command = String.valueOf(objectInput.read());

            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }
}
