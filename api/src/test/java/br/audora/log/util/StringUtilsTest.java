package br.audora.log.util;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class StringUtilsTest {

	@Test
	public void testContainsWithSimple() {
		assertTrue(StringUtils.contains("produto", "pro"));
		assertTrue(StringUtils.contains("produto", "p"));
	}
	
	@Test
	public void testContainsWithAccent() {
		assertTrue(StringUtils.contains("autenticação", "autenticaçao"));
		assertTrue(StringUtils.contains("autenticação", "autenticacão"));
		
		assertTrue(StringUtils.contains("paraíba", "paraiba"));
	}
	
	@Test
	public void testContainsWithIgnoreCase() {
		assertTrue(StringUtils.contains("Produto", "pro"));
		assertTrue(StringUtils.contains("OAB", "oab"));
	}
	
	@Test
	public void testNotContains() {
		assertFalse(StringUtils.contains("Produto", "teste"));
		assertFalse(StringUtils.contains("OAB", "oabteste"));
	}

	

}