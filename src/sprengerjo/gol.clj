(ns sprengerjo.gol)

(defn neighbours [[x y]]
 (set (for [dx [-1 0 1] dy (if (zero? dx) [-1 1] [-1 0 1])]
        [(+ dx x) (+ dy y)])))

(defn stepper [cells] 
  (set (for [[cell n] (frequencies (mapcat neighbours cells)) 
        :when (or (= n 3) (and (= n 2) (cells cell)))] cell)))

(defn step-over [n cells]
  (take n (iterate stepper cells)))

(defn step-over-to [n cells] 
  (nth  (step-over n cells) (dec n)))

(defn create-world [cells]
  (def i 5)
  (concat "#"
  (for [x (range i)]
    (seq (for [y (range i)]
      (if (cells [x y]) "x" "-"))))))

(defn print-world [n cell]
  (mapcat println (mapcat create-world 5 (step-over n cell))))