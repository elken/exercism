(ns sublist)

(defn sublist? [a b] (some #{a} (partition (count a) 1 b)))

(defn classify
  [list1 list2]
  (cond (= list1 list2) :equal
        (sublist? list1 list2) :sublist
        (sublist? list2 list1) :superlist
        :else :unequal))
