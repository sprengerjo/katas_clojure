(ns sprengerjo.fizzBuzz)

(defn fizz-buzz [i]
  (-> i
      fizz-buzz-upTo
      (nth i)
      ))

(defn fizz-buzz-upTo [n]
  (let [c constantly s #(str (inc %)) [f b] [(c "fizz") (c "buzz")] fb (c (str (f) (b)))]
    (take n (map-indexed #(%2 %) (cycle [s s f s b f s s f b s f s s fb])))))
