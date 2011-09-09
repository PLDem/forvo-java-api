package ru.o2genum.forvo;

public class ApiKey {
	static String key = "";

	public static void setKey(String apiKey) {
		key = apiKey;
	}

	public static String getKey() {
		if(key.length() == 0) {
			throw new IllegalStateException("ApiKey is empty! Looks like it " +
					"wasn't set!");
		}
		return key;
	}
}
