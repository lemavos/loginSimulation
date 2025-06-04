package com.bank.client;

import java.util.ArrayList;
import java.util.List;

public class ClientManager {
    private List<Client> clients = new ArrayList<>();

    public void createClientFromUi() {
        Client client = Client.createClientUi();
        if (client == null) {
            System.out.println("Client creation failed. Please try again.");
            return;
        }
        clients.add(client);
    }
}
