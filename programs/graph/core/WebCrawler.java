package com.graph;

import java.net.*;
import java.util.Hashtable;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.io.*;

public class WebCrawler {
	private Map<String, Integer> discoveredPages;
	private Queue<String> pageQueue;
	private String url;
	public WebCrawler(String url) throws IOException{
		this.url = url;
		discoveredPages = new Hashtable<>();
		pageQueue = new LinkedList<>();
		crawl(url);
	}
	private void crawl(String root){
		pageQueue.add(root);
		try{
			while(!pageQueue.isEmpty()){
				String url = pageQueue.remove();
				System.out.println("parsing web page : " + url);
		        URL oracle = new URL(url);
		        BufferedReader in = new BufferedReader(
		        new InputStreamReader(oracle.openStream()));
		        String fileContent = "";
		        String inputLine;
		        while ((inputLine = in.readLine()) != null){
		            fileContent += inputLine;
		        }
		        in.close();
		        String regex = "http://(\\w+\\.)*(\\w+)";
		        Pattern pattern = Pattern.compile(regex);
		        Matcher matcher = pattern.matcher(fileContent);
		        while(matcher.find()){
		        	String link = matcher.group();
		        	if(!discoveredPages.keySet().contains(link)){
		        		discoveredPages.put(link, 1);
		        		pageQueue.add(link);
		        	}
		        	else{
		        		discoveredPages.put(link, discoveredPages.get(link) + 1);
		        	}
		        }
			}
		}
		catch(java.net.UnknownHostException e){
			e.printStackTrace();
		}
		catch(java.io.IOException e){
			e.printStackTrace();
		}
	}
	public String toString(){
		String str = "";
		for(Map.Entry<String, Integer> entry : discoveredPages.entrySet()){
			str += entry.getKey() + " => " + entry.getValue() + "\n";
		}		
		return str;
	}
	public static void main(String[] args) throws IOException{
		String url = "http://www.oracle.com/";
		WebCrawler wc = new WebCrawler(url); 
		System.out.println(wc);
	}
}
