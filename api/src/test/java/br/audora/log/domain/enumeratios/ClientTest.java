package br.audora.log.domain.enumeratios;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import br.audora.log.domain.enumerations.Client;
import br.audora.log.exception.ParametersException;

public class ClientTest {

	private static final String TOCANTINS = "Tocantins";
	private static final String SERGIPE = "Sergipe";
	private static final String SAO_PAULO = "São Paulo";
	private static final String SANTA_CATARINA = "Santa Catarina";
	private static final String RONDONIA = "Rondônia";
	private static final String RIO_GRANDE_DO_SUL = "Rio Grande do Sul";
	private static final String RIO_GRANDE_DO_NORTE = "Rio Grande do Norte";
	private static final String RIO_DE_JANEIRO = "Rio de Janeiro";
	private static final String PIAUI = "Piauí";
	private static final String PERNAMBUCO = "Pernambuco";
	private static final String PARANA = "Paraná";
	private static final String PARAIBA = "Paraíba";
	private static final String PARA = "Pará";
	private static final String MINAS_GERAIS = "Minas Gerais";
	private static final String MATO_GROSSO_DO_SUL = "Mato Grosso do Sul";
	private static final String MATO_GROSSO = "Mato Grosso";
	private static final String MARANHAO = "Maranhão";
	private static final String GOIAS = "Goiás";
	private static final String ESPIRITO_SANTO = "Espírito Santo";
	private static final String DISTRITO_FEDERAL = "Distrito Federal";
	private static final String CEARA = "Ceará";
	private static final String BAHIA = "Bahia";
	private static final String AMAZONAS = "Amazonas";
	private static final String AMAPA = "Amapá";
	private static final String ACRE = "Acre";
	private static final String ALAGOAS = "Alagoas";

	@Test
	public void testDescriptionAcre() {
		assertEquals(ACRE, Client.ACRE.getDescription());
	}

	@Test
	public void testDescriptionAlagoas() {
		assertEquals(ALAGOAS, Client.ALAGOAS.getDescription());
	}

	@Test
	public void testDescriptionAmapa() {
		assertEquals(AMAPA, Client.AMAPA.getDescription());
	}

	@Test
	public void testDescriptionAmazonas() {
		assertEquals(AMAZONAS, Client.AMAZONAS.getDescription());
	}

	@Test
	public void testDescriptionBahia() {
		assertEquals(BAHIA, Client.BAHIA.getDescription());
	}

	@Test
	public void testDescriptionCeara() {
		assertEquals(CEARA, Client.CEARA.getDescription());
	}

	@Test
	public void testDescriptionDistritoFederal() {
		assertEquals(DISTRITO_FEDERAL, Client.DISTRITO_FEDERAL.getDescription());
	}

	@Test
	public void testDescriptionEspiritoSanto() {
		assertEquals(ESPIRITO_SANTO, Client.ESPIRITO_SANTO.getDescription());
	}

	@Test
	public void testDescriptionGoias() {
		assertEquals(GOIAS, Client.GOIAS.getDescription());
	}

	@Test
	public void testDescriptionMaranhao() {
		assertEquals(MARANHAO, Client.MARANHAO.getDescription());
	}

	@Test
	public void testDescriptionMatoGrosso() {
		assertEquals(MATO_GROSSO, Client.MATO_GROSSO.getDescription());
	}

	@Test
	public void testDescriptionMatoGrossoDoSul() {
		assertEquals(MATO_GROSSO_DO_SUL, Client.MATO_GROSSO_DO_SUL.getDescription());
	}

	@Test
	public void testDescriptionMinasGerais() {
		assertEquals(MINAS_GERAIS, Client.MINAS_GERAIS.getDescription());
	}

	@Test
	public void testDescriptionPara() {
		assertEquals(PARA, Client.PARA.getDescription());
	}

	@Test
	public void testDescriptionParaiba() {
		assertEquals(PARAIBA, Client.PARAIBA.getDescription());
	}

	@Test
	public void testDescriptionParana() {
		assertEquals(PARANA, Client.PARANA.getDescription());
	}

	@Test
	public void testDescriptionPernambuco() {
		assertEquals(PERNAMBUCO, Client.PERNAMBUCO.getDescription());
	}

	@Test
	public void testDescriptionPiaui() {
		assertEquals(PIAUI, Client.PIAUI.getDescription());
	}

	@Test
	public void testDescriptionRioDeJaneiro() {
		assertEquals(RIO_DE_JANEIRO, Client.RIO_DE_JANEIRO.getDescription());
	}

