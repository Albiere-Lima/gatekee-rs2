package br.ufpb.dcx.lima.albiere.controllers;

import br.ufpb.dcx.lima.albiere.exceptions.AplicativoInexistenteException;
import br.ufpb.dcx.lima.albiere.sistema.Registrador;
import br.ufpb.dcx.lima.albiere.sistema.SistemaRegistrador;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class PesquisarSenhaPorAplicativoController implements ActionListener {

    private SistemaRegistrador sistema;
    private JFrame janela;

    public PesquisarSenhaPorAplicativoController(SistemaRegistrador sistema, JFrame janela) {
        this.sistema=sistema;
        this.janela=janela;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            String nome = JOptionPane.showInputDialog("Nome do aplicativo:");
            List<Registrador> rg = sistema.procuraAplicativo(nome);
            for (Registrador r : rg) {
                JOptionPane.showMessageDialog(null, "==========================\n" +
                        "Aplicativo: " + r.getAplicativo() + "\n" +
                        "Usuário: " + r.getUsuario() + "\n" +
                        "Email: " + r.getEmail() + "\n" +
                        "Senha: " + r.getSenha());
            }
        } catch (AplicativoInexistenteException er) {
            JOptionPane.showMessageDialog(null, er.getMessage());

        }
    }
}
