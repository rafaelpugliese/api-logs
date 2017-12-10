package br.audora.log.controller.search;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.nullValue;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;

import br.audora.log.controller.LogRestController;
import br.audora.log.controller.SuiteControllerTest;

@RunWith(SpringRunner.class)
@WebMvcTest(LogRestController.class)
public class LogRestControllerSearchWithoutParametersTest extends SuiteControllerTest {
	
	@Override
	public void setUp() {
		super.setUp();
		log.setProduct(null);
		log.setCategory(null);
		log.setClient(null);
		log.setDateHour(null);
	}
	
	@Test
	public void testSearchWithoutProduct() throws Exception {
		mvc.perform(get("/log/search")
				.contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$", hasSize(1)))
				.andExpect(jsonPath("$[0].produto", nullValue()));
	}
	
	@Test
	public void testSearchWithoutCategory() throws Exception {
		mvc.perform(get("/log/search")
				.contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$", hasSize(1)))
				.andExpect(jsonPath("$[0].categoria", nullValue()));
	}
	
	@Test
	public void testSearchWithoutClient() throws Exception {
		mvc.perform(get("/log/search")
				.contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$", hasSize(1)))
				.andExpect(jsonPath("$[0].cliente", nullValue()));
	}
	
	@Test
	public void testSearchWithoutDateHour() throws Exception {
		mvc.perform(get("/log/search")
				.contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$", hasSize(1)))
				.andExpect(jsonPath("$[0].dataHora", nullValue()));
	}

}