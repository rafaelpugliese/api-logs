package br.audora.log.controller.search;

import static br.audora.log.util.Converter.DATE_FORMAT;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;

import br.audora.log.controller.LogRestController;
import br.audora.log.controller.SuiteControllerTest;
import br.audora.log.domain.Log;
import br.audora.log.domain.enumerations.Category;
import br.audora.log.domain.enumerations.Client;
import br.audora.log.domain.enumerations.Product;

@RunWith(SpringRunner.class)
@WebMvcTest(LogRestController.class)
public class LogRestControllerSearchWithParametersTest extends SuiteControllerTest {
	
	private Date date = Calendar.getInstance().getTime();
	
	@Override
	public void setUp() {
		super.setUp();
		
		log.setCategory(Category.AUTENTICACAO.getDescription());
		log.setClient(Client.ALAGOAS.getDescription());
		log.setDateHour(date);
		log.setProduct(Product.DEFENSORIA.getDescription());
		
		List<Log> allLogs = Arrays.asList(log);
		Map<String, String> params = new HashMap<>();

		given(logService.findAll(params)).willReturn(allLogs);
	}
	
	private String convertDate(Date date) {
		return new SimpleDateFormat(DATE_FORMAT).format(date);
	}
	
	@Test
	public void testSearchWithCategory() throws Exception {
		doRequestAndVerifyValue("categoria", Category.AUTENTICACAO.getDescription());
	}
	
	@Test
	public void testSearchWithClient() throws Exception {
		doRequestAndVerifyValue("cliente", Client.ALAGOAS.getDescription());
	}
	
	@Test
	public void testSearchWithDateHour() throws Exception {
		doRequestAndVerifyValue("dataHora", convertDate(date));
	}

	@Test
	public void testSearchWithProduct() throws Exception {
		doRequestAndVerifyValue("produto", Product.DEFENSORIA.getDescription());
	}

	public void doRequestAndVerifyValue(String field, String value) throws Exception {
		mvc.perform(get(LOG_SEARCH)
				.contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$", hasSize(1)))
				.andExpect(jsonPath("$[0]." + field, is(value)));
	}

}