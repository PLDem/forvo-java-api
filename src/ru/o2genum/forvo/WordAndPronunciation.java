package ru.o2genum.forvo;

/**
 * Represents a word-pronunciation pair
 *
 * @author Andrey Moiseev
 */

public class WordAndPronunciation {
	private Word word;
	private Pronunciation pronunciation;

	public WordAndPronunciation(Word word) {
		this.word = word;
	}

	public WordAndPronunciation(Word word, Pronunciation pronunciation) {
		this.word = word;
		this.pronunciation = pronunciation;
	}

    /**
     * Get the word object, obviously
     */
	public Word getWord() { return word; }

    /**
     * Get the pronunciation object
     */
public Pronunciation getPronunciation() { return pronunciation; }
}
