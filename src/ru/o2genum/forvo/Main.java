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
			Scanner sc = new Scanner(System.in);
			ApiKey.setKey(sc.nextLine());
			List<Pronunciation> l =
				new Word(sc.nextLine()).getPronunciations();
			for(Pronunciation p : l) {
				System.out.println(p.getLanguage().getLanguageName());
				System.out.println(p.getAudioURL(Pronunciation.AudioFormat.OGG));
			}
		} catch(Exception ex) {
			ex.printStackTrace();
		}
	}
}
