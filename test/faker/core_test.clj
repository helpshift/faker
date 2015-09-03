(ns faker.core-test
  (:use midje.sweet)
  (:require [faker.core :refer :all]))

^{:refer faker.core/words :added "0.2"}
(fact "Returns a list of words, the default is to return a single word"
  (words) => (contains [string?])

  "The default language is :en"
  
  (words {:n 10}) => (ten-of string?)

  "Other languages are possible"
  
  (words {:n 10 :lang :de}) => (ten-of string?))
