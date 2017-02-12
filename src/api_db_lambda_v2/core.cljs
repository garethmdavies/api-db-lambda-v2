(ns api-db-lambda-v2.core
  (:require [cljs-lambda.util :as lambda]
            [cljs-lambda.context :as ctx]
            [cljs-lambda.macros :refer-macros [deflambda]]
            [cljs.nodejs :as nodejs]
            [cljs.pprint :refer [pprint]]
            [sqlingvo.core :refer [select from limit where]]
            [sqlingvo.node :as db :refer-macros [<? <!?]])
  (:require-macros [cljs.core.async.macros :refer [go]]))

(def conf (db/db "postgres://user:password@database.eu-west-1.rds.amazonaws.com:5432/app?ssl=true&sslmode=verify-full"))

(defn asynchronous-db [id]
  (go
    (let [x (<? (db/connect conf))]
      (pprint (db/connected? x))
      (pprint (db/execute (select x [:*]
                           (from :customer)
                           (limit 5))))

      (db/disconnect x))))

(deflambda handler [{:keys [id] :as input} ctx]
  (asynchronous-db id))

;exports.api_db_lambda_v2_core_SLASH_handler = api_db_lambda_v2.core.handler;