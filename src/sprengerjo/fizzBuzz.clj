(ns sprengerjo.fizzBuzz)

(defn fizz-buzz [i]
  (if (= (mod i 15) 0) "fizzbuzz"
  (if (= (mod i 3) 0) "fizz"
  (if (= (mod i 5) 0) "buzz"
   (str i)))))

(defn fizz-buzz-upTo [n]
  (for [i (range 1 (inc n))] (fizz-buzz i)))