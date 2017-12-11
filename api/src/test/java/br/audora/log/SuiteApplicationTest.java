package br.audora.log;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import br.audora.log.controller.SuiteControllerTest;
import br.audora.log.domain.enumeratios.SuiteDomainTest;
import br.audora.log.repository.SuiteRepositoryTest;
import br.audora.log.service.SuiteServiceTest;
import br.audora.log.util.SuiteUtilTest;

@RunWith(Suite.class)
@Suite.SuiteClasses({ 
	SuiteControllerTest.class,
	SuiteDomainTest.class,
	SuiteRepositoryTest.class,
	SuiteServiceTest.class, 
	SuiteUtilTest.class
})
public class SuiteApplicationTest {

}