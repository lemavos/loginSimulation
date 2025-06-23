package com.bank.menus;

import com.bank.app.Login;
import com.bank.app.Register;
import com.bank.services.Utils;
import javax.swing.*;

public class MainMenu {

    public static void main(String[] args) {
        JFrame root = new JFrame("Login");
        root.setSize(350, 250);
        root.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        root.setLayout(null);
        root.setResizable(true);

        showMainMenu(root);

        root.setVisible(true);
    }

    private static void showMainMenu(JFrame root) {
        JButton loginButton = new JButton("Login");
        loginButton.setBounds(100, 60, 120, 30);
        root.add(loginButton);
        loginButton.addActionListener(e -> {
            root.dispose();
            Login.login();
        });

        JButton registerButton = new JButton("Register");
        registerButton.setBounds(100, 110, 120, 30);
        root.add(registerButton);
        registerButton.addActionListener(e -> {
            root.dispose();
            Register.createClientFromUi();
        });
    }
}
