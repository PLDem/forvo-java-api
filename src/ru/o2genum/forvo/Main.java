package ru.o2genum.forvo;

/**
 * This class is just for testing
 *
 * @author Andrey Moiseev
 */

import java.util.*;

import ru.o2genum.forvo.*;

public class Main {
	public static void main(String[] args) {
		try {
			ApiKey.setKey(new Scanner(System.in).nextLine());
			List<WordAndPronunciation> l =
				new Word("привет").searchPronouncedWords();
			for(WordAndPronunciation wap : l) {
				System.out.println(wap.getWord().getWord());
				System.out.println(wap.getPronunciation()
						.getAudioURL(Pronunciation.AudioFormat.OGG));
			}
		} catch(Exception ex) {
			ex.printStackTrace();
		}
	}
}
