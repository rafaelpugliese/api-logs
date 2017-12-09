package br.audora.log.domain;


import static br.audora.log.util.Constants.TIME_ZONE_AMERICA_MACEIO;
import static br.audora.log.util.Converter.FORMAT_DATE;

import java.util.Date;
import java.util.Map;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import br.audora.log.converter.RegistroConverter;

@Entity
@Table(name = "log")
public class Log {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "produto")
	@JsonProperty("produto")
	private String product;

	@Column(name = "cliente")
	@JsonProperty("cliente")
	private String client;

	// time zone deve ser o mesmo do banco de dados
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = FORMAT_DATE, timezone = TIME_ZONE_AMERICA_MACEIO)
	@Column(name = "dataHora")
	@JsonProperty("dataHora")
	private Date dateHour;

	@Column(name = "categoria")
	@JsonProperty("categoria")
	private String category;

	@Column(name = "registros")
	@JsonProperty("registros")
	@Convert(converter = RegistroConverter.class)
	private Map<String, Object> registros;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getProduct() {
		return product;
	}

	public void setProduct(String product) {
		this.product = product;
	}

	public String getClient() {
		return client;
	}

	public void setClient(String client) {
		this.client = client;
	}

	public Date getDateHour() {
		return dateHour;
	}

	public void setDateHour(Date dateHour) {
		this.dateHour = dateHour;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public Map<String, Object> getRegistros() {
		return registros;
	}

	public void setRegistros(Map<String, Object> registros) {
		this.registros = registros;
	}

}