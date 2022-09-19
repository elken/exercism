(ns elyses-destructured-enchantments)

(defn first-card
  "Returns the first card from deck."
  [deck]
  (let [[head] deck] head))

(defn second-card
  "Returns the second card from deck."
  [deck]
  (let [[_ second] deck] second))

(defn swap-top-two-cards
  "Returns the deck with first two items reversed."
  [deck]
  (let [[head second & tail] deck] (vec (conj tail head second))))

(defn discard-top-card
  "Returns a sequence containing the first card and
   a sequence of the remaining cards in the deck."
  [deck]
  (let [[head & tail] deck] [head tail]))

(def face-cards ["jack" "queen" "king"])

(defn insert-face-cards
  "Returns the deck with face cards between its head and tail."
  [deck]
  (let [[head & tail] deck]
    (vec (remove nil? (flatten [head face-cards tail])))))
