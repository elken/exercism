(ns complex-numbers)

(defn exp [base power]
  (reduce * (repeat power base)))

(defn real [[a b]]
  a)

(defn imaginary [[a b]]
  b)

(defn abs [[a b]]
  (Math/sqrt (+ (exp a 2) (exp b 2))))

(defn conjugate [[a b]]
  [a (* b -1)])

(defn add [[a b] [c d]]
  [(+ a c) (+ b d)])

(defn sub [[a b] [c d]]
  [(- a c) (- b d)])

(defn mul [[a b] [c d]]
  [(- (* a c) (* b d)) (+ (* b c) (* a d))])

(defn div [[a b] [c d]]
  [(double (/ (+ (* a c) (* b d)) (+ (exp c 2) (exp d 2)))) (double (/ (- (* b c) (* a d)) (+ (exp c 2) (exp d 2))))])
