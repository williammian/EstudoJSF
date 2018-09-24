package com.wm.cursojsf2.visao;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.event.ActionEvent;

import com.wm.cursojsf2.dominio.Produto;

@ManagedBean
//@ApplicationScoped
@SessionScoped
//@ViewScoped
//@NoneScoped //instancia por deamanda
//@RequestScoped //é o padrão
public class GestaoProdutosBean implements Serializable{

	private List<Produto> produtos;
	private Produto produto;
	
	private Produto produtoSelecionado;
	
	public GestaoProdutosBean() {
		this.produtos = new ArrayList<Produto>();
		this.produto = new Produto();
	}
	
	public String obterAjuda() {
		if (this.produtos.isEmpty()) {
			return "AjudaGestaoProdutos?faces-redirect=true";
		} else {
			return "AjudaGestaoProdutosTelefone?faces-redirect=true";
		}
	}
	
	public void verificarInclusao(ActionEvent event) {
		if ("".equals(this.produto.getFabricante())) {
			this.produto.setFabricante("Sem fabricante");
		}
	}
	
	public void incluir() {
		this.produtos.add(this.produto);
		this.produto = new Produto();
	}
	
	public void excluir() {
		this.produtos.remove(this.produtoSelecionado);
	}
	
	@PostConstruct
	public void inicializar() {
		System.out.println("Inicializou bean");
	}
	
	@PreDestroy
	public void finalizar() {
		System.out.println("Finalizando bean");
	}

	public Produto getProduto() {
		return produto;
	}

	public List<Produto> getProdutos() {
		return produtos;
	}
	
	public Produto getProdutoSelecionado() {
		return produtoSelecionado;
	}

	public void setProdutoSelecionado(Produto produtoSelecionado) {
		this.produtoSelecionado = produtoSelecionado;
	}
	
}