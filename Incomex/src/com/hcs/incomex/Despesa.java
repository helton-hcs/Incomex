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
public class Despesa extends Conta {
    
    private Status status;
    private GregorianCalendar dataRecebimento;
    private ArrayList<ContaParcial> pagamentosParciais;
    private FormulaDespesa formulaDespesa;
    private double valorPago;
    
    private enum Status {
        pago,
        pendente,
        pagoParcialmente
    }
    
    class FormulaDespesa {
        private String formula;
        private ArrayList<Receita> dependencias;
    }
    
}
