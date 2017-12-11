package br.audora.log.repository.findAllMap;

import static org.junit.Assert.assertNull;

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
import br.audora.log.repository.LogRepository;

@RunWith(SpringRunner.class)
@DataJpaTest
public class LogRepositoryFindAllWithoutParametersTest {

	@Autowired
	private TestEntityManager entityManager;

	@Autowired
	private LogRepository logRepository;

	private Log log = new Log();

	protected Map<String, String> params = new HashMap<>();

	@Before
	public void setUp() {
		log = entityManager.persist(log);
		entityManager.flush();
	}

	@Test
	public void testfindAllMapWithoutCategory() {
		List<Log> found = logRepository.findAll(params);
		assertNull(found.get(found.indexOf(log)).getCategory());
	}

	@Test
	public void testfindAllMapWithoutProduct() {
		List<Log> found = logRepository.findAll(params);
		assertNull(found.get(found.indexOf(log)).getProduct());
	}

	@Test
	public void testfindAllMapWithoutClient() {
		List<Log> found = logRepository.findAll(params);
		assertNull(found.get(found.indexOf(log)).getClient());
	}

}