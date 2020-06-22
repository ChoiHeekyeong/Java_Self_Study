package 음원사이트_크롤링;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class MelonMusic_Crawl1 {

	public String[] melon() {

		Document doc = null;
		try {
			doc = Jsoup.connect("https://www.melon.com/chart/").header("User-Agent",
					"Mozilla/5.0 (Macintosh; Intel Mac OS X 10_11_6) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/52.0.2743.82 Safari/537.36")
					.get();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		Elements list = doc.select("div.rank01>span>a");

		String[] chart = new String[100];
		int i = 0;
		for (Element e : list) {
			String title = e.text();
			chart[i] = title;
			//System.out.println(title);
			i++;
		}
		return chart;


	}
}
