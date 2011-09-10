package ru.o2genum.forvo.impl;

/**
 * Gson-level methods
 *
 * @author Andrey Moiseev
 */

import java.util.HashMap;
import java.util.Map;

import com.google.gson.Gson;

import ru.o2genum.forvo.Language;
import ru.o2genum.forvo.impl.gson.LanguageAlphabet;
import ru.o2genum.forvo.impl.gson.LanguageList;
import ru.o2genum.forvo.impl.gson.LanguagePopular;

public class ForvoGson {

	private static Gson gson = new Gson();

	public static LanguageList getLanguageList(Language.Order order,
			int minPronunciations) throws Exception {
		Map<String, String> keysValues = (Map<String, String>)
		   	new HashMap<String, String>();
		if(order != null) {
			if(order == Language.Order.Popular) {
				throw new IllegalArgumentException("Order must be eigher " +
						"Name or Code");
			}
			keysValues.put("order", 
					(order == Language.Order.Name) ? "name" : "code");
		}
		if(minPronunciations != -1) {
			if(minPronunciations > 0) {
				keysValues.put("min-pronunciations", 
						new Integer(minPronunciations).toString());
			} else {
				throw new IllegalArgumentException("MinPronunciations must " +
						"be either > 0 or -1");
			}
		}
		return (LanguageList) gson.fromJson(ForvoNet.get("language-list",
				   	keysValues), LanguageList.class);
	}

	public static LanguagePopular getPopularLanguages(Language.Order order,
		   	int limit) throws Exception {
		Map<String, String> keysValues = (Map<String, String>)
			new HashMap<String, String>();
		if(order != null && order != Language.Order.Popular) { 
			// Because popular is default
			keysValues.put("order",
					(order == Language.Order.Name) ? "name" : "code");
		}
		if(limit != -1) {
			if(limit > 0) {
				keysValues.put("limit", new Integer(limit).toString());
			} else {
				throw new IllegalArgumentException("Limit must be " +
						"either > 0 or -1");
			}
		}
		return (LanguagePopular) gson.fromJson(ForvoNet.get("language-popular",
				   	keysValues), LanguagePopular.class);
	}

	public static LanguageAlphabet getLanguageAlphabet(Language language)
		throws Exception {
		Map<String, String> keysValues = (Map<String, String>)
			new HashMap<String, String>();
		if(language == null) {
			throw new IllegalArgumentException("Language must not be null!");
		} else if (language.getCode() == null) {
			throw new IllegalArgumentException("Language code must not " +
					"be null!");
		}
		keysValues.put("language", language.getCode());

		return (LanguageAlphabet) gson.fromJson(
				ForvoNet.get("language-alphabet", keysValues),
				LanguageAlphabet.class);
	}
	// TODO Other methods
}
