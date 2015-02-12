(ns faker.generate
  "Contains function and data to create random data.
  Supports generation of data for various languages.
  Fall backs to english if translation not available.
  Inspired by: https://github.com/paraseba/faker"
  {:author "Mayank Jain <mayank@helpshift.com>"}
  (:require [faker.util :as util]
            [faker.helper :as h]))

;; Public Functions to generate a list of word/sentence/paragraph/body

(defn words
  "Returns n word string list
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
  "Gets n sentence string list of words between [min-words,max-words]
   n => number of sentences
        Default 1.
   lang => :en, :hi etc
           Default :en
   fallback-lang => if the given lang is missing use this lang
                    Default :en"
  ([]
   (sentences {}))
  ([{:keys [n
            min-words max-words
            lang fallback-lang]
     :or {n 1}
     :as args}]
   (take n (h/lazy-sentences args))))

(defn paragraphs
  "Gets n paragraph string list of sentences between [min-sentences,max-sentences]
   n => number of paragraphs
        Default 1.
   lang => :en, :hi etc
           Default :en
   fallback-lang => if the given lang is missing use this lang
                    Default :en"
  ([]
   (paragraphs {}))
  ([{:keys [n
            min-words max-words
            min-sentences max-sentences
            lang fallback-lang]
     :or {n 1}
     :as args}]
   (take n (h/lazy-paragraphs args))))

(defn bodys
  "Gets n body string list of paragraphs between [min-paras,max-paras]
   n => number of bodys
        Default 1.
   lang => :en, :hi etc
           Default :en
   fallback-lang => if the given lang is missing use this lang
                    Default :en"
  ([]
   (paragraphs {}))
  ([{:keys [n
            min-words max-words
            min-sentences max-sentences
            min-paras max-paras
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
   lang => :en, :hi etc
           Default :en
   fallback-lang => if the given lang is missing use this lang
                    Default :en"
  ([]
   (sentence {}))
  ([{:keys [min-words max-words lang fallback-lang]
     :as args}]
   (first (sentences args))))

(defn paragraph
  "Returns a single paragraph string.
   lang => :en, :hi etc
           Default :en
   fallback-lang => if the given lang is missing use this lang
                    Default :en"
  ([]
   (paragraph {}))
  ([{:keys [min-sentences max-sentences lang fallback-lang]
     :as args}]
   (first (paragraphs args))))

(defn body
  "Returns a single body string.
   lang => :en, :hi etc
           Default :en
   fallback-lang => if the given lang is missing use this lang
                    Default :en"
  ([]
   (body {}))
  ([{:keys [n
            min-words max-words
            min-sentences max-sentences
            min-paras max-paras
            lang fallback-lang]
     :as args}]
   (first (bodys args))))
