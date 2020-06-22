package 음원사이트_크롤링;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class MelonMusic_Crawl {

	public static void main(String[] args) throws IOException {

		Document doc = Jsoup.connect("https://www.melon.com/chart/").header("User-Agent", "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_11_6) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/52.0.2743.82 Safari/537.36").get();
		Elements list = doc.select("div.rank01>span>a");
		
		
		System.out.println("실시간 멜론 차트");
		System.out.println("---------------------");
		int i =0;
		for (Element e : list) {
			i++;
			String title = e.text();
			System.out.println(i+"위: "+title);
		}
		
		
		
	}

}
