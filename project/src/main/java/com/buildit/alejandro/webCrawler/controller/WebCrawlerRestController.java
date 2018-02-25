package com.buildit.alejandro.webCrawler.controller;

import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.buildit.alejandro.webCrawler.bean.WebLink;
import com.buildit.alejandro.webCrawler.utils.Spider;

@RestController
public class WebCrawlerRestController {
	

	@RequestMapping(value = "/api/getAllLinks" , method = RequestMethod.GET)
	 public  List<WebLink>  getAllPost(@RequestParam("webPage") String webPage )
		{
		 Spider spider = new Spider();
	        List<WebLink> list = spider.search(webPage);
	      
			 return list;
		}

	@RequestMapping(value = "/api/getShortLinks", method = RequestMethod.GET)
	 public  List<WebLink>  getShortLink(@RequestParam("webPage") String webPage )
		{
	
		 Spider spider = new Spider();
	        List<WebLink> list = spider.search(webPage);
	      
	        for(WebLink wl : list)
            {
	        	wl.setListLinks(null);
            }
			 return list;
		
		}
}
