package tech.criasystem.gerenciadorProjetos.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.google.gson.Gson;

import tech.criasystem.gerenciadorProjetos.model.Projeto;
import tech.criasystem.gerenciadorProjetos.model.Usuario;
import tech.criasystem.gerenciadorProjetos.service.AutenticacaoService;
import tech.criasystem.gerenciadorProjetos.service.ProjetoService;

@Controller
public class ProjetoController {
	
	@Autowired
	private ProjetoService projetoService;
	
	@Autowired
	private AutenticacaoService autenticacaoService;
	
	@RequestMapping("/projetos")
	public ModelAndView lista(String username) {
		Usuario usuario = projetoService.findProjetosPorUsuario(username);
		ModelAndView mv = new ModelAndView("projetos");
		Iterable<Projeto> projetos = usuario.getProjetos();
		mv.addObject("projetos", projetos);
		return mv;
	}
	
	@RequestMapping("/visualizarProjeto/{codigo}")
	public ModelAndView visualizarProjeto(@PathVariable("codigo") Long codigo){
		ModelAndView mv = new ModelAndView("visualizarProjeto");
		Projeto projeto = projetoService.findByProjetoCodigo(codigo);
		mv.addObject("projeto", projeto);
		return mv;
	}
	
	@RequestMapping(value="/salvarProjeto", method=RequestMethod.POST)
	public String salvarProjeto(Projeto projeto, BindingResult result,
			RedirectAttributes attributes) {
		projetoService.salvar(projeto);
		return "redirect:/";
	}
	
	@RequestMapping(value = "/api/projeto/lista", method = RequestMethod.POST,
			headers = "Accept=application/json")
	@ResponseBody
	public ResponseEntity<String> lista(@RequestBody Usuario usuario) {
		boolean validacao = autenticacaoService.validateToken(usuario.getToken());
		Iterable<Projeto> lista = projetoService.findAll();
		String employeeJsonString = new Gson().toJson(lista);
		return ResponseEntity.ok(employeeJsonString);
	}

}
