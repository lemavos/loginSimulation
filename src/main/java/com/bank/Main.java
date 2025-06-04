package com.bank;

import com.bank.client.Client;
import com.bank.lib.Utils;
import com.bank.lib.JsonSaver;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Utils.clearTerminal();

        // Cria o cliente com interface de texto
        Client client = Client.createClientUi();

        // Mapeia os clientes usando o ID como chave
        Map<String, Client> clients = new HashMap<>();
        clients.put(client.getId(), client);

        // Salva em JSON
        JsonSaver.saveClientsToJson(clients, "clients.json");
    }
}

