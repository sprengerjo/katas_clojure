(ns sprengerjo.fizzBuzz-test
  (:use clojure.test
        midje.sweet
        sprengerjo.fizzBuzz))

(facts 
  "1 must be 1"
  (fizz-buzz 1) => "1"
  "2 must be 2"
  (fizz-buzz 2) => "2"
  "3 must be fizz"
  (fizz-buzz 3) => "fizz"
  "5 must be buzz"
  (fizz-buzz 5) => "buzz"
  "6 must be fizz"
  (fizz-buzz 6) => "fizz"
  "10 must be buzz"
  (fizz-buzz 10) => "buzz"
  "15 must be fizzbuzz"
  (fizz-buzz 15) => "fizzbuzz"
 )

(fact 
  "just to be sure check all at once"
  (fizz-buzz-upTo 17) => ["1" "2" "fizz" "4" "buzz" "fizz" 
                          "7" "8" "fizz" "buzz" "11" "fizz" 
                          "13" "14" "fizzbuzz" "16" "17"])