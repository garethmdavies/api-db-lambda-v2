(require 'cljs.repl)
(require 'cljs.build.api)
(require 'cljs.repl.node)
(require 'sqlingvo.core)
(require 'sqlingvo.node)

(cljs.build.api/build "src"
  {:main 'api_db_lambda_v2.core
   :output-to "target/main.js"
   :verbose true})

(cljs.repl/repl (cljs.repl.node/repl-env)
  :watch "src"
  :output-dir "target")
