/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hcs.incomex.povoadores;

import br.unesp.igce.lacunas.GeradorDeNome;
import com.hcs.incomex.geradores.GeradorDeData;
import com.hcs.incomex.geradores.GeradorDeLogin;
import com.hcs.incomex.geradores.GeradorDeSenha;
import com.hcs.incomex.model.UsuarioModel;
import java.util.Random;


/**
 *
 * @author helton
 */
public class PovoadorUsuario {
       
    public static UsuarioModel getUsuario() {
        String nome = GeradorDeNome.prox();
        return new UsuarioModel(nome, 
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
            System.out.println(PovoadorUsuario.getUsuario());
            System.out.println("==============================================");
        }
    }    
    
}