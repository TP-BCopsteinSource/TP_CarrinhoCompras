package com.bcopstein.CarrinhoCompras;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class TestMockito {
	@Test
	public void test() {
		List<String> mockList = mock(List.class);
		mockList.add("First");
		when(mockList.get(0)).thenReturn("Mockito");
		when(mockList.get(1)).thenReturn("JCG");
		assertEquals("Mockito", mockList.get(0));
		assertEquals("JCG", mockList.get(1));
	}

}
