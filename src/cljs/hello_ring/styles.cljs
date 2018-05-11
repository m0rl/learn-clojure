(ns hello-ring.styles
  (:require [garden.core :refer [css]]))

(def todolist-header-style
  [:style (css [:.todolist-header {:text-align "center"
                                   :background-color "#332244"
                                   :color "white"
                                   :padding "30px 40px"}]
               [:.todolist-header:after {:display "table"}]
               [:.todolist-header-input {:display "flex"
                                         :height "40px"}]
               [:.todolist-header-input-text {:border "none"
                                              :width "75%"
                                              :padding "10px"
                                              :text-align "center"
                                              :font-size "16px"}]
               [:.todolist-header-input-button {:padding "10px"
                                                :width "25%"
                                                :background "#554466"
                                                :text-align "center"
                                                :font-size "16px"
                                                :cursor "pointer"
                                                :color "#FFF"
                                                :transition "0.3s"
                                                :white-space "nowrap"}]
               [:.todolist-header-input-button:hover {:background-color "#665577"}])])

(def todolist-style
  [:style (css [:.todolist-items {:margin "0"
                                  :padding "0"}
                [:li {:cursor "pointer"
                      :position "relative"
                      :padding "12px 8px 12px 40px"
                      :background "#bbaacc"
                      :font-size "18px"
                      :transition "0.2s"
                      :user-select "none"}]
                ["li:nth-child(odd)" {:background-color "#ccbbdd"}]
                [:li:hover {:background "#aa99bb"}]
                [:li.completed {:background "#ccbbdd77"
                                :text-decoration "line-through"}]])])
