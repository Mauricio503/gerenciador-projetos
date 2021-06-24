package tech.criasystem.gerenciadorProjetos.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Transient;

@Entity
public class Usuario implements Serializable {

	private static final long serialVersionUID = -3274541481163059101L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long codigo;
	
	private String username;
	
	private String nome;
	
	private String senha;
	
	@ManyToMany
	private List<Projeto> projetos;
	
	@Transient
	private String token;
	
	public Usuario() {
		super();
	}

	public Usuario(Long codigo, String username, String nome, String senha, List<Projeto> projetos, String token) {
		super();
		this.codigo = codigo;
		this.username = username;
		this.nome = nome;
		this.senha = senha;
		this.projetos = projetos;
		this.token = token;
	}


	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<Projeto> getProjetos() {
		return projetos;
	}

	public void setProjetos(List<Projeto> projetos) {
		this.projetos = projetos;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}
	
}