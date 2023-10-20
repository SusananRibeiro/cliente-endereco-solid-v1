package com.cadastro.useCases.endereco;
import com.cadastro.useCases.endereco.domains.EnderecosRequestDom;
import com.cadastro.useCases.endereco.domains.EnderecosResponseDom;
import java.util.List;

public interface EnderecosBusiness {
    public List<EnderecosResponseDom> carregarEnderecos();

    EnderecosResponseDom criarEndereco(EnderecosRequestDom enderecosRequestDom);

    EnderecosResponseDom  atualizarEnderecos(Long id, EnderecosRequestDom enderecosRequestDom);

    void deletarEndereco(Long id);
}
