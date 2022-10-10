package br.com.springboot.springboot.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.security.core.GrantedAuthority;

@Entity
public class RegrasCargo implements GrantedAuthority {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	private static final long serialVersionUID = 1L;
	private String regrasCargo;

	@Override
	public String getAuthority() {
		return this.regrasCargo;
	}

	public String getRegrasNome() { // retorna as os nomes definidos com a regras de acesso!
		return regrasCargo;
	}

	public void setRegrasNome(String regrasCargo) {
		this.regrasCargo = regrasCargo;
	}

}
