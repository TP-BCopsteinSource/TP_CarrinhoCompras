package com.bcopstein.CarrinhoCompras;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

//import static org.mockito.Matchers.intThat;
import static org.mockito.Matchers.anyDouble;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.mockito.ArgumentMatcher;
import org.mockito.AdditionalMatchers;

// http://static.javadoc.io/org.mockito/mockito-core/2.18.3/org/mockito/Mockito.html
public class TestCarrinho {
	class IsGreater extends ArgumentMatcher<Integer> {
		@Override
		public boolean matches(Object args) {
			return (int) args >= 20;
		}
	}

	private CarrinhoCompras carrinho;
	private Cotacao mockCotacao = mock(Cotacao.class);
	private Frete mockFrete = mock(Frete.class);

	@BeforeEach
	public void setUp() throws Exception {
		when(mockCotacao.getCotacao(Moeda.DOLAR)).thenReturn(1.0);
		when(mockCotacao.getCotacao(Moeda.REAL)).thenReturn(3.8);

		//IsGreater ig = new IsGreater();
		when(mockFrete.custoFrete(2.0, 1)).thenReturn(2.0);
		when(mockFrete.custoFrete(3.0, 1)).thenReturn(3.0);
		//when(mockFrete.custoFrete(anyDouble(), intThat(ig))).thenReturn(0.0);
		when(mockFrete.custoFrete(anyDouble(), AdditionalMatchers.geq(20))).thenReturn(0.0);
		
		carrinho = new CarrinhoCompras(mockCotacao, mockFrete);
		carrinho.addItem(new Produto("CPU I7", 2.0, 450), 1); // 450 + 2 = 452
		carrinho.addItem(new Produto("Monitor", 3.0, 120), 1); // 120 + 3 = 123
		carrinho.addItem(new Produto("Celular", 0.67, 200), 25); // 5000 + 0 = 5000
	}

	@Test
	public void testCustoDolar() {
		carrinho.defineMoeda(Moeda.DOLAR);
		assertEquals(5575.0, carrinho.calculaCusto(), 0.001);
	}

	@Test
	public void testCustoReal() {
		carrinho.defineMoeda(Moeda.REAL);
		assertEquals(21185.0, carrinho.calculaCusto(), 0.001);
	}
}
