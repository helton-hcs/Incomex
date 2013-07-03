/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hcs.incomex.view;

import com.hcs.incomex.controller.UsuarioController;
import com.hcs.incomex.model.UsuarioModel;
import java.awt.Toolkit;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;
import javax.swing.JOptionPane;

/**
 *
 * @author helton
 */
public class UsuarioViewer extends javax.swing.JFrame {
    
    private enum TipoEstado {
        INDEFINIDO,
        EDIT,
        INSERT
    }

    private UsuarioController controlador;            
    private TipoEstado estado;
    
    private void habilitarDesabilitarComponentes(boolean habilitar) {
        btnPesquisar.setEnabled(!habilitar);
        txfLogin.setEnabled(!habilitar);
        txfNome.setEnabled(habilitar);
        fmtSenha.setEnabled(habilitar);
        fmtDataNascimento.setEnabled(habilitar);
        fmtDataUltimoLogin.setEnabled(habilitar);
        fmtSalario.setEnabled(habilitar);
        chbxAtivo.setEnabled(habilitar);
        btnSalvar.setEnabled(habilitar);
        if (!habilitar) {
            txfNome.setText(null);
            fmtSenha.setText(null);    
            fmtDataNascimento.setText(null);
            fmtDataUltimoLogin.setText(null);
            fmtSalario.setText(null);            
        }
    }
    
    private boolean validaInformacoesUsuario() {
        if (txfLogin.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Login deve ser informado.");
            return false;
        }
        else if (fmtSenha.getPassword().length == 0) {
            JOptionPane.showMessageDialog(null, "A senha não pode ser vazia.");
            return false;            
        }        
        else if (fmtSenha.getPassword().length < 5) {
            JOptionPane.showMessageDialog(null, "A senha deve possuir, no mínimo, 5 caracteres.");
            return false;            
        }                
        else if (txfNome.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Nome deve ser informado.");
            return false;            
        }
        return true;
    }
    
    private String getStringData(Date date){
          return new SimpleDateFormat("MM/DD/YYYY").format(date);
    }

    private void carregaUsuario(UsuarioModel usuario) {
        habilitarDesabilitarComponentes(true);
        txfLogin.setText(usuario.getLogin());
        txfNome.setText(usuario.getNome());
        fmtSenha.setText(usuario.getSenha());
        if (usuario.getDataNascimento() != null) {
            fmtDataNascimento.setValue(usuario.getDataNascimento().getTime());
        }
        if (usuario.getDataUltimoLogin() != null) {
            fmtDataUltimoLogin.setValue(usuario.getDataUltimoLogin().getTime());
        }        
        chbxAtivo.setSelected(usuario.isAtivo());
        if (usuario.getSalario() > 0) {
            fmtSalario.setValue(usuario.getSalario());
        }       
    }
    
    private UsuarioModel construirUsuarioComDadosFormulario() {
        UsuarioModel usuario = new UsuarioModel();
        usuario.setLogin(txfLogin.getText());
        usuario.setNome(txfNome.getText());
        usuario.setSenha(new String(fmtSenha.getPassword()));
        if (!fmtDataNascimento.getText().isEmpty()) {
            GregorianCalendar g = new GregorianCalendar();
            g.setTime((Date)fmtDataNascimento.getValue());
            usuario.setDataNascimento(g);
        }
        if (!fmtDataUltimoLogin.getText().isEmpty()) {
            GregorianCalendar g = new GregorianCalendar();
            g.setTime((Date)fmtDataUltimoLogin.getValue());            
            usuario.setDataUltimoLogin(g);
        }        
        else {
            usuario.setDataUltimoLogin(new GregorianCalendar(Calendar.getInstance().getTimeZone()));            
        }
        usuario.setAtivo(chbxAtivo.isSelected());
        if (!fmtSalario.getText().isEmpty()) { 
            NumberFormat n = new DecimalFormat("\"¤#,##0.00\"");
            usuario.setSalario(Double.parseDouble(fmtSalario.getValue().toString()));
        }
        return usuario;
    }
    
