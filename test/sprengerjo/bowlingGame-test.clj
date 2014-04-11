(ns sprengerjo.bowlingGame-test
  (:use clojure.test
        sprengerjo.bowlingGame))


(defn roll-many [rolls pins]
  (for [x (range rolls)] pins))

(deftest gutter-game 
  (testing "score of gutter game ni zero")
   (is (= 0 (score (roll-many 20 0)))))

(deftest one-pin-game
  (testing "one pin games only")
   (is (= 20 (score (roll-many 20 1)))))

(deftest one-spare 
  (testing "one spare, bonus must be added")
   (is (= (+ 5 5 1 18) (score (concat [5 5] (roll-many 18 1)))
          )))

(deftest strike-bonus
  (testing "strikebonus must be added")
   (is (= (+ 10 1 1 18) (score (conj  (roll-many 18 1) 10)))))

(deftest perfect-game 
  (testing "perfect game must be 300")
   (is (= 300 (score (roll-many 12 10)))))

(run-tests)