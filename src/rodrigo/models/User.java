/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rodrigo.models;

/**
 *
 * @author myself
 */
public class User {

    private String nome;
    private String username;
    private String password;
    private String email;
    private String telefone;
    private final String tipo;

    public User(String nome, String username, String password, String email, String telefone) {
        this.nome = nome;
        this.username = username;
        this.password = password;
        this.email = email;
        this.telefone = telefone;
        this.tipo = "cliente"; // valor fixo por agora
    }

    public String getNome() {
        return nome;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

    public String getTelefone() {
        return telefone;
    }

    public String getTipo() {
        return tipo;
    }
}
