package tech.criasystem.gerenciadorProjetos.service;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

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
	
	public void save(Usuario usuario) {
		usuario.setSenha(hashSenha(usuario.getSenha()));
		usuarioRepository.save(usuario);
	}
	
	public String hashSenha(String passwordToHash) {
		String generatedPassword = null;
	    try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(passwordToHash.getBytes());
            byte[] bytes = md.digest();
            StringBuilder sb = new StringBuilder();
            for(int i=0; i< bytes.length ;i++)
            {
                sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
            }
            generatedPassword = sb.toString();
	        } catch (NoSuchAlgorithmException e) {
	        	e.printStackTrace();
	        }
	   return generatedPassword;
	}
}
