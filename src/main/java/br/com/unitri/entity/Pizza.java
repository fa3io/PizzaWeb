package br.com.unitri.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;


/**
 * The persistent class for the pizza database table.
 * 
 */
@Entity
@NamedQuery(name="Pizza.findAll", query="SELECT p FROM Pizza p")
public class Pizza implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	private String descricao;

	private String nome;

	private BigDecimal valor;
	
	private String imagem;

	//bi-directional many-to-one association to Pedido
	@OneToMany(mappedBy="pizza")
	private List<Pedido> pedidos;

	public Pizza() {
	}
	
	public Pizza(Integer id, String imagem,String nome, String descricao, BigDecimal valor) {
		this.id = id;
		this.setImagem(imagem);
		this.nome = nome;
		this.descricao = descricao;
		this.valor = valor;
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescricao() {
		return this.descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public BigDecimal getValor() {
		return this.valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	public List<Pedido> getPedidos() {
		return this.pedidos;
	}

	public void setPedidos(List<Pedido> pedidos) {
		this.pedidos = pedidos;
	}

	public String getImagem() {
		return imagem;
	}

	public void setImagem(String imagem) {
		this.imagem = imagem;
	}

	public Pedido addPedido(Pedido pedido) {
		getPedidos().add(pedido);
		pedido.setPizza(this);

		return pedido;
	}

	public Pedido removePedido(Pedido pedido) {
		getPedidos().remove(pedido);
		pedido.setPizza(null);

		return pedido;
	}

}