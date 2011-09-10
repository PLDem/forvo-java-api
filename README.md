Forvo Java API
==============
If you're interested in Forvo API, you likely know what Forvo is.

Overview
--------
The API is very simple: it consists of a few classes:

 * `Word`, it represents a word, provides some important methods for searching pronunciations, get popular words, etc.,
 * `Pronunciation`, represents a pronunciation,
 * `Language`, represents language and provides methods for getting popular languages, etc.,
 * `User` represents a user,
 * `WordAndPronunciation` is a simple container for a `Word`-`Pronunciation` pair.

Class structure is very obvious. 

Javadoc
-------
TODO: generate javadoc

Issues
-------
 * I used to think that [GSON](http://code.google.com/p/google-gson/) will not parse quoted values such as "100" as integers, but I was wrong: GSON does it.

Examples
--------
TODO: provide some examples

Et cetera
---------
Don't forget to read about Forvo API at http://api.forvo.com/documentation/general-information/
