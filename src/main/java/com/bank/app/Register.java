package com.bank.app;

import com.bank.db.ClientDB;
import com.bank.models.Client;
import com.bank.services.Utils;

public class Register {

    public static void createClientFromUi() {
        Utils.clearTerminal();

        Client client = Client.createClientUi();
        if (client == null) {
            System.out.println("Client creation failed. Please try again.");
            return;
        }
        // create DB and table
        ClientDB db = new ClientDB();
        db.createTableIfNotExists();

        // Saves the client in the database
        db.createDBClient(client);
    }
}
