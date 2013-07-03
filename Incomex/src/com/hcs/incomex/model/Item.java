/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hcs.incomex.model;

import java.util.GregorianCalendar;

/**
 *
 * @author helton
 */
public class Item {

    private int Id;
    private UsuarioModel usuario;
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
