package ru.o2genum.forvo.impl;

/**
 * Collection of forvo API methods
 *
 * @author Andrey Moiseev
 */

import ru.o2genum.forvo.Language;
import ru.o2genum.forvo.impl.gson.LanguageList;

import java.util.List;
import java.util.LinkedList;

public class Forvo {

	public static List<Language> getLanguageList(Language.Order order,
			int minPronunciations) throws Exception {
		LanguageList ll = ForvoGson.getLanguageList(order,
				minPronunciations);
		List<Language> ll2 = (List) new LinkedList<Language>();
		for(int i = 0; i < ll.items.length; i++) {
			Language lang = new Language(ll.items[i].code,
					ll.items[i].en);
			ll2.add(lang);
		}
		return ll2;
	}

	// TODO Other methods
}
