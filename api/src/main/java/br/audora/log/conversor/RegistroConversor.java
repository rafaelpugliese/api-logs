package br.audora.log.conversor;

import java.util.HashMap;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

import br.audora.log.util.GsonApiLog;

@Converter(autoApply = true)
@SuppressWarnings("rawtypes")
public class RegistroConversor implements AttributeConverter<HashMap, String> {

	@Override
	public String convertToDatabaseColumn(HashMap attribute) {
		return GsonApiLog.getGson().toJson(attribute);
	}

	@Override
	public HashMap convertToEntityAttribute(String dbData) {
		return GsonApiLog.getGson().fromJson(dbData, HashMap.class);
	}

}