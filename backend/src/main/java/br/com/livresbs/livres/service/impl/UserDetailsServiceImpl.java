package br.com.livresbs.livres.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import br.com.livresbs.livres.model.Usuario;
import br.com.livresbs.livres.repository.UsuarioRepository;
import br.com.livresbs.livres.service.UserDetailsService;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService{

	@Autowired
	private UsuarioRepository repo;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Usuario usuario = repo.findByLogin(username);
		if (usuario == null) {
			throw new UsernameNotFoundException(username);
		}
		return new UserDetailsImpl(usuario.getId(), 
				usuario.getLogin(), 
				usuario.getSenha());
		
	}

}
