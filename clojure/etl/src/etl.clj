(ns etl
  (:require [clojure.string :as str]))

(defn transform
  [source]
  (reduce (fn [out-map [score values]]
            (reduce #(assoc %1 (str/lower-case %2) score) out-map values))
    {}
    source))
