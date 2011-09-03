package ru.o2genum.forvo;

/**
 * Pepresents word's pronunciation
 *
 * @author Andrey Moiseev
 */

public class Pronunciation {

	public enum AudioFormat { MP3, OGG }

	private Word word;

	public Pronunciation(String word) {...}

	public Pronunciation(Word word) {...}

	public Pronunciation(int id, Date addDate, int hits,
			User user, String code, String langName, String mp3Path,
			String oggPath, int rate, int numVotes, int numPositiveVotes) {...}

	/**
	 * Get word for which the pronunciation is provided
	 */
	public Word getWord() {...}

	/**
	 * Don't know what is id used for, but you can get it
	 */
	public int getId() {...}

	/**
	 * When the pronunciation was added
	 */
	public Date getAddDate() {...}

	/**
	 * How much times the pronouncianion was listened
	 */
	public int getHits() {...}

	/**
	 * User, who added the pronunciation
	 */
	public User getUser() {...} // username, sex, country

	/**
	 * Get pronunciation's language
	 */
	public Language getLanguage() {...}

	/**
	 * Get pronunciation audio's (MP3/OGG) URL.
	 * @param format Format you prefer
	 */
	public URL getAudioURL(AudioFormat format) {...}

	/**
	 * Get pronounciation's rate
	 */
	public int getRate() {...}

	/**
	 * Get the number of positive votes
	 */
	public int getPositiveVotes() {...}

	/**
	 * Get the number of negative votes
	 */
	public int getNegativeVotes() {...}
}
