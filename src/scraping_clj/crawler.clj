(ns scraping-clj.crawler
  (:import [java.io PrintWriter File]
           [edu.uci.ics.crawler4j.crawler Page WebCrawler]
           [edu.uci.ics.crawler4j.url.WebURL]
           [org.jsoup.Jsoup])
  (:gen-class
   :name Crawler
   :main false
   :implements [edu.uci.ics.crawler4j.crawler.WebCrawler]
   :exposes-methods {shouldVisit visit}))

(defn -shouldVisit [url]
  (def href (-> url .getURL .toLowerCase))
  (println href)
  (and (.startWith("http://ameblo.jp/takagakiayahi-blog/entry")) (.endWith(".html"))))

(defn -visit [page]
  (println page)
  (def url (-> page .getWebURL .getURL)))
