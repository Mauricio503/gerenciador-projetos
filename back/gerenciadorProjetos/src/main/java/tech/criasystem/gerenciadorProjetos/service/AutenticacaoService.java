package tech.criasystem.gerenciadorProjetos.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.jsonwebtoken.Claims;
import tech.criasystem.gerenciadorProjetos.exception.ExpiredTokenException;
import tech.criasystem.gerenciadorProjetos.exception.InvalidLoginException;
import tech.criasystem.gerenciadorProjetos.exception.InvalidTokenException;
import tech.criasystem.gerenciadorProjetos.model.Usuario;
import tech.criasystem.gerenciadorProjetos.repository.UsuarioRepository;

@Service
public class AutenticacaoService {

	@Autowired 
	private UsuarioRepository usuarioRepository;
	
	@Autowired
	private TokenService tokenService;
	
	@Autowired
	private UsuarioService usuarioService;
	
	public Usuario authenticate(Usuario dados){
        Usuario user = usuarioRepository.findByUsername(dados.getUsername());
        if(usuarioService.hashSenha(dados.getSenha()).equals(user.getSenha())) {
        	user.setSenha(null);
        	user.setToken(tokenService.generateToken(user));
            return user;
        } else {
            throw new InvalidLoginException();
        }
	}   
	
	public boolean validateToken(String token) {
		if(!token.isEmpty() && validate(token)) {
			return true;
		}else {
			return false;
		}
	}
	
	private boolean validate(String token) {
        try {
            String tokenTratado = token.replace("Bearer ", "");
            Claims claims = tokenService.decodeToken(tokenTratado);

            //Verifica se o token está expirado
            if (claims.getExpiration().before(new Date(System.currentTimeMillis()))) throw new ExpiredTokenException();
            return true;
        } catch (ExpiredTokenException et){
            et.printStackTrace();
            throw et;
        } catch (Exception e) {
            e.printStackTrace();
            throw new InvalidTokenException();
        }

    }
}