    private void salvaUsuario() {        
        controlador.adicionarUsuario(construirUsuarioComDadosFormulario());
        habilitarDesabilitarComponentes(false);
        estado = TipoEstado.INDEFINIDO;
    }
    
    private void validaSairPrograma() {
        boolean opcao = false;
        if (estado != TipoEstado.INDEFINIDO) {
            opcao = JOptionPane.showOptionDialog(null,
                                                 "Quaisquer alterações realizadas serão perdidas. Deseja realmente sair?", 
                                                 "[Incomex] Sair", 
                                                 JOptionPane.YES_NO_OPTION, 
                                                 JOptionPane.QUESTION_MESSAGE, 
                                                 null,
                                                 new String[]{"Sim","Não"}, 
                                                 "Não") == 0;
        } 
        if ((estado == TipoEstado.INDEFINIDO) || opcao) {
            controlador.salvarDados();
            dispose();            
        }        
    }
    
    private void configuraFormulario() {
        habilitarDesabilitarComponentes(false);
        this.addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent windowEvent) {
                validaSairPrograma();
            }
        });        
        setLocation((Toolkit.getDefaultToolkit().getScreenSize().width - getWidth())/2,
                    (Toolkit.getDefaultToolkit().getScreenSize().height - getHeight())/2);         
    }
    
    /**
     * Creates new form UsuarioViewer
     */
    public UsuarioViewer(UsuarioController controlador) {
        Locale.setDefault(new Locale("pt", "BR"));        
        initComponents();
        configuraFormulario();
        this.controlador = controlador;
        this.estado = TipoEstado.INDEFINIDO;  
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblLogin = new javax.swing.JLabel();
        txfLogin = new javax.swing.JTextField();
        lblNome = new javax.swing.JLabel();
        txfNome = new javax.swing.JTextField();
        lblDataNascimento = new javax.swing.JLabel();
        fmtDataNascimento = new javax.swing.JFormattedTextField();
        btnSenha = new javax.swing.JLabel();
        fmtSenha = new javax.swing.JPasswordField();
        lblDataUltimoLogin = new javax.swing.JLabel();
        fmtDataUltimoLogin = new javax.swing.JFormattedTextField();
        lblSalario = new javax.swing.JLabel();
        fmtSalario = new javax.swing.JFormattedTextField();
        chbxAtivo = new javax.swing.JCheckBox();
        btnPesquisar = new javax.swing.JButton();
        btnSair = new javax.swing.JButton();
        btnSalvar = new javax.swing.JButton();
        lblDadosObrigatorios = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("[Incomex] Manutenção de Usuários");

        lblLogin.setText("Login*");

        lblNome.setText("Nome*");
        lblNome.setToolTipText("");

        lblDataNascimento.setText("Data de nascimento");

        fmtDataNascimento.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter(java.text.DateFormat.getDateInstance(java.text.DateFormat.SHORT))));

        btnSenha.setText("Senha*");

        lblDataUltimoLogin.setText("Data do último login");

        fmtDataUltimoLogin.setEditable(false);
        fmtDataUltimoLogin.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter(java.text.DateFormat.getDateInstance(java.text.DateFormat.SHORT))));

        lblSalario.setText("Salário");

        fmtSalario.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("¤#,##0.00"))));

        chbxAtivo.setSelected(true);
        chbxAtivo.setText("Ativo");

        btnPesquisar.setText("Pesquisar");
        btnPesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPesquisarActionPerformed(evt);
            }
        });

        btnSair.setText("Sair");
        btnSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSairActionPerformed(evt);
            }
        });

        btnSalvar.setText("Salvar");
        btnSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarActionPerformed(evt);
            }
        });

        lblDadosObrigatorios.setText("* Dados obrigatórios");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblDadosObrigatorios)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnSair, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lblLogin)
                            .addComponent(fmtSenha)
                            .addComponent(txfNome)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(fmtDataNascimento)
                                    .addComponent(lblDataNascimento, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(fmtDataUltimoLogin)
                                    .addComponent(lblDataUltimoLogin)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txfLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 271, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnPesquisar))
                            .addComponent(lblNome)
                            .addComponent(btnSenha)
                            .addComponent(lblSalario)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(fmtSalario, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(57, 57, 57))
                            .addComponent(chbxAtivo))
                        .addGap(0, 12, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblLogin)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txfLogin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnSenha)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(fmtSenha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblNome)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txfNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblDataNascimento)
                    .addComponent(lblDataUltimoLogin))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(fmtDataNascimento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(fmtDataUltimoLogin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblSalario)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(fmtSalario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(chbxAtivo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSair)
                    .addComponent(btnSalvar)
                    .addComponent(lblDadosObrigatorios))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPesquisarActionPerformed
        if (estado == TipoEstado.INDEFINIDO) {
            if (txfLogin.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Login deve ser informado para pesquisa.");
            }
            else {
                if (controlador.existeUsuario(txfLogin.getText())) {
                    UsuarioModel usuario = controlador.getUsuario(txfLogin.getText());
                    String senha = JOptionPane.showInputDialog("Apenas o usuário pode editar/excluir seu registro. Digite sua senha para confirmação: ");                    
                    if (controlador.verificarAcesso(usuario, senha)) {
                        int escolha = JOptionPane.showOptionDialog(null,
                                                       "Acesso permitido. Deseja editar ou excluir o registro?",
                                                       "Escolha uma opção", 
                                                       JOptionPane.YES_NO_OPTION, 
                                                       JOptionPane.QUESTION_MESSAGE, 
                                                       null, 
                                                       new String[]{"Excluir","Editar"}, 
                                                       "Editar");
                        if (escolha == 1) {
                            estado = TipoEstado.EDIT;                        
                            carregaUsuario(controlador.getUsuario(txfLogin.getText()));
                        }
                        else {
                            controlador.removerUsuario(controlador.getUsuario(txfLogin.getText()));
                            JOptionPane.showMessageDialog(null, "Usuário \"" + txfLogin.getText() + "\" removido.");
                            habilitarDesabilitarComponentes(false);
                        }
                    }
                    else if (!senha.isEmpty()){
                        JOptionPane.showMessageDialog(null, "Acesso negado.", "Verificação de senha", JOptionPane.ERROR_MESSAGE);
                    }
                }                        
                else {
                    if (JOptionPane.showConfirmDialog(null, "O login informado não existe. Deseja cadastrar um novo usuário?", "Novo usuário?", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
                        estado = TipoEstado.INSERT;
                        habilitarDesabilitarComponentes(true);                     
                    }
                }
                
            }
        }
    }//GEN-LAST:event_btnPesquisarActionPerformed

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed
        if (validaInformacoesUsuario()) {
            salvaUsuario();
        }
    }//GEN-LAST:event_btnSalvarActionPerformed
    
    private void btnSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSairActionPerformed
        validaSairPrograma();
    }//GEN-LAST:event_btnSairActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnPesquisar;
    private javax.swing.JButton btnSair;
    private javax.swing.JButton btnSalvar;
    private javax.swing.JLabel btnSenha;
    private javax.swing.JCheckBox chbxAtivo;
    private javax.swing.JFormattedTextField fmtDataNascimento;
    private javax.swing.JFormattedTextField fmtDataUltimoLogin;
    private javax.swing.JFormattedTextField fmtSalario;
    private javax.swing.JPasswordField fmtSenha;
    private javax.swing.JLabel lblDadosObrigatorios;
    private javax.swing.JLabel lblDataNascimento;
    private javax.swing.JLabel lblDataUltimoLogin;
    private javax.swing.JLabel lblLogin;
    private javax.swing.JLabel lblNome;
    private javax.swing.JLabel lblSalario;
    private javax.swing.JTextField txfLogin;
    private javax.swing.JTextField txfNome;
    // End of variables declaration//GEN-END:variables
}
