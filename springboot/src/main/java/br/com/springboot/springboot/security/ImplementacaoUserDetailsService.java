package br.com.springboot.springboot.security;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.springboot.springboot.model.Usuario;
import br.com.springboot.springboot.repository.UsuarioRepository;

@Service
@Transactional
public class ImplementacaoUserDetailsService implements UserDetailsService {
	
	@Autowired
	private UsuarioRepository usuarioRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Usuario usuario = usuarioRepository.findUserByLogin(username);
		
		if( usuario == null) {
			throw new UsernameNotFoundException("Usuário não encontrado!");
			
			
		} 
		return new User(usuario.getLogin(),
				usuario.getPassword(),
				usuario.isEnabled(), true,
				true, 
				true,
				usuario.getAuthorities());
	}
	
	public interface UserService {
	    public Optional<Usuario> findUserByEmail(String login);
	    public Optional<Usuario> findUserByResetToken(String resetToken);
	    public void save(Usuario usuario);
	}

}
