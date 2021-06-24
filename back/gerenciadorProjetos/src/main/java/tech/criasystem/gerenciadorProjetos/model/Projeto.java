package tech.criasystem.gerenciadorProjetos.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Projeto implements Serializable {

	private static final long serialVersionUID = 5846134124210238371L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long codigo;
	
	private String titulo;
	
	private String descricao;
	
	@ManyToMany
	private List<HorarioProjeto> horariosProjeto;
	
	public Projeto() {
		super();
	}

	public Projeto(Long codigo, String titulo, String descricao, List<HorarioProjeto> horariosProjeto) {
		super();
		this.codigo = codigo;
		this.titulo = titulo;
		this.descricao = descricao;
		this.horariosProjeto = horariosProjeto;
	}

	public Long getCodigo() {
		return codigo;
	}


	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}


	public String getTitulo() {
		return titulo;
	}


	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}


	public String getDescricao() {
		return descricao;
	}


	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public List<HorarioProjeto> getHorariosProjeto() {
		return horariosProjeto;
	}

	public void setHorariosProjeto(List<HorarioProjeto> horariosProjeto) {
		this.horariosProjeto = horariosProjeto;
	}
	
}