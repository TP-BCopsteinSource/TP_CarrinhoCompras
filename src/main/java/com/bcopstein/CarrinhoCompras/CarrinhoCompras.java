package com.bcopstein.CarrinhoCompras;

import java.util.LinkedList;
import java.util.List;

public class CarrinhoCompras {
	class ItemVenda{
		public Produto produto;
		public int quantidade;
		
		public ItemVenda(Produto produto,int quantidade) {
			this.produto = produto;
			this.quantidade = quantidade;
		}
	}
	
	private List<ItemVenda> itens;
	private Moeda moedaEscolhida;
	private Cotacao cotacao;
	private Frete frete;
	
	public CarrinhoCompras(Cotacao cotacao,Frete frete) {
		this.cotacao = cotacao;
		this.frete = frete;
		itens = new LinkedList<>();
		moedaEscolhida = Moeda.REAL;
	}
	
	public void addItem(Produto produto,int quantidade) {
		ItemVenda iv = new ItemVenda(produto,quantidade);
		itens.add(iv);
	}
	
	public void defineMoeda(Moeda moeda) {
		moedaEscolhida = moeda;
	}
	
	public double calculaCusto() {
		double custoTotal = 0.0;
		for(ItemVenda iv:itens) {
			double precoMoedaEscolhida = 
					iv.produto.getPrecoDolar()*cotacao.getCotacao(moedaEscolhida);
			double custo = precoMoedaEscolhida * iv.quantidade;
			
			double custoFreteDolar = frete.custoFrete(iv.produto.getPeso(), iv.quantidade);
			double custoFrete = custoFreteDolar*cotacao.getCotacao(moedaEscolhida);
			
			custoTotal += custo + custoFrete;
		}
		return custoTotal;
	}
}
