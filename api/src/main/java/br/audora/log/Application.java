package br.audora.log;

import static br.audora.log.util.Constants.TIME_ZONE_AMERICA_MACEIO;

import java.util.TimeZone;

import javax.annotation.PostConstruct;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@SpringBootApplication
public class Application extends WebMvcConfigurerAdapter {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@PostConstruct
	void started() {
		TimeZone.setDefault(TimeZone.getTimeZone(TIME_ZONE_AMERICA_MACEIO)); 	// Time zone deve ser o mesmo do banco de dados.
	}

}