package tech.criasystem.gerenciadorProjetos.test;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class GerenciadorProjetosApplicationTests {

	@Test
	void contextLoads() {
		String nome = "Mauricio";
		assertThat(nome).isNotNull();
	}

}


