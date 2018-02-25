package com.WebCrawler;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import com.buildit.alejandro.webCrawler.bean.WebLink;
import com.buildit.alejandro.webCrawler.utils.Spider;

public class WebCrawlerTest {

	@org.junit.Test
	public void test() {
		 Spider spider = new Spider();
	        List<WebLink> list = spider.search("https://wiprodigital.com");
	        
	        for(WebLink wl : list)
            {
	        	System.out.println("url= " +wl.url);
            }
	        
	        assertEquals("110010","" );  
	        
	}

}
