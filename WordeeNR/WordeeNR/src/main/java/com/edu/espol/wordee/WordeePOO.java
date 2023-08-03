/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.edu.espol.wordee;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 *
 * @author gladys
 */
public class WordeePOO {
    private ArrayList<String> frases;

    public WordeePOO(String archivo) {
        frases = new ArrayList<String>();
        cargarFrases(archivo);
        
        
    }
    
    /**
     * Selecciona aleatoriamente una frase de la lista de frases
     * @return String con frase aleatoria
     */
    public String seleccionarFrase(){
            
        int num = 0;
        String frase = "";
        while (frase.split(" ").length!=5){
            int len = frases.size();
            num = (int)(Math.random()*(len));
            frase = frases.get(num);
        }
        
        return frase;
    }
    
    /**
     * Inicializa y llena la variable de instancia frases con las frases que se
     * encuentran en el archivo
     * @param archivo nombre del archivo a leer
     */
    private void cargarFrases(String archivo){
        try{
            BufferedReader buffer = new BufferedReader(new FileReader(archivo));
            String line;
            while ((line = buffer.readLine())!= null){
                frases.add(line);
            }
        
        }catch(IOException e){e.printStackTrace();}
    }
}
