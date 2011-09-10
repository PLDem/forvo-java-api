package ru.o2genum.forvo;

/**
 * Represents a language
 *
 * @author Andrey Moiseev
 */

import java.util.List;

import ru.o2genum.forvo.impl.Forvo;

public class Language {

	private String code;
	private String langName;

	public enum Order { Name, Code, Popular };

	public Language(String code, String langName) {
		this.code = code;
		this.langName = langName;
	}

	public Language(String code) {
		this.code = code;
	}

	/**
	 * Get language code. See all language codes:
	 * http://www.forvo.com/languages-codes/
	 */
	public String getCode() {
		return code;
	}

	/**
	 * Get language name (in English)
	 */
	public String getLanguageName() {
		return langName;
	}

	/**
	 * Get all Forvo's currently supported languages
	 * @throws Exception If there were some problems
	 */
	public static List<Language> getLanguageList() throws Exception {
		return getLanguageList(null, -1);
	}

	/**
	 * Get all Forvo's currently supported languages
	 * in specified order
	 *
	 * @param order Name or Code
	 * @param minPronunctiations Minimal count of pronunciations
	 * @throws Exception There could be some exceptions (internet/io problems,
	 * etc...
	 */
	public static List<Language> getLanguageList(Order order,
			int minPronunciations) throws Exception {
		return Forvo.getLanguageList(order, minPronunciations);
	}

	/**
	 * Get most popular Forvo's languages
	 * @throws Exception Some troubles
	 */
	public static List<Language> getPopularLanguages() throws Exception {
		return getPopularLanguages(null, -1);
	}

	/**
	 * Get most popular Forvo's languages
	 * 
	 * @param order Popular, Name or Code
	 * @param limit Max. languages to return
	 * @throws Exception Some troubles
	 */
	public static List<Language> getPopularLanguages(Order order, int limit)
    throws Exception {
		return Forvo.getPopularLanguages(order, limit);
	}

	/**
	 * Get an array of all letters the language contains
	 */
	public char[] getLanguageAlphabet() throws Exception {
		return Forvo.getLanguageAlphabet(this);
	}
	
}
