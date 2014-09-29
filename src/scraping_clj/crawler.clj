(ns scraping-clj.crawler
  (:import [java.io PrintWriter File]
           [edu.uci.ics.crawler4j.crawler Page WebCrawler]
           [edu.uci.ics.crawler4j.url WebURL]
           [org.jsoup Jsoup])
  (:gen-class
   :name scraping-clj.crawler.Crawler
   :main false
   :extends edu.uci.ics.crawler4j.crawler.WebCrawler
   ))

(defn -shouldVisit [url]
  (println "ぱろぱろー1")
  (def href (-> url .getURL .toLowerCase))
  (and (.startWith href "http://ameblo.jp/takagakiayahi-blog/entry") (.endWith href ".html")))

(defn -visit [^Page page]
  (println "ぱろぱろー2")
  (def url (-> page .getWebURL .getURL)))
