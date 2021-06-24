package tech.criasystem.gerenciadorProjetos.test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;

import tech.criasystem.gerenciadorProjetos.model.Usuario;

public class UsuarioTest {

	@Test
	public void deveTerAdministrador() {
		Usuario usuario = new Usuario();
		usuario.setUsername("administrador");
		assertNotNull(usuario.getUsername());
	}
}
