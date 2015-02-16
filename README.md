# faker

A Clojure library to generate data in various languages.

Features:
* Generate random strings of various units (words, sentences, paragraphs, bodys).
* Supports 44 languages.
* Random String generation with greater control.
* Generate XSS attack strings for testing.
* Get random English Quotes.

You could also check out http://paraseba.github.com/faker/ as an alternative to this.

## Usage

Basic usage:

```clojure
> (require '[faker.generate :as gen])
nil

> (gen/word)
"opinion"

> (gen/word {:lang :hi})
"न्यायाधीश"
> (gen/sentence {:words-range [1,10]})
"Rice journey writing song."

> (gen/sentence {:words-range [1,10]})
"Fall."
```

Please check faker.generate, faker.quote & faker.xss ns for more documentation.

## License

Copyright © Helpshift Inc. 2015

Licensed under the EPL (see the file epl.html).
