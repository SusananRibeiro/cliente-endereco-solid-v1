package com.cadastro.useCases.endereco.impl.mappers;
import com.cadastro.entitys.Clientes;
import com.cadastro.entitys.Enderecos;
import com.cadastro.useCases.clientes.domains.ClientesRequestDom;
import com.cadastro.useCases.clientes.domains.ClientesResponseDom;
import com.cadastro.useCases.endereco.domains.EnderecosRequestDom;
import com.cadastro.useCases.endereco.domains.EnderecosResponseDom;

public class EnderecosMapper {
    public static EnderecosResponseDom enderecosToEnderecosResponseDom(Enderecos enderecos) {
        EnderecosResponseDom out = new EnderecosResponseDom();
        out.setId(enderecos.getId());
        out.setRua(enderecos.getRua());
        out.setBairro(enderecos.getBairro());
        out.setCidade(enderecos.getCidade());
        out.setEstado(enderecos.getEstado());
        out.setNomeResponsavel(enderecos.getNomeResponsavel());

        return out;

    }

    // Convertendo ClientesRequestDom para Clientes
    public static Enderecos enderecosResquestDomToEnderecos(EnderecosRequestDom enderecosRequestDom) {
        Enderecos out = new Enderecos();
        out.setRua(enderecosRequestDom.getRua());
        out.setBairro(enderecosRequestDom.getBairro());
        out.setCidade(enderecosRequestDom.getCidade());
        out.setEstado(enderecosRequestDom.getEstado());
        out.setNomeResponsavel(enderecosRequestDom.getNomeResponsavel());
        return out;

    }
}
