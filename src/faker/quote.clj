(ns faker.quote
  "Contains function to generate random quotes data."
  {:author "Mayank Jain <mayank@helpshift.com>"}
  (:require [faker.util :as util]))

(def default-language :en)

(def quotes (util/slurp-resource "quotes.clj"))

(defn quote
  "Gives you one random quote string out of the collection.
   lang => :en, :hi etc
           Default :en
   fallback-lang => if the given lang is missing use this lang
                    Default :en"
  ([]
   (quote {}))
  ([{:keys [lang fallback-lang]
     :or {fallback-lang default-language
          lang default-language}}]
   (rand-nth (util/get-with-fallback-key quotes
                                         lang
                                         fallback-lang))))
