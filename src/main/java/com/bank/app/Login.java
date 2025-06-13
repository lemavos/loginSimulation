package com.bank.app;

import com.bank.db.ClientDB;
import com.bank.services.Utils;

public class Login {

    public static void login() {
        ClientDB db = new ClientDB();

        System.out.print("Enter your Email: ");
        String email = Utils.input();

        System.out.print("Enter your Password: ");
        String password = Utils.input();

        boolean logged = db.authenticateClient(email, password);

        if (logged) {
            System.out.println("Logged in successfully!");
        } else {
            System.out.println("[!] Email or password incorrect.");
        }
    }
}
