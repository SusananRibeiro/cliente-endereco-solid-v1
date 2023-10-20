package com.cadastro.useCases.endereco;
import com.cadastro.useCases.endereco.domains.EnderecosRequestDom;
import com.cadastro.useCases.endereco.domains.EnderecosResponseDom;
import java.util.List;
public interface EnderecosServices {
    List<EnderecosResponseDom> carregarEnderecos();

    EnderecosResponseDom criarEndereco(EnderecosRequestDom enderecosRequestDom);

    EnderecosResponseDom atualizarEndereco(Long id, EnderecosRequestDom enderecosRequestDom);

    void deletarEndereco(Long id);

}
