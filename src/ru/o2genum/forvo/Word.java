package ru.o2genum.forvo;

/**
 * Represents a word
 *
 * @author Andrey Moiseev
 */

public class Word {
	private String word;

	public Word(String word) {...}

	public Word(String word, int id, String original, int numPronunciations){...}
	/**
	 * Don't know hot to use it, but Forvo API provides it
	 */
	public int getId() {...}

	/**
	 * Get string representation of the word
	 */
	public String getWord() {...}
	
	/**
	 * Get original word
	 */
	public String getOriginal {...}

	/**
	 * How much pronunciations of the word does forvo know?
	 */
	public int getPronunciationsNumber {...}

	/**
	 * Get the list of the word's pronuciations
	 */
	public List<Pronunciation> getPronunciations() {...}

	/**
	 * Get the list of the word's pronuciations
	 */
	public List<Pronunciation> getPronunciations(Language language,
			User user, int rate, Order order, int limit) {...}

	/**
	 * Get default pronunciation of the word
	 */
	public Pronunciation getStandardPronunciation() {...}

	/**
	 * Get default pronunciation of the word
	 */
	public Pronunciation getStandardPronunciation(Language language) {...}

	/**
	 * Search for words starting with specified pattern
	 * and having at least one pronunciation
	 */
	public List<WordAndPronunciation> searchPronuncedWords() {...}

	/**
	 * Search for words starting with specified pattern
	 * and having at least one pronunciation
	 */
	public List<WordAndPronunciation> searchPronuncedWord(Language
			language, int pageSize, int page) {...}

	/**
	 * Search for all words starting with specified pattern
	 */
	public List<WordAndPronunciation> searchWords() {...}

	/**
	 * Search for all words starting with specified pattern
	 */
	public List<WordAndPronunciation> searchWords(Language
			language, int pageSize, int page) {...}

	/**
	 * Get popular words
	 */
	public List<WordAndPronunciation> getPopularPronuncedWords() {...}

	/**
	 * Get the number of words what have pronunciations(s)
	 */
	public int getTotalPronuncedWords() {...}

	/**
	 * Get the number of words what have pronunciations(s)
	 */
	public int getTotalPronuncedWords(Language language) {...}

	/**
	 * Get the number of pronunciations
	 * stored by Forvo
	 */
	public int getTotalPronunciations() {...}

	/**
	 * Get the number of pronunciations
	 * stored by Forvo
	 */
	public int getTotalPronunciations(Language language) {...}
}
