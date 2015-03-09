(ns proggly.core
  (:require [org.httpkit.client :as http])
  (:import [org.apache.log4j Level]
           [org.apache.log4j.spi LoggingEvent])
  (:gen-class :name com.promotably.proggly.LogglyAppender
              :extends org.apache.log4j.AppenderSkeleton
              :state state
              :init init
              :methods [[logglyURL [String] void]]))

(defn -init []
  [[] (atom {})])

(defn -logglyURL [this url]
  (swap! (.state this) #(assoc % :url url)))

(defn -append [this ^LoggingEvent event]
  (let [threshold (.getThreshold this)
        endpoint (:url @(.state this))]
    (try
      (.setThreshold this Level/OFF)
      (http/post endpoint {:headers {"Content-Type" "text/plain"}
                           :body (.format (.getLayout this) event)
                           :timeout 2000})
      (catch Exception e
        (.error (.getErrorHandler this) (.getMessage e)))
      (finally
        (.setThreshold this threshold)))))

(defn -close [_])
(defn -requiresLayout [_] true)
