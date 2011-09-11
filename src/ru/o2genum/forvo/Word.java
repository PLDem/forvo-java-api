package ru.o2genum.forvo;

/**
 * Represents a word
 *
 * @author Andrey Moiseev
 */

import ru.o2genum.forvo.Language;
import ru.o2genum.forvo.Pronunciation;
import ru.o2genum.forvo.WordAndPronunciation;
import ru.o2genum.forvo.impl.Forvo;

import java.util.List;

public class Word {
	private String word;
	private int id = -1;
	private String original;
	private int numPronunciations = -1;

	public enum Order { DateDesc, DateAsc, RateDesc, RateAsc };

	public Word(String word) {
		this.word = word;
	}

	public Word(String word, int id, String original, int numPronunciations) {
		this.word = word;
		this.id = id;
		this.original = original;
		this.numPronunciations = numPronunciations;
	}

	/**
	 * Don't know hot to use it, but Forvo API provides it
	 */
	public int getId() { return id; }

	/**
	 * Get string representation of the word
	 */
	public String getWord() { return word; }
	
	/**
	 * Get original word
	 */
	public String getOriginal() { return original; }

	/**
	 * How much pronunciations of the word does forvo know?
	 */
	public int getPronunciationsNumber() { return numPronunciations; }

	/**
	 * Get the list of the word's pronuciations
	 */
	public List<Pronunciation> getPronunciations() throws Exception {
		return getPronunciations(null, null, -1, null, -1);
	}

	/**
	 * Get the list of the word's pronuciations
	 */
	public List<Pronunciation> getPronunciations(Language language,
			User user, int rate, Order order, int limit) throws Exception {
		return Forvo.getPronunciations(this, language, user, rate, order,
				limit);
	}

	/**
	 * Get default pronunciation of the word
	 */
	public Pronunciation getStandardPronunciation() throws Exception {
		return getStandardPronunciation(null);
	}

	/**
	 * Get default pronunciation of the word
	 */
	public Pronunciation getStandardPronunciation(Language language)
		throws Exception {
		return Forvo.getStandardPronunciation(this, language);
	}

	/**
	 * Search for words starting with specified pattern
	 * and having at least one pronunciation
	 */
	public List<WordAndPronunciation> searchPronouncedWords() throws Exception {
		return searchPronouncedWords(null, -1, -1);
	}

	/**
	 * Search for words starting with specified pattern
	 * and having at least one pronunciation
	 */
	public List<WordAndPronunciation> searchPronouncedWords(Language
			language, int pageSize, int page) throws Exception {
		return Forvo.searchWords(this, true, language, pageSize, page);
	}

	/**
	 * Search for all words starting with specified pattern
	 */
	public List<WordAndPronunciation> searchWords() throws Exception {
		return searchWords(null, -1, -1);
	}

	/**
	 * Search for all words starting with specified pattern
	 */
	public List<WordAndPronunciation> searchWords(Language
			language, int pageSize, int page) throws Exception {
		return Forvo.searchWords(this, false, language, pageSize, page);
	}

	/**
	 * Get popular words
	 */
	public List<WordAndPronunciation> getPopularPronouncedWords()
		throws Exception {
		return getPopularPronouncedWords(null, -1);
	}

	/**
	 * Get popular words
	 */
	public List<WordAndPronunciation> getPopularPronouncedWords(Language
			language, int limit) throws Exception {
		return Forvo.getPopularPronouncedWords(language, limit);
	}

	/**
	 * Get the number of words what have pronunciations(s)
	 */
	public int getTotalPronuncedWords() throws Exception {
		return getTotalPronouncedWords(null);
	}

	/**
	 * Get the number of words what have pronunciations(s)
	 */
	public int getTotalPronouncedWords(Language language) throws Exception {
		return Forvo.getTotalPronouncedWords(language);
	}

	/**
	 * Get the number of pronunciations
	 * stored by Forvo
	 */
	public int getTotalPronunciations() throws Exception {
		return getTotalPronunciations(null);
	}

	/**
	 * Get the number of pronunciations
	 * stored by Forvo
	 */
	public int getTotalPronunciations(Language language) throws Exception {
		return Forvo.getTotalPronunciations(language);
	}
}
