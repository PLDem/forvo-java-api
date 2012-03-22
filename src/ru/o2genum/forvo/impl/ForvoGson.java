package ru.o2genum.forvo.impl;

/**
 * Gson-level methods
 *
 * @author Andrey Moiseev
 */

import java.util.HashMap;
import java.util.Map;

import com.google.htcfix.gson.Gson;

import ru.o2genum.forvo.Language;
import ru.o2genum.forvo.User;
import ru.o2genum.forvo.Word;
import ru.o2genum.forvo.impl.gson.LanguageAlphabet;
import ru.o2genum.forvo.impl.gson.LanguageList;
import ru.o2genum.forvo.impl.gson.LanguagePopular;
import ru.o2genum.forvo.impl.gson.StandardPronunciation;
import ru.o2genum.forvo.impl.gson.Total;
import ru.o2genum.forvo.impl.gson.WordPronunciations;
import ru.o2genum.forvo.impl.gson.WordsSearchAndPopular;

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

	public static WordPronunciations getPronunciations(Word word,
		Language language, User user, int rate, Word.Order order, int limit)
	   	throws Exception {
		Map<String, String> keysValues = (Map<String, String>)
			new HashMap<String, String>();
		if(word == null) {
			throw new IllegalArgumentException("Word must not be null!");
		} else if (word.getWord() == null) { 
			throw new IllegalArgumentException("Word.getWord() returns null!");
		} else {
			keysValues.put("word", word.getWord());
		}
		if(language != null) {
			if(language.getCode() == null) {
				throw new IllegalArgumentException("Language's code must "+
						"be set!");
			} else {
				keysValues.put("language", language.getCode());
			}
		}
		if(user != null) {
			if((user.getUserName() != null) && (user.getSex() == null)) {
				throw new IllegalArgumentException("User must have set " +
						"either username, or sex, or both");
			} else {
				if(user.getUserName() != null)
					keysValues.put("username", user.getUserName());
				if(user.getSex() != null)
					keysValues.put("sex", user.getSex() == User.Sex.Male ?
							"m" : "f");
			}
		}
		if(rate != -1) {
			if(rate > 0) {
				keysValues.put("rate", new Integer(rate).toString());
			} else {
				throw new IllegalArgumentException("Rate must be either "+
						"-1 or > 0");
			}
		}
		if(order != null) {
			keysValues.put("order", wordOrderToString(order));
		}
		if(limit != -1) {
			if(limit > 0) {
				keysValues.put("limit", new Integer(limit).toString());
			} else {
				throw new IllegalArgumentException("Limit must be either " +
						"-1 or > 0");
			}
		}
		return (WordPronunciations) gson.fromJson(
				ForvoNet.get("word-pronunciations", keysValues),
				WordPronunciations.class);
	}

	public static StandardPronunciation getStandardPronunciation(Word word,
			Language language) throws Exception {
		Map<String, String> keysValues = (Map<String, String>)
			new HashMap<String, String>();
		if(word == null) {
			throw new IllegalArgumentException("Word must not be null!");
		} else if (word.getWord() == null) { 
			throw new IllegalArgumentException("Word.getWord() returns null!");
		} else {
			keysValues.put("word", word.getWord());
		}
		if(language != null) {
			if(language.getCode() == null) {
				throw new IllegalArgumentException("Language's code must "+
						"be set!");
			} else {
				keysValues.put("language", language.getCode());
			}
		}
		return (StandardPronunciation) gson.fromJson(
				ForvoNet.get("standard-pronunciation", keysValues),
				StandardPronunciation.class);
	}

	public static WordsSearchAndPopular searchWords(Word word,
			boolean pronouncedOnly, Language language, int pageSize,
			int page) throws Exception {
		Map<String, String> keysValues = (Map<String, String>)
			new HashMap<String, String>();
		if(word == null) {
			throw new IllegalArgumentException("Word must not be null!");
		} else if (word.getWord() == null) { 
			throw new IllegalArgumentException("Word.getWord() returns null!");
		} else {
			keysValues.put("search", word.getWord());
		}
		if(language != null) {
			if(language.getCode() == null) {
				throw new IllegalArgumentException("Language's code must "+
						"be set!");
			} else {
				keysValues.put("language", language.getCode());
			}
		}
		if(pageSize != -1) {
			if(pageSize > 0) {
				keysValues.put("pagesize", new Integer(pageSize).toString());
			} else {
				throw new IllegalArgumentException("Page size must be "+
						"either -1 or > 0!");
			}

		}
		if(page != -1) {
			if(page > 0) {
				keysValues.put("page", new Integer(page).toString());
			} else {
				throw new IllegalArgumentException("Page must be "+
						"either -1 or > 0!");
			}
		}
		return (WordsSearchAndPopular) gson.fromJson(
				ForvoNet.get(
					(pronouncedOnly ? "pronounced-" : "") + "words-search",
				   	keysValues), WordsSearchAndPopular.class);
	}

	public static WordsSearchAndPopular getPopularPronouncedWords(
			Language language, int limit) throws Exception {
		Map<String, String> keysValues = (Map<String, String>)
			new HashMap<String, String>();
		if(language != null) {
			if(language.getCode() == null) {
				throw new IllegalArgumentException("Language's code must "+
						"be set!");
			} else {
				keysValues.put("language", language.getCode());
			}
		}
		if(limit != -1) {
			if(limit > 0) {
				keysValues.put("limit", new Integer(limit).toString());
			} else {
				throw new IllegalArgumentException("Limit must be either " +
						"-1 or > 0");
			}
		}
		return (WordsSearchAndPopular) gson.fromJson(
				ForvoNet.get(
					"popular-pronounced-words",
				   	keysValues), WordsSearchAndPopular.class);
	}

	public static Total getTotalPronouncedWords(Language language)
	throws Exception {
		Map<String, String> keysValues = (Map<String, String>)
			new HashMap<String, String>();
		if(language != null) {
			if(language.getCode() == null) {
				throw new IllegalArgumentException("Language's code must "+
						"be set!");
			} else {
				keysValues.put("language", language.getCode());
			}
		}
	return (Total) gson.fromJson(ForvoNet.get("total-pronounced-words",
				keysValues), Total.class);
	}

	public static Total getTotalPronounciations(Language language)
	throws Exception {
		Map<String, String> keysValues = (Map<String, String>)
			new HashMap<String, String>();
		if(language != null) {
			if(language.getCode() == null) {
				throw new IllegalArgumentException("Language's code must "+
						"be set!");
			} else {
				keysValues.put("language", language.getCode());
			}
		}
	return (Total) gson.fromJson(ForvoNet.get("total-pronunciations",
				keysValues), Total.class);
	}

		// Helper methods
		private static String wordOrderToString(Word.Order order) {
			String value = "";
			switch(order) {
				case DateDesc:
					value = "date-desc";
					break;
				case DateAsc:
					value = "date-asc";
					break;
				case RateDesc:
					value = "rate-desc";
					break;
				case RateAsc:
					value ="rate-asc";
					break;
			}
			return value;
		}
}
