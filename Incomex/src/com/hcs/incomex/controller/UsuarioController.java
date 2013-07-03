/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hcs.incomex.controller;

import com.hcs.incomex.model.UsuarioModel;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author helton
 */
public class UsuarioController {
    
    private static final String NOME_ARQUIVO = "usuarios.incomex";
    
    protected Map<String,UsuarioModel> usuarios;   
    
    public UsuarioController() {
        usuarios = new HashMap<>();
    }
    
    public void adicionarUsuario(UsuarioModel usuario) {
        usuarios.put(usuario.getLogin(), usuario); 
    }
    
    public void removerUsuario(UsuarioModel usuario) {
        if (usuarios.containsKey(usuario.getLogin())) {        
            usuarios.remove(usuario.getLogin());
        }        
    }
    
    public boolean existeUsuario(String login) {
        return (usuarios.containsKey(login));
    }
    
    public UsuarioModel getUsuario(String login) {
        return usuarios.get(login);
    }
    
    public boolean verificarAcesso(UsuarioModel usuario, String senha) {
        return usuario.getSenha().equals(senha);
    }
    
    public void salvarDados() {
        try {
            FileOutputStream fos = new FileOutputStream(NOME_ARQUIVO);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(usuarios);
            oos.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }        
    }
    
    public void carregarDados() {
        if (new File(NOME_ARQUIVO).length() != 0) {        
            try {
                FileInputStream fis = new FileInputStream(NOME_ARQUIVO);
                ObjectInputStream ois = new ObjectInputStream(fis);
                usuarios = (HashMap<String,UsuarioModel>)ois.readObject();            
            } catch (Exception ex) {
                ex.printStackTrace();
            }        
        }
    }
    
}
