package br.audora.log.repository.findAllMap;

import static org.junit.Assert.assertEquals;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import br.audora.log.domain.Log;
import br.audora.log.domain.enumerations.Category;
import br.audora.log.domain.enumerations.Client;
import br.audora.log.domain.enumerations.Product;
import br.audora.log.repository.LogRepository;

@RunWith(SpringRunner.class)
@DataJpaTest
public class LogRepositoryFindAllWithParametersTest {

	@Autowired
	private TestEntityManager entityManager;

	@Autowired
	private LogRepository logRepository;

	private Log log = new Log();

	private Date date = new Date();

	protected Map<String, String> params = new HashMap<>();

	@Before
	public void setUp() {

		log.setCategory(Category.AUTENTICACAO.getDescription());
		log.setProduct(Product.OAB.getDescription());
		log.setClient(Client.AMAPA.getDescription());
		log.setDateHour(date);

		log = entityManager.persist(log);
		entityManager.flush();

		params.put("categoria", log.getCategory());
		params.put("produto", log.getProduct());
		params.put("cliente", log.getClient());
	}

	@Test
	public void testfindAllMapWithCategory() {
		List<Log> found = logRepository.findAll(params);
		assertEquals(Category.AUTENTICACAO.getDescription(), found.get(found.indexOf(log)).getCategory());
	}

	@Test
	public void testfindAllMapWithProduct() {
		List<Log> found = logRepository.findAll(params);
		assertEquals(Product.OAB.getDescription(), found.get(found.indexOf(log)).getProduct());
	}

	@Test
	public void testfindAllMapWithClient() {
		List<Log> found = logRepository.findAll(params);
		assertEquals(Client.AMAPA.getDescription(), found.get(found.indexOf(log)).getClient());
	}

}