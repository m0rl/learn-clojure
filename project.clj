(defproject hello_ring "0.1.0-SNAPSHOT"
  :source-paths ["src/clj"]
  :dependencies [[org.clojure/clojure "1.9.0"]
                 [org.clojure/clojurescript "1.10.238"]
                 [ring "1.6.3"]
                 [ring/ring-jetty-adapter "1.6.3"]
                 [ring/ring-defaults "0.3.1"]
                 [compojure "1.6.1"]
                 [reagent "0.6.0"]
                 [hiccup "1.0.5"]
                 [garden "1.3.5"]]
  :plugins [[lein-cljsbuild "1.1.7"]
            [lein-ring "0.12.4"]]
  :hooks [leiningen.cljsbuild]
  :cljsbuild {
              :builds {:client
                       {:source-paths ["src/cljs"]
                        :compiler {:main "hello-ring.core"
                                   :output-to "resources/public/js/client.js"
                                   :optimizations :whitespace
                                   :pretty-print true}}}}
  :ring {:handler hello-ring.routes/app})
