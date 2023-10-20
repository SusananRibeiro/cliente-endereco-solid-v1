package com.cadastro.useCases.clientes.impl.mappers;
import com.cadastro.entitys.Clientes;
import com.cadastro.useCases.clientes.domains.ClientesRequestDom;
import com.cadastro.useCases.clientes.domains.ClientesResponseDom;

public class ClientesMapper {

    // Convertendo Clientes para ClientesResponse
    public static ClientesResponseDom clientesToClientesResponseDom(Clientes clientes) {
        ClientesResponseDom out = new ClientesResponseDom();
        out.setId(clientes.getId());
        out.setNome(clientes.getNome());
        out.setSobrenome(clientes.getSobrenome());
        out.setDataNascimento(clientes.getDataNascimento());
        out.setEmail(clientes.getEmail());
        out.setTelefone(clientes.getTelefone());

        return out;

    }

    // Convertendo ClientesRequestDom para Clientes
    public static Clientes clientesResquestDomToClientes(ClientesRequestDom clientesRequestDom) {
        Clientes out = new Clientes();
        out.setNome(clientesRequestDom.getNome());
        out.setSobrenome(clientesRequestDom.getSobrenome());
        out.setDataNascimento(clientesRequestDom.getDataNascimento());
        out.setEmail(clientesRequestDom.getEmail());
        out.setTelefone(clientesRequestDom.getTelefone());
        return out;

    }

}
