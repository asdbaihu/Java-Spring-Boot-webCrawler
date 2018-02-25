package com.buildit.alejandro.webCrawler.utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import com.buildit.alejandro.webCrawler.bean.WebLink;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class Spider
{
  private static final int MAX_PAGES_TO_SEARCH = 20;
  private Set<String> pagesVisited = new HashSet<String>();
  private List<String> pagesToVisit = new LinkedList<String>();
  private List<String> pagesNOVisit =new ArrayList<String>() {{ add("facebook");
															    add("Google");
															    add("Twitter");}}; 
  
  /**
   * Our main launching point for the Spider's functionality. Internally it creates spider legs
   * that make an HTTP request and parse the response (the web page).
   * 
   * @param url
   *            - The starting point of the spider
  
   */
  public List<WebLink> search(String url)
  {
	  List<WebLink> listWl= new ArrayList<WebLink>();
	  
      while(listWl.size() < MAX_PAGES_TO_SEARCH)
      {
    	  String currentUrl="";
          SpiderLeg leg = new SpiderLeg();
          if(this.pagesToVisit.isEmpty())
          {
              currentUrl = url;
              this.pagesVisited.add(url);
          }
          else
          {
              currentUrl = this.nextUrl();
          }
          String newUrl = currentUrl;
          
          if(pagesNOVisit.contains(currentUrl))
          {
        	  continue;
        	  
          }
          
          boolean  result =  listWl.stream().filter(o -> o.getUrl().equals(newUrl)).findFirst().isPresent();
          
          if(result == true)
		  {
      	     continue;
		  }
          WebLink wl =  leg.crawl(currentUrl);
          listWl.add(wl);
          this.pagesToVisit.addAll(leg.getLinks());
      }
      return listWl;
  }


  /**
   * Returns the next URL to visit (in the order that they were found). We also do a check to make
   * sure this method doesn't return a URL that has already been visited.
   * 
   * @return
   */
  private String nextUrl()
  {
      String nextUrl;
      do
      {
          nextUrl = this.pagesToVisit.remove(0);
      } while(this.pagesVisited.contains(nextUrl));
      this.pagesVisited.add(nextUrl);
      return nextUrl;
  }
}