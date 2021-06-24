package tech.criasystem.gerenciadorProjetos.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;

import tech.criasystem.gerenciadorProjetos.model.Usuario;
import tech.criasystem.gerenciadorProjetos.service.AutenticacaoService;
import tech.criasystem.gerenciadorProjetos.service.UsuarioService;

@Controller
public class UsuarioController {

	@Autowired
	private AutenticacaoService autenticacaoService;
	
	@Autowired
	private UsuarioService usuarioService;
	
	@RequestMapping(value = "/api/login", method = RequestMethod.POST,
			headers = "Accept=application/json")
	@ResponseBody
	public ResponseEntity<String> login(@RequestBody Usuario usuario) {
		usuario = autenticacaoService.authenticate(usuario);
		String employeeJsonString = new Gson().toJson(usuario);
		return ResponseEntity.ok(employeeJsonString);
	}
	
	@RequestMapping(value = "/salvar", method = RequestMethod.POST,
			headers = "Accept=application/json")
	@ResponseBody
	public String salvar(@RequestBody Usuario usuario) {
		usuarioService.save(usuario);
		return "Sucesso";
	}
}
