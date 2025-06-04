package com.bank;

import com.bank.client.Client;
import com.bank.lib.Utils;
import com.bank.lib.JsonSaver;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Utils.clearTerminal();

        // Create a client (example data)
        Client client = new Client("John Doe", "john@example.com", "123456789");

        // Put the client in a map (using ID as key)
        Map<String, Client> clients = new HashMap<>();
        clients.put(client.getId(), client);

        // Save to JSON
        JsonSaver.saveClientsToJson(clients, "clients.json");
    }
}
