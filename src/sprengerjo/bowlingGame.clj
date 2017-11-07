(ns sprengerjo.bowlingGame)

(defn frame-bonus [[a b c] sum]
  (cond
    (= 10 a) (+ b c sum)
    (= 10 (+ a b)) (+ c sum)
    :else sum))

(defn drop-frame [[first]]
  (if (= 10 first)
    rest
    (partial drop 2)))

(defn bonus [rolls]
  (loop [sum 0
         rs rolls]
    (if (<= (count rs) 3)
      sum
      (recur (frame-bonus rs sum) ((drop-frame rs) rs)))))

(def sum (partial reduce +))

(defn score [pins]
  (sum ((juxt sum bonus) pins)))
