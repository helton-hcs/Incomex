/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hcs.incomex.generators;

import java.util.Random;

/**
 *
 * @author helton
 */
public class GeradorSenha {
    
    public enum TipoSenha {
        apenasLetras,
        apenasNumeros,
        alfanumerica,
        comCaracteresEspeciais
    }
    
    private static char getValorAscii(int inicio, int fim) {
        return (char)(inicio + new Random().nextInt(fim-inicio));
    }
    
    public static String getSenha() {   
        return getSenha(new Random().nextInt(20)+1);
    }    
    
    public static String getSenha(int tamanho) {   
        TipoSenha tipoSenha = TipoSenha.values()[new Random().nextInt(4)];
        return getSenha(tamanho, tipoSenha);
    }
    
    public static String getSenha(int tamanho, TipoSenha tipoSenha) {   
        
        String senha = "";
        Random r = new Random();                
        
        switch(tipoSenha) {
            //97-122 -> a-z
            case apenasLetras: 
                for (int i = 0; i < tamanho; i++) {                    
                    if (r.nextInt() <= .5) {             
                        senha += getValorAscii(65, 90);  //letras maiúsculas [A-Z]: 65-90
                    }
                    else {                                
                        senha += getValorAscii(97, 122); //letras minúscuals [a-z]: 97-127                       
                    }
                }
                break;
            case apenasNumeros:
                for (int i = 0; i < tamanho; i++) {           
                    senha += getValorAscii(48, 57);      //números [0-9]                               
                }                
                break;
            case alfanumerica:
                for (int i = 0; i < tamanho; i++) {                    
                    if (r.nextInt() <= .33) {             
                        senha += getValorAscii(65, 90);  //letras maiúsculas [A-Z]: 65-90
                    }
                    else if (r.nextInt() <= .33 * 2) {        
                        senha += getValorAscii(97, 122); //letras minúsculas [a-z]: 97-127                       
                    }
                    else {                                 
                        senha += getValorAscii(48, 57);  //números [0-9]                               
                    }
                }                
                break;
            case comCaracteresEspeciais:
                for (int i = 0; i < tamanho; i++) {                    
                    if (r.nextInt() <= .25 * 1) {             
                        senha += getValorAscii(65, 90);  //letras maiúsculas [A-Z]: 65-90
                    }
                    else if (r.nextInt() <= .25 * 2) {    
                        senha += getValorAscii(97, 122); //letras minúsculas [a-z]: 97-127
                    }
                    else if (r.nextInt() <= .25 * 3) {            
                        senha += getValorAscii(48, 57);  //números [0-9]                                
                    }
                    else if (r.nextInt() <= (.25 * 3) + (.25/4)) {
                        senha += getValorAscii(33, 47);    //caracteres especiais - grupo1 [33-47]                                
                    }
                    else if (r.nextInt() <= (.25 * 3) + (.25/3)){
                        senha += getValorAscii(58, 64);    //caracteres especiais - grupo2 [58-64]                                                       
                    }                    
                    else if (r.nextInt() <= (.25 * 3) + (.25/2)){
                        senha += getValorAscii(94, 96);    //caracteres especiais - grupo3 [94-96]                             
                    }
                    else if (r.nextInt() <= (.25 * 3) + (.25/1)){
                        senha += getValorAscii(123, 126);  //caracteres especiais - grupo4 [123-126]                             
                    }
                }                  
                break;
        }
        return senha;        
    }  
            
}

class TesteGeradorSenha {
    
    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            System.out.println("Senha: " + GeradorSenha.getSenha());
        }                
    }    
    
}