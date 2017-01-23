package com.web.crawler;

/**
 * Created by Gobinda-PC on 23-01-2017.
 */
public class CrawlerMain {

    public static void main(String[] args) {
        MyCrawler crawler = new MyCrawler();
        crawler.search("http://wiprodigital.com/");
    }
}
