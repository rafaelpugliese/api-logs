package br.audora.log.util;

import static br.audora.log.util.Validator.isNull;

import java.lang.reflect.Type;
import java.util.Date;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;

public class DateAdapterJson implements JsonDeserializer<Date>, JsonSerializer<Date> {
	
	@Override
	public Date deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) {
		return isNull(json) ? null : new Date(json.getAsLong());
	}

	@Override
	public JsonElement serialize(Date date, Type typeOfSrc, JsonSerializationContext context) {
		return new JsonPrimitive(date.getTime());
	}
}