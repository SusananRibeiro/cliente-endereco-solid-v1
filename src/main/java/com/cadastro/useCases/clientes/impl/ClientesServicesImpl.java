package com.cadastro.useCases.clientes.impl;
import com.cadastro.useCases.clientes.ClientesServices;
import com.cadastro.useCases.clientes.domains.ClientesRequestDom;
import com.cadastro.useCases.clientes.domains.ClientesResponseDom;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ClientesServicesImpl implements ClientesServices {
    @Autowired
    private ClientesBusinessImpl clientesBusiness;

    @Override
    public List<ClientesResponseDom> carregarClientes() {
        return clientesBusiness.carregarClientes();
    }

    @Override
    public ClientesResponseDom criarCliente(ClientesRequestDom clientesRequestDom) {
        return clientesBusiness.criarCliente(clientesRequestDom);
    }

    @Override
    public ClientesResponseDom atualizarCliente(Long id, ClientesRequestDom clientesRequestDom) {
        return clientesBusiness.atualizarCliente(id, clientesRequestDom);
    }

    @Override
    public void deletarCliente(Long id) {
        clientesBusiness.deletarCliente(id);
    }
}
