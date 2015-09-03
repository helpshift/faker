(ns faker.core
  {:author "Mayank Jain <mayank@helpshift.com>"}
  (:require [faker.util :as util]
            [faker.helper :as h]))

(defn words
  "Returns a list of words, the default is to return a single word
   (words) => (contains [string?])

   The default language is :en

   (words {:n 10}) => (ten-of string?)

   Other languages are possible

   (words {:n 10 :lang :de}) => (ten-of string?)"
  {:added "0.2"}
  ([]
   (words {}))
  ([{:keys [n]
     :or {n 1}
     :as args}]
   (take n (h/lazy-words args))))
