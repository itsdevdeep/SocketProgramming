package ChatService;

import java.io.*;
import java.net.*;

public class ChatClient {
    public static void main(String[] args) {
        try {
            InetAddress host = InetAddress.getLocalHost();
            Socket socket = new Socket(host.getHostName(), 5600);

            DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
            DataInputStream dis = new DataInputStream(System.in);

            String line = "";
            while (!line.equals("bye")) {
                try {
                    line = dis.readLine();
                    dos.writeUTF(line);
                    dos.flush();
                } catch (IOException e) {
                    System.out.println("Error in sending messages: " + e.getMessage());
                }
            }
            dis.close();
            dos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
