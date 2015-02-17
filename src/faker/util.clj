(ns faker.util
  "Contains utility function"
  {:author "Mayank Jain <mayank@helpshift.com>"}
  (:require [clojure.java.io :as io]))

(let [rand-int-range* (comp rand-nth range)]
  (defn rand-int-range
    "Generates a random number between [min-count,max-count]"
    ([max-count]
     (rand-int-range 0 max-count))
    ([min-count max-count]
     {:pre [(>= max-count min-count)]}
     (rand-int-range* min-count (inc max-count)))))

(defn get-with-fallback-key
  "get-wfk => get-with-fallback-key
   Given a map, key & a fallback-key,
   It'll look up the key in the given map, if found returns its result.
   Else it'll return the result of the fallback-key.
   If the fallback-key is also not found it'll throw an error."
  [m k fallback-key]
  (cond
    (contains? m k) (get m k)
    (contains? m fallback-key) (get m fallback-key)
    :else (throw (Exception. (format "Could not find key %s or fallback-key %s in the given map, having keys=> %s"
                                     k
                                     fallback-key
                                     (keys m))))))

(defn slurp-resource
  "Given a filename in resource directory,
   it'll read the contents of that filename."
  [filename]
  (-> filename
      io/resource
      slurp
      read-string))
