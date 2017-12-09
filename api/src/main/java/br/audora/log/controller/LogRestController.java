package br.audora.log.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.audora.log.service.LogService;

@RestController
@RequestMapping(value = "/log")
public class LogRestController {

	@Autowired
	private LogService logService;

	@GetMapping(value = "/search")
	public ResponseEntity<?> search(@RequestParam Map<String, String> params) {
		return ResponseEntity.ok(logService.findAll(params));
	}

}