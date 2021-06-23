package tech.criasystem.gerenciadorProjetos.repository;

import org.springframework.data.repository.CrudRepository;

import tech.criasystem.gerenciadorProjetos.model.Projeto;

public interface ProjetoRepository extends CrudRepository<Projeto,Long>{
	
	
	Projeto findByCodigo(Long codigo);

}
