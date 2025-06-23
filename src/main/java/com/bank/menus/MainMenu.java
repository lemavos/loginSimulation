package com.bank.menus;

import com.bank.app.Login;
import com.bank.app.Register;
import com.bank.services.Utils;
import javax.swing.*;

public class MainMenu {

    public static void main(String[] args) {
        JFrame janela = new JFrame("Login");
        janela.setSize(350, 250);
        janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        janela.setLayout(null);
        janela.setResizable(true);

        showMainMenu(janela);

        janela.setVisible(true);
    }

    private static void showMainMenu(JFrame janela) {
        JButton loginButton = new JButton("Login");
        loginButton.setBounds(100, 60, 120, 30);
        janela.add(loginButton);
        loginButton.addActionListener(e -> {
            janela.dispose();
            Login.login();
        });

        JButton registerButton = new JButton("Register");
        registerButton.setBounds(100, 110, 120, 30);
        janela.add(registerButton);
        registerButton.addActionListener(e -> {
            janela.dispose();
            handleCreateAccount();
        });
    }

    private static void handleCreateAccount() {
        Register.createClientFromUi();
        Utils.pressEnterToContinue();
    }
}
