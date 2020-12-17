import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class LottoCrawlingMain {

	static String data = "1";
	public static void main(String[] args) {
		
		//프레임 만들기
		JFrame f = new JFrame("로또 번호 확인하기");
		f.setSize(600,200);
		
		
		
		
		//패널
		JPanel lottoResultPanel = new JPanel();
		
		//패널 배치
		FlowLayout flow = new FlowLayout();
		//BorderLayout border = new BorderLayout();
		//f.setLayout(border);
		f.setLayout(flow);
		
		
		JLabel l1 = new JLabel();
		JLabel l2 = new JLabel();
		
		
		//텍스트필드
		JTextField input = new JTextField(30);
		
		//button
		JButton ok = new JButton("조회");
		
		//add
		f.add(lottoResultPanel);
		lottoResultPanel.add(l1);
		lottoResultPanel.add(l2);
		f.add(input);
		f.add(ok);
		
		//font
		Font font = new Font("바탕",1,30);
		Font font2 = new Font("바탕",1,20);
		l1.setFont(font);
		l2.setFont(font2);
		

//		System.out.println("몇회를 조회하시겠습니까? >>");
//		Scanner sc = new Scanner(System.in);
//		String data = sc.nextLine();
	
	
		
		
		LottoCrawlingModule lotto = new LottoCrawlingModule();
		
		String[] values = lotto.lotto(data);
		
		l1.setText(data+"회 로또 결과: ");
		l2.setText(values[0]+" "+values[1]+" "+values[2]+" "+values[3]+" "+values[4]+" "+values[5]+" + "+values[6]);
		
		
		
		ok.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				data = input.getText();
				String[] values = lotto.lotto(data);
				l1.setText(data+"회 로또 결과: ");
				l2.setText(values[0]+" "+values[1]+" "+values[2]+" "+values[3]+" "+values[4]+" "+values[5]+" + "+values[6]);
			}
		});
		
		
		
		
		
		f.setVisible(true);
	}
	
	
	

}
