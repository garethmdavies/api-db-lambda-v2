(ns api-db-lambda-v2.test-runner
 (:require [doo.runner :refer-macros [doo-tests]]
           [api-db-lambda-v2.core-test]
           [cljs.nodejs :as nodejs]))

(try
  (.install (nodejs/require "source-map-support"))
  (catch :default _))

(doo-tests
 'api-db-lambda-v2.core-test)
