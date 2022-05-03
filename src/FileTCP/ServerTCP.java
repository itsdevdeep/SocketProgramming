package FileTCP;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class ServerTCP {
    public static void main(String[] args) throws Exception{
       int port=5000;
       try{
           ServerSocket server=new ServerSocket(port);
           System.out.println("Server running..");

           Socket socket = server.accept();
           System.out.println("Client connection successful..");

           FileInputStream fileInputStream = new FileInputStream("C:\\Users\\ddg15\\Documents\\Compiler Lab\\Test.txt");
           byte[] b = new byte[4*1024];
           fileInputStream.read(b,0,b.length);

           OutputStream outputStream = socket.getOutputStream();
           outputStream.write(b,0,b.length);
       }
       catch (IOException e){
           e.printStackTrace();
       }
    }
}