/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rodrigo.models;

import java.time.LocalDate;

/**
 *
 * @author myself
 */
public class Agendamento {

    private int clienteId;
    private int barbeiroId;
    private LocalDate data;
    private String hora;
    private String servico;

    public Agendamento(int clienteId, int barbeiroId, LocalDate data, String hora, String servico) {
        this.clienteId = clienteId;
        this.barbeiroId = barbeiroId;
        this.data = data;
        this.hora = hora;
        this.servico = servico;
    }

    public int getClienteId() {
        return clienteId;
    }

    public int getBarbeiroId() {
        return barbeiroId;
    }

    public LocalDate getData() {
        return data;
    }

    public String getHora() {
        return hora;
    }

    public String getServico() {
        return servico;
    }
}

