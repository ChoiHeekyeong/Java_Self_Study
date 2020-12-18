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
	
	
	public void screenDraw(Graphics2D g) {
		
		g.drawImage(pianoReleased1, 150, 15, null);
		g.drawImage(pianoReleased2, 200, 15, null);
		g.drawImage(pianoReleased3, 250, 15, null);
		g.drawImage(pianoReleased4, 300, 15, null);
		g.drawImage(pianoReleased5, 350, 15, null);
		g.drawImage(pianoReleased6, 400, 15, null);
		g.drawImage(pianoReleased7, 450, 15, null);
		g.drawImage(pianoReleased8, 500, 15, null);
		g.drawString("도", 170, 170);
		g.drawString("레", 220, 170);
		g.drawString("미", 270, 170);
		g.drawString("파", 320, 170);
		g.drawString("솔", 370, 170);
		g.drawString("라", 420, 170);
		g.drawString("시", 470, 170);
		g.drawString("도", 520, 170);
		
	}
	
	
	public void pressS() {
		pianoReleased1 = new ImageIcon(Main.class.getResource("./images/pianoPressed.png")).getImage();
		new Music("sound1.mp3",false).start();
	}
	public void releaseS() {
		pianoReleased1 = new ImageIcon(Main.class.getResource("./images/pianoReleased.png")).getImage();
	}
	public void pressD() {
		pianoReleased2 = new ImageIcon(Main.class.getResource("./images/pianoPressed.png")).getImage();
		new Music("sound2.mp3",false).start();
	}
	public void releaseD() {
		pianoReleased2 = new ImageIcon(Main.class.getResource("./images/pianoReleased.png")).getImage();
	}
	public void pressF() {
		pianoReleased3 = new ImageIcon(Main.class.getResource("./images/pianoPressed.png")).getImage();
		new Music("sound3.mp3",false).start();
	}
	public void releaseF() {
		pianoReleased3 = new ImageIcon(Main.class.getResource("./images/pianoReleased.png")).getImage();
	}
	public void pressG() {
		pianoReleased4 = new ImageIcon(Main.class.getResource("./images/pianoPressed.png")).getImage();
		new Music("sound4.mp3",false).start();
	}
	public void releaseG() {
		pianoReleased4 = new ImageIcon(Main.class.getResource("./images/pianoReleased.png")).getImage();
	}
	public void pressH() {
		pianoReleased5 = new ImageIcon(Main.class.getResource("./images/pianoPressed.png")).getImage();
		new Music("sound5.mp3",false).start();
	}
	public void releaseH() {
		pianoReleased5 = new ImageIcon(Main.class.getResource("./images/pianoReleased.png")).getImage();
	}
	public void pressJ() {
		pianoReleased6 = new ImageIcon(Main.class.getResource("./images/pianoPressed.png")).getImage();
		new Music("sound6.mp3",false).start();
	}
	public void releaseJ() {
		pianoReleased6 = new ImageIcon(Main.class.getResource("./images/pianoReleased.png")).getImage();
	}
	public void pressK() {
		pianoReleased7 = new ImageIcon(Main.class.getResource("./images/pianoPressed.png")).getImage();
		new Music("sound7.mp3",false).start();
	}
	public void releaseK() {
		pianoReleased7 = new ImageIcon(Main.class.getResource("./images/pianoReleased.png")).getImage();
	}
	public void pressL() {
		pianoReleased8 = new ImageIcon(Main.class.getResource("./images/pianoPressed.png")).getImage();
		new Music("sound8.mp3",false).start();
	}
	public void releaseL() {
		pianoReleased8 = new ImageIcon(Main.class.getResource("./images/pianoReleased.png")).getImage();
	}
	
	
	
	
	
	
	
	
	@Override
	public void run() {
		
	}

}
