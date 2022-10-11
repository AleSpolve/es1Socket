package com.example;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class App 
{
    public static void main( String[] args ) throws Exception
    {
        ServerSocket ss = new ServerSocket(3000);
        System.out.println("Server in ascolto sulla porta 3000");
        Socket s = ss.accept();
        System.out.println("Client connesso");

        InputStreamReader in = new InputStreamReader(s.getInputStream());
        BufferedReader br = new BufferedReader(in);
        String str = br.readLine();
        System.out.println("Client: " + str);

        //altezza 
        InputStreamReader in1 = new InputStreamReader(s.getInputStream());
        BufferedReader br1 = new BufferedReader(in1);
        String strAltezza = br1.readLine();
        float altezza = Float.parseFloat(strAltezza);

        //peso
        InputStreamReader in2 = new InputStreamReader(s.getInputStream());
        BufferedReader br2 = new BufferedReader(in2);
        String strPeso = br2.readLine();
        float peso = Float.parseFloat(strPeso);

        //risultato
        PrintWriter pr = new PrintWriter(s.getOutputStream());
        pr.println("il tuo BMI é:" + peso / (altezza * altezza));
        
        //chiusura
        pr.flush();
        s.close();
        ss.close();

        

    }
}

