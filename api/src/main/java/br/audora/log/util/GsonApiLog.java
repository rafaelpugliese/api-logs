
package br.audora.log.util;

import java.util.Date;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class GsonApiLog {

	public static Gson gson() {
		GsonBuilder gson = new GsonBuilder();
		gson.registerTypeAdapter(Date.class, new DateAdapterJson());
		return gson.create();
	}

}