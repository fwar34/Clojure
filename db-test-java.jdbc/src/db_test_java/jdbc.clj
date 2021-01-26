(ns db-test-java.jdbc
  (:require [clojure.java.jdbc :as j])
  (:gen-class))

(def pg-db {:dbtype "postgres"
            :dbname "test"
            :user "feng"
            :password "111111"})
(defn test-jdbc []
  (j/insert-multi! pg-db :users
                   [{:name "feng" :sex "man"}
                    {:name "jing" :sex "woman"}])
  (j/query pg-db
           ["select * from users where name = ?" "feng"]
           {:row-fn :sex})
  )
(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (println "Hello, World!")
  (test-jdbc)
  )
