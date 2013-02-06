package ru.o2genum.forvo;

public class ApiKey {
	static String key = "";
    static String host = "apifree.forvo.com";

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
     * Set host address. Depends on your plan (free or premium),
     * defaults to <code>apifree.forvo.com</code>
     */
    public static void setHost(String newHost) {
        host = newHost;
    }

    /**
     * Get host address.
     */
    public static String getHost() {
        return host;
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
