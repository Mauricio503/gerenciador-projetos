package tech.criasystem.gerenciadorProjetos.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import tech.criasystem.gerenciadorProjetos.model.Projeto;

public class ProjetoTest {
	
	@Test
	public void deveSetarTituloProjeto() {
		Projeto projeto = new Projeto();
		projeto.setTitulo("Calculadora");
		assertEquals("Calculadora", projeto.getTitulo());
	}

}
