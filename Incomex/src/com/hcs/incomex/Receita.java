/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hcs.incomex;

import java.util.ArrayList;
import java.util.GregorianCalendar;

/**
 *
 * @author helton
 */
public class Receita extends Item {
    
    private Status status;
    private GregorianCalendar dataRecebimento;
    private ArrayList<ItemParcial> recebimentosParciais;
    private double valorRecebido;
    
    private enum Status {
        recebido,
        pendente,
        recebidoParcialmente
    }
    
}
