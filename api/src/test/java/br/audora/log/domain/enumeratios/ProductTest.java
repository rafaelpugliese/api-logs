package br.audora.log.domain.enumeratios;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import br.audora.log.domain.enumerations.Product;
import br.audora.log.exception.ParametersException;

public class ProductTest {

	@Test
	public void testDescriptionDefensoria() {
		assertEquals("Defensoria", Product.DEFENSORIA.getDescription());
	}

	@Test
	public void testDescriptionOAB() {
		assertEquals("OAB", Product.OAB.getDescription());
	}

	@Test
	public void testDescriptionValid() {
		assertTrue("Descrição de 'defensoria' deveria ser válida", Product.isValid("defensoria"));
		assertTrue("Descrição de 'OAB' deveria ser válida", Product.isValid("OAB"));
	}

	@Test(expected = ParametersException.class)
	public void testDescriptionIsNotValid() {
		Product.isValid("teste");
	}

}