package tech.criasystem.gerenciadorProjetos.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/autenticacao")
public class AutenticacaoController {

	
	@GetMapping("/index")
	public void listar() {
	}
}
