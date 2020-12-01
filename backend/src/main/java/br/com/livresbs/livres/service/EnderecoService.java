package br.com.livresbs.livres.service;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import br.com.livresbs.livres.model.EnderecoEntrega;


@SuppressWarnings("rawtypes")
public interface EnderecoService {
	
    List<EnderecoEntrega> listarEndereco();
    EnderecoEntrega listaEnderecoUnico(@PathVariable(value = "id") Long id);
    ResponseEntity cadastraEndereco(@RequestBody EnderecoEntrega con);
    void deletarEndereco(@PathVariable(value = "id") Long id);
    ResponseEntity<String> editaEndereco (EnderecoEntrega endereco);
}
