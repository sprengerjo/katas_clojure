(ns sprengerjo.bowlingGame)

(defn frame-bonus [[a b c] sum]
  (cond
    (= 10 a) (+ b c sum)
    (= 10 (+ a b)) (+ c sum)
    :else sum))

(defn bonus [rolls]
  (loop [sum 0
         rs rolls]
    (if (<= (count rs) 3)
      sum
      (recur (frame-bonus rs sum) (drop (if (= 10 (first rs)) 1 2) rs)))))

(defn sum [ns]
  (reduce + ns))

(defn score [pins]
  (sum ((juxt sum bonus) pins)))
