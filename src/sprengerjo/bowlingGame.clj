(ns sprengerjo.bowlingGame)
 
(defn score [pins]
 (reduce + (concat pins (mapcat 
        (fn [a b c] (cond (= 10 a) [b c] (= 10 (+ a b)) [c] :else []))
             pins (drop 1 pins) (drop 2 pins)))))
