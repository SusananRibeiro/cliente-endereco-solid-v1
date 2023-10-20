package com.cadastro.useCases.endereco.impl;
import com.cadastro.useCases.clientes.impl.ClientesBusinessImpl;
import com.cadastro.useCases.endereco.EnderecosServices;
import com.cadastro.useCases.endereco.domains.EnderecosRequestDom;
import com.cadastro.useCases.endereco.domains.EnderecosResponseDom;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
public class EnderecosServicesImpl implements EnderecosServices {
    @Autowired
    private EnderecosBusinessImpl enderecosBusiness;
    @Override
    public List<EnderecosResponseDom> carregarEnderecos() {

        return enderecosBusiness.carregarEnderecos();
    }

    @Override
    public EnderecosResponseDom criarEndereco(EnderecosRequestDom enderecosRequestDom) {
        return enderecosBusiness.criarEndereco(enderecosRequestDom);
    }

    @Override
    public EnderecosResponseDom atualizarEndereco(Long id, EnderecosRequestDom enderecosRequestDom) {
        return enderecosBusiness.atualizarEnderecos(id, enderecosRequestDom);
    }

    @Override
    public void deletarEndereco(Long id) {
        enderecosBusiness.deletarEndereco(id);
    }
}
