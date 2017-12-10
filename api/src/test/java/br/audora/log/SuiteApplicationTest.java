package br.audora.log;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import br.audora.log.controller.SuiteControllerTest;
import br.audora.log.repository.SuiteRepositoryTest;
import br.audora.log.service.SuiteServiceTest;

@RunWith(Suite.class)
@Suite.SuiteClasses({ 
	SuiteControllerTest.class, 
	SuiteServiceTest.class, 
	SuiteRepositoryTest.class
})
public class SuiteApplicationTest {

}