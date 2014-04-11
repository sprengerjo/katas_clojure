(ns sprengerjo.tennisGame)

(defn player-one-score [scores] 
  (seq (conj scores "One")))

(defn transform-score [n]
  (cond 
    (= n 0) "love"
    (= n 1) "fifteen"
    (= n 2) "thirty"
    :else "fourty"))

(defn score [scoreOne scoreTwo]
  (if(= 0 (+ scoreOne scoreTwo)) "love all"
   (str (transform-score scoreOne) 
        " " (transform-score scoreTwo))))