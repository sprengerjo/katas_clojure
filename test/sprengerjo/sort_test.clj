(ns sprengerjo.sort_test
  (:use clojure.test
        midje.sweet
        clojure.core.match))


(defn quick-sort
  [[head & tail]]
  (if head
    (let [{lesser true greater false} (group-by #(< % head) tail)]
      (lazy-cat
        (quick-sort lesser)
        [head]
        (quick-sort greater))
      )
    []
    )
  )

(defn create-many [n]
  (take n (repeatedly #(rand-int 100)))
  )

(defn assert-many [list]
  (for [[a b] (partition 2 list)]
    (<= a b)
    )
  )

(facts
  "sort list"
  (quick-sort []) => []
  (quick-sort [1]) => [1]
  (quick-sort [2 1]) => [1 2]
  (quick-sort [1 3 2]) => [1 2 3]
  (quick-sort [2 1 3]) => [1 2 3]
  (quick-sort [3 1 2]) => [1 2 3]
  (quick-sort [3 2 1]) => [1 2 3]
  (quick-sort [1 2 3]) => [1 2 3]

  (-> 200000 create-many quick-sort assert-many) => (has every? true?)
  )


