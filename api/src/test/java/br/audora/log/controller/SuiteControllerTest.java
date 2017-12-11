package br.audora.log.controller;

import org.junit.Before;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;

import br.audora.log.controller.search.LogRestControllerSearchWithParametersTest;
import br.audora.log.controller.search.LogRestControllerSearchWithoutParametersTest;
import br.audora.log.domain.Log;
import br.audora.log.service.LogService;

@RunWith(Suite.class)
@Suite.SuiteClasses({ 
	LogRestControllerSearchWithoutParametersTest.class,
	LogRestControllerSearchWithParametersTest.class
})
@WithMockUser(username = "audora", password = "audora", roles = "USER")
public class SuiteControllerTest {
	
	protected static final String LOG_SEARCH = "/log/search?";

	@Autowired
	protected MockMvc mvc;
	
	protected Log log;
	
	@MockBean
	protected LogService logService;
	
	@Before
	public void setUp() {
		log = new Log();
	}
	
}