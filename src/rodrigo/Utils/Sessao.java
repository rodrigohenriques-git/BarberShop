/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package rodrigo.Utils;

/**
 *
 * @author mysel
 */
public class Sessao {

    private static int clienteId;
    private static int barbeiroIdSelecionado;

    public static void setClienteId(int id) {
        clienteId = id;
    }

    public static int getClienteId() {
        return clienteId;
    }

    public static void setBarbeiroIdSelecionado(int id) {
        barbeiroIdSelecionado = id;
    }

    public static int getBarbeiroIdSelecionado() {
        return barbeiroIdSelecionado;
    }
}
