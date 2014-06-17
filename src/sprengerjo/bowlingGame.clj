(ns sprengerjo.bowlingGame)
 
(defn remove-last-strike [pins]
  (if (= 10 (last pins)) 
    (drop-last pins) 
       pins))

(defn frame-bonus [a b c]
  (cond 
    (= 10 a) [b c] 
    (= 10 (+ a b)) [c] 
    :else []))

(defn bonus [pins]
  (mapcat frame-bonus pins 
     (drop 1 pins) 
       (drop 2 (remove-last-strike pins))))

(defn score [pins]
  (reduce + (concat pins (bonus pins))))
