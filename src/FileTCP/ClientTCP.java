package FileTCP;

import java.io.*;
import java.net.*;

public class ClientTCP {
    public static void main(String[] args) throws IOException {
        try{
            Socket socket = new Socket("localhost", 5000);
            System.out.println("Connection successful..");
            InputStream inputStream = socket.getInputStream();
            byte[] b =new byte[4*1024];
            inputStream.read(b,0,b.length);

            FileOutputStream fileOutputStream = new FileOutputStream("C:\\Users\\ddg15\\Desktop\\ServerFileTCP.txt");
            fileOutputStream.write(b,0,b.length);
        }
        catch(IOException e){
            e.printStackTrace();
        }
    }
}