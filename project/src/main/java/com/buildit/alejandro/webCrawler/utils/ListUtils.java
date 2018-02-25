package com.buildit.alejandro.webCrawler.utils;

import java.util.HashSet;
import java.util.List;

public class ListUtils {

	public static List<String> deleteDublicate (List<String>  list)
	{
	    HashSet hs = new HashSet();
	    hs.addAll(list);
	    list.clear();
	    list.addAll(hs);
	    return list;
	}
}
