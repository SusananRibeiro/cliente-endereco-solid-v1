package com.cadastro.useCases.clientes.impl;
import com.cadastro.entitys.Clientes;
import com.cadastro.useCases.clientes.ClientesBusiness;
import com.cadastro.useCases.clientes.domains.ClientesRequestDom;
import com.cadastro.useCases.clientes.domains.ClientesResponseDom;
import com.cadastro.useCases.clientes.impl.mappers.ClientesMapper;
import com.cadastro.useCases.clientes.impl.repository.ClientesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ClientesBusinessImpl implements ClientesBusiness {
    @Autowired
    private ClientesRepository clientesRepository;
    @Override
    public List<ClientesResponseDom> carregarClientes() {
        List<Clientes> clientesList = clientesRepository.findAll();

        List<ClientesResponseDom> out = clientesList.stream()
                .map(ClientesMapper::clientesToClientesResponseDom)
                .collect(Collectors.toList());
        return out;
    }

    @Override
    public ClientesResponseDom criarCliente(ClientesRequestDom clientesRequestDom) {
        Clientes clientes = ClientesMapper.clientesResquestDomToClientes(clientesRequestDom); // esse não tem o id
        Clientes resultClientes = clientesRepository.save(clientes); // aqui vai salvar no banco de dados, é esse que tem o id, é esse que tem que converter
        ClientesResponseDom out = ClientesMapper.clientesToClientesResponseDom(resultClientes);

        return out;
    }
    @Override
    public ClientesResponseDom atualizarCliente(Long id, ClientesRequestDom clientesRequestDom) {
        // aqui ele tras o registro que se quer atualizar
        Clientes clientes = clientesRepository.findById(id).map(record -> {
            record.setNome(clientesRequestDom.getNome());
            record.setSobrenome(clientesRequestDom.getSobrenome());
            record.setDataNascimento(clientesRequestDom.getDataNascimento());
            record.setEmail(clientesRequestDom.getEmail());
            record.setTelefone(clientesRequestDom.getTelefone());
            return clientesRepository.save(record);
        }).get();

        ClientesResponseDom out = ClientesMapper.clientesToClientesResponseDom(clientes);

        return out;
    }

    @Override
    public void deletarCliente(Long id) {
        clientesRepository.deleteById(id);
    }

}
