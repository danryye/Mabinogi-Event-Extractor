import java.io.IOException;
import java.util.ArrayList;
import java.util.Formatter;

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
        String texturl = "events.txt";
        
        //Connects to website, extracts the html of page into (doc)
        Document doc = Jsoup.connect(url).get();
        Elements announcements = doc.select("td");
        
        //Opens txt file
        Formatter f = new Formatter(texturl);       
        
        for(int i = 0; i < announcements.size(); i+=3) {
            String title = announcements.get(i).select("a[href]").text().toString();
            String link = announcements.get(i).select("a[href]").attr("abs:href").toString();
            String date = announcements.get(i + 1).text().toString();
            
            String combine = title + "\n" + link + "\n" + date + "\n";
            
            f.format("%s%n%s%n%s%n", title, link, date);
            System.out.println(combine);
        }
        
        f.close();
    }
}

