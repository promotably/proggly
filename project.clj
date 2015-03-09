(defproject org.clojars.promotably/proggly "0.1.8"
  :description "Clojure Loggly Appender for Log4j"
  :url "http://github.com/promotably/proggly"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.6.0"]
                 [log4j/log4j "1.2.17"]
                 [http-kit "2.1.16"]]
  :aot [proggly.core]
  :profiles {:dev {:dependencies [[midje "1.6.3"]
                                  [org.clojure/tools.logging "0.3.1"]
                                  [org.slf4j/slf4j-log4j12 "1.7.9"]]}})
