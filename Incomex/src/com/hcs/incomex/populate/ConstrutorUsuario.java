/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hcs.incomex.populate;

import br.unesp.igce.lacunas.GeradorDeNome;
import com.hcs.incomex.Usuario;
import com.hcs.incomex.generators.GeradorDeData;
import com.hcs.incomex.generators.GeradorDeLogin;
import com.hcs.incomex.generators.GeradorDeSenha;
import java.util.Random;

/**
 *
 * @author helton
 */
public class ConstrutorUsuario {
       
    public static Usuario getUsuario() {
        String nome = GeradorDeNome.prox();
        return new Usuario(nome, 
                new GeradorDeData(1950, 1995).getData(), 
                GeradorDeLogin.getLogin(nome),
                GeradorDeSenha.getSenha(),                 
                new GeradorDeData(2005).getData(), 
                Math.round((new Random().nextDouble() * 10000.00)));
    }  
        
}

class TesteConstrutorUsuario {
    
    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            System.out.println(ConstrutorUsuario.getUsuario());
            System.out.println("==============================================");
        }
    }    
    
}