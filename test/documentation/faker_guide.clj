(ns documentation.faker-guide
  (:use midje.sweet)
  (:require [faker.generate :as gen]
            [faker.core :refer :all]))

[[:chapter {:title "Introduction"}]]

[[:section {:title "Overview"}]]

"[faker](https://www.github.com/helpshift/faker) is a library for generating string-like inputs for testing data. It currents supports output of:

- Random strings of various units (words, sentences, paragraphs, bodys).
- A built-in collection of words from 45 languages.
- A built-in collection of XSS-attack-like strings to use for XSS attack testing.
- Random English Quotes (Useful when you want actual sentences)."

[[:section {:title "Installation"}]]

"In your project.clj, add faker to the `[:profiles :dev :dependencies]` entry:

```clojure
(defproject ...
    ...
    :profiles {:dev {:dependencies [...
                                    [helpshift/faker \"{{PROJECT.version}}\"]
                                    ...]}}
    ...)
```
"

"All functionality is the `faker.generate` namespace:"

(comment
  (require '[faker.generate :as gen]))

[[:chapter {:title "Usage"}]]

[[:section {:title "Random Words"}]]

[[:reference {:refer faker.core/words :mode :source}]]

[[:reference {:refer faker.core/words :mode :docs}]]

[[:section {:title "Random Sentences"}]]

[[:section {:title "Multilingual"}]]

[[:section {:title "Random Quotes"}]]

[[:chapter {:title "References"}]]

[[:chapter {:title "Links"}]]
