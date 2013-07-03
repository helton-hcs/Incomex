/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hcs.incomex.geradores;

import br.unesp.igce.lacunas.GeradorDeNome;
import java.util.Random;

/**
 *
 * @author helton
 */
public class GeradorDeLogin {
    
    public static String getLogin(String nome) { 
        nome = nome.toLowerCase().replaceAll("^([A-Za-z]+) .*$", "$1");
        Random r = new Random();
        int inicio = r.nextInt(nome.length());
        return ((inicio != nome.length()-1) ? nome.substring(inicio) : nome) + GeradorDeSenha.getSenha(3, GeradorDeSenha.TipoSenha.apenasNumeros);
    }
    
}

class TesteGeradorDeLogin {
    
    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            System.out.println(GeradorDeLogin.getLogin(GeradorDeNome.prox()));
        }
    }
    
}
