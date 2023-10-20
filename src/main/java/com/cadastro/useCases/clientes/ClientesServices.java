package com.cadastro.useCases.clientes;
import com.cadastro.useCases.clientes.domains.ClientesRequestDom;
import com.cadastro.useCases.clientes.domains.ClientesResponseDom;
import java.util.List;

public interface ClientesServices {
    List<ClientesResponseDom> carregarClientes();

    ClientesResponseDom criarCliente(ClientesRequestDom clientesRequestDom); // o que vai retornar

    ClientesResponseDom atualizarCliente(Long id, ClientesRequestDom clientesRequestDom); // vai chamar o business

    void deletarCliente(Long id);

}
