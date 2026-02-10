package br.ufpb.dcx.lima.albiere.gui;

import br.ufpb.dcx.lima.albiere.controllers.LoginController;
import br.ufpb.dcx.lima.albiere.controllers.PesquisarSenhaPorAplicativoController;
import br.ufpb.dcx.lima.albiere.sistema.SistemaRegistrador;

import javax.swing.*;
import java.awt.*;

public class GuiV3BaseAyla extends JFrame {

    JMenuBar barraDeMenu = new JMenuBar();

    public GuiV3BaseAyla() {
        setTitle("Gerenciador de Senhas");
        setSize(800, 600); //tamanho da janela
        setLocation(150, 150);
        setResizable(false);
        setBackground(Color.white);
        setLayout(new GridLayout(3, 1));
        add(new JLabel());
        SistemaRegistrador sistema = new SistemaRegistrador();
        JMenu menuCadastrar = new JMenu("Usuario");
        JMenuItem menuCadastrarSenha = new JMenuItem(
                "Trocar Usuário");
        menuCadastrar.add(menuCadastrarSenha);
        JMenu menuPesquisar = new JMenu("Pesquisar");
        JMenuItem menuPesquisarSenha = new JMenuItem(
                "Pesquisar Senha");
        menuPesquisar.add(menuPesquisarSenha);
        JMenu menuRemover = new JMenu("Remover");
        JMenuItem menuRemoverSenha = new JMenuItem(
                "Remover Senha");
        menuRemover.add(menuRemoverSenha);
        menuPesquisarSenha.addActionListener(
                new PesquisarSenhaPorAplicativoController(sistema, this));
        JMenu menuLogin = new JMenu("Trocar Usuário");
        JMenuItem menuTrocarUser = new JMenuItem("Alterar");
        menuLogin.add(menuTrocarUser);
        menuTrocarUser.addActionListener(
            new LoginController(sistema, this)
        );
        barraDeMenu.add(menuCadastrar);
        barraDeMenu.add(menuPesquisar);
        barraDeMenu.add(menuRemover);
        barraDeMenu.add(menuTrocarUser);
        setJMenuBar(barraDeMenu);
    }
}
    //...
//    public static void main(String[] args) {
//        JFrame janela = new GuiV3BaseAyla();
//        janela.setVisible(true);
//        janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//    }
//}
