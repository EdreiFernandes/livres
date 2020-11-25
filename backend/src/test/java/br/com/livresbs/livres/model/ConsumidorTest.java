package br.com.livresbs.livres.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class ConsumidorTest {

	@Test
	final void testGetCpf() {
		Consumidor c1 = new Consumidor();
		c1.setCpf("12345678912");
		assertEquals("12345678912", c1.getCpf());
	}

	@Test
	final void testGetNome() {
		Consumidor c1 = new Consumidor();
		c1.setNome("gabriel");
		assertEquals("gabriel", c1.getNome());
	}

	@Test
	final void testGetSobrenome() {
		Consumidor c1 = new Consumidor();
		c1.setSobrenome("Tavares");
		assertEquals("Tavares", c1.getSobrenome());
	}

	@Test
	final void testGetSenha() {
		Consumidor c1 = new Consumidor();
		c1.setSenha("Ciro");
		assertEquals("Ciro", c1.getSenha());
	}

	@Test
	final void testGetPrecomunidade() {
		Consumidor c = new Consumidor();
		PreComunidade p = new PreComunidade();
		c.setPrecomunidade(p);
		assertEquals(p, c.getPrecomunidade());
	}
}
