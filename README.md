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

Class structure is very simple and obvious. 

Note: when you call method (or construct new object) with many perameters, you can omit some of them, providing `null` instead of objects, `-1` instead of some reasonable positive integer values.

Javadoc
-------
TODO: generate javadoc

Issues
-------
Forvo JSON output seems strange: sometimes integer values are represented as strings, sometimes as ints. I wrote to forvo team, and I'm waiting for result. I will not use XML instead, because it's too cumbersome, and now I can't use JSON too, because I need to know the type (string/int) of every value. So, development is suspended for some time...

Examples
--------
TODO: provide some examples

Et cetera
---------
Don't forget to read about Forvo API at http://api.forvo.com/documentation/general-information/
