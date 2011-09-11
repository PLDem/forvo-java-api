package ru.o2genum.forvo;

/**
 * Pepresents word's pronunciation
 *
 * @author Andrey Moiseev
 */

import java.net.URL;
import java.util.Date;

public class Pronunciation {

	public enum AudioFormat { MP3, OGG }

	private Word word;
	private int id = -1;
	private Date addDate;
	private int hits = -1;
	private User user;
	private Language language;
	private URL pathMp3;
	private URL pathOgg;
	private int rate = -1;
	private int numVotes = -1;
	private int positiveVotes = -1;

	public Pronunciation(String word) {
		this.word = new Word(word);
	}

	public Pronunciation(Word word) {
		this.word = word;
	}

	public Pronunciation(int id, Date addDate, int hits,
			User user, Language language, String mp3Path,
			String oggPath, int rate, int numVotes, int numPositiveVotes) 
		throws Exception {
		this.id = id;
		this.addDate = addDate;
		this.hits = hits;
		this.user = user;
		this.language = language;
		this.pathMp3 = new URL(mp3Path);
		this.pathOgg = new URL(oggPath);
		this.rate = rate;
		this.numVotes = numVotes;
		this.positiveVotes = numPositiveVotes;
	}

	/**
	 * Get word for which the pronunciation is provided
	 */
	public Word getWord() { return word; }

	/**
	 * Don't know what is id used for, but you can get it
	 */
	public int getId() { return id; }

	/**
	 * When the pronunciation was added
	 */
	public Date getAddDate() { return addDate; }

	/**
	 * How much times the pronouncianion was listened
	 */
	public int getHits() { return hits; }

	/**
	 * User, who added the pronunciation
	 */
	public User getUser() { return user; } // username, sex, country

	/**
	 * Get pronunciation's language
	 */
	public Language getLanguage() { return language; }

	/**
	 * Get pronunciation audio's (MP3/OGG) URL.
	 * @param format Format you prefer
	 */
	public URL getAudioURL(AudioFormat format) {
		return format == AudioFormat.MP3 ? pathMp3 : pathOgg;
	}

	/**
	 * Get pronounciation's rate
	 */
	public int getRate() { return rate; }

	/**
	 * Get the number of positive votes
	 */
	public int getPositiveVotes() { return positiveVotes; }

	/**
	 * Get the number of negative votes
	 */
	public int getNegativeVotes() { return numVotes - positiveVotes; }
}
