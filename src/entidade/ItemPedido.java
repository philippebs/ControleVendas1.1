package entidade;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;

@Entity
public class ItemPedido {
	
	@Id
	@SequenceGenerator(name="seqItemPedido", sequenceName="seqItem")
	@GeneratedValue(generator="seqItemPedido")
	private Long idItemPedido;
	
	@ManyToOne
	@JoinColumn(name="idProduto", nullable = false)
	private Produto produto;
	
	@ManyToOne
	@JoinColumn(name = "idPedido", nullable = false)
	private Pedido pedido;
	
	@Column
	private Integer quantidade;
	
	@Column
	private Double valor;
	
	public ItemPedido() {
		// TODO Auto-generated constructor stub
	}

	public Long getIdItemPedido() {
		return idItemPedido;
	}

	public void setIdItemPedido(Long idItemPedido) {
		this.idItemPedido = idItemPedido;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public Pedido getPedido() {
		return pedido;
	}

	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

}
