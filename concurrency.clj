;; {{https://clojure.org/about/concurrent_programming
;; 并发
(import '(java.util.concurrent Executors))
(defn test-stm [nitems nthreads niters]
  (let [refs (map ref (repeat nitems 0))
        pool (Executors/newFixedThreadPool nthreads)
        tasks (map (fn [t]
                     (fn []
                       (dotimes [n niters]
                         (dosync
                           (doseq [r refs]
                             (alter r + 1 t))))))
                   (range nthreads))]
    (doseq [future (.invokeAll pool tasks)]
      (.get future))
    (.shutdown pool)
    (map deref refs)))
(test-stm 10 10 10000)

;;;;;;;;;;;;;;;;;;;;;;;;;;
(def ^:dynamic *v*) ;; https://clojure.org/reference/vars
(defn incv [n] (set! *v* (+ *v* n)))
(defn test-vars [nthreads niters]
  (let [pool (Executors/newFixedThreadPool nthreads)
        tasks (map (fn [t]
                     #(binding [*v* 0]
                        (dotimes [n niters]
                          (incv t))
                        *v*))
                   (range nthreads))]
      (let [ret (.invokeAll pool tasks)]
        (.shutdown pool)
        (map #(.get %) ret))))
(test-vars 10 1000000)
(set! *v* 4) ;; java.lang.IllegalStateException: Can't change/establish root binding of: *v* with set
;; }}

;; {{https://purelyfunctional.tv/guide/clojure-concurrency/
;; Delay
;; }}
