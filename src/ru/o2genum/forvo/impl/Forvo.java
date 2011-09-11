package ru.o2genum.forvo.impl;

/**
 * Collection of forvo API methods
 *
 * @author Andrey Moiseev
 */

import ru.o2genum.forvo.Language;
import ru.o2genum.forvo.Pronunciation;
import ru.o2genum.forvo.User;
import ru.o2genum.forvo.Word;
import ru.o2genum.forvo.WordAndPronunciation;
import ru.o2genum.forvo.impl.gson.Item;
import ru.o2genum.forvo.impl.gson.LanguageList;
import ru.o2genum.forvo.impl.gson.LanguagePopular;
import ru.o2genum.forvo.impl.gson.StandardPronunciation;
import ru.o2genum.forvo.impl.gson.Total;
import ru.o2genum.forvo.impl.gson.WordPronunciations;
import ru.o2genum.forvo.impl.gson.WordsSearchAndPopular;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.LinkedList;
import java.util.Scanner;

public class Forvo {

	// Language methods
	public static List<Language> getLanguageList(Language.Order order,
			int minPronunciations) throws Exception {
		LanguageList ll = ForvoGson.getLanguageList(order,
				minPronunciations);
		List<Language> ll2 = (List<Language>) new LinkedList<Language>();
		for(int i = 0; i < ll.items.length; i++) {
			Language lang = new Language(ll.items[i].code,
					ll.items[i].en);
			ll2.add(lang);
		}
		return ll2;
	}

	public static List<Language> getPopularLanguages(Language.Order order,
			int limit) throws Exception {
		LanguagePopular lp = ForvoGson.getPopularLanguages(order, limit);
		List<Language> l = (List<Language>) new LinkedList<Language>();
		for(int i = 0; i < lp.items.length; i++) {
			Language lang = new Language(lp.items[i].code,
					lp.items[i].en);
			l.add(lang);
		}
		return l;
	}

	public static char[] getLanguageAlphabet(Language language)
		throws Exception {
		return ForvoGson.getLanguageAlphabet(language).items;
	}

	// Word methods
	public static List<Pronunciation> getPronunciations(Word word,
			Language language, User user, int rate, Word.Order order,
			int limit) throws Exception {
		WordPronunciations wp = ForvoGson.getPronunciations(word, language,
				user, rate, order, limit);
		List<Pronunciation> pl = (List<Pronunciation>)
			new LinkedList<Pronunciation>();
		for(int i = 0; i < wp.items.length; i++) {
		pl.add(generatePronunciationFromItem(wp.items[i]));
		}
		return pl;
	}

	public static Pronunciation getStandardPronunciation(Word word,
			Language language) throws Exception {
		StandardPronunciation sp = ForvoGson.getStandardPronunciation(word,
				language);
		return generatePronunciationFromItem(sp.items[0]);
	}

	public static List<WordAndPronunciation> searchWords(Word word,
			boolean pronouncedOnly, Language language, int pageSize,
			int page) throws Exception {
		if(word == null) {
			throw new IllegalArgumentException("Word must not be null!");
		} else if (word.getWord() == null) {
			throw new IllegalArgumentException("Word's word field is not set!");
		}

		WordsSearchAndPopular wsap = ForvoGson.searchWords(word, pronouncedOnly,
				language, pageSize, page);

		List<WordAndPronunciation> l = (List<WordAndPronunciation>)
			new LinkedList<WordAndPronunciation>();

		for(int i = 0; i < wsap.items.length; i++) {
			WordAndPronunciation wap =
				new WordAndPronunciation(
						new Word(wsap.items[i].word, wsap.items[i].id,
							wsap.items[i].original,
							wsap.items[i].num_pronunciations),
						generatePronunciationFromItem(
							wsap.items[i].standard_pronunciation));
			l.add(wap);
		}
		return l;
	}

	public static List<WordAndPronunciation> getPopularPronouncedWords(
			Language language, int limit) throws Exception {
		WordsSearchAndPopular wsap = 
			ForvoGson.getPopularPronouncedWords(language, limit);
		List<WordAndPronunciation> l = (List<WordAndPronunciation>)
			new LinkedList<WordAndPronunciation>();

		for(int i = 0; i < wsap.items.length; i++) {
			WordAndPronunciation wap =
				new WordAndPronunciation(
						new Word(wsap.items[i].word, wsap.items[i].id,
							wsap.items[i].original,
							wsap.items[i].num_pronunciations),
						generatePronunciationFromItem(
							wsap.items[i].standard_pronunciation));
			l.add(wap);
		}
		return l;
	}

	public static int getTotalPronouncedWords(Language language)
		throws Exception {
		Total total = ForvoGson.getTotalPronouncedWords(language);
		return total.attributes.total;
	}

	public static int getTotalPronunciations(Language language)
		throws Exception {
		Total total = ForvoGson.getTotalPronounciations(language);
		return total.attributes.total;
	}

	// Helper methods
	private static Date toDate(String str) throws Exception { 
		String readyToParse = str.replace('-', ' ').replace(':', ' ');
		Scanner sc = new Scanner(readyToParse);
		Calendar calendar = Calendar.getInstance();
		calendar.set(sc.nextInt(), sc.nextInt(), sc.nextInt(),
				sc.nextInt(), sc.nextInt(), sc.nextInt());
		return calendar.getTime();
	}

	private static Pronunciation generatePronunciationFromItem(Item item)
	throws Exception {
		return new Pronunciation(item.id,
					toDate(item.addtime), item.hits,
					new User(item.username,
						item.sex.equals("m") ? 
						User.Sex.Male : User.Sex.Female, item.country),
					new Language(item.code, item.langname),
					item.pathmp3, item.pathogg, item.rate,
					item.num_votes, item.num_positive_votes);
	}
}
