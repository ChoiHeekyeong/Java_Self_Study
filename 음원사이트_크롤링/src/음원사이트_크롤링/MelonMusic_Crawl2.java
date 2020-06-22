package 음원사이트_크롤링;

import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class MelonMusic_Crawl2 {

	public static void main(String[] args) {
		JFrame f = new JFrame("멜론뮤직 차트 순위");
		f.setSize(700, 1500);

		FlowLayout flow = new FlowLayout();
		f.setLayout(flow);

		JButton ftotView = new JButton("1~3위 보기");
		JButton allView = new JButton("전체 순위 보기");
		// JButton singer = new JButton("가수 이름 보기");
		JButton enter = new JButton("보기");

		JLabel label = new JLabel();
		label.setText("     원하는 순위를 숫자로 입력하세요     ");

		JTextArea result = new JTextArea(50, 40);

		JTextField field = new JTextField(5);
		field.setSize(200, 30);

		f.add(ftotView);
		f.add(allView);
		f.add(label);
		f.add(field);
		f.add(enter);
		f.add(result);

		Font font1 = new Font("궁서", 1, 30);
		Font font2 = new Font("궁서", 1, 20);

		ftotView.setFont(font1);
		allView.setFont(font1);
		label.setFont(font1);
		field.setFont(font1);
		enter.setFont(font1);
		result.setFont(font2);

		result.setEnabled(false);

		ftotView.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				result.setText("");
				MelonMusic_Crawl1 m = new MelonMusic_Crawl1();
				String[] chart = m.melon();
				for (int i = 0; i < 3; i++) {

					result.append((i + 1) + "위: " + chart[i] + "\n");
				}
			}
		});

		allView.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				result.setText("");
				MelonMusic_Crawl1 m = new MelonMusic_Crawl1();
				String[] chart = m.melon();
				for (int i = 0; i < 100; i++) {

					result.append((i + 1) + "위: " + chart[i] + "\n");
				}
			}
		});

		enter.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				result.setText("");
				String num = field.getText();
				int realnum = Integer.parseInt(num);
				MelonMusic_Crawl1 m = new MelonMusic_Crawl1();
				String[] chart = m.melon();
				for (int i = 0; i < 100; i++) {
					if ((i+1) == realnum) {
						result.append((i + 1) + "위: " + chart[i] + "\n");
					}


				}
			}
		});

		f.setVisible(true);

	}

}
