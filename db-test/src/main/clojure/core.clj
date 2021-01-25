(ns core
  (:require [next.jdbc :as jdbc])
  (:gen-class))

(def db-spec {:dbtype "postgres"
              :dbname "test"
              :user "feng"
              :password "111111"})

(def ds (jdbc/get-datasource db-spec))

(defn create-table-address [ds]
  (jdbc/execute! ds ["create table address (
                     id SERIAL primary key,
                     name varchar(32),
                     email varchar(255)
                     )"]))

(defn drop-table-address [ds]
  (jdbc/execute! ds ["drop table address"]))

(defn insert-address [ds]
  (jdbc/execute! ds ["insert into address(name,email)
                     values('Lei','Lei@hello.com')"]))

(defn list-address [ds]
  (jdbc/execute! ds ["select * from address"]))

(defn demo-connection [ds]
  (with-open [conn (jdbc/get-connection ds)]
    (create-table-address conn)
    (insert-address conn)
    (insert-address conn)
    (println (list-address conn))
    (drop-table-address conn)))

(defn demo-transaction [ds]
  (jdbc/with-transaction [conn (jdbc/get-connection ds)]
    (create-table-address conn)
    (insert-address conn)
    (insert-address conn)
    (doseq [address (list-address conn)]
      (println address))
    (drop-table-address conn)))

(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (demo-connection ds)
  (demo-transaction ds))
