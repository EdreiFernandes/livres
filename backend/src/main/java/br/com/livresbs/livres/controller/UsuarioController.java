package br.com.livresbs.livres.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.livresbs.livres.model.Usuario;
import br.com.livresbs.livres.service.UsuarioService;

@RestController
@RequestMapping(value = "usuario")
public class UsuarioController {
    @Autowired
    private UsuarioService service;

    @SuppressWarnings("rawtypes")
	@CrossOrigin
    @PostMapping
    public ResponseEntity cadastraUsuario(@RequestBody Usuario obj) { return service.cadastraUsuario(obj); }
    
}