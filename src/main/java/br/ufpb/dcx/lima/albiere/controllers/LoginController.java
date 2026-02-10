package br.ufpb.dcx.lima.albiere.controllers;

import br.ufpb.dcx.lima.albiere.sistema.SistemaRegistrador;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.security.NoSuchAlgorithmException;

public class LoginController implements ActionListener {
    private SistemaRegistrador sistema;
    private JFrame janela;
    
    public LoginController(SistemaRegistrador sistema, JFrame janela) {
        this.sistema=sistema;
        this.janela=janela;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        login();
    }
    
    public void registrar() throws NoSuchAlgorithmException {
        String usuario = JOptionPane.showInputDialog(janela, "Digite seu usuário:", "Registro - GateKeepers", JOptionPane.QUESTION_MESSAGE);
        String senha = JOptionPane.showInputDialog(janela, "Digite sua senha:", "Registro - GateKeepers", JOptionPane.QUESTION_MESSAGE);
        if (sistema.registrarLogin(usuario, senha)) {
            login();
        } else {
            JOptionPane.showMessageDialog(janela, "Este usuário já existe!", "Registro - GatekKeepers", JOptionPane.QUESTION_MESSAGE);
        }
    }
    
    public void login() {
        String usuario = JOptionPane.showInputDialog(janela, "Digite seu usuário:", "Login - GateKeepers", JOptionPane.QUESTION_MESSAGE);
        String senha = JOptionPane.showInputDialog(janela, "Digite sua senha:", "Login - GateKeepers", JOptionPane.QUESTION_MESSAGE);
        if(!sistema.procurarUsuarioLogin(usuario)) {
            String outraEscolha = JOptionPane.showInputDialog(janela, "Usuario não encontrado, deseja se registrar?", "Menu De Login - GateKeepers", JOptionPane.QUESTION_MESSAGE);
            if (outraEscolha.equalsIgnoreCase("Sim") || outraEscolha.equalsIgnoreCase("S")) {
                try {
                    registrar();
                } catch (NoSuchAlgorithmException ex) {
                    throw new RuntimeException(ex);
                }
            } else {
                JOptionPane.showMessageDialog(janela, "Saindo...", "Login - GatekKeepers", JOptionPane.QUESTION_MESSAGE);
                System.exit(0);
            }
        } else {
            try {
                if (!sistema.login(usuario, senha)) {
                    JOptionPane.showMessageDialog(janela, "Senha Incorreta", "Login - GatekKeepers", JOptionPane.QUESTION_MESSAGE);
                }
            } catch (NoSuchAlgorithmException ex) {
                throw new RuntimeException(ex);
            }
        }
    }
}
