import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;

import javax.swing.ImageIcon;




public class PianoPlay extends Thread{
	
	//private Image pianoImage = new ImageIcon(Main.class.getResource("./images/pianofinal.png")).getImage();
	private Image pianoReleased1 = new ImageIcon(Main.class.getResource("./images/pianoReleased.png")).getImage();
	private Image pianoReleased2 = new ImageIcon(Main.class.getResource("./images/pianoReleased.png")).getImage();
	private Image pianoReleased3 = new ImageIcon(Main.class.getResource("./images/pianoReleased.png")).getImage();
	private Image pianoReleased4 = new ImageIcon(Main.class.getResource("./images/pianoReleased.png")).getImage();
	private Image pianoReleased5 = new ImageIcon(Main.class.getResource("./images/pianoReleased.png")).getImage();
	private Image pianoReleased6 = new ImageIcon(Main.class.getResource("./images/pianoReleased.png")).getImage();
	private Image pianoReleased7 = new ImageIcon(Main.class.getResource("./images/pianoReleased.png")).getImage();
	private Image pianoReleased8 = new ImageIcon(Main.class.getResource("./images/pianoReleased.png")).getImage();
	private Image pianoReleased9 = new ImageIcon(Main.class.getResource("./images/pianoReleased.png")).getImage();
	private Image pianoReleased10 = new ImageIcon(Main.class.getResource("./images/pianoReleased.png")).getImage();
	private Image pianoReleased11 = new ImageIcon(Main.class.getResource("./images/pianoReleased.png")).getImage();
	private Image pianoReleased12 = new ImageIcon(Main.class.getResource("./images/pianoReleased.png")).getImage();
	private Image pianoReleased13 = new ImageIcon(Main.class.getResource("./images/pianoReleased.png")).getImage();
	
	
	public void screenDraw(Graphics2D g) {
		//그림 위치
		g.drawImage(pianoReleased1, 151, 15, null);
		g.drawImage(pianoReleased2, 201, 15, null);
		g.drawImage(pianoReleased3, 250, 15, null);
		g.drawImage(pianoReleased4, 301, 15, null);
		g.drawImage(pianoReleased5, 351, 15, null);
		g.drawImage(pianoReleased6, 401, 15, null);
		g.drawImage(pianoReleased7, 451, 15, null);
		g.drawImage(pianoReleased8, 501, 15, null);
		g.drawImage(pianoReleased9, 185, 15, null);
		g.drawImage(pianoReleased10, 235, 15, null);
		g.drawImage(pianoReleased11, 335, 15, null);
		g.drawImage(pianoReleased12, 385, 15, null);
		g.drawImage(pianoReleased13, 436, 15, null);
		g.drawString("도", 170, 170);
		g.drawString("레", 220, 170);
		g.drawString("미", 270, 170);
		g.drawString("파", 320, 170);
		g.drawString("솔", 370, 170);
		g.drawString("라", 420, 170);
		g.drawString("시", 470, 170);
		g.drawString("도", 520, 170);
		
	}
	
	//흰건반
	public void pressS() {
		pianoReleased1 = new ImageIcon(Main.class.getResource("./images/pressedWhiteKey1.png")).getImage();
		new Music("c4.mp3",false).start();
	}
	public void releaseS() {
		pianoReleased1 = new ImageIcon(Main.class.getResource("./images/pianoReleased.png")).getImage();
	}
	public void pressD() {
		pianoReleased2 = new ImageIcon(Main.class.getResource("./images/pressedWhiteKey2.png")).getImage();
		new Music("d4.mp3",false).start();
	}
	public void releaseD() {
		pianoReleased2 = new ImageIcon(Main.class.getResource("./images/pianoReleased.png")).getImage();
	}
	public void pressF() {
		pianoReleased3 = new ImageIcon(Main.class.getResource("./images/pressedWhiteKey3.png")).getImage();
		new Music("e4.mp3",false).start();
	}
	public void releaseF() {
		pianoReleased3 = new ImageIcon(Main.class.getResource("./images/pianoReleased.png")).getImage();
	}
	public void pressG() {
		pianoReleased4 = new ImageIcon(Main.class.getResource("./images/pressedWhiteKey1.png")).getImage();
		new Music("f4.mp3",false).start();
	}
	public void releaseG() {
		pianoReleased4 = new ImageIcon(Main.class.getResource("./images/pianoReleased.png")).getImage();
	}
	public void pressH() {
		pianoReleased5 = new ImageIcon(Main.class.getResource("./images/pressedWhiteKey2.png")).getImage();
		new Music("g4.mp3",false).start();
	}
	public void releaseH() {
		pianoReleased5 = new ImageIcon(Main.class.getResource("./images/pianoReleased.png")).getImage();
	}
	public void pressJ() {
		pianoReleased6 = new ImageIcon(Main.class.getResource("./images/pressedWhiteKey2.png")).getImage();
		new Music("a4.mp3",false).start();
	}
	public void releaseJ() {
		pianoReleased6 = new ImageIcon(Main.class.getResource("./images/pianoReleased.png")).getImage();
	}
	public void pressK() {
		pianoReleased7 = new ImageIcon(Main.class.getResource("./images/pressedWhiteKey3.png")).getImage();
		new Music("b4.mp3",false).start();
	}
	public void releaseK() {
		pianoReleased7 = new ImageIcon(Main.class.getResource("./images/pianoReleased.png")).getImage();
	}
	public void pressL() {
		pianoReleased8 = new ImageIcon(Main.class.getResource("./images/pressedWhiteKey1.png")).getImage();
		new Music("sound8.mp3",false).start();
	}
	public void releaseL() {
		pianoReleased8 = new ImageIcon(Main.class.getResource("./images/pianoReleased.png")).getImage();
	}
	//검은건반
	public void pressE() {
		pianoReleased9 = new ImageIcon(Main.class.getResource("./images/pressedBlackKey.png")).getImage();
		new Music("c4m.mp3",false).start();
	}
	public void releaseE() {
		pianoReleased9 = new ImageIcon(Main.class.getResource("./images/pianoReleased.png")).getImage();
	}
	public void pressR() {
		pianoReleased10 = new ImageIcon(Main.class.getResource("./images/pressedBlackKey.png")).getImage();
		new Music("d4m.mp3",false).start();
	}
	public void releaseR() {
		pianoReleased10 = new ImageIcon(Main.class.getResource("./images/pianoReleased.png")).getImage();
	}
	public void pressY() {
		pianoReleased11 = new ImageIcon(Main.class.getResource("./images/pressedBlackKey.png")).getImage();
		new Music("f4m.mp3",false).start();
	}
	public void releaseY() {
		pianoReleased11 = new ImageIcon(Main.class.getResource("./images/pianoReleased.png")).getImage();
	}
	public void pressU() {
		pianoReleased12 = new ImageIcon(Main.class.getResource("./images/pressedBlackKey.png")).getImage();
		new Music("g4m.mp3",false).start();
	}
	public void releaseU() {
		pianoReleased12 = new ImageIcon(Main.class.getResource("./images/pianoReleased.png")).getImage();
	}
	public void pressI() {
		pianoReleased13 = new ImageIcon(Main.class.getResource("./images/pressedBlackKey.png")).getImage();
		new Music("a4m.mp3",false).start();
	}
	public void releaseI() {
		pianoReleased13 = new ImageIcon(Main.class.getResource("./images/pianoReleased.png")).getImage();
	}
	
	
	
	
	
	
	
	
	@Override
	public void run() {
		
	}

}
