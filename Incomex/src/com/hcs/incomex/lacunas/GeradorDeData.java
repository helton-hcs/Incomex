/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hcs.incomex.lacunas;

import java.util.Arrays;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Random;


/**
 *
 * @author helton
 */
public class GeradorDeData {
    
    private static int anoInicial = getAnoAtual() - 100;
    private static int anoFinal   = getAnoAtual();    
   
    public GeradorDeData(int anoInicial) {
        this(anoInicial, getAnoAtual());
    }              
    
    public GeradorDeData(int anoInicial, int anoFinal) {
        GeradorDeData.anoInicial = anoInicial;
        GeradorDeData.anoFinal   = anoFinal;
    }
    
    private static int getAnoAtual() {
        return new GregorianCalendar().get(Calendar.YEAR);        
    }       
    
    private static int geraAno() { 
        return anoInicial + new Random().nextInt(anoFinal-anoInicial);
    }       
    
    private static int geraMes() {
        return new Random().nextInt(11);
    }
    
    private static int geraDia(int mes, int ano) {
        if (Arrays.asList(new int[] {4, 6, 9, 11}).contains(mes)) 
            return new Random().nextInt(30)+1;
        if (Arrays.asList(new int[] {1, 3, 5, 7, 8, 10, 12}).contains(mes)) 
            return new Random().nextInt(31)+1;        
        if (new GregorianCalendar().isLeapYear(ano))
            return new Random().nextInt(29)+1;
        return  new Random().nextInt(28)+1;                      
    }
    
    public static GregorianCalendar getData () {    
        int ano = geraAno();
        int mes = geraMes();
        int dia = geraDia(mes, ano);
        return new GregorianCalendar(ano, mes, dia);
    }    
 
}

class TesteGeradorData {
    
    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            GregorianCalendar data = new GeradorDeData(1950, 1995).getData();
            System.out.println(data.getTime());
        }
    }    
    
}