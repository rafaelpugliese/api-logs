package br.audora.log.repository;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import br.audora.log.domain.Category;
import br.audora.log.domain.Log;

@RunWith(SpringRunner.class)
@DataJpaTest
public class LogRepositoryTest {

	@Autowired
	private TestEntityManager entityManager;

	@Autowired
	private LogRepository logRepository;

	@Test
	public void testSaveWithCategory() {
		// given
		Log log = new Log();
		log.setCategoria(Category.AUTENTICACAO.getDescription());
		log = entityManager.persist(log);
		entityManager.flush();

		// when
		Log found = logRepository.findOne(log.getId());

		// then
		assertEquals(found.getCategoria(), log.getCategoria());
	}

}