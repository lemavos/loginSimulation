package com.bank.client;

import java.util.List;

import com.bank.lib.Utils;

import java.math.BigDecimal;

public class Transaction {
    private List<Client> clients;

    public Transaction(List<Client> clients) {
        this.clients = clients;
    }

    public void transactionUi() {
        System.out.println("\nInitiating transaction...");
        System.out.print("Sender ID: ");
        String senderId = Utils.input();
        System.out.print("Receiver ID: ");
        String receiverId = Utils.input();
        System.out.print("Amount: ");
        BigDecimal amount;

        try {
            amount = new BigDecimal(Utils.input());
        } catch (NumberFormatException e) {
            System.out.println("\nInvalid amount. Please enter a valid number.");
            return;
        }

        Client sender = findClientById(senderId);
        Client receiver = findClientById(receiverId);

        if (sender == null || receiver == null) {
            System.out.println("\nTransaction failed. One or both clients not found.");
            return;
        }

        transaction(sender, receiver, amount);
    }

    private Client findClientById(String id) {
        for (Client c : clients) {
            if (c.getId().equals(id)) {
                return c;
            }
        }
        return null;
    }

    public static void transaction(Client sender, Client receiver, BigDecimal amount) {
        if (!sender.getStatus() || !receiver.getStatus()) {
            System.out.println("\nTransaction failed. One or both clients are not active.");
            return;
        }
        if (amount.compareTo(BigDecimal.ZERO) <= 0) {
            System.out.println("\nTransaction failed. Amount must be greater than zero.");
            return;
        }
        if (sender.getCredit().compareTo(amount) < 0) {
            System.out.println("\nTransaction failed. Insufficient credit for client " + sender.getId() + ".");
            return;
        }
        sender.setCredit(sender.getCredit().subtract(amount));
        receiver.setCredit(receiver.getCredit().add(amount));
        System.out.println("\nTransaction between " + sender.getId() + " and " + receiver.getId() + " is successful.");
    }
}