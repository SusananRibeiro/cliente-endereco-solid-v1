package com.cadastro.controller;
import com.cadastro.useCases.endereco.EnderecosServices;
import com.cadastro.useCases.endereco.domains.EnderecosRequestDom;
import com.cadastro.useCases.endereco.domains.EnderecosResponseDom;
import com.cadastro.useCases.endereco.impl.EnderecosServicesImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/enderecos")
public class EnderecosController {

    @Autowired
    private EnderecosServices enderecosService = new EnderecosServicesImpl();

    @GetMapping(path = "/carregar")
    public ResponseEntity<List<EnderecosResponseDom>> carregarEnderecos() {
        return ResponseEntity.ok(enderecosService.carregarEnderecos());
    }

    @PostMapping(path = "/criar") // pode colocar ou não o "path = ", vai funcionar da mesma forma
    public ResponseEntity<EnderecosResponseDom> criarEndereco(@RequestBody EnderecosRequestDom enderecosRequestDom) {
        return ResponseEntity.status(HttpStatus.CREATED).body(enderecosService.criarEndereco(enderecosRequestDom));
    }
    @PutMapping("/atualizar/{id}")
    public ResponseEntity<EnderecosResponseDom> atualizarEndereco(@PathVariable Long id,
                                                                @RequestBody EnderecosRequestDom enderecosRequestDom) {

        return ResponseEntity.ok(enderecosService.atualizarEndereco(id, enderecosRequestDom));

    }
    @DeleteMapping("deletar/{id}")
    public ResponseEntity<Void> deletarEndereco(@PathVariable Long id) {
        enderecosService.deletarEndereco(id);
        return ResponseEntity.ok(null);
    }

}
