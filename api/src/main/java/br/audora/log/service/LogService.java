package br.audora.log.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.audora.log.domain.Log;
import br.audora.log.repository.LogRepository;

@Service
public class LogService {

	@Autowired
	private LogRepository logRepositoryImpl;

	public List<Log> findAll(Map<String, String> params) {
		return logRepositoryImpl.findAll(params);
	}

}