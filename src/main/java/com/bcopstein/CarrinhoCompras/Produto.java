package com.bcopstein.CarrinhoCompras;


public class Produto {
    private String descricao;
    private double precoDolar;
    private double peso; // Kgs
    
    public Produto(String descricao, double peso, double precoDolar) {
		super();
		this.descricao = descricao;
		this.precoDolar = precoDolar;
		this.peso = peso;
	}

	public String getDescricao() {
		return descricao;
	}

	public double getPeso() {
		return peso;
	}
	
	public double getPrecoDolar() {
		return precoDolar;
	}

	@Override
	public String toString() {
		return "Produto [descricao=" + descricao + ", peso="+peso+", precoDolar=" + precoDolar + "]";
	}
}
