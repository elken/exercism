(ns collatz-conjecture)

(defn collatz [num]
  (loop [acc 0
         num num]
    (cond
      (<= num 0) (throw (IllegalArgumentException.))
      (= 1 num) acc
      (even? num) (recur (inc acc) (int (/ num 2.0)))
      (odd? num) (recur (inc acc) (+ (* 3 num) 1)))))

