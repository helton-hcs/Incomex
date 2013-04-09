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
public class Usuario {
    
    private String nome;
    private GregorianCalendar dataNascimento;
    private String login;
    private String senha;
    private GregorianCalendar dataUltimoLogin;
    private double salario;

    public Usuario(String nome, GregorianCalendar dataNascimento, String login, 
                   String senha, GregorianCalendar dataUltimoLogin, double salario) {
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.login = login;
        this.senha = senha;
        this.dataUltimoLogin = dataUltimoLogin;
        this.salario = salario;
    }
    
    public String getNome() {
        return nome;
    }

    public GregorianCalendar getDataNascimento() {
        return dataNascimento;
    }

    public String getLogin() {
        return login;
    }

    public String getSenha() {
        return senha;
    }

    public GregorianCalendar getDataUltimoLogin() {
        return dataUltimoLogin;
    }

    public double getSalario() {
        return salario;
    }
    
    @Override
    public String toString() {
        return "Nome .............: " + getNome() + "\n" + 
               "Data de nascimento: " + getDataNascimento().getTime() + "\n" +
               "Login.............: " + getLogin() + "\n" +                       
               "Senha.............: " + getSenha() + "\n" +                       
               "Data último login.: " + getDataUltimoLogin().getTime() + "\n" +                        
               "Salário...........: " + getSalario();
    }
    
}
