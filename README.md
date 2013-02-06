Forvo Java API
==============
Forvo pronunciation guide provides a huge database of words and their pronunciations. Luckily, Forvo has [free API](http://api.forvo.com/). Before you begin, you need to register your forvo.com account, obtain your API key, and, of course, read general information about API.

What's next?
============
 * Download [Forvo Java API JAR] (https://github.com/o2genum/forvo-java-api/blob/master/build/jar/forvo-java-api.jar?raw=true)
 * Look for javadoc in `javadoc/` directory or [download it](https://github.com/o2genum/forvo-java-api/blob/master/build/jar/forvo-java-api-javadoc.jar?raw=true)
 * Download special [GSON](https://github.com/o2genum/forvo-java-api/blob/master/lib/fixed-gson-1.7.1.jar?raw=true) JAR (fixed for Android HTC)
 * And [Apache Commons Codec](http://commons.apache.org/codec/): my library uses those JARs
 * Have fun!

```java
import java.util.*;

import ru.o2genum.forvo.*; // This package contains all you need

public class Main {
	public static void main(String[] args) {
		// API's methods are full of exceptions. So we use try block
		try {
			// First of all, we have to set API key. We ask user for it
			System.out.println("Please, enter your API key and press ENTER:");
			ApiKey.setKey(new Scanner(System.in).nextLine());
            // Also, we should set request host, it depends on your plan.
            // For free plan, it is apifree.forvo.com
            // If you don't call this method, free plan host is the default value.
            ApiKey.setHost("apifree.forvo.com"); // NEW feature!
            /* Or:
               ApiKey.setHost("apipremium.forvo.com"); // For premium
            */
			// For example, let's search for words like "привет"
			// and find out their pronounciations.
			List<WordAndPronunciation> list = 
				new Word("привет") // We construct new Word object
					.searchPronouncedWords(); // and search for similar words
											  // (that have at least one
											  // pronunciation)
			// Yeah! Now we have the list of word-pronunciation pairs!
			// Let's output each found word and its URL of OGG pronunciation sound
			for(WordAndPronunciation wap : list) {
				System.out.println(
					wap.getWord()    // We get Word from Word-Pronunciation pair
					.getWord()       // Seems similar, but now we get Word's
							      ); // String itself.
			System.out.println(wap.getPronunciation()
					.getAudioURL(Pronunciation.AudioFormat.OGG);
			}
		} catch (Exception ex) {
			System.out.println(ex.getMessage()); // If something went wrong
		}
	}
}
```
Check it out! Don't forget about dependencies. The program will output numerous words and one pronunciation URL for each word. Open the first of the URLs in your browser. Now you know hot to say "hello" in Russian!

License
-------
Open Source Initiative (OSI) MIT License.
