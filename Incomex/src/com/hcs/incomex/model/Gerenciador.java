/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hcs.incomex.model;

import java.util.ArrayList;

/**
 *
 * @author helton
 */
public class Gerenciador {
    
    private UsuarioModel usuario;
    private ArrayList<Despesa> despesas;
    private ArrayList<Receita> receitas;
    public double saldo;
    
    private double getTotalReceitas() {
        return 0;
    }
    
    private double getTotalDespesas() {
        return 0;
    }

    public double getSaldo() {
        return saldo;
    }    
    
}
