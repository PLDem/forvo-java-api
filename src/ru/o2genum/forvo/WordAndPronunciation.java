package ru.o2genum.forvo;

/**
 * Represents word-pronunciation pair
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

	public Word getWord() { return word; }

	public Pronunciation getPronunciation() { return pronunciation; }
}
