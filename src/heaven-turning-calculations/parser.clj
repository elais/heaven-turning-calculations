(ns heaven-turning-calculations.parser
  (:require [clojure.edn :as edn]
            [instaparse.core :as insta]))


(def roll-parser
  (insta/parser
   "<roll> = <'.roll'> group* dice
    <group> = <'/'> (autosuccess | double | reroll | target)
    dice = <' '> integer
    autosuccess = <'as'> integer
    double = <'db'> die
    reroll = <'re'> die
    target = <'tn'> die
    <die> = #'[0-9]'+
    <integer> = #'[1-9][0-9]*'"))

(defn- to-roll [parse-tree]
  (if (insta/failure? parse-tree)
    (throw (IllegalArgumentException. "Failed to parse roll."))))


(defn parse [^String input-str]
  (->> (roll-parser input-str)
       (to-roll)))
