import java.io.IOException;
import java.util.ArrayList;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/**
 * API: https://jsoup.org/
 *
 */
public class Extractor {
	public static void main(String[]args) throws IOException {
		
		String url = "http://mabinogi.nexon.net/News/Announcements/1";
		
		//Connects to website, extracts the html of page into (doc)
		Document doc = Jsoup.connect(url).get();
		Elements links = announcements.select("a[href]");
		Elements dates = announcements.select("td[class]");
		
		//Event Array
		ArrayList<MabiEvent> events = new ArrayList<MabiEvent>();
				
		
		for(int i = 0; i < announcements.size(); i+=3) {
			String title = announcements.get(i).select("a[href]").text().toString();
			String link = announcements.get(i).select("a[href]").attr("abs:href").toString();
			String date = announcements.get(i + 1).text().toString();
			//events.add(new MabiEvent(title, link, date));
			
			System.out.println(title);
			System.out.println(link);
			System.out.println(date);
			System.out.println();
			
			
		}
	}
}

