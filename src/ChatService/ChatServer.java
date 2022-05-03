package ChatService;

import java.io.*;
import java.net.*;

public class ChatServer {
    private ServerSocket server;
    private int port = 5600;

    public ChatServer() {
        try {
            server = new ServerSocket(port);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        ChatServer server = new ChatServer();
        server.connection();
    }

    public void connection() {
        System.out.println("Waiting for client...");
        try {
            Socket socket = server.accept();
            System.out.println("Client accepted: " + socket);

            DataInputStream dis = new DataInputStream(new BufferedInputStream(socket.getInputStream()));
            boolean done = false;
            while (!done) {
                try {
                    String line = dis.readUTF();
                    System.out.println(line);
                    done = line.equals("bye");
                } catch (IOException e) {
                    done = true;
                }
            }
            dis.close();
            socket.close();
        } catch (IOException e) {
            System.out.println(e);
        }
    }
}
