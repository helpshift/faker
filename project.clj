(defproject helpshift/faker "0.2.0"
  :description "Helpshift's Library for generating Fake Data."
  :url "https://engineering.helpshift.com"
  :license  {:name "Eclipse Public License"
             :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.10.3"]]

  :documentation {:site   "faker"
                  :output "docs"
                  :template {:path "template"
                             :copy ["assets"]
                             :defaults {:template     "article.html"
                                        :navbar       [:file "partials/navbar.html"]
                                        :dependencies [:file "partials/deps-web.html"]
                                        :navigation   :navigation
                                        :article      :article}}
                  :paths ["test/documentation"]
                  :files {"index"
                          {:input "test/documentation/faker_guide.clj"
                           :title "faker"
                           :subtitle "generation of fake data"}}}

  :profiles {:dev {:global-vars {*warn-on-reflection* true
                                 *assert* true}
                   :codox {:defaults {:doc "FIXME: Write docs."
                                      :doc/format :markdown}}
                   :dependencies [[midje "1.6.3"]
                                  [helpshift/hydrox "0.1.2"]
                                  [im.chit/hara.common.checks "2.2.7"] ;; this is a temporary fix
                                  ]
                   :plugins [[codox "0.8.10"]
                             [lein-midje "3.1.3"]]}})
