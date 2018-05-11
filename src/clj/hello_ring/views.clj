(ns hello-ring.views
  (:require [hiccup.page :refer [html5 include-js]]
            [garden.core :refer [css]]))

(def index-page-style
  (css [:body {:background "#eee"}]))

(defn index-page []
  (html5
   [:head
    [:title "Ring Application"]
    [:style index-page-style]]
   [:body
    [:div#app]
    (include-js "/js/client.js")
    [:script {:type "text/javascript"}
     (str "hello_ring.core.run();")]]))
