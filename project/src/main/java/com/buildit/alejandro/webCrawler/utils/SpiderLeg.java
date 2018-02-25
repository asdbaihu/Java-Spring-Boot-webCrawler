package com.buildit.alejandro.webCrawler.utils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.buildit.alejandro.webCrawler.bean.WebLink;

public class SpiderLeg
{
    // We'll use a fake USER_AGENT so the web server thinks the robot is a normal web browser.
    private static final String USER_AGENT =
            "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/535.1 (KHTML, like Gecko) Chrome/13.0.782.112 Safari/535.1";
    private List<String> links = new LinkedList<String>();
    private Document htmlDocument;


    /**
     * This performs all the work. It makes an HTTP request, checks the response, and then gathers
     * up all the links on the page. Perform a searchForWord after the successful crawl
     * 
     * @param url
     *            - The URL to visit
     * @return whether or not the crawl was successful
     */
    public WebLink crawl(String url)
    {
    	WebLink wl =  new WebLink();
    	wl.url=url;
    	List<String> listLinks =  new ArrayList<String>();
        try
        {
            Connection connection = Jsoup.connect(url).userAgent(USER_AGENT);
            Document htmlDocument = connection.get();
            this.htmlDocument = htmlDocument;

            if(!connection.response().contentType().contains("text/html"))
            {
                return wl;
            }
            Elements linksOnPage = htmlDocument.select("a[href]");
           for(Element link : linksOnPage)
            {
                this.links.add(link.absUrl("href").trim());
                listLinks.add(link.absUrl("href").trim());
            }

           listLinks = ListUtils.deleteDublicate(listLinks);
        
            wl.setListLinks(listLinks);
            wl.setNlink(listLinks.size());
            return wl;
        }
        catch(IOException ioe)
        {
            return new WebLink();
        }
    }

    public List<String> getLinks()
    {
        return this.links;
    }

}