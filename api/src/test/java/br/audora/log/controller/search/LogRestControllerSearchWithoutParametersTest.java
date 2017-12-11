package br.audora.log.controller.search;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.nullValue;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Arrays;
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

@RunWith(SpringRunner.class)
@WebMvcTest(LogRestController.class)
public class LogRestControllerSearchWithoutParametersTest extends SuiteControllerTest {
	
	public void setUp() {
		super.setUp();
		List<Log> allLogs = Arrays.asList(log);
		Map<String, String> params = new HashMap<>();

		given(logService.findAll(params)).willReturn(allLogs);
	}
	
	@Test
	public void testSearchWithoutProduct() throws Exception {
		doRequestAndVerifyNullValue("produto");
	}
	
	@Test
	public void testSearchWithoutCategory() throws Exception {
		doRequestAndVerifyNullValue("categoria");
	}
	
	@Test
	public void testSearchWithoutClient() throws Exception {
		doRequestAndVerifyNullValue("cliente");
	}
	
	@Test
	public void testSearchWithoutDateHour() throws Exception {
		doRequestAndVerifyNullValue("dataHora");
	}
	
	public void doRequestAndVerifyNullValue(String field) throws Exception {
		mvc.perform(get(LOG_SEARCH)
				.contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$", hasSize(1)))
				.andExpect(jsonPath("$[0]." + field, nullValue()));
	}

}