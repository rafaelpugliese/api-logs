package br.audora.log.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.audora.log.domain.Log;
import br.audora.log.service.LogService;

@RestController
@RequestMapping(value = "/log")
public class LogRestController {

	@Autowired
	private LogService logService;

	@RequestMapping(value = "/search", method = RequestMethod.GET)
	public List<Log> search(@RequestParam Map<String, String> params) {
		return logService.findAll(params);
	}

}