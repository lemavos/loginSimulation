package com.bank.menus;

import com.bank.services.Utils;

public class Banners {

    public static void printWelcomeBanner() {
        System.out.println("+============================================+");
        System.out.println("|            🏦 BANK SIMULATION 🏦           |");
        System.out.println("|                                            |");
        System.out.println("|        Welcome to our Banking System!      |");
        System.out.println("+============================================+");
    }

    public static void printMainMenuBanner() {
        System.out.println("+================= MAIN MENU ================+");
        System.out.println("|                                            |");
        System.out.println("|  [ 1 ]  Create New Account                 |");
        System.out.println("|  [ 2 ]  Login to Account                   |");
        System.out.println("|  [ 3 ]  Exit                               |");
        System.out.println("|                                            |");
        System.out.println("+============================================+");
    }

    public static void printCreateAccountBanner() {
        Utils.clearTerminal();
        System.out.println("+=====================================+");
        System.out.println("|            CREATE ACCOUNT           |");
        System.out.println("+=====================================+");
    }

    public static void printLoginBanner() {
        Utils.clearTerminal();
        System.out.println("+=====================================+");
        System.out.println("|               LOGIN                 |");
        System.out.println("+=====================================+");
    }
}
