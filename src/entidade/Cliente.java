package entidade;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/*
 * Mapeamento Objeto-Relacional(ORM) utilizando 
 * notações de JPA(Java Persistence API).
 */

@Entity
// Determina que a classe participa de um ORM.
@Table(name = "cliente")
// Definição da tabela que participa do ORM.
public class Cliente {

	@Column(name = "id")
	@Id
	@SequenceGenerator(name = "seqcliente", sequenceName = "seqcli")
	@GeneratedValue(generator = "seqcliente")
	private Integer idCliente;

	@Column(length = 30, nullable = false)
	private String nome;
	
	@Column(length=10, nullable = false)
	private Integer codigo;

	public Cliente() {
		// TODO Auto-generated constructor stub
	}

	public Cliente(String nome, Integer codigo) {
		super();
		this.nome = nome;
		this.codigo = codigo;
	}

	public Integer getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(Integer idCliente) {
		this.idCliente = idCliente;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}
}
