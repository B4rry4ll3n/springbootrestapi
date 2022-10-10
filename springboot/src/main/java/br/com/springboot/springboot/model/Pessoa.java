package br.com.springboot.springboot.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class Pessoa implements Serializable {
	
	
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@NotNull(message="Por gentileza, digite um nome válido!")
	@NotEmpty(message="Por gentileza, digite um nome válido!")
	private String nome;
	
	@NotNull(message="Por gentileza, digite um sobrenome válido!")
	@NotEmpty(message="Por gentileza, digite um sobrenome válido!")
	private String sobrenome;
	
	@Min(value = 1,message = "Digite a Data de Vencimento entre os dias 1 a 31!")
	@Max(value = 31, message = "Digite a Data de Vencimento entre os dias 1 a 31!")
	private int diaDoVencimento;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Temporal(TemporalType.DATE)
	private Date dataAdesaoPlano;
	
	public int getDiaDoVencimento() {
		return diaDoVencimento;
	}

	public void setDiaDoVencimento(int diaDoVencimento) {
		this.diaDoVencimento = diaDoVencimento;
	}

	@OneToMany(mappedBy = "pessoa", orphanRemoval = true, cascade = CascadeType.ALL)
	private List<Telefone> telefones;
	
	@NotNull(message = "Digite um CEP!")
	private String cep;
	
	@NotNull(message = "Digite um número!")
	private String numero;
	
	@NotNull(message = "Digite uma Rua!")
	private String rua;
	
	@NotNull(message = "Digite um Bairro!")
	private String bairro;
	
	@NotNull(message = "Digite uma cidade!")
	private String cidade;
	
	@NotNull(message = "Digite um UF!")
	private String uf;
	
	@NotNull(message = "Digite o nome do cachorro!")
	private String nomeCachorro;
	

	private String porteCachorro;
	
	
	private String racaCachorro;
	
	public String getNomeCachorro() {
		return nomeCachorro;
	}

	public void setNomeCachorro(String nomeCachorro) {
		this.nomeCachorro = nomeCachorro;
	}

	public String getPorteCachorro() {
		return porteCachorro;
	}

	public void setPorteCachorro(String porteCachorro) {
		this.porteCachorro = porteCachorro;
	}

	public String getRacaCachorro() {
		return racaCachorro;
	}

	public void setRacaCachorro(String racaCachorro) {
		this.racaCachorro = racaCachorro;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getRua() {
		return rua;
	}

	public void setRua(String rua) {
		this.rua = rua;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getUf() {
		return uf;
	}

	public void setUf(String uf) {
		this.uf = uf;
	}


	public int getdiaDoVencimento() {
		return diaDoVencimento;
	}

	public List<Telefone> getTelefones() {
		return telefones;
	}

	public void setTelefones(List<Telefone> telefones) {
		this.telefones = telefones;
	}

	public void setdiaDoVencimento(int diaDoVencimento) {
		this.diaDoVencimento = diaDoVencimento;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSobrenome() {
		return sobrenome;
	}

	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}
	

}
