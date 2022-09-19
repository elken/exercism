(ns cars-assemble)

(def hourly-rate 221)

(defn success-rate
  "Returns the success rate taking into account its speed"
  [speed]
  (cond (<= 1 speed 4) 1.0
        (<= 5 speed 8) 0.9
        (= 9 speed) 0.8
        (= 10 speed) 0.77
        :else 0.0))

(defn production-rate
  "Returns the assembly line's production rate per hour,
   taking into account its success rate"
  [speed]
  (-> (* speed hourly-rate)
      (* (success-rate speed))))

(defn working-items
  "Calculates how many working cars are produced per minute"
  [speed]
  (-> (production-rate speed)
      (/ 60)
      (int)))
