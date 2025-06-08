package com.bank.client;

import java.sql.*;

public class ClientDB {

    private Connection connect() {
        String url = "jdbc:sqlite:clients.db";
        try {
            return DriverManager.getConnection(url);
        } catch (SQLException e) {
            System.out.println("[!] Error connecting to DB: " + e.getMessage());
            return null;
        }
    }

    public void createTableIfNotExists() {
        String sql = "CREATE TABLE IF NOT EXISTS clients (" +
                     "id TEXT PRIMARY KEY," +
                     "status INTEGER," +
                     "credit TEXT," +
                     "name TEXT," +
                     "email TEXT," +
                     "phone TEXT" +
                     ");";

        try (Connection conn = connect(); Statement stmt = conn.createStatement()) {
            stmt.execute(sql);
            System.out.println("Table 'clients' ready.");
        } catch (SQLException e) {
            System.out.println("[!] Error creating table: " + e.getMessage());
        }
    }

    public void insertOrUpdateClient(Client client) {
        String sql = "INSERT INTO clients(id, status, credit, name, email, phone) VALUES (?, ?, ?, ?, ?, ?) "
                + "ON CONFLICT(id) DO UPDATE SET "
                + "status=excluded.status, "
                + "credit=excluded.credit, "
                + "name=excluded.name, "
                + "email=excluded.email, "
                + "phone=excluded.phone;";

        try (Connection conn = connect(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, client.getId());
            pstmt.setInt(2, client.getStatus() ? 1 : 0);
            pstmt.setString(3, client.getCredit().toPlainString());
            pstmt.setString(4, client.getName());
            pstmt.setString(5, client.getEmail());
            pstmt.setString(6, client.getPhone());

            pstmt.executeUpdate();
            System.out.println("Client saved: " + client.getName());
        } catch (SQLException e) {
            System.out.println("[1] Error saving client: " + e.getMessage());
        }
    }
}
