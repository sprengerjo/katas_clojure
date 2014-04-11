(ns sprengerjo.bowlingGame)

(defn sum [n pins] (reduce + (take n pins)))

(defn strike? [pins]
  (= 10 (first pins)))

(defn spare? [pins]
(= 10 (reduce + (take 2 pins))))
  
(defn score [pins]
  (cond
   (empty? pins) 0
	 (strike? pins) (+ (sum 3 pins) (score (drop (if (= 3 (count pins)) 3 1) pins)))
	 (spare? pins) (+ (sum 3 pins) (score (drop 2 pins)))
   :else  (+ (sum 2 pins) (score (drop 2 pins)))))