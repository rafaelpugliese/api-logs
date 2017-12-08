package br.audora.log.controller;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import br.audora.log.domain.Category;
import br.audora.log.domain.Log;
import br.audora.log.service.LogService;

@RunWith(SpringRunner.class)
@WebMvcTest(LogRestController.class)
public class LogRestControllerTest {

	@Autowired
	private MockMvc mvc;

	@MockBean
	private LogService logService;

	@Test
	public void testSearchByCategoria() throws Exception {

		Log log = new Log();
		log.setCategoria(Category.AUTENTICACAO.getDescription());

		List<Log> allLogs = Arrays.asList(log);
		Map<String, String> params = new HashMap<>();

		given(logService.findAll(params)).willReturn(allLogs);

		mvc.perform(get("/log/search")
				.contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$", hasSize(1)))
				.andExpect(jsonPath("$[0].categoria", is(log.getCategoria())));
	}

}