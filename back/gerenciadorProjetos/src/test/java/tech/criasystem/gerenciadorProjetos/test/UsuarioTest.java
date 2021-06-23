package tech.criasystem.gerenciadorProjetos.test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import tech.criasystem.gerenciadorProjetos.model.Usuario;
import tech.criasystem.gerenciadorProjetos.service.UsuarioService;

public class UsuarioTest {

	@Autowired
	private UsuarioService usuarioService;
	
	@Test
	public void deveTerAdministrador() {
		Usuario usuario = usuarioService.findUsuarioUsername("administrador");
		assertNotNull(usuario);
	}
}
