package com.bank.menus;

import com.bank.client.Register;
import com.bank.lib.Utils;

public class MainMenu {

    private static boolean running = true;

    public static void main(String[] args) {
        while (running) {
            showMainMenu();
            handleMenuChoice();
        }

        System.out.println("\n Thank you for using Bank Simulation! Goodbye!");
    }

    private static void showMainMenu() {
        Utils.clearTerminal();

        MenuBanners.printWelcomeBanner();
        MenuBanners.printMainMenuBanner();

        System.out.print("Please select an option (1-3): ");
    }

    private static void handleMenuChoice() {
        String choice = Utils.input();

        System.out.println();

        switch (choice) {
            case "1":
                handleCreateAccount();
                break;
            case "2":
                handleLogin();
                break;
            case "3":
                handleExit();
                break;
            default:
                System.out.println(
                    "❌ Invalid option! Please select a number between 1-6."
                );
                Utils.pressEnterToContinue();
                break;
        }
    }

    private static void handleCreateAccount() {
        MenuBanners.printCreateAccountBanner();

        Register.createClientFromUi();
        Utils.pressEnterToContinue();
    }

    private static void handleLogin() {
        MenuBanners.printLoginBanner();

        // Fazer depois
        System.out.println("Not finished yet :(");

        Utils.pressEnterToContinue();
    }

    private static void handleExit() {
        System.out.println("+=====================================+");
        System.out.println("|                 GOODBYE             |");
        System.out.println("+=====================================+");
        System.out.println();
        System.out.println("[!] Are you sure you want to exit? (y/n): ");
        String confirm = Utils.input().trim().toLowerCase();

        if (confirm.equals("y") || confirm.equals("yes")) {
            running = false;
        } else {
            System.out.println("Returning to main menu...");
            Utils.pressEnterToContinue();
        }
    }
}
