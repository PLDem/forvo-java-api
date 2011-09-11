Forvo Java API
==============
Forvo pronunciation guide provides a huge database of words and their pronunciations. Luckily, Forvo has [free API](http://api.forvo.com/). Before you begin, you need to register your forvo.com account, obtain your API key, and, of course, read general information about API.

What's next?
============
 * Download [GSON](http://code.google.com/p/google-gson/)'s JAR
 * And [Apache Commons Codec](http://commons.apache.org/codec/): my library uses those JARs
 * Have fun!

```java
import java.util.*;

import ru.o2genum.forvo.*; // This package contains all you ned

public class Main {
	public static void main(String[] args) {
		// API's methods are full of exceptions. So we use try block
		try {
			// First of all, we have to set API key. We ask user for it
			System.out.println("Please, enter your API key and press ENTER:");
			ApiKey.setKey(new Scanner(System.in).nextLine());
			// For example, let's search for words like "привет"
			// and find out their pronounciations.
			List<WordAndPronunciation> list = 
				new Word("привет") // We construct new Word object
					.searchPronouncedWords(); // and search for similar words
											  // (that have at least one
											  // pronunciation)
			// Yeah! Now we have the list of word-pronunciation pairs!
			// Let's output each found word and it's OGG pronunciation sound
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