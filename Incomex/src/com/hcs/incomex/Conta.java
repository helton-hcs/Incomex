/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hcs.incomex;

import java.util.GregorianCalendar;

/**
 *
 * @author helton
 */
public class Conta {

    private int Id;
    private Usuario usuario;
    private String nome;
    private String descricao;
    private double valor;
    private GregorianCalendar periodo;    
    private Tipo tipo;
    
    private enum Tipo {
        fixo,
        porPeriodo,
        momentaneo,
    }
        
    
}
