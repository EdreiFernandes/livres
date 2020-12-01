package br.com.livresbs.livres.service;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;

import br.com.livresbs.livres.model.Usuario;

public interface UsuarioService {

    @SuppressWarnings("rawtypes")
	ResponseEntity cadastraUsuario(@RequestBody Usuario obj);
}
