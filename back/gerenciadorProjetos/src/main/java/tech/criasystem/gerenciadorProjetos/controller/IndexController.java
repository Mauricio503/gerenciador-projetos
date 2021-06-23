package tech.criasystem.gerenciadorProjetos.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class IndexController {

	@RequestMapping(value = "/teste", method = RequestMethod.GET)
	@ResponseBody
	public String teste() {
		return "Deu Certo";
	}
	
	@RequestMapping("/index")
	public String index() {
		return "index";
	}
}