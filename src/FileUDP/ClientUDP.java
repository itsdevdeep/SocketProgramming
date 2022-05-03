package FileUDP;
import java.io.*;
import java.net.*;

public class ClientUDP
{
    public static void main(String[] args)throws Exception
    {
        byte b[] = new byte[1024];
        FileInputStream f=new FileInputStream("C:\\Users\\ddg15\\Documents\\Compiler Lab\\Test.txt");
        DatagramSocket dsoc=new DatagramSocket();

        int i=0;
        while(f.available()!=0)
        {
            b[i]=(byte)f.read();
            i++;
        }

        f.close();
        dsoc.send(new DatagramPacket(b,i,InetAddress.getLocalHost(),5555));
    }
}