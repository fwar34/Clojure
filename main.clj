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

(defn test [[k v]]
  [k (inc v)])
(map test {:b 3 :a 4})

(type 1111111111111111111111111111111111111111)
(type (/ 1 2))

(def t {:hello 1})
(def s1 #{1 2 3})
(s1 3)
(s1 4)

(def m1 {:age 10 :name {:firstname "John" :surname "Smith"}})
(get m1 :name)
(get-in m1 [:name :surname])
(assoc m1 :height 50)
;; update和assoc的区别在于update可以把原来的值作为生成新的值的一个参数，其实他也等同于你用get之后再用assoc，用下面的等式来表达
;; (update m k f) = (assoc m k (f (get m k)))
(update m1 :age (fn [x] (+ x 1)))

;; -> 将第一个参数当成后面的参数（函数）的第一个参数
(-> {:name {:fullname "Xiao Wang"} :from {:Country "China" :City "Beijing"}}
    (assoc-in [:from :City] "Shanghai")
    (update-in [:name :fullname] (fn [full-name] (clojure.string/split full-name #" "))))

;; ----------------------------
;; https://my.oschina.net/clopopo/blog/142589
(def alphabet "abcdefghijklmnopqrstuvwxyz")
(def alphabet-length (fn [] (count alphabet)))
(def alphabet-length2 #(count alphabet))
(defn select-random
  "从一个列表中随机返回一个元素"
  {:added "1.2"} ;; 元数据metadata
  [options]
  (nth options (rand-int (count options))))
(select-random (list "growl" "lick" "jump"))

(defn greeting
  "Composes a greeting sentence. Expects both the name of a greeter
  and the name of whom is to be greeted for arguments. An approach
  and an action are randomly selected."
  {:added "1.2"}
  [greeter whom]
  (str greeter " greeted " whom " with a "
       (select-random (list "ferocious" "wimpy" "precarious" "subtle")) " "
       (select-random (list "growl" "lick" "jump")) "!"))
(greeting "John" "Thaddeus")

;; ----------------------------
;; https://my.oschina.net/clopopo/blog/142705
(defn add [v1 v2 & others]
  (+ v1 v2
     (if others
       (reduce + 0 others)
       0)))
(add 1 2)
(add 1 2 3)

;; ----------------------------
;; https://my.oschina.net/clopopo/blog/142982
(meta #'select-random)
(def approaches
  (with-meta
    (list "ferocious" "wimpy" "precarious")
    {:creator "tim"}))
(meta approaches)

;; ----------------------------
;; https://my.oschina.net/clopopo/blog/143000
(defn msec []
  (System/currentTimeMillis)) ;;这里的斜线相当于java中的 "."
(msec)
;; 上面是静态方法调用的展示，下面再来看看如果调用实例方法。让我们创建两个java.util.Date对象。
;; 注意，之前我们使用的都是java.lang下面的类，所以不需要手动导入。非lang包下的必须手动导入（和java一样一样的）。 
(import java.util.Date)  ;;手动导入Date (语法都和java一样）
(Date.) ;;创建Date对象 
(class (Date.))
(defn date
  ([] (Date.))
  ([systime] (Date. systime)))
(date)
(date 1307328017335)

(import java.text.SimpleDateFormat)
(defn format-date
  ([] (format-date (date) "yyyy MM dd HH mm ss"))
  ([x] (if (string? x)
         (format-date (date) x)
         (format-date x "yyyy MM dd HH mm ss")))
  ([dt fmt] (.format (SimpleDateFormat. fmt) dt)))
(format-date)
(format-date (date 404534000000))
(format-date "yyyy/MM/dd HH:mm:ss")
(format-date (date 404534000000) "yyyy/MM/dd HH:mm:ss")

;; ----------------------------
;; https://my.oschina.net/clopopo/blog/143294
;; https://clojure.github.io/clojure-contrib/str-utils-api.html
;; clojure-contrib is now deprecated
;; clojure-contrib is no longer being developed or maintained.
;; Rather than a single, monolithic, contributions library, 
;; Clojure now has a set of separate libraries for each unit of functionality
(defn date-list
  ([] (clojure.string/split (format-date) #"\W+"))
  ([systime] (clojure.string/split (format-date systime) #"\W+")))
(date-list)

;; ----------------------------
;; https://my.oschina.net/clopopo/blog/145319
;; 不过，用下面这种方式，如果传入的键值对少于9个，它实际上创建的是ArrayMap而不是HashMap: 
(class {:a 1 :b 2})
(class {:a 1 :b 2 :c 3 :d 4 :e 5 :f 6 :g 7 :h 8 :i 9})
;; 如果是map的键是关键字类型，关键字直接可以当做函数使用
(def m {:key1 1 :key2 2})
(:key1 m)
;; map本身也可以用于取值，这种适应于任意类型的key
(m :key1)
;; 一种更好的方式是使用get函数，因为可以设置缺省值。 (get 也可以用于向量，把key变成索引值即可）
(get m :key1)
(get m :key3 "default")
;; 我们可以使用get-in 获取嵌套map的值 
(def m {:username "sally"
        :profile {:name "Sally Clojurian"
                  :address {:city "Austin" :state "TX"}}})
(get-in m [:profile :name])
(get-in m [:profile :address])
(get-in m [:profile :address :city])
;; 如果键不存在，可以设置默认值 
(get-in m [:profile :address :zip-code] "no zip code!")
;; 我敢说这是json好么！！！ (get-in 函数可不只是用于map，向量也可以使用get-in操作）

;; 没则增加，有则修改 conj
(conj {:name "qh" :age 20} {:age 30} {:gender 'male})
;; 没则增加，有则修改 merge
(merge {:name "qh" :age 20} {:age 30} {:gender 'male})
;; assoc是操作map和对应的元素，上面两个操作的是多个map，注意区别
(assoc {:name "qh" :age 20} :age 30 :gender 'male)
;; 删除
(dissoc {:name "qh" :age 20} :name)
(def m {:name "qh" :age 30})
(dissoc m :name)
;; m没有改变
(println m)

;; sorted-map
(def sm (sorted-map :c 1 :b 2 :f 3 :a 3))
(println sm)
;; 有序map增删改查操作和上面一样。 

;; ----------------------------
;; https://my.oschina.net/clopopo/blog/148993
;;;; 事物型引用 (Transactional References)
;; {{包装引用对象 
;; 包装一个空的哈希表
(ref (hash-map))
;; 绑定一个Ref类型对象，该Ref包装了一个哈希表
(def vehicles (ref {:trunk "Toyota" :car "Subaru" :plane "de Havilland"}))
vehicles
;; }}

;; {{解引用对象 
;; 接上面的例子，我们已经有了一个被包装在Ref类型之下的一个对象vehicles，
;; 但有很多函数需要访问被包装的对象，而不是这个引用对象
;; vehicles 不是一个map，所以会报错
(vals vehicles)
(map? vehicles)
(class vehicles)
;; 我们可以使用defref函数来获取封装在Ref内部的对象，当然还有一种更简洁的方式就是使用@符号：
(deref vehicles)
@vehicles
(map? @vehicles)
(keys @vehicles)
;; }}

;; {{修改引用对象
;; 我们引用对象的目的，就是想修改它。之所以叫作事务型引用，
;; 是因为我们必须在一个事务中去修改它。在事务中（例如dosync使用alter函数是最安全的修改方式，
;; 它能确保我们在事务操作期间，其他对这个对象的改变都不会发生。 
(dosync
  (alter vehicles assoc :car "Volkswagon"))
;; vehicles是真的被改变了，而不是返回一个新的对象
@vehicles
(dosync
  (alter vehicles dissoc :car))
@vehicles
;; 如果你不关心引用对象原来的值的话，可以使用ref-set来设置一个新的值 
(dosync
  (ref-set vehicles {:motorcycle "Ducati"}))
;; }}

;;;; 原子类型 (Atoms)
;; 和引用类型(Ref)类似，原子也是创建一个管卡来修改一个不可变对象，
;; 并且原子也能和Ref一样进行同步更新。但是原子并不要求在事务中运行，
;; 并且它们不能协调多个状态的更新。（多个Ref类型对象可以在一个事务中协调更新，
;; 要么同时成功，要么同时失败，即回滚） 
(def vehicles (atom ["Toyota Tacoma" "Subaru Outback" "de Havilland Beaver"]))
vehicles
(class vehicles)
(deref vehicles)
@vehicles
;; {{修改原子对象
;; 我们可以使用swap！函数或者reset！函数（名字后面有感叹号在lisp方言中代表修改函数之意）
;; 来修改被原子包装的对象。swap！用于在原来值的基础上进行修改，reset！则是直接用新值替换原来的值。 
(swap! vehicles conj "Ducati Diavel")
@vehicles
(reset! vehicles (take 2 @vehicles))
@vehicles
;; }}

;; ----------------------------
;; https://my.oschina.net/clopopo/blog/149922
(defn multiple? [n div]
  (= 0 (mod n div)))
(multiple? 3 3)
(multiple? 4 3)
(doseq [i (range 0 101)]
  (cond (and (multiple? i 3)
             (multiple? i 5)) (println "FizzBuzz")
        (multiple? i 3) (println "Fizz")
        (multiple? i 5) (println "Buzz")
        :else (println i)))

;; for循环是另一种迭代的方式，但是接下来你会发现使用for循环不适合解决FizzBuzz问题。
;; for循环的语法和doseq是一样的，只不过for 返回lazy seq（类似python 中的yield）
;; 而doseq是side effect。这么说有点抽象，还是用例子来说明吧： 

;; 我们原想返回0-10中所有的偶数，但是得到的结果是nil
(doseq [x (range 0 11) :when (even? x)] x)

;; 使用doseq只能返回nil，不够我们可以在遍历期间做其他事情。比如 打印
(doseq [x (range 0 10) :when (even? x)] (println x ","))

;; 我们使用for来获取0-10中所有的偶数
(for [x (range 0 10) :when (even? x)] x)
;; 可以这么说，使用doseq就向java中的for循环，只能在循环过程中做些什么事情，
;; 而clojure中的for循环可以在每次的遍历中向外输出值，最终由这些值组成一个序列。

;; 再用个例子体会一下 
(for [x [0 1 2 3 4 5]
      :let [y (* x 3)]
      :when (even? y)] y)

;; for循环不适合解决FizzBuzz问题的原因就在于，FizzBuzz只是在遍历过程中需要打印出对应的值，
;; 而不需要每次都返回结果。有兴趣你可以把解决FizzBuzz代码中的doseq换成for来看看输出效果就明白了。
(for [x (range 0 101)]
  (cond (and (multiple? x 3)
             (multiple? x 5)) (println "FizzBuzz")
        (multiple? x 3) (println "Fizz")
        (multiple? x 5) (println "Buzz")
        :else (println x)))


;; loop 在许多语言中都有这个关键字,基本上都是为了更好的使用迭代器而存在。但是在Clojure中，
;; loop实际上是递归的，所以使用它需要更多一点的相关知识和代码。 
(loop [data (range 0 101)]
  (if (not (empty? data))
    (let [x (first data)]
      (cond (and (multiple? x 3)
                 (multiple? x 5)) (println "FizzBuzz")
            (multiple? x 3) (println "Fizz")
            (multiple? x 5) (println "Buzz")
            :else (println x))
      (recur (rest data)))))
;; 首先cond里面的逻辑和之前doseq的一模一样，这个是不变的。我们知道递归必须有一个结束条件，
;; 所以我们在这里在递归开始加入了一个判断语句 (if (not (empty? data)) ,
;; 就是判断data是否为空列表，如果为空递归结束，否则继续进行。每次递归，我们都从列表中取出一个值，
;; 然后把它传递给cond那部分逻辑进行判断。cond逻辑结束后，为了能递归调用上面逻辑，我们使用recur来达到目的。
;; 上例中，我们每次都将使用本次递归中的列表除第一个元素以外的剩下列表进行下一次递归。
;; （递归必须是一个收敛的过程，否则递归将永远无法结束）
;; 我们使用loop来打印0-11的偶数，对比之前的例子。主要体会如何使用递归思想来解决问题 :
(loop [x 0]
  (when (<= x 10)
    (if (even? x) (println x))
    (recur (+ x 1))))

;; (建议大家可以看看《the little schemer》，看完肯定能更好的掌握递归思想，并且对学习clojure大有好处）

;; 现在我们再来个稍微难点的例子，我们会递归迭代一组数字，然后搜集遍历过程中得到的前十个偶数。
;; 注意这个例子和前面不同的是，我们每次递归 (recur)传入的参数是多个，而不是一个。
;; recur后面参数其实是和loop的第一个向量参数中的绑定参数 (data、n、n-count、result)是一一对应的，大家仔细观察一下。
(loop [data (range 1 101)
       n (first data)
       n-count 0
       result nil] ;; result 初始为空列表
  (if (and n (< n-count 10)) ;;递归结束条件
    (if (even? n)
    (recur (rest data) (first data) (inc n-count) (cons n result))
    (recur (rest data) (first data) n-count result))
    (reverse result))) ;;递归结束后，反转结果列表

;; 我们可以做的更好一点，就是把上面定义成一个递归函数：
(defn take-evens
  ([x nums] (take-evens x nums 0 nil))
  ([x nums n-count result]
   (if (empty? nums) ;;递归结束条件一
     (reverse result)
     (if (< n-count 10) ;;递归结束条件二
       (let [n (first nums)]
         (if (even? n)
           (recur x (rest nums) (inc n-count) (cons n result))
           (recur x (rest nums) n-count result)))
       (reverse result)))))
(take-evens 10 (range 1 101))

;; {{my-test
(defn recursive-reverse [coll]
  (loop [coll coll
         result nil]
    (if (empty? coll)
      result
      (recur (rest coll) (conj result (first coll))))))
(recursive-reverse [1 2 3 4 5])

(defn factorial [n]
    (if (= n 1)
      (* 1 1)
      (* n (factorial (dec n)))))
(factorial 100003N)  ;; StackOverflowError

;; http://praneett.blogspot.com/2014/06/clojure-koans-answers-and-explanations_4.html
(defn factorial2 [n]
  (loop [n n
         result 1]
    (if (= n 0)
      result
      (recur (dec n) (* n result)))))
(factorial2 100003N) ;; OK
;; }}

;; ----------------------------
;; High order function (HOF)
;; http://mokagio.github.io/tech-journal/2014/12/18/clojure-higher-order-functions.html
;; https://christophermaier.name/2011/07/07/writing-elegant-clojure-code-using-higher-order-functions/
(map inc [1 2 3 4 5])
(map #(* 5 %) [1 2 3 4 5])


;; ----------------------------
;; https://clojuredocs.org/clojure.core/defmulti
;this example illustrates that the dispatch type
;does not have to be a symbol, but can be anything (in this case, it's a string)
(defmulti greeting (fn [x] (get x "language")))
;params is not used, so we could have used [_]]
(defmethod greeting "English" [params] "Hello!")
(defmethod greeting "French" [params] "Bonjour!")
;;default handling
(defmethod greeting :default [params]
  (throw (IllegalArgumentException.
           (str "I don't know the " (get params "language") " language"))))

;then can use this like this:
(def english-map {"id" "1", "language" "English"})
(def french-map  {"id" "2", "language" "French"})
(def spanish-map {"id" "3", "language" "Spanish"})

(greeting english-map)
(greeting french-map)
(greeting spanish-map)

;; https://www.bookstack.cn/read/clojure-learning-notes/getting-started-polymorphism.md
(defmulti area :Shape)
(defn rect [wd ht] {:Shape :Rect :wd wd :ht ht})
(defn circle [radius] {:Shape :Circle :radius radius})
(defmethod area :Rect [r]
  (* (:wd r) (:ht r)))
(defmethod area :Circle [c]
  (* (. Math PI) (* (:radius c) (:radius c))))
(defmethod area :default [x] :oops)
(def r (rect 4 13))
(def c (circle 12))

(area r)
(area c)
(area {})

;; {{https://clojuredocs.org/clojure.core/deftype#example-572bd5cee4b050526f331422
;; define a couple of shape types
(deftype Circle [radius])
(deftype Square [lenght width])

;; multimethod to calculate the area of a shape
(defmulti area class)
(defmethod area Circle [c]
  (* Math/PI (* (.radius c) (.radius c))))
(defmethod area Square [s]
  (* (.lenght s) (.width s)))

;; create a couple shapes and get their area
(def myCircle (Circle. 10))
(def mySquare (Square. 5 11))
(area myCircle)
(area mySquare)
;; }}

(-> {} (assoc :a 1) (assoc :b 2) (assoc :c {:d 3}) (get-in [:c :d]))

;; {{my-test
(let [[first-name last-name & aliases]
      (list "Rich" "Hickey" "The Clojurer" "Go Time" "Lambda Guru")]
  (str first-name " " last-name (apply str (map #(str " aka " %) aliases))))

(let [[first-name last-name :as full-name] ["Rich" "Hickey"]]
  (println first-name)
  (println last-name)
  (println full-name))
;; }}
