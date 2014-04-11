(ns sprengerjo.bowlingGame-test
  (:use clojure.test
        sprengerjo.bowlingGame
         midje.sweet))


(defn roll-many [rolls pins]
  (for [x (range rolls)] pins))

(facts
   "score of gutter game must be zero"
   (score (roll-many 20 0)) => 0
   "one pin games only"
   (score (roll-many 20 1)) => 20   
   "one spare, bonus must be added"
   (score (concat [5 5] (roll-many 18 1))) => (+ 5 5 1 18) 
   "strike bonus must be added"
   (score (conj  (roll-many 18 1) 10)) => (+ 10 1 1 18)
   "perfect game must be 300"
   (score (roll-many 12 10)) => 300
   )