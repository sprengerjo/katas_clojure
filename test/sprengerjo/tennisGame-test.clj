(ns sprengerjo.tennisGame-test
    (:use clojure.test
        sprengerjo.tennisGame))

(deftest transform-0-must-be-love
  (testing "0 points must be love")
   (is (= "love" (transform-score 0))))

(deftest transform-1-must-be-fifteen
  (testing "1 must be fifteen")
   (is (= "fifteen" (transform-score 1))))

(deftest transform-2-must-be-thirty
  (testing "2 must be thirty")
   (is (= "thirty" (transform-score 2))))

(deftest transform-3-must-be-fourty
  (testing "3 must be fourty")
   (is (= "fourty" (transform-score 3))))


;(deftest player-one-scores
;  (testing "a sequence of scores must be constructed")
;   (is (seq? (player-one-scores empty))))

(deftest intial-score-must-be-loveall
  (testing "intial score must be love all")
  (is (= "love all" (score 0 0))))

(deftest player-one-scores
  (testing "player one scores, score must be fifteen all")
   (is (= "fifteen love" (score 1 0))))

(run-tests)