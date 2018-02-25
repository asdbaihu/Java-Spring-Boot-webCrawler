package com.buildit.alejandro.webCrawler.bean;

import java.util.List;

public class WebLink {
 public String url;
 public List<String> listLinks;
 public int nlink ;
 
 
public WebLink() {
	super();
}



public WebLink(String url, List<String> listLinks, int nlink) {
	super();
	this.url = url;
	this.listLinks = listLinks;
	this.nlink = nlink;
}



public int getNlink() {
	return nlink;
}



public void setNlink(int nlink) {
	this.nlink = nlink;
}



public String getUrl() {
	return url;
}
public void setUrl(String url) {
	this.url = url;
}



public List<String> getListLinks() {
	return listLinks;
}


public void setListLinks(List<String> listLinks) {
	this.listLinks = listLinks;
}

 
 
}
