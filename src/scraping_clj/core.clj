(ns scraping-clj.core
  (:import (edu.uci.ics.crawler4j.crawler CrawlController CrawlConfig)
           (edu.uci.ics.crawler4j.fetcher.PageFetcher)
           (edu.uci.ics.crawler4j.robotstxt RobotstxtServer RobotstxtConfig)
           (scraping-clj.crawler Crawler)
           ))

(def crawlStorage "scrape")

(def config (new CrawlConfig))

(defn -main []
  (.setCrawlStorageFolder config crawlStorage)
  (.setPolitenessDelay config 1000)
  (def pageFetcher (new edu.uci.ics.crawler4j.fetcher.PageFetcher config))
  (def robotstxtConfig (new RobotstxtConfig))
  (def robotstxtServer (new RobotstxtServer robotstxtConfig pageFetcher))
  (def controller (new CrawlController config pageFetcher robotstxtServer))
  (.addSeed controller "http://ameblo.jp/takagakiayahi-blog/")
  (.start controller ((.class Crawler) 1)))
