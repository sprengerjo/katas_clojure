(ns sprengerjo.fizzBuzz)

(defn fb [f b i]
  (str f b (when (clojure.string/blank? (str f b)) i)))

(defn fizz-buzz-upTo [n]
  (take n (map fb
               (cycle ["" "" "fizz"])
               (cycle ["" "" "" "" "buzz"])
               (iterate inc 1))))

(defn fizz-buzz [i]
  (nth (fizz-buzz-upTo i) (dec i)))


