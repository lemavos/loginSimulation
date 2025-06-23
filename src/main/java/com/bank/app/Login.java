package com.bank.app;

import com.bank.db.ClientDB;
import javax.swing.*;

public class Login {

    public static void login() {
        ClientDB db = new ClientDB();

        int axisX = 1080;
        int axisY = 720;

        int labelWidth = 80;
        int fieldWidth = 200;
        int buttonWidth = 100;
        int statusWidth = 200;

        JFrame root = new JFrame("Login");
        root.setSize(axisX, axisY);
        root.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        root.setLayout(null);
        root.setResizable(true);

        JLabel emailLabel = new JLabel("Email:");
        emailLabel.setBounds((axisX - labelWidth) / 2, 100, labelWidth, 25);
        root.add(emailLabel);

        JTextField emailField = new JTextField();
        emailField.setBounds((axisX - fieldWidth) / 2, 130, fieldWidth, 25);
        root.add(emailField);

        JLabel passwordLabel = new JLabel("Password:");
        passwordLabel.setBounds((axisX - labelWidth) / 2, 170, labelWidth, 25);
        root.add(passwordLabel);

        JPasswordField passwordField = new JPasswordField();
        passwordField.setBounds((axisX - fieldWidth) / 2, 200, fieldWidth, 25);
        root.add(passwordField);

        JButton loginButton = new JButton("Login");
        loginButton.setBounds((axisX - buttonWidth) / 2, 250, buttonWidth, 30);
        root.add(loginButton);

        JLabel labelStatus = new JLabel("");
        labelStatus.setBounds((axisX - statusWidth) / 2, 290, statusWidth, 20);
        root.add(labelStatus);

        loginButton.addActionListener(e -> {
            String email = emailField.getText();
            String password = new String(passwordField.getPassword());

            boolean logged = db.authenticateClient(email, password);

            if (logged) {
                labelStatus.setText("Logged in successfully!");
            } else {
                labelStatus.setText("[ ! ] Email or password incorrect.");
            }
        });

        root.setVisible(true);
    }
}
