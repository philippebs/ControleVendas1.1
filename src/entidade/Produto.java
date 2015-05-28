package entidade;

import java.beans.ConstructorProperties;
import java.math.BigDecimal;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

@Entity
public class Produto {

	@Id
	@SequenceGenerator(name="seqproduto", sequenceName="seprod")
	@GeneratedValue(generator="seqproduto")
	private Long idProduto;
	
	@Column
	private String nome;
	
	@Column
	private Double valor;
	
	@Column
	private Integer quantidade;
	
	@OneToMany(mappedBy="produto")
	private List<ItemPedido> itens;
	
	public Produto() {
		// TODO Auto-generated constructor stub
	}

	public Produto(String nome, Double valor, Integer quantidade) {
		super();
		this.nome = nome;
		this.valor = valor;
		this.quantidade = quantidade;
	}

	public Long getIdProduto() {
		return idProduto;
	}

	public void setIdProduto(Long idProduto) {
		this.idProduto = idProduto;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}
	
}
