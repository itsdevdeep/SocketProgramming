package Factorial;
import java.net.*;
import java.io.*;

public class ServerFact {
    public static void main(String[] args)
    {
        try
        {
            ServerSocket ss =new ServerSocket(2222);
            System.out.println("Server is started");
            while(true)
            {
                Socket s=ss.accept();
                System.out.print("Connection request Received");

                InputStream is=s.getInputStream();
                InputStreamReader isr= new InputStreamReader(is);
                BufferedReader br=new BufferedReader(isr);

                OutputStream os=s.getOutputStream();
                PrintWriter pw= new PrintWriter(os,true);
                String no=br.readLine();
                int fact=1,i=0;
                int no1=Integer.parseInt(no);
                while(no1>i)
                {
                    fact=fact*no1;
                    no1--;
                }
                pw.println(fact);
                s.close();
            }
        }

        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
}
