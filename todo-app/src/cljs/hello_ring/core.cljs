(ns hello-ring.core
  (:require [reagent.core :as r]
            [hello-ring.styles :refer [todolist-header-style todolist-style]]))

(defonce todos (r/atom (sorted-map)))
(defonce todos-counter (r/atom 0))

(defn- add-new-todolist-entry [todo]
  (let [id (swap! todos-counter inc)]
    (swap! todos assoc id {:id id :todo todo :is-completed? false})))

(defn- toggle-complete-status [id]
  (swap! todos update-in [id :is-completed?] not))

(defn render-todolist []
  (map
   (fn [{:keys [id todo is-completed?]}]
     ^{:key id} [:li {:class (if is-completed? "completed")
                      :on-click #(toggle-complete-status id)}
                 todo])
   (vals @todos)))

(defn- todo-app []
  (let [next-todo (r/atom "")
        add-non-empty-todo (fn [] (some-> @next-todo
                                          not-empty
                                          add-new-todolist-entry)
                             (reset! next-todo ""))]
    (fn []
      [:div
       [:div.todolist-header todolist-header-style
        [:h2 "ClojureScript TODO list"]
        [:div.todolist-header-input
         [:input.todolist-header-input-text
          {:type "text" :value @next-todo :placeholder "what is next to do?"
           :on-change #(reset! next-todo (-> % .-target .-value))
           :on-key-down #(if (= 13 (.-which %)) (add-non-empty-todo))}]
         [:div.todolist-header-input-button
          {:on-click add-non-empty-todo} "Add to List"]]]
       [:ul.todolist-items todolist-style
        (render-todolist)]])))

(defn ^:export run []
  (r/render [todo-app]
            (js/document.getElementById "app")))
