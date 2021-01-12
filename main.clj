;; https://www.w3cschool.cn/clojure
(ns clojure.examples.hello
  (:require [clojure.set :as set])
  (:gen-class))

(require 'clojure.core)

(defn Example []
  (def x 1)
  (def y 1.25)
  (def str1 "Hello")
  (println x)
  (println y)
  (println str1)
  )
;; (Example)

(defn Example2 []
  (def x (+ 3 2))
  (println x)

  (def x (- 2 1))
  (println x)

  (def x (* 2 2))
  (println x)

  (def x (float(/ 2 1)))
  (println x)

  (def x (inc 2))
  (println x)

  (def x (max 1 3 5))
  (println x)

  (def x (rem 3 2))
  (println x))
(Example2)


(defn Example3 []
  (def x (atom 1))
  (while (< @x 5)
    (do
      (println @x)
      (swap! x inc))))
(Example3)

(defn doseq-test []
  (doseq [n [0 1 2]]
    (println n)))
(doseq-test)

(defn dotimes-test []
  (dotimes [n 5]
    (println n)))
(dotimes-test)

(defn loop-test []
  (loop [x 10]
    (when (> x 1)
      (println x)
      (recur (- x 2)))))
(loop-test)

(defn if-test []
  (if (= 2 2)
    (println "Values are equal")
    (println "Values are not equal")))
(if-test)

(defn if-do-test []
  (if (= 2 2)
    (do
      (println "Both the values are equal")
      (println "true"))
    (do
      (println "Both the values are not equal")
      (println "false"))))
(if-do-test)

(defn case-test []
  (def x 5)
  (case x 5 (println "x is 5")
        10 (println "x is 10")
        (println "x is neither 5 or 10")))
(case-test)

(defn cond-test []
  (def x 5)
  (cond
    (= x 5) (println "x is 5")
    (= x 10) (println "x is 10")
    :else (println "x is not defined")))
(cond-test)

(defn lambda-test []
  ((fn [x] (* 2 x)) 2))
(lambda-test)

(defn variable-arguments-test [message & others]
  (str message " " (clojure.string/join " " others)))
(variable-arguments-test "Hello" "This" "is" "the" "message")

(defn number-test []
  (def x 5)
  (def y 5.25)
  (println (type x))
  (println (type y)))
(number-test)

(defn recur-test []
  (loop [i 0]
    (when (< i 5)
      (println i)
      (recur (inc i)))))
(recur-test)

(defn slurp-test []
  (def string1 (slurp "Example.txt"))
  (println string1))
(slurp-test)

(println "----")

(defn spit-test []
  (spit "Example.txt"
        "This is a string"))
(spit-test)

;; 没有成功
(defn reader-test []
  (with-open [rdr (clojure.java.io/reader "Example.txt")]
    (reduce conj [] (line-seq rdr))))
(reader-test)

(defn writer-test []
  (with-open [w (clojure.java.io/writer "Example.txt" :append true)]
    (.write w (str "hello" "world"))))
(writer-test)

(defn file-test []
  (println (.exists (clojure.java.io/file "Example.txt"))))
(file-test)

(defn format-test []
  (println (format "Hello, %s" "World"))
  (println (format "Pad with leading zeros %06d" 1234)))
(format-test)

(defn subs-test []
  (println (subs "Hello world" 2 5))
  (println (subs "Hello world" 5 7)))
(subs-test)

(defn join-test []
  (println (clojure.string/join ", " [1 2 3])))
(join-test)

(defn split-test []
  (println (clojure.string/split "Hello world" #" ")))
(split-test)

(defn split-lines-test []
  (println (clojure.string/split-lines "Hello\nworld")))
(split-lines-test)

(defn number-list-test []
  (println (list 1 2 3 4))
  (println '(1 2 3 4)))
(number-list-test)

(defn symbol-list-test []
  (println (list 'a 'b 'c))
  (println '(a b c)))
(symbol-list-test)

(defn list*-test []
  (println (list* 1 [2, 3]))
  (println (list* 1 [2 3])))
(list*-test)

(defn cons-test []
  (println (cons 0 (list 1 2, 3)))
  (println (cons 0 '(1 2 3))))
(cons-test)

(println "conj-test")
(defn conj-test []
  (println (conj (list 1 2 3) 4 5)))
(conj-test)

(defn sorted-set-test []
  (println (sorted-set 3 2 1))
  )
(sorted-set-test)

(defn set-test []
  (println (get (set '(1 3 2)) 1))
  (println (contains? (set '(3 2 1)) 2))
  (println (conj (set '(3 4 2)) 5))
  (println (disj (set '(3 2 4)) 4)))
(set-test)

(defn union-test []
  (println (set/union #{1 2} #{4 3})))
(union-test)

(defn vector-of-test []
  (println (vector-of :int 1 2 3))
  (println (conj (vector 3 2 1) 4))
  (println (pop (vector 3 2 1))))
(vector-of-test)

(defn hash-map-test []
  (println (hash-map "z" "1" "b" "2" "a" "3"))
  (println (hash-map "z" 1 "b" 2 "a" 3))
  (def demokeys (hash-map "z" 1 "b" 2))
  (println (get demokeys "z"))
  (println (contains? demokeys "z"))
  (println (find demokeys "z"))
  (println (keys demokeys))
  (println (vals demokeys))
  (println (dissoc demokeys "b"))
  (def demokeys2 (hash-map "z" 2 "h" 5 "i" 7))
  (println (merge demokeys demokeys2))
  (println (merge-with + demokeys demokeys2))
  (println (select-keys demokeys2 ["z" "i"]))
  (println (set/rename-keys demokeys {"z" "newz" "b" "newb"}))
  (println (set/map-invert demokeys)))
(hash-map-test)

(defn sorted-map-test []
  (println (sorted-map "z" 1 "b" 2 "a" 3)))
(sorted-map-test)

(defn exception-test []
  (try
    (aget (int-array [1 2 3]) 5)
    (catch Exception e (println (str "caught exception: " (.toString e))))
    (finally (println "This is our final block")))
  (println "Let't move on")
  )
(exception-test)

(defn exception-test2 []
  (try
    (def string1 (slurp "test.txt"))
    (println string1)
    (catch java.io.FileNotFoundException e (println (str "file not found exception: " (.getMessage e))))
    (catch Exception e (println (str "caught exception: " (.getMessage e))))
    (finally (println "This is our final block")))
  (println "Let's move on"))
(exception-test2)

(defn seq-test []
  (println (cons 0 (seq [1 2 3])))
  (println (conj [1 2 3] 4))
  (def seq1 (seq [1 2]))
  (def seq2 (seq [3 4]))
  (println (concat seq1 seq2))
  (println (distinct (seq [1 1 2 3])))
  (println (first (seq [2 3 4])))
  (println (last (seq [2 3 4])))
  (println (rest (seq [2 3 4])))
  (println (sort (seq [3 2 1])))
  (println (drop 2 (seq [1 3 4])))
  (println (take-last 2 (seq [2 3 4 5])))
  (println (take 2 (seq [2 3 4 5 56])))
  (println (split-at 2 (seq [2 3 4 5 6])))
  )
(seq-test)

(defn reg-test []
  (def pat (re-pattern "\\d+"))
  (println (re-find pat "abic23"))
  (println (clojure.string/replace "abc123de" pat "789"))
  (println (clojure.string/replace-first "abc123de123" pat "89")))
(reg-test)

(defn predicates-test []
  (println ((every-pred number? even?) 2 4 6))
  (println ((every-pred number? odd?) 2 4 6))
  (println (every? even? '(2 4 6)))
  (println (every? odd? '(2 4 6)))
  (println (some even? '(1 2 3 4)))
  (println (not-any? even? '(2 4 6))))
(predicates-test)

(defn destructing-test []
  (def my-vector [1 2 3 4])
  (let [[a b c d] my-vector]
    (println a b c d))
  (let [[a b c d e f] [1 2 3 4]]
    (println a b c d e f))
  (let [[a b & the-rest] [1 2 3 4]]
    (println a b the-rest))
  (def my-map {"a" 1 "b" 2})
  (let [{a "a" b "b"} my-map]
    (println a b))
  (let [{a "a" b "b" c "c"} my-map]
    (println a b c)))
(destructing-test)

(defn date-test []
  (println (.toString (java.util.Date.)))
  (println (.format (java.text.SimpleDateFormat. "MM/dd/yyyy") (new java.util.Date)))
  (println (.getTime (java.util.Date.))))
(date-test)

(defn atom-test []
  (def myatom (atom 1))
  (println @myatom)
  (reset! myatom 2)
  (println @myatom)
  (compare-and-set! myatom 0 3)
  (println @myatom)
  (compare-and-set! myatom 2 335)
  (println @myatom)
  (swap! myatom inc)
  (println @myatom))
(atom-test)

(defn meta-test []
  (def mymap (with-meta [1 2 3] {:prop "values"}))
  (println (meta mymap))
  (def newmap (vary-meta mymap assoc :newprop "new values"))
  (println (meta newmap))
  )
(meta-test)

(defn struct-test []
  (println (defstruct Employee :EmployeeName :EmployeeId))
  (def emp (struct Employee "John" 1))
  (println emp)
  (def emp (struct-map Employee :EmployeeName "John" :EmployeeId 3))
  (println emp)
  (println (:EmployeeId emp))
  (println (:EmployeeName emp))
  (def newemp (assoc emp :EmployeeName "Jack" :EmployeeId 2))
  (println newemp)
  (println (assoc newemp :EmployeeRank "A"))
  )
(struct-test)

;; (defn proxy-test []
;;   (def counter (agent 1))
;;   (println counter)
;;   (println @counter)
;;   (send counter + 100)
;;   ;; 由于发送函数是异步函数，因此当代理的值被更新时存在时间延迟。 这就是为什么我们为程序添加了一个额外的'println'语句。 这是为了给Clojure环境相应地更新代理值所需的时间
;;   (println "Incrementing Counter")
;;   (println @counter)
;;   (shutdown-agents))
;; (proxy-test)

(defn watch-test []
  (def x (atom 0))
  (add-watch x :watcher
             (fn [key atom old-state new-state]
               (println "The value of the atom has been changed")
               (println "old-state" old-state)
               (println "new-state" new-state)))
  (reset! x 2)
  (remove-watch x :watcher)
  (reset! x 4))
(watch-test)

(defn macro-test []
  (defmacro Simple [arg]
    (list 2 arg))
  (println (macroexpand '(Simple 2))))
(macro-test)

(import java.util.Stack)
(defn java-test []
  (println (.toUpperCase "hello"))
  (println (.indexOf "Hello world" "e"))
  (def str1 (new String "Hello"))
  (println str1)
  (def my-int (new Integer 1))
  (println (+ 2 my-int))
  (let [stack (Stack.)]
    (.push stack "First")
    (.push stack "Second")
    (println (first stack)))
  (println (. Math PI))
  (println (.. System getProperties (get "java.version"))))
(java-test)

(defn concurrency-test []
  (def names (ref []))
  (defn change [newname]
    (dosync
      (alter names conj newname)))
  (change "John")
  (change "Mark")
  (println @names)
  
  (def var1 (ref 10))
  (def var2 (ref 20))
  (println @var1 @var2)
  (defn change-value [var1 var2 newvalue]
    (dosync
      (alter var1 - newvalue)
      (alter var2 + newvalue)))
  (change-value var1 var2 20)
  (println @var1 @var2))
(concurrency-test)
