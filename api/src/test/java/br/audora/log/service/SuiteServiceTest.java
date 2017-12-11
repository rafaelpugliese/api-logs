package br.audora.log.service;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import br.audora.log.service.findAllMap.LogServiceFindAllMapWithParametersTest;
import br.audora.log.service.findAllMap.LogServiceFindAllMapWithoutParametersTest;

@RunWith(Suite.class)
@Suite.SuiteClasses({ 
	LogServiceFindAllMapWithParametersTest.class,
	LogServiceFindAllMapWithoutParametersTest.class
})
public class SuiteServiceTest {
	
}