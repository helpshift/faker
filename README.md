# faker

A Clojure library to generate arbitrary text strings, in various languages.

## faker Artifacts

faker artifacts are [released to Clojars](https://clojars.org/helpshift/faker).

### With Leiningen

Add dependency in your `project.clj`:

[![Clojars Project](http://clojars.org/helpshift/faker/latest-version.svg)](http://clojars.org/helpshift/faker)


## Features:
* Generate random strings of various units (words, sentences, paragraphs, bodys).
* A built-in collection of words from 45 languages.
* A built-in collection of XSS-attack-like strings to use for XSS attack testing.
* Get random English Quotes (Useful when you want actual sentences).

You could also check out http://paraseba.github.com/faker/ as an alternative to this.

## Usage

Basic usage:

The main functionality is provided by the faker.generate namespace.

First, require it in the REPL:

```clojure
> (require '[faker.generate :as gen])
nil
```

To generate a random word (by default it's english)
```clojure
> (gen/word)
"opinion"
```

If you would like to specifiy the language say french, pass the language code.
```clojure
> (gen/word {:lang :fr})
"la plaie""
```

To find out supported language codes:
```clojure
> gen/available-languages
{"sq" "Albanian", "ar" "Arabic", .... }
```

Here's an example of generating random english sentence of varying word size between 1 to 10 (both inclusive).
```clojure
> (gen/sentence {:words-range [1,10]})
"Rice journey writing song."

> (gen/sentence {:words-range [1,10]})
"Fall."
```

A real world usecase is to generate say a map of string title, a summary paragraph, a body and a list of tags.
```clojure
> (let [lang-code :fr]
    {:title (gen/sentence {:lang lang-code
                           :words-range [5,10]})
     :summary (gen/paragraph {:lang lang-code
                              :sentence-range [1 5]})
     :body (gen/body {:lang lang-code
                      :paras-range [2 5]})
     :tags (gen/words {:lang lang-code
                       :n 5})})

{:title "Le sexe le pain fruits l'ombre société fille pli la relation la suggestion la religion.",
 :summary "La demande le sourire nombre la musique le bruit. le cuir route la prose le confort. voyage la peinture le transport la taille nombre l'ombre. l'ordre son impulsion le mois la suggestion la peur portier.",
 :body "La dette la musique la haine le courant. minute le papier le tissu le rythme rouleau coup de pied la chaleur. danger la surprise l'approbation portier animal. l'amour la lecture le laiton le gouvernement la nation la page avant manière. bits route de le rythme.<div> <br /> </div>signe la de copier la chose. le cuir flamme note la criminalité l'hiver de la vapeur la mort. la distance l'attraction le temps le verset. la concurrence le sentiment le mien.<div> <br /> </div>à la fin un lieu minute la conception l'amour le besoin. fils impression arrêter baiser le doute la laine la tendance la douleur la pâte fiche. parler sang la tendance le besoin. la courbe un lieu mordre personne le respect la maladie le sel mouvement la discussion l'observation.",
 :tags ("pleurer" "la langue" "pleurer" "l'air" "or")}
```

Sometimes you may also want actual Sentences. faker provides a collection of english sentences.
```clojure
> (require '[faker.quote :as q])
nil

> (q/rand-quote)
"Whenever I climb I am followed by a dog called 'Ego'."
```

Note: Currently it only supports english quotes.
if you pass another language it'll fallback to the english language.
You can override this by passing the fallback-lang key.

```clojure
> (q/rand-quote {:lang :fr})
"A doctor can bury his mistakes but an architect can only advise his clients to plant vines."

> (q/rand-quote {:lang :fr
                 :fallback-lang :not-found})
Exception Could not find key :fr or fallback-key :not-found in the given map, having keys=> (:en)  faker.util/get-with-fallback-key (util.clj:28)

> (q/rand-quote {:lang :en
                :fallback-lang :not-found})
"I will tell you how to become rich. Close the doors. Be fearful when others are greedy. Be greedy when others are fearful."
```

Similarly you can get xss data
```clojure
> (require '[faker.xss :as xss])
nil

> (xss/filename)
"xss-data.tmp"

> (xss/string)
"<SCRIPT SRC=\"http://ha.ckers.org/xss.jpg\"></SCRIPT>"
```

**Please check the following namespaces for more documentation:**

* faker.generate
* faker.quote
* faker.xss

## License

Copyright © Helpshift Inc. 2015

Licensed under the EPL (see the file epl.html).
