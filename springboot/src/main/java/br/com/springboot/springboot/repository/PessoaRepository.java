package br.com.springboot.springboot.repository;


import java.util.List;



import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.springboot.springboot.model.Pessoa;


@Repository
@Transactional
public interface PessoaRepository extends JpaRepository<Pessoa,Long>{

	@Query("select p from Pessoa p where p.nome like %?1% ")
	List<Pessoa> findPessoaByName(String nome);
	
	default Page<Pessoa> findPessoaByNamePage(String nome, Pageable pageable) {
		
		Pessoa pessoa = new Pessoa();
		pessoa.setNome(nome);
		
		ExampleMatcher ignoringExampleMatcher = ExampleMatcher.matchingAny()
			      .withMatcher("nome", ExampleMatcher.GenericPropertyMatchers.contains().ignoreCase());
		
		Example<Pessoa> example = Example.of(pessoa, ignoringExampleMatcher);
		
		Page<Pessoa> pessoas = findAll(example, pageable);
		
		return pessoas;
		
	}
	
}
