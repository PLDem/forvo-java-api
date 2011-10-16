package ru.o2genum.forvo;

public class ApiKey {
	static String key = "";

    /**
     * Set API key. You can obtain it at {@link 
     * <a href="http://api.forvo.com/">http://api.forvo.com
     * </a>}.
     * Don't forget to set.
     */
	public static void setKey(String apiKey) {
		key = apiKey;
	}

    /**
     * Get (preset) API key. Just for symmetry.
     * Don't think you will use this method.
     */
	public static String getKey() {
		if(key.length() == 0) {
			throw new IllegalStateException("ApiKey is empty! Looks like it " +
					"wasn't set!");
		}
		return key;
	}
}
