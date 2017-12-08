package br.audora.log.service;

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

import br.audora.log.domain.Category;
import br.audora.log.domain.Log;
import br.audora.log.repository.LogRepository;
import br.audora.log.service.LogService;

@RunWith(SpringRunner.class)
public class LogServiceTest {

	@TestConfiguration
	static class EmployeeServiceImplTestContextConfiguration {

		@Bean
		public LogService logService() {
			return new LogService();
		}
	}

	@Autowired
	private LogService logService;

	@MockBean
	private LogRepository logRepository;

	@Before
	public void setUp() {
		Log log = new Log();
		log.setCategoria(Category.AUTENTICACAO.getDescription());

		Map<String, String> params = new HashMap<>();
		params.put("categoria", Category.AUTENTICACAO.getDescription());

		Mockito.when(logRepository.findAll(params)).thenReturn(Arrays.asList(log));
	}

	@Test
	public void testSearchByCategoria() {
		String autenticacao = Category.AUTENTICACAO.getDescription();
		Map<String, String> params = new HashMap<>();
		params.put("categoria", autenticacao);

		List<Log> founds = logService.findAll(params);
		assertEquals(autenticacao, founds.get(0).getCategoria());
	}
}