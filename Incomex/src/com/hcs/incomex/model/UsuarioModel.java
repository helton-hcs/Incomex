/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hcs.incomex.model;

import java.io.Serializable;
import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 *
 * @author helton
 */
public class UsuarioModel implements Serializable {
    
    private String nome;
    private GregorianCalendar dataNascimento;
    private String login;
    private String senha;
    private GregorianCalendar dataUltimoLogin;
    private double salario;
    private boolean ativo;
    
    public UsuarioModel() {
        
    }

    public UsuarioModel(String nome, GregorianCalendar dataNascimento, String login, 
                   String senha, GregorianCalendar dataUltimoLogin, double salario) {
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.login = login;
        this.senha = senha;
        this.dataUltimoLogin = dataUltimoLogin;
        this.salario = salario;
        this.ativo = true;
    }

    public UsuarioModel(String nome, GregorianCalendar dataNascimento, String login, String senha, GregorianCalendar dataUltimoLogin, double salario, boolean ativo) {
        this(nome, dataNascimento, login, senha, dataUltimoLogin, salario);
        this.ativo = ativo;
        this.dataUltimoLogin = new GregorianCalendar(Calendar.getInstance().getTimeZone());
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
    
    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }        
    
    public String exibirDados() {
        return "Nome .............: " + getNome() + "\n" + 
               "Data de nascimento: " + getDataNascimento().getTime() + "\n" +
               "Login.............: " + getLogin() + "\n" +                       
               "Senha.............: " + getSenha() + "\n" +                       
               "Data último login.: " + getDataUltimoLogin().getTime() + "\n" +                        
               "Salário...........: " + getSalario();
    }

    /**
     * @param nome the nome to set
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * @param dataNascimento the dataNascimento to set
     */
    public void setDataNascimento(GregorianCalendar dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    /**
     * @param login the login to set
     */
    public void setLogin(String login) {
        this.login = login;
    }

    /**
     * @param senha the senha to set
     */
    public void setSenha(String senha) {
        this.senha = senha;
    }

    /**
     * @param dataUltimoLogin the dataUltimoLogin to set
     */
    public void setDataUltimoLogin(GregorianCalendar dataUltimoLogin) {
        this.dataUltimoLogin = dataUltimoLogin;
    }

    /**
     * @param salario the salario to set
     */
    public void setSalario(double salario) {
        this.salario = salario;
    }
    
}
