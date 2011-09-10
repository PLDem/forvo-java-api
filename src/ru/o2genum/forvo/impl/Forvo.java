package ru.o2genum.forvo.impl;

/**
 * Collection of forvo API methods
 *
 * @author Andrey Moiseev
 */

import ru.o2genum.forvo.Language;
import ru.o2genum.forvo.impl.gson.LanguageList;
import ru.o2genum.forvo.impl.gson.LanguagePopular;

import java.util.List;
import java.util.LinkedList;

public class Forvo {

	public static List<Language> getLanguageList(Language.Order order,
			int minPronunciations) throws Exception {
		LanguageList ll = ForvoGson.getLanguageList(order,
				minPronunciations);
		List<Language> ll2 = (List<Language>) new LinkedList<Language>();
		for(int i = 0; i < ll.items.length; i++) {
			Language lang = new Language(ll.items[i].code,
					ll.items[i].en);
			ll2.add(lang);
		}
		return ll2;
	}

	public static List<Language> getPopularLanguages(Language.Order order,
			int limit) throws Exception {
		LanguagePopular lp = ForvoGson.getPopularLanguages(order, limit);
		List<Language> l = (List<Language>) new LinkedList<Language>();
		for(int i = 0; i < lp.items.length; i++) {
			Language lang = new Language(lp.items[i].code,
					lp.items[i].en);
			l.add(lang);
		}
		return l;
	}

	public static char[] getLanguageAlphabet(Language language)
		throws Exception {
		return ForvoGson.getLanguageAlphabet(language).items;
	}
	// TODO Other methods
}
