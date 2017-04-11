(set-env!
 :resource-paths #{"src"}
 :dependencies '[[dithcord "0.0.10"]
                 [instaparse "1.4.5"]])

(task-options!
 pom {:project 'heaven-turning-calculations
      :version "0.1.0"})
