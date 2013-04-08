/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hcs.incomex.generators;

import java.util.Arrays;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Random;

/**
 *
 * @author helton
 */
public class GeradorData {
    
    private static int anoInicial;
    private static int anoFinal;    
    
    public GeradorData() {
        anoFinal   = getAnoAtual();
        anoInicial = getAnoAtual() - 100;         
    }
   
    public GeradorData(int anoInicial) {
        this(anoInicial, getAnoAtual());
    }              
    
    public GeradorData(int anoInicial, int anoFinal) {
        GeradorData.anoInicial = anoInicial;
        GeradorData.anoFinal   = anoFinal;
    }
    
    private static int getAnoAtual() {
        GregorianCalendar date = new GregorianCalendar();        
        return date.get(Calendar.YEAR);        
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
    
    static {
        anoFinal   = getAnoAtual();
        anoInicial = getAnoAtual() - 100;           
    }

}

class TesteGeradorData {
    
    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            GregorianCalendar data = new GeradorData(1950, 1995).getData();
            System.out.println(data.getTime());
        }
    }    
    
}