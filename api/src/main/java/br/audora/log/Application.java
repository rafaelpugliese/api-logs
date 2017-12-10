package br.audora.log;

import static br.audora.log.util.Constants.TIME_ZONE;

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

	/*
	 * Para que as operações com data sejam realizadas perfeitamente, o valor da contante deve ser igual ao timezone do banco de dados.
	 * Caso seja necessário alterar, deve-se alterar na constante, assim, em todos os locais necessários serão alterados
	 */
	@PostConstruct
	void started() {
		TimeZone.setDefault(TimeZone.getTimeZone(TIME_ZONE)); 	// Time zone deve ser o mesmo do banco de dados.
	}

}