/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rodrigo.Utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author mysel
 */
public class DatabaseConnection {

    public static Connection connect() {
        try {
            // Defina o caminho para a base de dados
            String url = "jdbc:sqlite:barber.db"; // Atualize para o local da sua base de dados
            Connection conn = DriverManager.getConnection(url);
            return conn;
        } catch (SQLException e) {
            System.out.println("Erro na conexão com a base de dados: " + e.getMessage());
        }
        return null;
    }
}
