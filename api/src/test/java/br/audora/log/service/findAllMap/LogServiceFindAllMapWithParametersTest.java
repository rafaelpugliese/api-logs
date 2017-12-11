package br.audora.log.service.findAllMap;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

import br.audora.log.domain.Log;
import br.audora.log.domain.enumerations.Category;
import br.audora.log.domain.enumerations.Client;
import br.audora.log.domain.enumerations.Product;
import br.audora.log.repository.LogRepository;
import br.audora.log.service.LogService;

@RunWith(SpringRunner.class)
public class LogServiceFindAllMapWithParametersTest {

	@TestConfiguration
	static class LogServiceImplTestContextConfiguration {

		@Bean
		public LogService logService() {
			return new LogService();
		}
	}

	@Autowired
	protected LogService logService;

	@MockBean
	protected LogRepository logRepository;

	protected Log log = new Log();

	protected Map<String, String> params = new HashMap<>();

	@Before
	public void setUp() {

		log.setCategory(Category.AUTENTICACAO.getDescription());
		log.setProduct(Product.OAB.getDescription());
		log.setClient(Client.ALAGOAS.getDescription());

		params.put("categoria", log.getCategory());
		params.put("produto", log.getProduct());
		params.put("cliente", log.getClient());

		Mockito.when(logRepository.findAll(params)).thenReturn(Arrays.asList(log));
	}

	@Test
	public void testFindAllMapWithCategory() {
		List<Log> founds = logService.findAll(params);
		assertEquals(log.getCategory(), founds.get(0).getCategory());
	}

	@Test
	public void testFindAllMapWithClient() {
		List<Log> founds = logService.findAll(params);
		assertEquals(log.getClient(), founds.get(0).getClient());
	}

	@Test
	public void testFindAllMapWithProduct() {
		List<Log> founds = logService.findAll(params);
		assertEquals(log.getProduct(), founds.get(0).getProduct());
	}
}