	@Test
	public void testDescriptionRioGrandeDoNorte() {
		assertEquals(RIO_GRANDE_DO_NORTE, Client.RIO_GRANDE_DO_NORTE.getDescription());
	}

	@Test
	public void testDescriptionRioGrandeDoSul() {
		assertEquals(RIO_GRANDE_DO_SUL, Client.RIO_GRANDE_DO_SUL.getDescription());
	}

	@Test
	public void testDescriptionRondonia() {
		assertEquals(RONDONIA, Client.RONDONIA.getDescription());
	}

	@Test
	public void testDescriptionSantaCatarina() {
		assertEquals(SANTA_CATARINA, Client.SANTA_CATARINA.getDescription());
	}

	@Test
	public void testDescriptionSaoPaulo() {
		assertEquals(SAO_PAULO, Client.SAO_PAULO.getDescription());
	}

	@Test
	public void testDescriptionSergipe() {
		assertEquals(SERGIPE, Client.SERGIPE.getDescription());
	}

	@Test
	public void testDescriptionTocantins() {
		assertEquals(TOCANTINS, Client.TOCANTINS.getDescription());
	}

	@Test
	public void testDescriptionValid() {
		assertTrue("Descrição de " + ACRE + " deveria ser válida", Client.isValid("acre"));
		assertTrue("Descrição de " + ALAGOAS + " deveria ser válida", Client.isValid(ALAGOAS));
		assertTrue("Descrição de " + AMAPA + " deveria ser válida", Client.isValid(AMAPA));
		assertTrue("Descrição de " + AMAZONAS + "deveria ser válida", Client.isValid(AMAZONAS));
		assertTrue("Descrição de " + BAHIA + " deveria ser válida", Client.isValid(BAHIA));
		assertTrue("Descrição de " + CEARA + " deveria ser válida", Client.isValid(CEARA));
		assertTrue("Descrição de " + DISTRITO_FEDERAL + " deveria ser válida", Client.isValid(DISTRITO_FEDERAL));
		assertTrue("Descrição de " + ESPIRITO_SANTO + " deveria ser válida", Client.isValid(ESPIRITO_SANTO));
		assertTrue("Descrição de " + GOIAS + " deveria ser válida", Client.isValid(GOIAS));
		assertTrue("Descrição de " + MARANHAO + " deveria ser válida", Client.isValid(MARANHAO));
		assertTrue("Descrição de " + MATO_GROSSO + " deveria ser válida", Client.isValid(MATO_GROSSO));
		assertTrue("Descrição de " + MATO_GROSSO_DO_SUL + " deveria ser válida", Client.isValid(MATO_GROSSO_DO_SUL));
		assertTrue("Descrição de " + MINAS_GERAIS + " deveria ser válida", Client.isValid(MINAS_GERAIS));
		assertTrue("Descrição de " + PARA + " deveria ser válida", Client.isValid(PARA));
		assertTrue("Descrição de " + PARAIBA + " deveria ser válida", Client.isValid(PARAIBA));
		assertTrue("Descrição de " + PARANA + " deveria ser válida", Client.isValid(PARANA));
		assertTrue("Descrição de " + PERNAMBUCO + " deveria ser válida", Client.isValid(PERNAMBUCO));
		assertTrue("Descrição de " + PIAUI + " deveria ser válida", Client.isValid(PIAUI));
		assertTrue("Descrição de " + RIO_DE_JANEIRO + " deveria ser válida", Client.isValid(RIO_DE_JANEIRO));
		assertTrue("Descrição de " + RIO_GRANDE_DO_NORTE + " deveria ser válida", Client.isValid(RIO_GRANDE_DO_NORTE));
		assertTrue("Descrição de " + RIO_GRANDE_DO_SUL + " deveria ser válida", Client.isValid(RIO_GRANDE_DO_SUL));
		assertTrue("Descrição de " + RONDONIA + " deveria ser válida", Client.isValid(RONDONIA));
		assertTrue("Descrição de " + SANTA_CATARINA + " deveria ser válida", Client.isValid(SANTA_CATARINA));
		assertTrue("Descrição de " + SAO_PAULO + " deveria ser válida", Client.isValid(SAO_PAULO));
		assertTrue("Descrição de " + SERGIPE + " deveria ser válida", Client.isValid(SERGIPE));
		assertTrue("Descrição de " + TOCANTINS + " deveria ser válida", Client.isValid(TOCANTINS));
	}

	@Test(expected = ParametersException.class)
	public void testDescriptionIsNotValid() {
		Client.isValid("teste");
	}

}