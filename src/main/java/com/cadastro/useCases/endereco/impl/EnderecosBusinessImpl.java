package com.cadastro.useCases.endereco.impl;
import com.cadastro.entitys.Clientes;
import com.cadastro.entitys.Enderecos;
import com.cadastro.useCases.clientes.domains.ClientesResponseDom;
import com.cadastro.useCases.clientes.impl.mappers.ClientesMapper;
import com.cadastro.useCases.clientes.impl.repository.ClientesRepository;
import com.cadastro.useCases.endereco.EnderecosBusiness;
import com.cadastro.useCases.endereco.domains.EnderecosRequestDom;
import com.cadastro.useCases.endereco.domains.EnderecosResponseDom;
import com.cadastro.useCases.endereco.impl.mappers.EnderecosMapper;
import com.cadastro.useCases.endereco.impl.repository.EnderecosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class EnderecosBusinessImpl implements EnderecosBusiness {
    @Autowired
    private EnderecosRepository enderecosRepository;
    @Override
    public List<EnderecosResponseDom> carregarEnderecos() {
        List<Enderecos> enderecosList = enderecosRepository.findAll();

        List<EnderecosResponseDom> out = enderecosList.stream()
                .map(EnderecosMapper::enderecosToEnderecosResponseDom)
                .collect(Collectors.toList());
        return out;
    }

    @Override
    public EnderecosResponseDom criarEndereco(EnderecosRequestDom enderecosRequestDom) {
        Enderecos enderecos = EnderecosMapper.enderecosResquestDomToEnderecos(enderecosRequestDom); // esse não tem o id
        Enderecos resultEnderecos = enderecosRepository.save(enderecos); // aqui vai salvar no banco de dados, é esse que tem o id, é esse que tem que converter
        EnderecosResponseDom out = EnderecosMapper.enderecosToEnderecosResponseDom(resultEnderecos);

        return out;

    }

    @Override
    public EnderecosResponseDom atualizarEnderecos(Long id, EnderecosRequestDom enderecosRequestDom) {
        // aqui ele tras o registro que se quer atualizar
        Enderecos enderecos = enderecosRepository.findById(id).map(record -> {
            record.setRua(enderecosRequestDom.getRua());
            record.setBairro(enderecosRequestDom.getBairro());
            record.setCidade(enderecosRequestDom.getCidade());
            record.setEstado(enderecosRequestDom.getEstado());
            record.setNomeResponsavel(enderecosRequestDom.getNomeResponsavel());
            return enderecosRepository.save(record);
        }).get();

        EnderecosResponseDom out = EnderecosMapper.enderecosToEnderecosResponseDom(enderecos);

        return out;

    }

    @Override
    public void deletarEndereco(Long id) {
        enderecosRepository.deleteById(id);

    }
}
