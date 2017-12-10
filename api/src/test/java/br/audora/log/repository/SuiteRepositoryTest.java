package br.audora.log.repository;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import br.audora.log.repository.findAllMap.LogRepositoryFindAllWithParametersTest;
import br.audora.log.repository.findAllMap.LogRepositoryFindAllWithoutParametersTest;

@RunWith(Suite.class)
@Suite.SuiteClasses({ 
	LogRepositoryFindAllWithParametersTest.class,
	LogRepositoryFindAllWithoutParametersTest.class
})
public class SuiteRepositoryTest {

}