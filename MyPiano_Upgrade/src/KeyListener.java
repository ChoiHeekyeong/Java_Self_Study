import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;


public class KeyListener extends KeyAdapter{
	
	@Override
	public void keyPressed(KeyEvent e) {
		
		
		if(e.getKeyCode() == KeyEvent.VK_S) {
			MyPianoGraphic.pianoplay.pressS();
		}
		else if(e.getKeyCode() == KeyEvent.VK_D) {
			MyPianoGraphic.pianoplay.pressD();
		}
		else if(e.getKeyCode() == KeyEvent.VK_F) {
			MyPianoGraphic.pianoplay.pressF();
		}
		else if(e.getKeyCode() == KeyEvent.VK_G) {
			MyPianoGraphic.pianoplay.pressG();
		}
		else if(e.getKeyCode() == KeyEvent.VK_H) {
			MyPianoGraphic.pianoplay.pressH();
		}
		else if(e.getKeyCode() == KeyEvent.VK_J) {
			MyPianoGraphic.pianoplay.pressJ();
		}
		else if(e.getKeyCode() == KeyEvent.VK_K) {
			MyPianoGraphic.pianoplay.pressK();
		}
		else if(e.getKeyCode() == KeyEvent.VK_L) {
			MyPianoGraphic.pianoplay.pressL();
		}
		else if(e.getKeyCode() == KeyEvent.VK_E) {
			MyPianoGraphic.pianoplay.pressE();
		}
		else if(e.getKeyCode() == KeyEvent.VK_R) {
			MyPianoGraphic.pianoplay.pressR();
		}
		else if(e.getKeyCode() == KeyEvent.VK_Y) {
			MyPianoGraphic.pianoplay.pressY();
		}
		else if(e.getKeyCode() == KeyEvent.VK_U) {
			MyPianoGraphic.pianoplay.pressU();
		}
		else if(e.getKeyCode() == KeyEvent.VK_I) {
			MyPianoGraphic.pianoplay.pressI();
		}
		
	}
	@Override
	public void keyReleased(KeyEvent e) {
		
		if(e.getKeyCode() == KeyEvent.VK_S) {
			MyPianoGraphic.pianoplay.releaseS();
		}
		else if(e.getKeyCode() == KeyEvent.VK_D) {
			MyPianoGraphic.pianoplay.releaseD();
		}
		else if(e.getKeyCode() == KeyEvent.VK_F) {
			MyPianoGraphic.pianoplay.releaseF();
		}
		else if(e.getKeyCode() == KeyEvent.VK_G) {
			MyPianoGraphic.pianoplay.releaseG();
		}
		else if(e.getKeyCode() == KeyEvent.VK_H) {
			MyPianoGraphic.pianoplay.releaseH();
		}
		else if(e.getKeyCode() == KeyEvent.VK_J) {
			MyPianoGraphic.pianoplay.releaseJ();
		}
		else if(e.getKeyCode() == KeyEvent.VK_K) {
			MyPianoGraphic.pianoplay.releaseK();
		}
		else if(e.getKeyCode() == KeyEvent.VK_L) {
			MyPianoGraphic.pianoplay.releaseL();
		}
		else if(e.getKeyCode() == KeyEvent.VK_E) {
			MyPianoGraphic.pianoplay.releaseE();
		}
		else if(e.getKeyCode() == KeyEvent.VK_R) {
			MyPianoGraphic.pianoplay.releaseR();
		}
		else if(e.getKeyCode() == KeyEvent.VK_Y) {
			MyPianoGraphic.pianoplay.releaseY();
		}
		else if(e.getKeyCode() == KeyEvent.VK_U) {
			MyPianoGraphic.pianoplay.releaseU();
		}
		else if(e.getKeyCode() == KeyEvent.VK_I) {
			MyPianoGraphic.pianoplay.releaseI();
		}
		
		
	}

}
