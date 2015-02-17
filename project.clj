(defproject helpshift/faker "0.1.1"
  :description "Helpshift's Library for generating Fake Data."
  :url "https://engineering.helpshift.com"
  :license  {:name "Eclipse Public License"
             :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.6.0"]]
  :profiles {:dev {:global-vars {*warn-on-reflection* true
                                 *assert* true}
                   :codox {:defaults {:doc "FIXME: Write docs."
                                      :doc/format :markdown}}
                   :plugins [[codox "0.8.10"]]}})
