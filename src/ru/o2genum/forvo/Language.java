package ru.o2genum.forvo;

/**
 * Represents a language
 *
 * @author Andrey Moiseev
 */

public class Language {

	public enum Order { Name, Code, Popular };

	public Language(String code, String langName) {...}

	public Language(String code) {...}

	/**
	 * Get language code. See all language codes:
	 * http://www.forvo.com/languages-codes/
	 */
	public String getCode() {...}

	/**
	 * Get language name (in English)
	 */
	public String getLanguageName() {...}

	/**
	 * Get all Forvo's currently supported languages
	 */
	public List<Language> getLanguageList() {...}

	/**
	 * Get all Forvo's currently supported languages
	 * in specified order
	 *
	 * @param order Name or Code
	 */
	public List<Language> getLanguageList(Order order) {...}

	/**
	 * Get most popular Forvo's languages
	 */
	public List<Language> getPopularLanguages() {...}

	/**
	 * Get most popular Forvo's languages
	 * 
	 * @param order Popular, Name or Code
	 * @param limit Max. languages to return
	 */
	public List<Language> getPopularLanguages(Order order, int limit) {...}

	/**
	 * Get an array of all letters the language contains
	 */
	public char[] getLanguageAlphabet() {...}
}
