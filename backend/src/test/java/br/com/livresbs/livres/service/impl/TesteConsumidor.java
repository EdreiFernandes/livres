package br.com.livresbs.livres.service.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;

import br.com.livresbs.livres.model.Consumidor;
import br.com.livresbs.livres.model.PreComunidade;

class TesteConsumidor {

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
		c1.setSenha("CiroTroll");
		assertEquals("CiroTroll", c1.getSenha());
	}

	@Test
	final void testGetPrecomunidade() {
		Consumidor c =  new Consumidor();
		PreComunidade p =  new PreComunidade();
		c.setPrecomunidade(p);
		
		assertEquals(p, c.getPrecomunidade());
	}

	@Test
	final void testGetEnderecos() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	final void testSetCpf() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	final void testSetNome() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	final void testSetSobrenome() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	final void testSetSenha() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	final void testSetPrecomunidade() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	final void testSetEnderecos() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	final void testConsumidor() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	final void testEqualsObject() {
		fail("Not yet implemented"); // TODO
	}

}
