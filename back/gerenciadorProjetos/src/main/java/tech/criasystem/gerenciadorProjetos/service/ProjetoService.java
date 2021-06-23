package tech.criasystem.gerenciadorProjetos.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import tech.criasystem.gerenciadorProjetos.model.Projeto;
import tech.criasystem.gerenciadorProjetos.model.Usuario;
import tech.criasystem.gerenciadorProjetos.repository.ProjetoRepository;
import tech.criasystem.gerenciadorProjetos.repository.UsuarioRepository;

@Service
public class ProjetoService {

	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Autowired
	private ProjetoRepository projetoRepository;
	
	public Usuario findProjetosPorUsuario(String username) {
		Usuario usuario = usuarioRepository.findByUsername(username);
		if(usuario == null) {
			throw new ResponseStatusException(
			           HttpStatus.NOT_FOUND, "Usuario Não Encontrado");
		}else {
			return usuario;
		}
	}
	
	public Projeto findByProjetoCodigo(Long codigo) {
		Projeto projeto = projetoRepository.findByCodigo(codigo);
		if(projeto == null) {
			throw new ResponseStatusException(
			           HttpStatus.NOT_FOUND, "Projeto Não Encontrado");
		}else {
			return projeto;
		}
	}
	
	public void salvar(Projeto projeto) {
		projetoRepository.save(projeto);
	}
	
}
