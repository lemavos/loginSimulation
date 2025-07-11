package com.app.gui;

import com.app.constants.CommonConstants;
import com.app.db.ClientDB;
import com.app.models.Client;
import com.app.services.EmailSender;
import com.app.services.Utils;
import com.app.services.ValCodeGen;
import javax.swing.*;

public class Register {

    public static void createClientFromUi() {
        int axisX = CommonConstants.AXIS_X;
        int axisY = CommonConstants.AXIS_Y;

        int labelWidth = 80;
        int fieldWidth = 200;
        int buttonWidth = 100;

        JFrame root = new JFrame("Register");
        root.setSize(axisX, axisY);
        root.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        root.setLayout(null);
        root.setResizable(true);

        // Username
        JLabel usernameLabel = new JLabel("Username:");
        usernameLabel.setBounds((axisX - labelWidth) / 2, 100, labelWidth, 25);
        root.add(usernameLabel);

        JTextField usernameField = new JTextField();
        usernameField.setBounds((axisX - fieldWidth) / 2, 130, fieldWidth, 25);
        root.add(usernameField);

        // Email
        JLabel emailLabel = new JLabel("Email:");
        emailLabel.setBounds((axisX - labelWidth) / 2, 170, labelWidth, 25);
        root.add(emailLabel);

        JTextField emailField = new JTextField();
        emailField.setBounds((axisX - fieldWidth) / 2, 200, fieldWidth, 25);
        root.add(emailField);

        // Password
        JLabel passwordLabel = new JLabel("Password:");
        passwordLabel.setBounds((axisX - labelWidth) / 2, 240, labelWidth, 25);
        root.add(passwordLabel);

        JPasswordField passwordField = new JPasswordField();
        passwordField.setBounds((axisX - fieldWidth) / 2, 270, fieldWidth, 25);
        root.add(passwordField);

        // Phone
        JLabel phoneLabel = new JLabel("Phone (optional):");
        phoneLabel.setBounds(
            (axisX - labelWidth) / 2,
            300,
            labelWidth + 100,
            25
        );
        root.add(phoneLabel);

        JTextField phoneField = new JTextField();
        phoneField.setBounds((axisX - fieldWidth) / 2, 330, fieldWidth, 25);
        root.add(phoneField);

        // Register Button
        JButton registerButton = new JButton("Register");
        registerButton.setBounds(
            (axisX - buttonWidth) / 2,
            360,
            buttonWidth,
            25
        );
        root.add(registerButton);

        JLabel statusLabel = new JLabel("");
        statusLabel.setBounds(
            (axisX - labelWidth) / 2,
            400,
            labelWidth + 300,
            25
        );
        root.add(statusLabel);

        registerButton.addActionListener(e -> {
            String username = usernameField.getText().trim();
            String email = emailField.getText().trim();
            String password = new String(passwordField.getPassword()).trim();
            String phone = phoneField.getText().trim();

            // Validações
            if (username.isEmpty() || email.isEmpty() || password.isEmpty()) {
                statusLabel.setText(
                    "All fields are required. Please try again."
                );
                return;
            }

            if (!Utils.isValidEmail(email)) {
                statusLabel.setText("Invalid email format. Please try again.");
                return;
            }

            if (!phone.isEmpty() && !Utils.isValidPhone(phone)) {
                statusLabel.setText(
                    "Invalid phone number format. Please try again."
                );
                return;
            }

            if (!Utils.isValidPassword(password)) {
                statusLabel.setText(
                    "Invalid password format. Please try again."
                );
                return;
            }

            statusLabel.setText(""); // limpa status

            // Criação do client
            Client client = new Client(username, email, phone, password);
            client.setValidateCode(ValCodeGen.generateCode());

            // Envia o código por email
            EmailSender.sendValEmail(
                client.getEmail(),
                client.getValidateCode()
            );

            // Pede código por JOptionPane
            String codeInsert = JOptionPane.showInputDialog(
                root,
                "A validation code was sent to your email.\nPlease enter the code:"
            );

            if (codeInsert == null || codeInsert.trim().isEmpty()) {
                statusLabel.setText("Validation cancelled or empty.");
                return;
            }

            if (!codeInsert.equals(client.getValidateCode())) {
                statusLabel.setText("Invalid code. Registration failed.");
                return;
            }

            // Salva no banco
            ClientDB db = new ClientDB();
            db.createTableIfNotExists();
            db.createDBClient(client);

            statusLabel.setText("Client registered successfully!");
        });

        root.setVisible(true);
    }
}
