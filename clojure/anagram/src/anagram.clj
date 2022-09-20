(ns anagram
  (:require [clojure.string :as str]))

(defn anagrams-for
  [word prospect-list]
  (let [word (str/lower-case word)
        sorted-word (sort (seq word))]
    (filter (fn [word-candidate]
              (let [word-candidate (str/lower-case word-candidate)]
                (and (= sorted-word (sort (seq word-candidate)))
                     (not (= word word-candidate)))))
      prospect-list)))
