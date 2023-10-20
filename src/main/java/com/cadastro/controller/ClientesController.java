package com.cadastro.controller;
import com.cadastro.useCases.clientes.ClientesServices;
import com.cadastro.useCases.clientes.domains.ClientesRequestDom;
import com.cadastro.useCases.clientes.domains.ClientesResponseDom;
import com.cadastro.useCases.clientes.impl.ClientesServicesImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Controller
@RequestMapping("/clientes")
public class ClientesController {
    @Autowired
    private ClientesServices clientesService = new ClientesServicesImpl();

    @GetMapping(path = "/carregar")
    public ResponseEntity<List<ClientesResponseDom>> carregarClientes() {
        return ResponseEntity.ok(clientesService.carregarClientes());
    }

    @PostMapping("/criar") // pode colocar ou não o "path = ", vai funcionar da mesma forma
    public ResponseEntity<ClientesResponseDom> criarCliente(@RequestBody ClientesRequestDom clientesRequestDom) {
        return ResponseEntity.status(HttpStatus.CREATED).body(clientesService.criarCliente(clientesRequestDom));
    }
    @PutMapping("/atualizar/{id}")
    public ResponseEntity<ClientesResponseDom> atualizarCliente(@PathVariable Long id,
                                                                @RequestBody ClientesRequestDom clientesRequestDom) {

        return ResponseEntity.ok(clientesService.atualizarCliente(id, clientesRequestDom));

    }
    @DeleteMapping("deletar/{id}")
    public ResponseEntity<Void> deletarCliente(@PathVariable Long id) {
        clientesService.deletarCliente(id);
        return ResponseEntity.ok(null);
    }

}
