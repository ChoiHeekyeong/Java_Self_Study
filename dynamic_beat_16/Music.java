package dynamic_beat_16;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;

import javazoom.jl.player.Player;

public class Music extends Thread{
	private Player player;
	private boolean isLoop;
	private File file;
	private FileInputStream fis;
	private BufferedInputStream bis;

	
	public Music(String name, boolean isLoop) {
		try {
			this.isLoop = isLoop;
			file = new File(Main.class.getResource("../music/"+name).toURI());
			fis = new FileInputStream(file);
			bis = new BufferedInputStream(fis);
			player = new Player(bis);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	//음악의 노트를 떨어뜨릴때
	public int getTime() {
		if (player == null)
			return 0;
		return player.getPosition();
	}
	
	//항상 종료 가능 하도록
	public void close() {
		isLoop = false;
		player.close();
		this.interrupt();//스레드를 중지하는것.
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
