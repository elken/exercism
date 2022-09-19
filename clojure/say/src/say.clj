(ns say
  (:require [clojure.pprint :refer [cl-format]]
            [clojure.string :as str]))

(defn number
  [num]
  (if (<= 0 num 999999999999)
    (str/replace (cl-format nil "~R" num) "," "")
    (throw (IllegalArgumentException.))))

;; Got really close, not quite right.
;; (def number-level
;;   "List of numbers and string lengths"
;;   {3 "hundred",
;;    4 "thousand",
;;    6 "hundred thousand",
;;    7 "million",
;;    10 "billion",
;;    13 "trillion"})

;; (def number-digits
;;   {0 "zero",
;;    1 "one",
;;    2 "two",
;;    3 "three",
;;    4 "four",
;;    5 "five",
;;    6 "six",
;;    7 "seven",
;;    8 "eight",
;;    9 "nine"})

;; (def number-teens
;;   {10 "ten",
;;    11 "eleven",
;;    12 "twelve",
;;    13 "thirteen",
;;    14 "fourteen",
;;    15 "fifteen",
;;    16 "sixteen",
;;    17 "seventeen",
;;    18 "eighteen",
;;    19 "nineteen"})

;; (def number-tens
;;   {2 "twenty",
;;    3 "thirty",
;;    4 "fourty",
;;    5 "fifty",
;;    6 "sixty",
;;    7 "seventy",
;;    8 "eighty",
;;    9 "ninety"})

;; (defn- partition-number
;;   [num]
;;   (let [num (str num)
;;         number-size (count num)
;;         remainder (rem number-size 3)]
;;     (when (zero? remainder) (partition 3 num))
;;     (concat (map #(concat (repeat (- 3 remainder) \0) %)
;;               (partition-all 3 (take remainder num)))
;;             (partition 3 (drop remainder num)))))

;; ;; (defn- number-to-digits
;; ;;   "Given a number, return the composite digits"
;; ;;   [num]
;; ;;   (reverse (map-indexed #(* %2 (reduce * (repeat %1 10)))
;; ;;                         (reverse (map #(Character/digit % 10) (str
;; num))))))

;; (defn- chars->words
;;   [chars]
;;   (let [[hundred ten digit] chars]
;;     (remove nil?
;;       (cond (= \0 ten) (map #(get number-digits %) chars)
;;             (= \1 ten) (list (when-not (= \0 hundred)
;;                                (get number-digits hundred))
;;                              (get number-teens (str ten digit)))
;;             :else (list (when-not (= \0 hundred) (get number-digits
;;             hundred))
;;                         (get number-tens ten)
;;                         (get number-digits digit))))))

;; ;; (defn- number-to-words
;; ;;   "Given a number, convert it to English words."
;; ;;   [num]
;; ;;   (if (number-to-word num)
;; ;;     (number-to-word num)
;; ;;     (str/join "-" (map number-to-word (number-to-digits num)))))

;; (defn group-thousands
;;   [num]
;;   (loop [n num
;;          res ()]
;;     (if (zero? n) res (recur (quot n 1000) (conj res (mod n 1000))))))

;; (defn number-to-words
;;   [num]
;;   (condp >= num
;;     9 (get number-digits num)
;;     19 (get number-teens num)
;;     99 (str/join "-"
;;                  [(get number-tens (quot num 10))
;;                   (get number-digits (mod num 10))])
;;     999 (str/join " "
;;                   [(number-to-words (quot num 100)) "hundred"
;;                    (number-to-words (mod num 100))])))

;; (defn add-suffixes
;;   [groups]
;;   (let [suffixes ["" "thousand" "million" "billion"]]
;;     (->> groups
;;          reverse
;;          (map-indexed #(str/join " " [%2 (suffixes %1)]))
;;          reverse)))

;; (defn number
;;   [num]
;;   (if (<= 0 num 999999999999)
;;     (->> num
;;          group-thousands
;;          (map number-to-words)
;;          add-suffixes
;;          (str/join " "))
;;     (throw (IllegalArgumentException.))))

;; (number 1000)

;; (map chars->words (partition-number 99))

;; (let [[hundred ten digit] (first (partition-number 99))] ten)

;; (map #(Character/digit % 10) (str 999999))
