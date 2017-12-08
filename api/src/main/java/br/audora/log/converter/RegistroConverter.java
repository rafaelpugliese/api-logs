package br.audora.log.converter;

import static br.audora.log.util.GsonApiLog.getGson;

import java.util.HashMap;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter(autoApply = true)
@SuppressWarnings("rawtypes")
public class RegistroConverter implements AttributeConverter<HashMap, String> {

	@Override
	public String convertToDatabaseColumn(HashMap attribute) {
		return getGson().toJson(attribute);
	}

	@Override
	public HashMap convertToEntityAttribute(String dbData) {
		return getGson().fromJson(dbData, HashMap.class);
	}

}