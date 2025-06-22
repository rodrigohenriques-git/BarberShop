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
public class UserDAO {

// Verifica se o username já existe na base de dados
    public boolean usernameExists(String username) {
        String sql = "SELECT id FROM utilizadores WHERE username = ?";
        try (Connection conn = DatabaseManager.connect(); PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, username);
            ResultSet rs = stmt.executeQuery();
            return rs.next(); // true se existir
        } catch (SQLException e) {
            System.out.println("Erro ao verificar username: " + e.getMessage());
            return false;
        }
    }

// Regista o novo utilizador na base de dados
    public boolean registarUtilizador(User user) {
        String sql = "INSERT INTO utilizadores (nome, username, password, email, telefone, tipo) VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection conn = DatabaseManager.connect(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, user.getNome());
            stmt.setString(2, user.getUsername());
            stmt.setString(3, user.getPassword());
            stmt.setString(4, user.getEmail());
            stmt.setString(5, user.getTelefone());
            stmt.setString(6, user.getTipo());
            int rowsInserted = stmt.executeUpdate();
            return rowsInserted > 0;
        } catch (SQLException e) {
            System.out.println("Erro ao registar utilizador: " + e.getMessage());
            return false;
        }
    }

// Autenticação de login
    public String autenticar(String username, String password) {
        String sql = "SELECT tipo FROM utilizadores WHERE username = ? AND password = ?";
        try (Connection conn = DatabaseManager.connect(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, username);
            stmt.setString(2, password);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return rs.getString("tipo");  // Devolve o tipo (cliente ou barbeiro)
            } else {
                return null;  // Retorna null se não encontrar o utilizador
            }
        } catch (SQLException e) {
            System.out.println("Erro no login: " + e.getMessage());
            return null;
        }
    }
}

