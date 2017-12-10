package br.audora.log.controller.search;

import static br.audora.log.util.Converter.DATE_FORMAT;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;

import br.audora.log.controller.LogRestController;
import br.audora.log.controller.SuiteControllerTest;
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
	}
	
	@Test
	public void testSearchWithCategory() throws Exception {
		mvc.perform(get("/log/search")
				.contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$", hasSize(1)))
				.andExpect(jsonPath("$[0].categoria", is(Category.AUTENTICACAO.getDescription())));
	}
	
	@Test
	public void testSearchWithClient() throws Exception {
		mvc.perform(get("/log/search")
				.contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$", hasSize(1)))
				.andExpect(jsonPath("$[0].cliente", is(Client.ALAGOAS.getDescription())));
	}
	
	@Test
	public void testSearchWithDateHour() throws Exception {
		DateFormat df = new SimpleDateFormat(DATE_FORMAT);
		String dateInString = df.format(date);
		
		mvc.perform(get("/log/search")
				.contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$", hasSize(1)))
				.andExpect(jsonPath("$[0].dataHora", is(dateInString)));
	}
	
	@Test
	public void testSearchWithProduct() throws Exception {
		mvc.perform(get("/log/search")
				.contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$", hasSize(1)))
				.andExpect(jsonPath("$[0].produto", is(Product.DEFENSORIA.getDescription())));
	}


}