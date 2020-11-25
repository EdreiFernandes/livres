package br.com.livresbs.livres.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import br.com.livresbs.livres.model.EnderecoEntrega;
import br.com.livresbs.livres.repository.EnderecoRepository;
import br.com.livresbs.livres.service.EnderecoService;

@Service
public class EnderecoEntregaImpl implements EnderecoService{
	
	@Autowired
	private EnderecoRepository repo;

	@Override
	public List<EnderecoEntrega> listarEndereco() {
		
		return repo.findAll();
	}

	@Override
	public EnderecoEntrega listaEnderecoUnico(Long id) {
		
		return repo.getOne(id);
	}

	@Override
	public ResponseEntity cadastraEndereco(EnderecoEntrega end) {
		
		repo.save(end);
	
		return ResponseEntity.status(HttpStatus.OK).body("Cadastrado com Sucesso!");
	}

	@Override
	public void deletarEndereco(Long id) {
		repo.deleteById(id);	
	}

	@Override
	public ResponseEntity<String> editaEndereco(EnderecoEntrega endereco) {
		repo.save(endereco); 
		
		return ResponseEntity.status(HttpStatus.OK).body("Cadastrado com Sucesso!");
	}
}
