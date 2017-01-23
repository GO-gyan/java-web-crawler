package com.web.crawler;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/**
 * Created by Gobinda-PC on 23-01-2017.
 */
public class MyCrawler {
    private Set<String> pagesVisited = new HashSet<String>();
    private List<String> pagesToVisit = new LinkedList<String>();

    public void search(String url) {
        String currentUrl;
        WebCrawling crawling = new WebCrawling();
        if(getPagesToVisit().isEmpty()) {
            currentUrl = url;
            getPagesVisited().add(url);
        } else {
            currentUrl = nextURL();
            System.out.print(currentUrl);
        }
        crawling.crawl(currentUrl);
        getPagesToVisit().addAll(crawling.getLinks());
        System.out.println(String.format("**Done** Visited %s web page(s)", this.pagesVisited.size()));
    }

    private String nextURL() {
        String nextUrl;
        do {
            nextUrl = getPagesToVisit().remove(0);
        }while(getPagesToVisit().contains(nextUrl));
        getPagesVisited().add(nextUrl);
        System.out.println(nextUrl);
        return nextUrl;
    }

    public Set<String> getPagesVisited() {
        return pagesVisited;
    }

    public void setPagesVisited(Set<String> pagesVisited) {
        this.pagesVisited = pagesVisited;
    }

    public List<String> getPagesToVisit() {
        return pagesToVisit;
    }

    public void setPagesToVisit(List<String> pagesToVisit) {
        this.pagesToVisit = pagesToVisit;
    }
}
