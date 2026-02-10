package br.ufpb.dcx.lima.albiere;

import br.ufpb.dcx.lima.albiere.gui.GuiV3BaseAyla;

import javax.swing.*;

public class ProgramaGerenciador {
    public static void main(String[] args) {
        JFrame janela = new GuiV3BaseAyla();
        janela.setVisible(true);
        janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
