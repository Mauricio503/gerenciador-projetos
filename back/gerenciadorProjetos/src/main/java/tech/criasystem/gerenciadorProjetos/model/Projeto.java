package tech.criasystem.gerenciadorProjetos.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Projeto implements Serializable {

	private static final long serialVersionUID = 5846134124210238371L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long codigo;
	
	private String titulo;
	
	private String descricao;
	
	private LocalDate dataPrevisaoFinalizacao;
	
	private LocalDate dataFinalizacao;
	
	private LocalDateTime horaPrevisaoFinalizacao;
	
	private LocalDateTime horaFinalizacao;
	
	public Projeto() {
		super();
	}

	public Projeto(Long codigo, String titulo, String descricao, LocalDate dataPrevisaoFinalizacao,
			LocalDate dataFinalizacao, LocalDateTime horaPrevisaoFinalizacao, LocalDateTime horaFinalizacao) {
		super();
		this.codigo = codigo;
		this.titulo = titulo;
		this.descricao = descricao;
		this.dataPrevisaoFinalizacao = dataPrevisaoFinalizacao;
		this.dataFinalizacao = dataFinalizacao;
		this.horaPrevisaoFinalizacao = horaPrevisaoFinalizacao;
		this.horaFinalizacao = horaFinalizacao;
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


	public LocalDate getDataPrevisaoFinalizacao() {
		return dataPrevisaoFinalizacao;
	}


	public void setDataPrevisaoFinalizacao(LocalDate dataPrevisaoFinalizacao) {
		this.dataPrevisaoFinalizacao = dataPrevisaoFinalizacao;
	}

	public LocalDate getDataFinalizacao() {
		return dataFinalizacao;
	}

	public void setDataFinalizacao(LocalDate dataFinalizacao) {
		this.dataFinalizacao = dataFinalizacao;
	}

	public LocalDateTime getHoraPrevisaoFinalizacao() {
		return horaPrevisaoFinalizacao;
	}

	public void setHoraPrevisaoFinalizacao(LocalDateTime horaPrevisaoFinalizacao) {
		this.horaPrevisaoFinalizacao = horaPrevisaoFinalizacao;
	}

	public LocalDateTime getHoraFinalizacao() {
		return horaFinalizacao;
	}

	public void setHoraFinalizacao(LocalDateTime horaFinalizacao) {
		this.horaFinalizacao = horaFinalizacao;
	}
	
}