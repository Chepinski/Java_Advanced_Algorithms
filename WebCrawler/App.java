package WebCrawler;

public class App {
	
	public static void main (String [] args) {
		
		WebCrawler crawler = new WebCrawler();
		
		String rootUrl = "https://www.imdb.com/";
		
		crawler.discoverWeb(rootUrl);
	}

}
