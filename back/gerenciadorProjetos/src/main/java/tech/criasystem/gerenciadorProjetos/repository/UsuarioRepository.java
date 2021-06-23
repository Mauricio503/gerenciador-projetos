package tech.criasystem.gerenciadorProjetos.repository;

import org.springframework.data.repository.CrudRepository;

import tech.criasystem.gerenciadorProjetos.model.Usuario;

public interface UsuarioRepository extends CrudRepository<Usuario,Long>{

	Usuario findByUsername(String username);

}
