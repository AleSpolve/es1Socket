package com.example;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class App 
{
    public static void main( String[] args ) throws Exception
    {
        Socket s = new Socket("localhost", 3000);
        PrintWriter pr = new PrintWriter(s.getOutputStream());

        BufferedReader tastiera = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Inserisci il messaggio:");
        String stringaUtente = tastiera.readLine();
        
        pr.println(stringaUtente);
        pr.flush();

        //altezza
        BufferedReader tas2 = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Inserisci l'altezza:");
        String altezza = tas2.readLine();
        
        pr.println(altezza);
        pr.flush();

        //peso
        BufferedReader tas3 = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Inserisci il peso:");
        String peso= tas3.readLine();
        
        pr.println(peso);
        pr.flush();

        //chiusura
        InputStreamReader in = new InputStreamReader(s.getInputStream());
        BufferedReader br = new BufferedReader(in);
        String str = br.readLine();
        System.out.println("Server: " + str);
        s.close();


    }
}
