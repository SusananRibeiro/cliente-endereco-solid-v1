package com.cadastro.useCases.clientes;
import com.cadastro.useCases.clientes.domains.ClientesRequestDom;
import com.cadastro.useCases.clientes.domains.ClientesResponseDom;
import java.util.List;

// Vai ficar as regars de negocio
public interface ClientesBusiness {

    public List<ClientesResponseDom> carregarClientes();

    ClientesResponseDom criarCliente(ClientesRequestDom clientesRequestDom);

    ClientesResponseDom atualizarCliente(Long id, ClientesRequestDom clientesRequestDom);

    void deletarCliente(Long id);

}
