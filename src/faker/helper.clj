(ns faker.helper
  "Contains helper function for creating random data."
  {:author "Mayank Jain <mayank@helpshift.com>"}
  (:require [clojure.string :as cs]
            [faker.util :as util])
  (:import [java.util Locale]))

(def default-language :en)

(def lorem (util/slurp-resource "lorem.clj"))

(defn- stringify-stream
  "Takes a function like lazy-sentences/paragraphs/bodys,
   that returns a lazy stream, takes n elements from it and
   stringifies the output of that function.
   Also adds a separator between the elements of that stream.
   Like a \" \" between stream of words.
   And at the end adds a end-seperator.

   f => function which returns a lazy string stream.
   args => args to f
   sep => String like \" \"
   end-sep => String like \".\""
  [f args sep end-sep n]
  (as-> (f args) $
    (take n $)
    (cs/join sep $)
    (cs/capitalize $)
    (str $ end-sep)))

(defn- make-stream-of
  "Useful in generating lazy infinite sentences/paras/bodys"
  [f args [min-range max-range] sep end-sep]
  (map (partial stringify-stream
                f
                args
                sep
                end-sep)
       (repeatedly #(util/rand-int-range min-range
                                         max-range))))

(defn lazy-words
  "Lazy sequence of random words"
  [{:keys [lang fallback-lang]
    :or {fallback-lang default-language
         lang default-language}}]
  (repeatedly #(rand-nth (util/get-with-fallback-key lorem
                                                     lang
                                                     fallback-lang))))

(defn lazy-sentences
  "Lazy sequence of random sentences."
  [{:keys [words-range]
    :as args
    :or {words-range [4 10]}}]
  (make-stream-of lazy-words
                  args
                  words-range
                  " "
                  "."))

(defn lazy-paragraphs
  "Lazy sequence of random paragraphs."
  [{:keys [sentences-range]
    :as args
    :or {sentences-range [3 5]}}]
  (make-stream-of lazy-sentences
                  args
                  sentences-range
                  " "
                  ""))

(defn lazy-bodys
  "Lazy sequence of random bodys."
  [{:keys [paras-range
           para-sep]
    :as args
    :or {para-sep "<div> <br /> </div>"
         paras-range [1 5]}}]
  (make-stream-of lazy-paragraphs
                  args
                  paras-range
                  para-sep
                  ""))

(def ^{:doc "Special Case handling of Chinese since chinese traditional is not available in the JVM."}
  special-language-name {"zh" "Chinese (Simplified)"
                         "zh-hant" "Chinese (Traditional)"})


(defn available-languages*
  "Get all the available languages from the Locale class"
  []
  (merge (reduce (fn [m ^Locale l]
                   (assoc m
                     (.getLanguage l)
                     (.getDisplayLanguage l)))
                 {}
                 (Locale/getAvailableLocales))
         special-language-name))
