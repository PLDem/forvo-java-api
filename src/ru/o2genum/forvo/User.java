package ru.o2genum.forvo;

/**
 * Represents the user who added pronounciation
 *
 * @author Andrey Moiseev
 */

public class User {

	public enum Sex { Male, Female };

	public User(String userName, Sex sex, String country) {...}

	/**
	 * Get user's username
	 */
	public String getUserName() {...}

	/**
	 * Get user's sex
	 */
	public Sex getSex() {...}

	/**
	 * Get user's country (in English)
	 */
	public String getCountry() {...}
}
