import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

public class LottoCrawlingModule {

	public String[] lotto(String data) {
		Document doc = null;
		try {
			doc = Jsoup.connect("https://www.dhlottery.co.kr/gameResult.do?method=byWin&drwNo=" + data).get();

		} catch (IOException e) {
			System.out.println("에러 발생");
		}

		String[] code = new String[7];
		Elements list = doc.select("div.nums span");
		for (int i = 0; i < 6; i++) {
			code[i] = list.get(i).text();
		}
		code[6]=list.get(6).text();
		

		String[] values = { code[0], code[1], code[2], code[3], code[4], code[5], code[6] };
		return values;
	}

}
