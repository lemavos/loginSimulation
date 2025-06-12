package com.bank.db;

import com.bank.models.Client;
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

    public boolean authenticateClient(String email, String password) {
        String sql = "SELECT password FROM clients WHERE email = ?";

        try (
            Connection conn = connect();
            PreparedStatement pstmt = conn.prepareStatement(sql)
        ) {
            pstmt.setString(1, email);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                String storedPassword = rs.getString("password");
                return password.equals(storedPassword);
            } else {
                return false;
            }
        } catch (SQLException e) {
            System.out.println(
                "[!] Error during authentication: " + e.getMessage()
            );
            return false;
        }
    }

    public void createTableIfNotExists() {
        String sql =
            "CREATE TABLE IF NOT EXISTS clients (" +
            "id TEXT PRIMARY KEY," +
            "status INTEGER," +
            "credit TEXT," +
            "name TEXT," +
            "email TEXT," +
            "phone TEXT," +
            "password TEXT" +
            ");";

        try (
            Connection conn = connect();
            Statement stmt = conn.createStatement()
        ) {
            stmt.execute(sql);
            System.out.println("Table 'clients' ready.");
        } catch (SQLException e) {
            System.out.println("[!] Error creating table: " + e.getMessage());
        }
    }

    public void createDBClient(Client client) {
        String sql =
            "INSERT INTO clients(id, status, credit, name, email, phone, password) VALUES (?, ?, ?, ?, ?, ?, ?) " +
            "ON CONFLICT(id) DO UPDATE SET " +
            "status=excluded.status, " +
            "credit=excluded.credit, " +
            "name=excluded.name, " +
            "email=excluded.email, " +
            "phone=excluded.phone, " +
            "password=excluded.password";

        try (
            Connection conn = connect();
            PreparedStatement pstmt = conn.prepareStatement(sql)
        ) {
            pstmt.setString(1, client.getId());
            pstmt.setInt(2, client.getStatus() ? 1 : 0);
            pstmt.setString(3, client.getCredit().toPlainString());
            pstmt.setString(4, client.getName());
            pstmt.setString(5, client.getEmail());
            pstmt.setString(6, client.getPhone());
            pstmt.setString(7, client.getPassword());

            pstmt.executeUpdate();
            System.out.println("Client saved: " + client.getName());
        } catch (SQLException e) {
            System.out.println("[1] Error saving client: " + e.getMessage());
        }
    }
}
