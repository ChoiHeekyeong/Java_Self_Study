import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class MyPianoGraphic extends JFrame {
	private Image pianoImage = new ImageIcon(Main.class.getResource("./images/pianofinal.png")).getImage();
	private Image screenImage;
	private Graphics screenGraphic;

	public static PianoPlay pianoplay = new PianoPlay();

	public MyPianoGraphic() {// 생성자
		setTitle("MY PIANO");
		setSize(700, 200);
		setResizable(false); // 한 번 만들어진 창의 사이즈를 사용자가 임의로 줄일 수 있는지
		setLocationRelativeTo(null);// 실행했을때 창이 모니터의 정중앙에 뜨게 해줌
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);// 필수! 게임창을 종료했을때 프로그램 전체가 종료하게 해줌. 이걸 안해주면 창을 꺼도 프로그램이 안꺼진다
		setVisible(true);
		addKeyListener(new KeyListener());// 이게 있어야 키보드리스너 클래스랑 연동됨!!!!!!!!!!!!!
	}

	public void paint(Graphics g) {// 그리는 함수
		// super.paintComponents(g);
		screenImage = createImage(700, 200);
		screenGraphic = screenImage.getGraphics();
		screenDraw((Graphics2D) screenGraphic);
		g.drawImage(screenImage, 0, 0, null);

	}

	public void screenDraw(Graphics2D g) {
		g.drawImage(pianoImage, 0, 0, null);// 배경을 그려줌
		pianoplay.screenDraw(g);
		this.repaint();
	}

}
