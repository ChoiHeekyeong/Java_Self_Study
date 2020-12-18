import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;

import javazoom.jl.player.Player;

public class Music extends Thread{
	
	private boolean isLoop;
	private File file;
	private FileInputStream fis;
	private BufferedInputStream bis;
	private Player player;
	public Music(String name, boolean isLoop) {
		try {
			this.isLoop = isLoop;
			file = new File(Main.class.getResource("./music/"+name).toURI());
			fis = new FileInputStream(file);
			bis = new BufferedInputStream(fis);
			player = new Player(bis);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	
	@Override
	public void run() {//Thread를 상속받으면 무조건 선언해줘야 하는 메소드 = run()
		try {
			do {
				player.play();
				fis = new FileInputStream(file);
				bis = new BufferedInputStream(fis);
				player = new Player(bis);
			} while (isLoop);
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

}
