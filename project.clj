(defproject scraping-clj "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.6.0"]
                 [edu.uci.ics/crawler4j "3.5"]
                 [org.jsoup/jsoup "1.7.2"]]
  :aot [scraping-clj.crawler]
  :main scraping-clj.core)
