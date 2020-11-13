package br.com.livresbs.livres.service;

import br.com.livresbs.livres.service.impl.UserDetailsImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;

import br.com.livresbs.livres.model.Usuario;

public interface UsuarioService {

    ResponseEntity cadastraUsuario(@RequestBody Usuario obj);
}
