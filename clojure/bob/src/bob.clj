(ns bob
  (:require [clojure.string :as str]))

(defn is-question [s] (str/ends-with? s "?"))

(defn is-yelled [s] (and (re-find #"[A-Z]" s) (not (re-find #"[a-z]" s))))

(defn response-for
  [s]
  (cond (empty? (.trim s)) "Fine. Be that way!"
        (and (is-question s) (is-yelled s)) "Calm down, I know what I'm doing!"
        (is-question (.trim s)) "Sure."
        (is-yelled s) "Whoa, chill out!"
        :else "Whatever."))
