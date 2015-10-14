package br.com.unitri.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;


/**
 * The persistent class for the ingredientes database table.
 * 
 */
@Entity
@Table(name="ingredientes")
@NamedQuery(name="Ingrediente.findAll", query="SELECT i FROM Ingrediente i")
public class Ingrediente implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	private String descricao;

	private BigDecimal valor;

	//bi-directional many-to-many association to Pedido
	@ManyToMany
	@JoinTable(
		name="pedido_ingrediente"
		, joinColumns={
			@JoinColumn(name="idingrediente")
			}
		, inverseJoinColumns={
			@JoinColumn(name="idpedido")
			}
		)
	private List<Pedido> pedidos;

	public Ingrediente() {
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

}