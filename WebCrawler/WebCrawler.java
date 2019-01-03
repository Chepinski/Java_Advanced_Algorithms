package WebCrawler;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WebCrawler {
	
	private Queue<String> queue;//needed for FIFO list with webcrawlers
	private List<String> discoveredWebsitesList;

	public WebCrawler() {
		this.queue = new LinkedList<>();
		this.discoveredWebsitesList = new ArrayList<>();
	}
	
	public void discoverWeb(String root) {
		
		this.queue.add(root);//add root website to queue
		this.discoveredWebsitesList.add(root);//add root website to the array of websites
		
		while ( !queue.isEmpty() ){
			
			String v = this.queue.remove();//v = earliest visited url
			String rawHtml = readUrl(v);//send to readUrl method to get entire url
			
			String regexp = "http://(\\w+\\.)*(\\w+)";//regular expression to find a website
			Pattern pattern = Pattern.compile(regexp);
			Matcher matcher = pattern.matcher(rawHtml);//match regular expression to html on website
			
			while ( matcher.find() ) {
				
				String currentUrl = matcher.group();
				
				//if website is not already on the list then add it to the
				//discovered website array and println
				if( !discoveredWebsitesList.contains(currentUrl) ) {
					discoveredWebsitesList.add(currentUrl);
					System.out.println("Website found: "+ currentUrl);
					queue.add(currentUrl);
				}
			}
		}
	}
	
	private String readUrl(String v) {
		
		String rawHtml = "";
		
		try {
			
			URL url = new URL(v);
			BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream()));
			
			String inputLine = "";//better to use Stringreader
			
			while( (inputLine = in.readLine()) != null) {
				rawHtml += inputLine;
			}
			
			in.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return rawHtml;
	}
}
