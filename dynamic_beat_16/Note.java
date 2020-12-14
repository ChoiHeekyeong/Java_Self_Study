package dynamic_beat_16;

import java.awt.Graphics2D;
import java.awt.Image;

import javax.swing.ImageIcon;

public class Note extends Thread {
	private Image noteBasicImage = new ImageIcon(Main.class.getResource("../images/noteBasic.png")).getImage();
	private int x, y = -720;//580 - (1000 / Main.SLEEP_TIME * Main.NOTE_SPEED) * Main.REACH_TIME;
	private String noteType;
	private boolean proceeded = true;// 현재 노트 진행 여부
	
	public String getNoteType() {
		return noteType;
	}
	public boolean isProceeded() {
		return proceeded;
	}
	public void close() {
		proceeded = false;
	}

	public Note(String noteType) {
		if (noteType.equals("S")) {
			x = 228;
		} else if (noteType.equals("D")) {
			x = 332;
		} else if (noteType.equals("F")) {
			x = 436;
		} else if (noteType.equals("Space")) {
			x = 540;
		} else if (noteType.equals("J")) {
			x = 744;
		} else if (noteType.equals("K")) {
			x = 848;
		} else if (noteType.equals("L")) {
			x = 952;
		}
		this.noteType = noteType;
	}

	public void screenDraw(Graphics2D g) {
		if (!noteType.equals("Space")) {
			g.drawImage(noteBasicImage, x, y, null);
		} else {
			g.drawImage(noteBasicImage, x, y, null);
			g.drawImage(noteBasicImage, x + 100, y, null);
		}
	}

	public void drop() {
		y += Main.NOTE_SPEED;
		if(y>620) {
			//System.out.println("Miss");
			close();
		}
	}

	@Override
	public void run() {
		try {
			while (true) {
				drop();
				if(proceeded) {
					Thread.sleep(Main.SLEEP_TIME);
				}
				else {
					interrupt();
					break;
				}
				Thread.sleep(Main.SLEEP_TIME);// 노트 떨어지는 텀
			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}
	public String judge() {
		if(y>=613) {
			//System.out.println("Late");
			close();
			return "Late";
		}
		else if(y>=600) {
			//System.out.println("Good");
			close();
			return "Good";
		}
		else if(y>=587) {
			//System.out.println("Great");
			close();
			return "Great";
		}
		else if(y>=573) {
			//System.out.println("Perfect");
			close();
			return "Perfect";
		}
		else if(y>=565) {
			//System.out.println("Great");
			close();
			return "Great";
		}
		else if(y>=550) {
			//System.out.println("Good");
			close();
			return "Good";
		}
		else if(y>=535) {
			//System.out.println("Early");
			close();
			return "Early";
		}
		return "None";
	}
	public int getY() {
		return y;
	}

}
