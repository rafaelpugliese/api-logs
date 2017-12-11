package br.audora.log.domain.enumeratios;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import br.audora.log.domain.enumerations.Category;
import br.audora.log.exception.ParametersException;

public class CategoryTest {

	@Test
	public void testDescriptionAutenticacao() {
		assertEquals("Autenticação", Category.AUTENTICACAO.getDescription());
	}

	@Test
	public void testDescriptionErro() {
		assertEquals("Erro", Category.ERRO.getDescription());
	}

	@Test
	public void testDescriptionPermissao() {
		assertEquals("Permissão", Category.PERMISSAO.getDescription());
	}

	@Test
	public void testDescriptionValid() {
		assertTrue("Descrição de 'autenticação' deveria ser válida", Category.isValid("autenticação"));
		assertTrue("Descrição de 'erro' deveria ser válida", Category.isValid("erro"));
		assertTrue("Descrição de 'permissão' deveria ser válida", Category.isValid("permissão"));
	}

	@Test(expected = ParametersException.class)
	public void testDescriptionIsNotValid() {
		Category.isValid("teste");
	}

}