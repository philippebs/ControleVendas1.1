package entidade;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

@Entity
public class Pedido {
	
	@Id
	@SequenceGenerator(name="seqpedido", sequenceName= "seqped")
	@GeneratedValue(generator = "seqpedido")
	private Long idPedido;
	
	@Column
	private Double valor;
	
	@Column
	private String codigo;
	
	@ManyToOne
	@JoinColumn(name="idcliente")
	private Cliente cliente; 
	
	@OneToMany(mappedBy="pedido")
	private List<ItemPedido> itens;

	public Pedido() {
		// TODO Auto-generated constructor stub
	}
	
	public Long getIdPedido() {
		return idPedido;
	}

	public void setIdPedido(Long idPedido) {
		this.idPedido = idPedido;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public List<ItemPedido> getItens() {
		return itens;
	}

	public void setItens(List<ItemPedido> itens) {
		this.itens = itens;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	
}
