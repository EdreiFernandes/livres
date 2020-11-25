package br.com.livresbs.livres.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.livresbs.livres.model.EnderecoEntrega;
import br.com.livresbs.livres.service.EnderecoService;
@SuppressWarnings("rawtypes")
@RestController // controlador rest
@RequestMapping(value = "endereco") //caminho
public class EnderecoController {

    @Autowired
    private EnderecoService ends;

    @CrossOrigin // quando tenho duas tec conversando em dif servidores... estabele contrato de comunicacao..
    @GetMapping
    public List<EnderecoEntrega> listarEnderecos() {
        return ends.listarEndereco();
    }

    @CrossOrigin
    @GetMapping("/{id}")
    public EnderecoEntrega listaEnderecoUnico(@PathVariable(value = "id") Long id) {
        return ends.listaEnderecoUnico(id);
    }

    @CrossOrigin
    @PutMapping
    public ResponseEntity<String> editaEndereco(@RequestBody EnderecoEntrega obj){
        return ends.editaEndereco(obj);
    }

    @CrossOrigin
    @PostMapping
    public ResponseEntity cadastraEndereco(@RequestBody EnderecoEntrega obj) { 
    	return ends.cadastraEndereco(obj); 
    }
    
    @CrossOrigin
    @DeleteMapping("/{id}")
    public void deletaEndereco(@PathVariable(value = "id") Long id) {
    	ends.deletarEndereco(id);
    }
}
