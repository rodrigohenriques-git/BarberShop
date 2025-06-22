/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rodrigo.models;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import rodrigo.Utils.DatabaseManager;


/**
 *
 * @author myself
 */
public class BarbeiroDAO {

// Verifica se o barbeiro existe na base de dados
    public boolean barbeiroExists(String username) {
        String sql = "SELECT id FROM barbeiros WHERE username = ?";
        try (Connection conn = DatabaseManager.connect(); PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, username);
            ResultSet rs = stmt.executeQuery();
            return rs.next(); // true se existir
        } catch (SQLException e) {
            System.out.println("Erro ao verificar barbeiro: " + e.getMessage());
            return false;
        }
    }

// Regista novo barbeiro na base de dados
    public boolean registarBarbeiro(Barbeiro barbeiro) {
        String sql = "INSERT INTO barbeiros (nome, username, password, cargo) VALUES (?, ?, ?, ?)";
        try (Connection conn = DatabaseManager.connect(); PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, barbeiro.getNome());
            stmt.setString(2, barbeiro.getUsername());
            stmt.setString(3, barbeiro.getPassword());
            stmt.setString(4, barbeiro.getCargo());

            int rowsInserted = stmt.executeUpdate();
            return rowsInserted > 0;
        } catch (SQLException e) {
            System.out.println("Erro ao registar barbeiro: " + e.getMessage());
            return false;
        }
    }

    // Autenticação de login para barbeiros
    public boolean autenticarBarbeiro(String username, String password) {
        String sql = "SELECT id FROM barbeiros WHERE username = ? AND password = ?";
        try (Connection conn = DatabaseManager.connect(); PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, username);
            stmt.setString(2, password);
            ResultSet rs = stmt.executeQuery();
            return rs.next(); // true se encontrou
        } catch (SQLException e) {
            System.out.println("Erro no login do barbeiro: " + e.getMessage());
            return false;
        }
    }
}
