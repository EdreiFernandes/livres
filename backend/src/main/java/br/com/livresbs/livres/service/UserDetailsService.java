package br.com.livresbs.livres.service;

import org.springframework.security.core.userdetails.UserDetails;

public interface UserDetailsService {
	
	UserDetails loadUserByUsername(String username);
}
