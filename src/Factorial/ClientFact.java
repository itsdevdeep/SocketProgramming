package Factorial;
import  java.net.*;
import java.io.*;

public class ClientFact {
    public static void main(String args[])
    {
        try
        {
            Socket s = new Socket("localhost",2222);

            InputStream is=s.getInputStream();
            InputStreamReader isr= new InputStreamReader(is);
            BufferedReader br=new BufferedReader(isr);

            OutputStream os=s.getOutputStream();
            PrintWriter pw= new PrintWriter(os,true);
            String msg="6";
            pw.println(msg);
            msg=br.readLine();
            int f=Integer.parseInt(msg);
            System.out.println("The Factorial is = "+f);
            s.close();

        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
