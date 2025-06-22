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
 * @author myself
 */
public class DatabaseManager {

    private static final String URL = "jdbc:sqlite:barber.db";

    public static Connection connect() {
        try {
            return DriverManager.getConnection(URL);
        } catch (SQLException e) {
            System.out.println("Erro na ligação à BD: " + e.getMessage());
            return null;
        }
    }

    public static void initDB() throws SQLException {
        try (Connection conn = connect(); java.sql.Statement stmt = conn.createStatement()) {
// Tabela Utilizadores
            String sqlUtilizadores = "CREATE TABLE IF NOT EXISTS utilizadores ("
                    + "id INTEGER PRIMARY KEY AUTOINCREMENT,"
                    + "nome TEXT NOT NULL,"
                    + "username TEXT NOT NULL UNIQUE,"
                    + "password TEXT NOT NULL,"
                    + "email TEXT,"
                    + "telefone TEXT"
                    + ");";

// Tabela Barbeiros
            String sqlBarbeiros = "CREATE TABLE IF NOT EXISTS barbeiros ("
                    + "id INTEGER PRIMARY KEY AUTOINCREMENT,"
                    + "nome TEXT NOT NULL,"
                    + "username TEXT NOT NULL UNIQUE,"
                    + "password TEXT NOT NULL,"
                    + "especialidade TEXT,"
                    + "email TEXT"
                    + ");";

// Tabela Agendamentos
            String sqlAgendamentos = "CREATE TABLE IF NOT EXISTS agendamentos ("
                    + "id INTEGER PRIMARY KEY AUTOINCREMENT,"
                    + "cliente_id INTEGER NOT NULL,"
                    + "barbeiro_id INTEGER NOT NULL,"
                    + "data TEXT NOT NULL,"
                    + "hora TEXT NOT NULL,"
                    + "servico TEXT NOT NULL,"
                    + "estado TEXT DEFAULT 'pendente',"
                    + "FOREIGN KEY (cliente_id) REFERENCES utilizadores(id),"
                    + "FOREIGN KEY (barbeiro_id) REFERENCES barbeiros(id)"
                    + ");";

// Tabela Reviews
            // Tabela Reviews
            String sqlReviews = "CREATE TABLE IF NOT EXISTS reviews ("
                    + "id INTEGER PRIMARY KEY AUTOINCREMENT,"
                    + "rating INTEGER NOT NULL,"
                    + "comentario TEXT NOT NULL,"
                    + "barbeiro_id INTEGER, " // Agora esta coluna é opcional (pode ser NULL)
                    + "cliente_id INTEGER, "
                    + "FOREIGN KEY (barbeiro_id) REFERENCES barbeiros(id),"
                    + "FOREIGN KEY (cliente_id) REFERENCES utilizadores(id)"
                    + ");";

// Execute a criação da tabela
            stmt.execute(sqlReviews);

// Agora, se a tabela já existir e a coluna tiver a restrição NOT NULL, tentamos alterá-la
            try {
                stmt.executeUpdate("ALTER TABLE reviews RENAME TO reviews_old"); // Renomeia a tabela original
                stmt.executeUpdate("CREATE TABLE reviews ("
                        + "id INTEGER PRIMARY KEY AUTOINCREMENT,"
                        + "rating INTEGER NOT NULL,"
                        + "comentario TEXT NOT NULL,"
                        + "barbeiro_id INTEGER, "
                        + "cliente_id INTEGER, "
                        + "FOREIGN KEY (barbeiro_id) REFERENCES barbeiros(id),"
                        + "FOREIGN KEY (cliente_id) REFERENCES utilizadores(id)"
                        + ");");  // Cria a nova tabela sem a restrição NOT NULL

                // Copiar os dados da tabela antiga para a nova
                stmt.executeUpdate("INSERT INTO reviews (id, rating, comentario, barbeiro_id, cliente_id)"
                        + " SELECT id, rating, comentario, barbeiro_id, cliente_id FROM reviews_old");

                stmt.executeUpdate("DROP TABLE reviews_old");  // Apaga a tabela antiga
                System.out.println("Tabela reviews atualizada com sucesso!");
            } catch (SQLException e) {
                if (!e.getMessage().contains("duplicate column name")) {
                    System.out.println("Erro ao tentar alterar a tabela reviews: " + e.getMessage());
                }
            }
        }
    }

    public static Connection getConnection() {
        return connect(); // Retorna a conexão à BD
    }
}
