package com.bank.app;

import com.bank.db.ClientDB;
import com.bank.models.Client;
import com.bank.services.Utils;
import javax.swing.*;

public class Register {

    public static void createClientFromUi() {
        int axisX = 1080;
        int axisY = 720;

        int labelWidth = 80;
        int fieldWidth = 200;
        int buttonWidth = 100;
        int statusWidth = 200;

        JFrame janela = new JFrame("Register");
        janela.setSize(axisX, axisY);
        janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        janela.setLayout(null);
        janela.setResizable(true);

        // Username
        JLabel usernameLabel = new JLabel("Username:");
        usernameLabel.setBounds((axisX - labelWidth) / 2, 100, labelWidth, 25);
        janela.add(usernameLabel);

        JTextField usernameField = new JTextField();
        usernameField.setBounds((axisX - fieldWidth) / 2, 130, fieldWidth, 25);
        janela.add(usernameField);

        // Email
        JLabel emailLabel = new JLabel("Email:");
        emailLabel.setBounds((axisX - labelWidth) / 2, 170, labelWidth, 25);
        janela.add(emailLabel);

        JTextField emailField = new JTextField();
        emailField.setBounds((axisX - fieldWidth) / 2, 200, fieldWidth, 25);
        janela.add(emailField);

        // Password
        JLabel passwordLabel = new JLabel("Password:");
        passwordLabel.setBounds((axisX - labelWidth) / 2, 240, labelWidth, 25);
        janela.add(passwordLabel);

        JPasswordField passwordField = new JPasswordField();
        passwordField.setBounds((axisX - fieldWidth) / 2, 270, fieldWidth, 25);
        janela.add(passwordField);

        // Phone
        JLabel phoneLabel = new JLabel("Phone (optional):");
        phoneLabel.setBounds(
            (axisX - labelWidth) / 2,
            300,
            labelWidth + 100,
            25
        );
        janela.add(phoneLabel);

        JTextField phoneField = new JTextField();
        phoneField.setBounds((axisX - fieldWidth) / 2, 330, fieldWidth, 25);
        janela.add(phoneField);

        // Register Button
        JButton registerButton = new JButton("Register");
        registerButton.setBounds(
            (axisX - buttonWidth) / 2,
            360,
            buttonWidth,
            25
        );
        janela.add(registerButton);

        JLabel statusLabel = new JLabel("");
        statusLabel.setBounds(
            (axisX - labelWidth) / 2,
            400,
            labelWidth + 300,
            25
        );
        janela.add(statusLabel);

        registerButton.addActionListener(e -> {
            String username = usernameField.getText();
            String email = emailField.getText();
            String password = new String(passwordField.getPassword());
            String phone = phoneField.getText();

            // -- BUTTON FUNCTION --
            // Validate inputs
            if (username.isEmpty() || email.isEmpty() || password.isEmpty()) {
                statusLabel.setText(
                    "All fields are required. Please try again."
                );
            }

            if (!Utils.isValidEmail(email)) {
                statusLabel.setText("Invalid email format. Please try again.");
            }

            if (phone != null && !phone.isEmpty()) {
                if (!Utils.isValidPhone(phone)) {
                    statusLabel.setText(
                        "Invalid phone number format. Please try again."
                    );
                }
            }
            if (!Utils.isValidPassword(password)) {
                statusLabel.setText(
                    "Invalid password format. Please try again."
                );
            }
        });
        janela.setVisible(true);
    }
}
