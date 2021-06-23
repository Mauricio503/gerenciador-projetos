package tech.criasystem.gerenciadorProjetos.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tech.criasystem.gerenciadorProjetos.model.Usuario;
import tech.criasystem.gerenciadorProjetos.repository.UsuarioRepository;

@Service
public class UsuarioService {

	@Autowired
	private UsuarioRepository usuarioRepository;
	
	public Usuario findUsuarioUsername(String username) {
		Usuario usuario = usuarioRepository.findByUsername(username);
		return usuario;
	}
}
