(ns scraping-clj.crawler
  (:import [java.io PrintWriter File]
           [edu.uci.ics.crawler4j.crawler Page WebCrawler]
           [edu.uci.ics.crawler4j.url.WebURL]
           [org.jsoup.Jsoup])
  (:gen-class
   :name Crawler
   :main false
   :extends edu.uci.ics.crawler4j.crawler.WebCrawler
   ))

(declare shouldVisit visit write)

(defn -shouldVisit [url]
  (println url)
  (def href (-> url .getURL .toLowerCase))
  (and (.startWith href "http://ameblo.jp/takagakiayahi-blog/entry") (.endWith href ".html")))

(defn -visit [page]
  (def url (-> page .getWebURL .getURL))
  (println url))

(defn write [title text]
  (def writer (new PrintWriter (new File (str title ".txt"))))
  (. writer write text)
  (. writer close)
  )
