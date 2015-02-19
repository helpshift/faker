(ns faker.generate
  "Contains function and data to create random data.
  Supports generation of data for various languages.
  Fall backs to english if translation not available.
  Inspired by: https://github.com/paraseba/faker"
  {:author "Mayank Jain <mayank@helpshift.com>"}
  (:require [faker.util :as util]
            [faker.helper :as h]))

;; Public Vars

(def available-languages
  "Returns a map of key => language code and value as the language name
   supported by this namespace.
   The map is sorted by language name (for readability purpose)"
  (let [locale-map (h/available-languages*)]
    (into (sorted-map-by (fn [k1 k2]
                           (compare (locale-map k1)
                                    (locale-map k2))))
          locale-map)))

;; Public Functions to generate a list of word/sentence/paragraph/body

(defn words
  "Returns n word string list.

   n => number of words
        Default 1.
   lang => :en, :hi etc
           Default :en
   fallback-lang => if the given lang is missing use this lang
                    Default :en"
  ([]
   (words {}))
  ([{:keys [n]
     :or {n 1}
     :as args}]
   (take n (h/lazy-words args))))

(defn sentences
  "Gets n sentence string list of words.

   words-range => (Optional) Sequence of [min-words,max-words]
   n => number of sentences
        Default 1.
   lang => :en, :hi etc
           Default :en
   fallback-lang => if the given lang is missing use this lang
                    Default :en"
  ([]
   (sentences {}))
  ([{:keys [n
            words-range
            lang fallback-lang]
     :or {n 1}
     :as args}]
   (take n (h/lazy-sentences args))))

(defn paragraphs
  "Gets n paragraph string list of sentences.

   words-range => (Optional) Sequence of [min-words,max-words]
   sentences-range => (Optional) Sequence of [min-sentences,max-sentences]
   n => number of paragraphs
        Default 1.
   lang => :en, :hi etc
           Default :en
   fallback-lang => if the given lang is missing use this lang
                    Default :en"
  ([]
   (paragraphs {}))
  ([{:keys [n
            words-range sentences-range
            lang fallback-lang]
     :or {n 1}
     :as args}]
   (take n (h/lazy-paragraphs args))))

(defn bodys
  "Gets n body string list of paragraphs.

   para-sep => (Optional) String seperator between paras.
               Default: \"<div> <br /> </div>\"

   words-range => (Optional) Sequence of [min-words,max-words]
   sentences-range => (Optional) Sequence of [min-sentences,max-sentences]
   paras-range => (Optional) Sequence of [min-paras,max-paras]

   n => number of bodys
        Default 1.
   lang => :en, :hi etc
           Default :en
   fallback-lang => if the given lang is missing use this lang
                    Default :en"
  ([]
   (paragraphs {}))
  ([{:keys [n
            words-range sentences-range paras-range
            lang fallback-lang]
     :or {n 1}
     :as args}]
   (take n (h/lazy-bodys args))))

;; Public Functions to generate a single word/sentence/paragraph/body

(defn word
  "Returns a single word string.

   lang => :en, :hi etc
           Default :en
   fallback-lang => if the given lang is missing use this lang
                    Default :en"
  ([]
   (word {}))
  ([{:keys [lang fallback-lang]
     :as args}]
   (first (words args))))

(defn sentence
  "Returns a single sentence string.

   words-range => (Optional) Sequence of [min-words,max-words]

   lang => :en, :hi etc
           Default :en
   fallback-lang => if the given lang is missing use this lang
                    Default :en"
  ([]
   (sentence {}))
  ([{:keys [words-range
            lang fallback-lang]
     :as args}]
   (first (sentences args))))

(defn paragraph
  "Returns a single paragraph string.

   words-range => (Optional) Sequence of [min-words,max-words]
   sentences-range => (Optional) Sequence of [min-sentences,max-sentences]

   lang => :en, :hi etc
           Default :en
   fallback-lang => if the given lang is missing use this lang
                    Default :en"
  ([]
   (paragraph {}))
  ([{:keys [words-range sentences-range
            lang fallback-lang]
     :as args}]
   (first (paragraphs args))))

(defn body
  "Returns a single body string.

   para-sep => (Optional) String seperator between paras.
               Default: \"<div> <br /> </div>\"

   words-range => (Optional) Sequence of [min-words,max-words]
   sentences-range => (Optional) Sequence of [min-sentences,max-sentences]
   paras-range => (Optional) Sequence of [min-paras,max-paras]

   lang => :en, :hi etc
           Default :en
   fallback-lang => if the given lang is missing use this lang
                    Default :en"
  ([]
   (body {}))
  ([{:keys [words-range sentences-range paras-range
            lang fallback-lang]
     :as args}]
   (first (bodys args))))
