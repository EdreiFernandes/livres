package br.com.livresbs.livres.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import br.com.livresbs.livres.model.Usuario;
import br.com.livresbs.livres.repository.UsuarioRepository;
import br.com.livresbs.livres.service.UsuarioService;

@Service
public class UsuarioImpl implements UsuarioService {
    @Autowired
    UsuarioRepository repo;
    
    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    public ResponseEntity cadastraUsuario(@RequestBody Usuario obj) {
    	obj.setSenha(passwordEncoder.encode(obj.getSenha()));
    	repo.save(obj);
    	return ResponseEntity.status(HttpStatus.CREATED).body("Usuario cadastrado!");
    }

    public static UserDetailsImpl authenticated() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null) {
            return (UserDetailsImpl) auth.getPrincipal();
        }
        return null;
    }
}