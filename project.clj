(defproject helpshift/faker "0.1.0"
  :description "Helpshift's Library for generating Fake Data."
  :url "https://engineering.helpshift.com"
  :license  {:name "TBD" :url "TBD"}
  :dependencies [[org.clojure/clojure "1.6.0"]]
  :profiles {:dev {:global-vars {*warn-on-reflection* true
                                 *assert* true}
                   :codox {:defaults {:doc "FIXME: Write docs."
                                      :doc/format :markdown}}
                   :plugins [[codox "0.8.10"]
                             [s3-wagon-private "1.1.2"]]
                   :repositories [["private" {:url "s3p://maven.helpshift.com/releases/"
                                              :username :env
                                              :passphrase :env}]]}})
