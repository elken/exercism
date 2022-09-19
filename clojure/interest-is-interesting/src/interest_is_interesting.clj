(ns interest-is-interesting)

(defn interest-rate
  [balance]
  (if (< balance 0M)
    -3.213
    (cond (< balance 1000M) 0.5
          (< balance 5000M) 1.621
          :else 2.475)))

(defn yearly-interest
  [balance]
  (* (/ balance 100M) (bigdec (interest-rate balance))))

(defn annual-balance-update
  [balance]
  ((if (< balance 0M) - +) balance (yearly-interest balance)))

(defn amount-to-donate
  [balance tax-free-percentage]
  (let [donate (* balance (/ tax-free-percentage 100))]
    (->> (cond (> balance 0M) (* 2 donate)
               (< donate 0) 0
               :else donate)
         Math/floor
         int)))
