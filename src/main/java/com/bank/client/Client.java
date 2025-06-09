package com.bank.client;

import com.bank.lib.EmailSender;
import com.bank.lib.IdGen;
import com.bank.lib.Utils;
import com.bank.lib.ValCodeGen;
import java.math.BigDecimal;

public class Client {

    private String id;
    private boolean status;
    private BigDecimal credit;
    private String name;
    private String email;
    private String phone;
    private String password;
    private transient String validateCode;

    private Client(String name, String email, String phone, String password) {
        createClient(name, email, phone, password);
    }

    public static Client createClientUi() {
        System.out.println("\nWelcome to the Client Creation Interface!");
        System.out.println(
            "Please provide the following details to create a new client:"
        );

        System.out.print("Enter name: ");
        String name = Utils.input();
        System.out.print("Enter email: ");
        String email = Utils.input();
        System.out.print("Enter phone (optional): ");
        String phone = Utils.input();
        System.out.print("Enter password: ");
        String password = Utils.input();

        // Validate inputs
        if (name.isEmpty() || email.isEmpty() || password.isEmpty()) {
            System.out.println(
                "[!] All fields are required. Please try again."
            );
            return null;
        }
        if (!Utils.isValidEmail(email)) {
            System.out.println("[!] Invalid email format. Please try again.");
            return null;
        }
        if (phone != null && !phone.isEmpty()) {
            if (!Utils.isValidPhone(phone)) {
                System.out.println(
                    "[!] Invalid phone number format. Please try again."
                );
            }
        }
        if (!Utils.isValidPassword(password)) {
            System.out.println(
                "[!] Invalid password format. Please try again."
            );
            return null;
        }

        Client client = new Client(name, email, phone, password);
        client.validateCode = ValCodeGen.generateCode();
        EmailSender.sendValEmail(client.email, client.validateCode);

        boolean activated = client.activateClient();
        if (!activated) {
            System.out.println(
                "[!] Client creation failed due to invalid code."
            );
            return null;
        }

        client.info();
        return client;
    }

    private void info() {
        System.out.println("\nClient Information:");
        System.out.println("  Name: " + this.name);
        System.out.println("  Email: " + this.email);
        System.out.println("  Phone: " + this.phone);
        System.out.println("  ID: " + this.id);
        System.out.println("  Status: " + this.status);
        System.out.println("  Credit: " + this.credit);
    }

    private void createClient(
        String name,
        String email,
        String phone,
        String password
    ) {
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.id = new IdGen().generateId();
        this.status = false;
        this.credit = new BigDecimal(0);
        this.password = password;
        System.out.println("\nClient created with ID: " + this.id);
    }

    private boolean activateClient() {
        System.err.println("Val code: " + this.validateCode); // remove after tests
        System.out.print("Insert validation code: ");
        String codeInsert = Utils.input();
        if (codeInsert.isEmpty()) {
            System.out.println("\n[!] Code validation is empty");
            return false;
        }

        if (codeInsert.equals(this.validateCode)) {
            this.status = true;
            System.out.println("\nClient activated with ID: " + this.id);
            return true;
        } else {
            System.out.println("[!] Invalid validation code");
            return false;
        }
    }

    // criar uma ui pra isso
    public void deleteClient(Client client) {
        if (client.credit.compareTo(BigDecimal.ZERO) > 0) {
            System.out.println(
                "\n[!] Client cannot be deleted. Credit must be zero."
            );
            return;
        }
        client.status = false;
        System.out.println("\nClient deleted with ID: " + client.id);
    }

    // Getters
    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public String getPassword() {
        return password;
    }

    public BigDecimal getCredit() {
        return credit;
    }

    public boolean getStatus() {
        return status;
    }

    // Setters
    public void setCredit(BigDecimal credit) {
        this.credit = credit;
    }
}
