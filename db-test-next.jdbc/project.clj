(defproject db-test "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :license {:name "EPL-2.0 OR GPL-2.0-or-later WITH Classpath-exception-2.0"
            :url "https://www.eclipse.org/legal/epl-2.0/"}
  :dependencies [[org.clojure/clojure "1.10.1"]
                 [seancorfield/next.jdbc "1.1.613"]
                 [org.postgresql/postgresql "42.2.18"]]
  ; :main ^:skip-aot core
  :main myapp.Application
  :source-paths ["src/main/clojure"]
  :java-source-paths ["src/main/java"]
  :target-path "target/%s"
  :profiles {:uberjar {:aot :all
                       :jvm-opts ["-Dclojure.compiler.direct-linking=true"]}}
  )
