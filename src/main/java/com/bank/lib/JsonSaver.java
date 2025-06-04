package com.bank.lib;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import com.bank.client.Client;

public class JsonSaver {

    public static void saveClientsToJson(Map<String, Client> clients, String filePath) {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        try (FileWriter writer = new FileWriter(filePath)) {
            gson.toJson(clients, writer);
            System.out.println("Clients saved to JSON successfully.");
        } catch (IOException e) {
            System.out.println("Failed to save clients: " + e.getMessage());
        }
    }
}

