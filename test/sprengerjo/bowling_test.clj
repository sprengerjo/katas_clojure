(ns sprengerjo.bowling_test
    (:use clojure.test
        sprengerjo.bowlingGame
         midje.sweet))


(defn roll-many [rolls pins]
  (for [x (range rolls)] pins))

(facts
   "scores should be calculated as expected"
   (score (roll-many 20 0)) => 0
   (score (roll-many 20 1)) => 20
   (score (concat [5 5 5 5] (roll-many 16 1))) => (+ 5 5 5 5 5 1 16)
   (score (conj  (roll-many 18 1) 10)) => (+ 10 1 1 18)
   (score (roll-many 12 10)) => 300
   )