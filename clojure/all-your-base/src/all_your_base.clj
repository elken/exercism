(ns all-your-base)

(defn to-base-ten [digits base] (reduce #(+ (* base %1) %2) 0 digits))

(defn from-base-ten
  [n base]
  (loop [acc ()
         last-num n]
    (let [quotient (quot last-num base)
          acc (cons (rem last-num base) acc)]
      (if (zero? quotient) acc (recur acc quotient)))))

(defn convert
  [base-from digits base-to]
  (when (and (seq digits)
             (> base-from 1)
             (> base-to 1)
             (every? (partial contains? (set (range base-from))) digits))
    (from-base-ten (to-base-ten digits base-from) base-to)))
