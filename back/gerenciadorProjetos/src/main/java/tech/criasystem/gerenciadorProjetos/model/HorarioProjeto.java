package tech.criasystem.gerenciadorProjetos.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class HorarioProjeto implements Serializable {

	private static final long serialVersionUID = -78539099283441711L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long codigo;
	
	private LocalDate dataPrevisaoFinalizacao;
	
	private LocalDate dataFinalizacao;
	
	private LocalDateTime horaPrevisaoFinalizacao;
	
	private LocalDateTime horaFinalizacao;
	
	@ManyToOne
	private Usuario usuario;

	public HorarioProjeto() {
		super();
	}

	public HorarioProjeto(Long codigo, LocalDate dataPrevisaoFinalizacao, LocalDate dataFinalizacao,
			LocalDateTime horaPrevisaoFinalizacao, LocalDateTime horaFinalizacao, Usuario usuario) {
		super();
		this.codigo = codigo;
		this.dataPrevisaoFinalizacao = dataPrevisaoFinalizacao;
		this.dataFinalizacao = dataFinalizacao;
		this.horaPrevisaoFinalizacao = horaPrevisaoFinalizacao;
		this.horaFinalizacao = horaFinalizacao;
		this.usuario = usuario;
	}

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
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

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
}