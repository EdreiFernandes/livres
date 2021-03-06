package br.com.livresbs.livres.service.impl;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class UserDetailsImpl implements UserDetails {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Long id;
	private String login;
	private String senha;
	
	public UserDetailsImpl() { }
	
	public UserDetailsImpl(Long id, String login, String senha) {
		super();
		this.id = id;
		this.login = login;
		this.senha = senha;

		}
	
	public Long getId() { return id; }
	
	@Override
	public String getPassword() { return senha; }
	
	@Override
	public String getUsername() { return login; }
	
	@Override
	public boolean isAccountNonExpired() { return true; }
	
	@Override
	public boolean isAccountNonLocked() { return true; }
	
	@Override
	public boolean isCredentialsNonExpired() { return true; }
	
	@Override
	public boolean isEnabled() { return true; }

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return null;
	}
}
