(ns accumulate)

(defn accumulate
  [f list]
  (if (empty? list) [] (cons (f (first list)) (accumulate f (rest list)))))
