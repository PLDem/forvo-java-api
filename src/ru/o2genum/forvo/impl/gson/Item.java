package ru.o2genum.forvo.gson;

public class Item {

	public int id;

	public String addtime;

	public int hits;

	public String username;

	public String sex;

	public String country;

	public String code;

	public String langname;

	public String pathmp3;

	public String pathogg;

	public int rate;

	public int num_votes;

	public int num_positive_votes;
	// Oops! Sometimes num_positive_votes is int:
	// http://apifree.forvo.com/key/bd1ea80089bf823e55791eff92168548/format/json/action/word-pronunciations/word/cat/language/en
}
