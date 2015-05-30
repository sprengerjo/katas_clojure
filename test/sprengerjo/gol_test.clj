(ns sprengerjo.gol-test
  (:use clojure.test
        sprengerjo.gol
        midje.sweet))

(facts 
  "neighbours of [1 1] contain north neighbour"
   (neighbours [1 1])  => #{[2 1] [1 0] [2 2] [0 0] [0 1] [1 2] [0 2] [2 0]}
   "neighbours of 2/2"
   (neighbours [2 2]) => #{[2 1] [3 2] [3 3] [1 1] [2 3] [1 2] [1 3] [3 1]}
)

(facts
  (def blinker #{[1 0] [1 1] [1 2]})
   "only one cell must die"
   (stepper #{[0 0]}) => empty?
   "only one neighbour that is far away, so the cell must die"
   (stepper #{[0 0] [3 3]}) => empty?
   "two neighbours, so the cell must live"
   (stepper #{[0 0] [0 1] [0 2]}) =not=> empty?
    "cells with three neighbours dies"
    (stepper blinker) => #{[2 1] [1 1] [0 1]}
    "cells after 5 iterations"
    (step-over-to 5 blinker) => #{[1 0] [1 1] [1 2]}
)