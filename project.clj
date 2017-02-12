(defproject api-db-lambda-v2 "0.1.0-SNAPSHOT"
  :description "FIXME"
  :url "http://please.FIXME"
  :dependencies [[org.clojure/clojure       "1.8.0"]
                 [org.clojure/clojurescript "1.8.51"]
                 [org.clojure/core.async    "0.2.395"]
                 [io.nervous/cljs-lambda    "0.3.4"]
                 [sqlingvo.node "0.1.0"]]
  :plugins [[lein-cljsbuild "1.1.4"]
            [lein-npm       "0.6.0"]
            [lein-doo       "0.1.7"]
            [io.nervous/lein-cljs-lambda "0.6.4"]]
  :npm {:dependencies [[source-map-support "0.4.0"]]}
  :source-paths ["src"]
  :cljs-lambda
  {:defaults      {:role "FIXME"}
   :functions
   [{:name   "api-db-lambda-v2"
     :invoke api-db-lambda-v2.core/handler}]}
  :cljsbuild
  {:builds [{:id "api-db-lambda-v2"
             :source-paths ["src"]
             :compiler {:output-to     "target/api-db-lambda-v2/api_db_lambda_v2.js"
                        :output-dir    "target/api-db-lambda-v2"
                        :target        :nodejs
                        :language-in   :ecmascript5
                        :optimizations :none
                        :source-map    true
                        :main          "api-db-lambda-v2.core"
                        :closure-defines {"goog.DEBUG" false}}}
            #_{:id "api-db-lambda-v2-test"
             :source-paths ["src" "test"]
             :compiler {:output-to     "target/api-db-lambda-v2-test/api_db_lambda_v2.js"
                        :output-dir    "target/api-db-lambda-v2-test"
                        :target        :nodejs
                        :language-in   :ecmascript5
                        :optimizations :none
                        :main          api-db-lambda-v2.test-runner}}]})
