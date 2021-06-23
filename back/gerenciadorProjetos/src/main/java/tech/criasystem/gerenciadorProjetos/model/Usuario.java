package tech.criasystem.gerenciadorProjetos.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

@Entity
public class Usuario implements Serializable {

	private static final long serialVersionUID = -3274541481163059101L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long codigo;
	
	private String username;
	
	private String nome;
	
	@ManyToMany
	private List<Projeto> projetos;
	
	public Usuario() {
		super();
	}

	public Usuario(Long codigo, String username, String nome, List<Projeto> projetos) {
		super();
		this.codigo = codigo;
		this.username = username;
		this.nome = nome;
		this.projetos = projetos;
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
	
}