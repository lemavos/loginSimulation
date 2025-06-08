package com.bank.client;
import java.util.Random;

public class IdGen {
    public String generateId() {
        String characters = "abcdefghijklmnopqrstuvwxyz1234567890";
        StringBuilder id = new StringBuilder();
        Random rand = new Random();

        for (int i = 0; i < 15; i++) {
            int index = rand.nextInt(characters.length());
            id.append(characters.charAt(index));
        }
        return id.toString();
    }
}
