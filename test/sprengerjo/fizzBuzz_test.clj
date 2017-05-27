(ns sprengerjo.fizzBuzz_test
  (:use clojure.test
        midje.sweet
        sprengerjo.fizzBuzz))

(facts
  "parameter must be transformed to particular string"
  (fizz-buzz 1) => "1"
  (fizz-buzz 2) => "2"
  (fizz-buzz 3) => "fizz"
  (fizz-buzz 5) => "buzz"
  (fizz-buzz 6) => "fizz"
  (fizz-buzz 10) => "buzz"
  (fizz-buzz 15) => "fizzbuzz"
 )

(fact
  "just to be sure check all at once"
  (fizz-buzz-upTo 17) => ["1" "2" "fizz" "4" "buzz" "fizz"
                          "7" "8" "fizz" "buzz" "11" "fizz"
                          "13" "14" "fizzbuzz" "16" "17"])
