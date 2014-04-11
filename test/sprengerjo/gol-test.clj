(ns sprengerjo.gol-test
  (:use clojure.test
        sprengerjo.gol))

(deftest neighbours-must-contain-north
  (testing "neighbours must contain north neighbour"
    (is ((neighbours [1 1]) [1 0]))))

(deftest neighbours-must-contain-south
  (testing "neighbours must contain south neighbour"
    (is ((neighbours [2 2]) [1 2]))))

(deftest neighbours-must-not-contain-cell-itself
  (testing "neighbours must not contain cell itself"
    (is (not ((neighbours [2 2]) [2 2])))))

(deftest all-neighbours-must-be-contained
  (testing "neighbours of 2/2"
    (is (=(neighbours [2 2]) 
                 #{[2 1] [3 2] [3 3] [1 1] [2 3] [1 2] [1 3] [3 1]}))))

(deftest cells-without-neughbours-do-not-survive
  (testing "only one cell must die"
           (is (empty? (stepper #{[0 0]})))))

(deftest cells-with-one-neighbour-must-die
  (testing "only one neighbour that is far away, so the cell must die"
           (is (empty? (stepper #{[0 0] [3 3]})))))

(deftest cell-with-two-neighbours-must-survive
  (testing "two neighbours, so the cell must live"
           (is (not (empty? (stepper #{[0 0] [0 1] [0 2]}))))))

(def blinker #{[1 0] [1 1] [1 2]})

(deftest cell-with-three-neighbours-must-die
  (testing "cells with three neighbours dies"
           (is (= #{[2 1] [1 1] [0 1]} (stepper blinker)))))

(deftest cell-after-5-iterations
  (testing "cells after 5 iterations"
           (is (= #{[1 0] [1 1] [1 2]} (step-over-to 5 blinker)))))


(run-tests)