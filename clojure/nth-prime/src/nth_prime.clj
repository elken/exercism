(ns nth-prime)

(defn is-prime [num]
  (cond
    (= num 2) true
    (<= num 1) false
    :else (reduce (fn [_ n]
                    (let [remainder (rem num n)]
                      (if (= remainder 0)
                        (reduced false)
                        (> remainder 0))))
                  false
                  (let [sqrt (int (Math/sqrt num))]
                    (if (< sqrt 2)
                      (list 2)
                      (range 2 (+ 1 sqrt)))))))

(defn nth-prime
  "Returns the prime number in the nth position."
  [n]
  (cond
    (<= n 0) (throw (IllegalArgumentException.))
    (= n 1) 2
    :else (loop [idx 1
                 last-num 2]
            (let [next-num (inc last-num)
                  prime (is-prime next-num)]
              (if (and prime
                       (= idx (- n 1)))
                next-num
                (recur (if prime (inc idx) idx) next-num))))))
