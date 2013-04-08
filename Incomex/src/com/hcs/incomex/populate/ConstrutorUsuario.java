/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hcs.incomex.populate;

import br.unesp.igce.lacunas.GeradorDeNome;
import com.hcs.incomex.Usuario;
import com.hcs.incomex.generators.GeradorData;
import com.hcs.incomex.generators.GeradorLogin;
import com.hcs.incomex.generators.GeradorSenha;
import java.util.Random;

/**
 *
 * @author helton
 */
public class ConstrutorUsuario {
       
    public static Usuario getUsuario() {
        return new Usuario(GeradorDeNome.prox(), 
                new GeradorData(1950, 1995).getData(), 
                GeradorLogin.getLogin(),
                GeradorSenha.getSenha(),                 
                new GeradorData(2005).getData(), 
                new Random().nextDouble() * 10000.00);
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