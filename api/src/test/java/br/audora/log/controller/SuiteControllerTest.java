package br.audora.log.controller;

import static org.mockito.BDDMockito.given;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

	@Autowired
	protected MockMvc mvc;
	
	protected Log log;
	
	@MockBean
	protected LogService logService;
	
	@Before
	public void setUp() {
		log = new Log();

		List<Log> allLogs = Arrays.asList(log);
		Map<String, String> params = new HashMap<>();

		given(logService.findAll(params)).willReturn(allLogs);
	}
	
}