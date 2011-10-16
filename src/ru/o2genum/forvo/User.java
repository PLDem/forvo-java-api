package ru.o2genum.forvo;

/**
 * Represents the user who added pronounciation
 *
 * @author Andrey Moiseev
 */

public class User {
	private Sex sex;
	private String userName;
	private String country;

	public enum Sex { Male, Female };

	public User(String userName, Sex sex, String country) {
		this.userName = userName;
		this.sex = sex;
		this.country = country;
	}

	/**
	 * Get the username of the user 
	 */
	public String getUserName() { return userName; }

	/**
	 * Get the gender of the user
	 */
	public Sex getSex() { return sex; }

	/**
	 * Get the country where the user lives in (in English).
	 */
	public String getCountry() { return country; }
}
