package org.ativav3;

import java.io.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args)
    {
        // ENTRADA DE DADOS

        Jogo jogo = new Jogo(System.in);
        Arquivo arq = new Arquivo(System.in);
        arq.escrever(jogo);

        InputStream fluxoEntrada = null;
        InputStreamReader leitorFluxoEntrada = null;
        BufferedReader bufferEntrada = null;
        String linha = null;


        try {
            fluxoEntrada = new FileInputStream("C://Users//JohnS//Desktop//Netbeans//log.txt/");
            leitorFluxoEntrada = new InputStreamReader(fluxoEntrada);
            bufferEntrada = new BufferedReader(leitorFluxoEntrada);
            linha = bufferEntrada.readLine();
            while(linha != null) {
                System.out.println(linha);
                linha = bufferEntrada.readLine();
            }
        }
        catch (FileNotFoundException ex){
            System.err.printf("FileNotFoundException: %s.%n", ex);
        }
        catch (IOException ex){
            System.err.printf("IOException: %s.%n", ex);
        }
        finally {
            try{
                bufferEntrada.close();
            }
            catch (IOException ex){
                System.err.printf("IOException: %s.%n", ex);
            }
        }

        //SAIDA DE DADOS

        OutputStream fluxoSaida = null;
        OutputStreamWriter geradorFluxoSaida = null;
        BufferedWriter bufferSaida = null;
        try {
            fluxoSaida = new FileOutputStream("C://Users//JohnS//Desktop//Netbeans//log.txt/", true);
            geradorFluxoSaida = new OutputStreamWriter(fluxoSaida);
            bufferSaida.write(linha);
            bufferSaida.newLine();
        }
        catch (FileNotFoundException ex)
        {
            System.err.printf("FileNotFoundException: %s.%n", ex);
        }
        catch (IOException ex)
        {
            System.err.printf("IOException: %s.%n");
        }
        finally{
            try{
                bufferSaida.close();
            }
            catch (IOException ex){
                System.err.printf("IOException: %s.%n", ex);
            }
        }
    }

}
