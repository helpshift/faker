(ns faker.xss
  "Contains function to generate xss data."
  {:author "Mayank Jain <mayank@helpshift.com>"}
  (:require [faker.util :as util]))

(def xss-data (util/slurp-resource "xss_data.clj"))
(def xss-files (util/slurp-resource "xss_files.clj"))

(defn string
  "Gives you one random xss string out of the collection."
  []
  (rand-nth xss-data))

(defn filename
  "Gives you one random xss filename out of the collection."
  []
  (rand-nth xss-files))
