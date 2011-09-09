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
import ru.o2genum.forvo.impl.gson.LanguageList;

public class ForvoGson {

	private static Gson gson = new Gson();

	public static LanguageList getLanguageList(Language.Order order,
			int minPronunciations) throws Exception {
		Map<String, String> keysValues = (Map) new HashMap<String, String>();
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
				throw new IllegalArgumentException("MinPronunciations must be either > 0 or -1");
			}
		}
		return (LanguageList) gson.fromJson(ForvoNet.get("language-list",
				   	keysValues), LanguageList.class);
	}
	// TODO Other methods
}
