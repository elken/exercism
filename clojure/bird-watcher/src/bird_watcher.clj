(ns bird-watcher)

(def last-week [0 2 5 3 7 8 4])

(defn today [birds] (last birds))

(defn inc-bird [birds] (assoc birds (- (count birds) 1) (+ 1 (today birds))))

(defn day-without-birds? [birds] (true? (some #(= 0 %) birds)))

(defn n-days-count [birds n] (reduce + (take n birds)))

(defn busy-days [birds] (reduce #(if (<= 5 %2) (+ 1 %1) %1) 0 birds))

(defn odd-week? [birds] (every? #(= [1 0] %1) (partition 2 2 [0] birds)))
