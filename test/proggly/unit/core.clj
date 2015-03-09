(ns proggly.unit.core
  (:require [clojure.test :refer :all]
            [clojure.tools.logging :as log]
            [midje.sweet :refer :all])
  (:import [com.promotably.proggly LogglyAppender]
           [org.apache.log4j Logger]))

(facts "Can instantiate"
  (class (LogglyAppender.)) => LogglyAppender)

(facts "Can assign URL"
  (let [url "https://logs.loggly.com/inputs/1234"
        appender (LogglyAppender.)]
    (.logglyURL appender url) => anything
    (:url @(.state appender)) => url))
