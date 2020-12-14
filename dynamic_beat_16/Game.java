package dynamic_beat_16;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import javax.swing.ImageIcon;

public class Game extends Thread {

	// private Image noteBasicImage = new
	// ImageIcon(Main.class.getResource("../images/noteBasic.png")).getImage();
	private Image noteRouteLineImage = new ImageIcon(Main.class.getResource("../images/noteRouteLine.png")).getImage();
	private Image judgementLineImage = new ImageIcon(Main.class.getResource("../images/judgementLine.png")).getImage();
	private Image gameInfoImage = new ImageIcon(Main.class.getResource("../images/gameinfo.png")).getImage();
	private Image noteRouteSImage = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();
	private Image noteRouteDImage = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();
	private Image noteRouteFImage = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();
	private Image noteRouteSpace1Image = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();
	private Image noteRouteSpace2Image = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();
	private Image noteRouteJImage = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();
	private Image noteRouteKImage = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();
	private Image noteRouteLImage = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();
	private Image blueFlareImage;
	private Image judgeImage;
	private Image keyPadSImage = new ImageIcon(Main.class.getResource("../images/keyPadBasic.png")).getImage();
	private Image keyPadDImage = new ImageIcon(Main.class.getResource("../images/keyPadBasic.png")).getImage();
	private Image keyPadFImage = new ImageIcon(Main.class.getResource("../images/keyPadBasic.png")).getImage();
	private Image keyPadSpace1Image = new ImageIcon(Main.class.getResource("../images/keyPadBasic.png")).getImage();
	private Image keyPadSpace2Image = new ImageIcon(Main.class.getResource("../images/keyPadBasic.png")).getImage();
	private Image keyPadJImage = new ImageIcon(Main.class.getResource("../images/keyPadBasic.png")).getImage();
	private Image keyPadKImage = new ImageIcon(Main.class.getResource("../images/keyPadBasic.png")).getImage();
	private Image keyPadLImage = new ImageIcon(Main.class.getResource("../images/keyPadBasic.png")).getImage();

	private String titleName;
	private String difficulty;
	private String musicTitle;
	private Music gameMusic;

	private boolean gameMaker = true;// 노트 좌표 찍을때만 켜두는 개발자모드
	int score = 0;

	ArrayList<Note> noteList = new ArrayList<Note>();

	public Game(String titleName, String difficulty, String musicTitle) {
		this.titleName = titleName;
		this.difficulty = difficulty;
		this.musicTitle = musicTitle;
		gameMusic = new Music(this.musicTitle, false);

	}

	public void screenDraw(Graphics2D g) {
		g.drawImage(noteRouteSImage, 228, 30, null);
		g.drawImage(noteRouteDImage, 332, 30, null);
		g.drawImage(noteRouteFImage, 436, 30, null);
		g.drawImage(noteRouteSpace1Image, 540, 30, null);
		g.drawImage(noteRouteSpace2Image, 640, 30, null);
		g.drawImage(noteRouteJImage, 744, 30, null);
		g.drawImage(noteRouteKImage, 848, 30, null);
		g.drawImage(noteRouteLImage, 952, 30, null);
		g.drawImage(noteRouteLineImage, 224, 30, null);
		g.drawImage(noteRouteLineImage, 328, 30, null);
		g.drawImage(noteRouteLineImage, 432, 30, null);
		g.drawImage(noteRouteLineImage, 536, 30, null);
		g.drawImage(noteRouteLineImage, 740, 30, null);
		g.drawImage(noteRouteLineImage, 844, 30, null);
		g.drawImage(noteRouteLineImage, 948, 30, null);
		g.drawImage(noteRouteLineImage, 1052, 30, null);
		g.drawImage(gameInfoImage, 0, 660, null);
		g.drawImage(judgementLineImage, 0, 580, null);
//		g.drawImage(noteBasicImage,228,120,null);
//		g.drawImage(noteBasicImage,332,30,null);
//		g.drawImage(noteBasicImage,436,30,null);
//		g.drawImage(noteBasicImage,540,30,null);
//		g.drawImage(noteBasicImage,640,30,null);
//		g.drawImage(noteBasicImage,744,30,null);
//		g.drawImage(noteBasicImage,848,30,null);
//		g.drawImage(noteBasicImage,952,30,null);
		for (int i = 0; i < noteList.size(); i++) {
			Note note = noteList.get(i);
			if (note.getY() > 620) {
				judgeImage = new ImageIcon(Main.class.getResource("../images/judgeMiss.png")).getImage();
			}
			if (!note.isProceeded()) {
				noteList.remove(i);
				i--;
			} else {
				note.screenDraw(g);
			}
		}
		g.setColor(Color.white);
		g.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
		g.setColor(Color.white);
		g.setFont(new Font("Arial", Font.BOLD, 30));
		g.drawString(titleName, 20, 702);
		g.drawString(difficulty, 1190, 702);
		g.setFont(new Font("Arial", Font.PLAIN, 26));
		g.setColor(Color.DARK_GRAY);
		g.drawString("S", 270, 609);
		g.drawString("D", 374, 609);
		g.drawString("F", 478, 609);
		g.drawString("Space Bar", 580, 609);
		g.drawString("J", 784, 609);
		g.drawString("K", 889, 609);
		g.drawString("L", 993, 609);
		g.setColor(Color.LIGHT_GRAY);
		g.setFont(new Font("Elephant", Font.BOLD, 30));
		g.drawString(score + "", 565, 702);
		g.drawImage(blueFlareImage, 160, 100, null);
		g.drawImage(judgeImage, 450, 420, null);
		g.drawImage(keyPadSImage, 228, 580, null);
		g.drawImage(keyPadDImage, 332, 580, null);
		g.drawImage(keyPadFImage, 436, 580, null);
		g.drawImage(keyPadSpace1Image, 540, 580, null);
		g.drawImage(keyPadSpace2Image, 640, 580, null);
		g.drawImage(keyPadJImage, 744, 580, null);
		g.drawImage(keyPadKImage, 848, 580, null);
		g.drawImage(keyPadLImage, 952, 580, null);
	}

	public void pressS() {
		judge("S");
		noteRouteSImage = new ImageIcon(Main.class.getResource("../images/noteRoutePressed.png")).getImage();
		keyPadSImage = new ImageIcon(Main.class.getResource("../images/keyPadPressed.png")).getImage();
		new Music("drumSmall1.mp3", false).start();
		if (gameMaker == true) {
			System.out.println("new Beat(" + gameMusic.getTime() + "-gap, \"S\"),");

		}
	}

	public void releaseS() {
		noteRouteSImage = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();
		keyPadSImage = new ImageIcon(Main.class.getResource("../images/keyPadBasic.png")).getImage();
	}

	public void pressD() {
		judge("D");
		noteRouteDImage = new ImageIcon(Main.class.getResource("../images/noteRoutePressed.png")).getImage();
		keyPadDImage = new ImageIcon(Main.class.getResource("../images/keyPadPressed.png")).getImage();
		new Music("drumSmall1.mp3", false).start();
		if (gameMaker == true) {
			System.out.println("new Beat(" + gameMusic.getTime() + "-gap, \"D\"),");
		}
	}

	public void releaseD() {
		noteRouteDImage = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();
		keyPadDImage = new ImageIcon(Main.class.getResource("../images/keyPadBasic.png")).getImage();
	}

	public void pressF() {
		judge("F");
		noteRouteFImage = new ImageIcon(Main.class.getResource("../images/noteRoutePressed.png")).getImage();
		keyPadFImage = new ImageIcon(Main.class.getResource("../images/keyPadPressed.png")).getImage();
		new Music("drumSmall2.mp3", false).start();
		if (gameMaker == true) {
			System.out.println("new Beat(" + gameMusic.getTime() + "-gap, \"F\"),");
		}
	}

	public void releaseF() {
		noteRouteFImage = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();
		keyPadFImage = new ImageIcon(Main.class.getResource("../images/keyPadBasic.png")).getImage();
	}

	public void pressSpace() {
		judge("Space");
		noteRouteSpace1Image = new ImageIcon(Main.class.getResource("../images/noteRoutePressed.png")).getImage();
		keyPadSpace1Image = new ImageIcon(Main.class.getResource("../images/keyPadPressed.png")).getImage();
		noteRouteSpace2Image = new ImageIcon(Main.class.getResource("../images/noteRoutePressed.png")).getImage();
		keyPadSpace2Image = new ImageIcon(Main.class.getResource("../images/keyPadPressed.png")).getImage();
		new Music("drumBig1.mp3", false).start();
		if (gameMaker == true) {
			System.out.println("new Beat(" + gameMusic.getTime() + "-gap, \"Space\"),");
		}
	}

	public void releaseSpace() {
		noteRouteSpace1Image = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();
		keyPadSpace1Image = new ImageIcon(Main.class.getResource("../images/keyPadBasic.png")).getImage();
		noteRouteSpace2Image = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();
		keyPadSpace2Image = new ImageIcon(Main.class.getResource("../images/keyPadBasic.png")).getImage();
	}

	public void pressJ() {
		judge("J");
		noteRouteJImage = new ImageIcon(Main.class.getResource("../images/noteRoutePressed.png")).getImage();
		keyPadJImage = new ImageIcon(Main.class.getResource("../images/keyPadPressed.png")).getImage();
		new Music("drumSmall2.mp3", false).start();
		if (gameMaker == true) {
			System.out.println("new Beat(" + gameMusic.getTime() + "-gap, \"J\"),");
		}
	}

	public void releaseJ() {
		noteRouteJImage = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();
		keyPadJImage = new ImageIcon(Main.class.getResource("../images/keyPadBasic.png")).getImage();
	}

	public void pressK() {
		judge("K");
		noteRouteKImage = new ImageIcon(Main.class.getResource("../images/noteRoutePressed.png")).getImage();
		keyPadKImage = new ImageIcon(Main.class.getResource("../images/keyPadPressed.png")).getImage();
		new Music("drumSmall1.mp3", false).start();
		if (gameMaker == true) {
			System.out.println("new Beat(" + gameMusic.getTime() + "-gap, \"K\"),");
		}
	}

	public void releaseK() {
		noteRouteKImage = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();
		keyPadKImage = new ImageIcon(Main.class.getResource("../images/keyPadBasic.png")).getImage();
	}

	public void pressL() {
		judge("L");
		noteRouteLImage = new ImageIcon(Main.class.getResource("../images/noteRoutePressed.png")).getImage();
		keyPadLImage = new ImageIcon(Main.class.getResource("../images/keyPadPressed.png")).getImage();
		new Music("drumSmall1.mp3", false).start();
		if (gameMaker == true) {
			System.out.println("new Beat(" + gameMusic.getTime() + "-gap, \"L\"),");
		}
	}

	public void releaseL() {
		noteRouteLImage = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();
		keyPadLImage = new ImageIcon(Main.class.getResource("../images/keyPadBasic.png")).getImage();
	}

	public void close() {
		gameMusic.close();
		this.interrupt();
	}

	public void dropNotes() {
		Beat[] beats = null;
		int gap = 4770;
		if (titleName.equals("Friend-ChoMingyu") && difficulty.equals("Easy")) {
			// int startTime = 1000 - Main.REACH_TIME * 1000;
			beats = new Beat[] { new Beat(5760 - gap, "D"), new Beat(6620 - gap, "K"), new Beat(7440 - gap, "L"),
					new Beat(8260 - gap, "S"), new Beat(9110 - gap, "J"), new Beat(9910 - gap, "Space"),
					new Beat(10760 - gap, "K"), new Beat(10770 - gap, "D"), new Beat(11590 - gap, "S"),
					new Beat(11610 - gap, "L"), new Beat(12450 - gap, "F"), new Beat(12450 - gap, "J"),
					new Beat(13400 - gap, "Space"), new Beat(14370 - gap, "S"), new Beat(15170 - gap, "F"),
					new Beat(15950 - gap, "J"), new Beat(16900 - gap, "L"), new Beat(17780 - gap, "K"),
					new Beat(18570 - gap, "D"), new Beat(19430 - gap, "J"), new Beat(19780 - gap, "F"),
					new Beat(20180 - gap, "Space"), new Beat(21050 - gap, "S"), new Beat(21830 - gap, "F"),
					new Beat(22640 - gap, "L"), new Beat(23490 - gap, "J"), new Beat(24290 - gap, "K"),
					new Beat(25110 - gap, "D"), new Beat(25940 - gap, "F"), new Beat(25960 - gap, "J"),
					new Beat(26740 - gap, "Space"), new Beat(27520 - gap, "S"), new Beat(28410 - gap, "Space"),
					new Beat(29190 - gap, "J"), new Beat(30040 - gap, "Space"), new Beat(30870 - gap, "L"),
					new Beat(31700 - gap, "K"), new Beat(32540 - gap, "J"), new Beat(33370 - gap, "Space"),
					new Beat(34180 - gap, "S"), new Beat(34980 - gap, "L"), new Beat(35800 - gap, "K"),
					new Beat(36680 - gap, "J"), new Beat(36680 - gap, "F"), new Beat(37380 - gap, "S"),
					new Beat(38200 - gap, "F"), new Beat(39030 - gap, "D"), new Beat(39960 - gap, "Space"),
					new Beat(40790 - gap, "L"), new Beat(41540 - gap, "S"), new Beat(42360 - gap, "K"),
					new Beat(43230 - gap, "J"), new Beat(44070 - gap, "F"), new Beat(44860 - gap, "S"),
					new Beat(45690 - gap, "D"), new Beat(46490 - gap, "Space"), new Beat(47300 - gap, "F"),
					new Beat(48100 - gap, "S"), new Beat(48920 - gap, "L"), new Beat(49700 - gap, "Space"),
					new Beat(50550 - gap, "D"), new Beat(51350 - gap, "S"), new Beat(52130 - gap, "J"),
					new Beat(52930 - gap, "Space"), new Beat(53700 - gap, "K"), new Beat(53700 - gap, "D"),
					new Beat(54550 - gap, "L"), new Beat(54570 - gap, "F"), new Beat(55370 - gap, "S"),
					new Beat(55370 - gap, "L"), new Beat(56110 - gap, "J"), new Beat(56910 - gap, "K"),
					new Beat(57740 - gap, "D"), new Beat(58630 - gap, "L"), new Beat(59410 - gap, "Space"),
					new Beat(60170 - gap, "J"), new Beat(60190 - gap, "S"), new Beat(61030 - gap, "K"),
					new Beat(61030 - gap, "D"), new Beat(61860 - gap, "L"), new Beat(61870 - gap, "F"),
					new Beat(62640 - gap, "S"), new Beat(62660 - gap, "L"), new Beat(63490 - gap, "K"),
					new Beat(64270 - gap, "D"), new Beat(65020 - gap, "J"), new Beat(65920 - gap, "Space"),
					new Beat(66700 - gap, "S"), new Beat(67500 - gap, "L"), new Beat(68330 - gap, "J"),
					new Beat(69170 - gap, "F"), new Beat(69930 - gap, "K"), new Beat(70760 - gap, "D"),
					new Beat(71620 - gap, "F"), new Beat(71630 - gap, "S"), new Beat(71630 - gap, "J"),
					new Beat(71630 - gap, "L"), new Beat(72350 - gap, "Space"), new Beat(73200 - gap, "L"),
					new Beat(73980 - gap, "S"), new Beat(74730 - gap, "K"), new Beat(75600 - gap, "Space"),
					new Beat(76370 - gap, "S"), new Beat(77190 - gap, "F"), new Beat(78050 - gap, "D"),
					new Beat(78890 - gap, "Space"), new Beat(79670 - gap, "F"), new Beat(79690 - gap, "J"),
					new Beat(80490 - gap, "S"), new Beat(80510 - gap, "L"), new Beat(81360 - gap, "K"),
					new Beat(81360 - gap, "D"), new Beat(82020 - gap, "Space"), new Beat(82830 - gap, "F"),
					new Beat(83690 - gap, "K"), new Beat(84450 - gap, "D"), new Beat(85340 - gap, "Space"),
					new Beat(86200 - gap, "S"), new Beat(86220 - gap, "L"), new Beat(86970 - gap, "J"),
					new Beat(87780 - gap, "F"), new Beat(88570 - gap, "S"), new Beat(88580 - gap, "L"),
					new Beat(89350 - gap, "K"), new Beat(90170 - gap, "D"), new Beat(91000 - gap, "J"),
					new Beat(91850 - gap, "Space"), new Beat(92580 - gap, "S"), new Beat(93380 - gap, "D"),
					new Beat(94280 - gap, "F"), new Beat(95070 - gap, "J"), new Beat(95910 - gap, "K"),
					new Beat(96730 - gap, "L"), new Beat(97510 - gap, "K"), new Beat(98310 - gap, "L"),
					new Beat(98320 - gap, "S"), new Beat(99180 - gap, "F"), new Beat(99920 - gap, "D"),
					new Beat(100790 - gap, "J"), new Beat(101600 - gap, "S"), new Beat(102430 - gap, "K"),
					new Beat(103170 - gap, "Space"), new Beat(104020 - gap, "F"), new Beat(104820 - gap, "Space"),
					new Beat(105620 - gap, "S"), new Beat(106420 - gap, "L"), new Beat(107260 - gap, "F"),
					new Beat(108070 - gap, "K"), new Beat(108880 - gap, "Space"), new Beat(109680 - gap, "K"),
					new Beat(109700 - gap, "D"), new Beat(110430 - gap, "S"), new Beat(110460 - gap, "L"),
					new Beat(111250 - gap, "F"), new Beat(111250 - gap, "J"), new Beat(112110 - gap, "K"),
					new Beat(112910 - gap, "S"), new Beat(113810 - gap, "L"), new Beat(114560 - gap, "Space"),
					new Beat(115370 - gap, "F"), new Beat(116160 - gap, "K"), new Beat(116970 - gap, "D"),
					new Beat(117820 - gap, "Space"), new Beat(118550 - gap, "S"), new Beat(119420 - gap, "Space"),
					new Beat(120200 - gap, "F"), new Beat(121050 - gap, "Space"), new Beat(121880 - gap, "J"),
					new Beat(122700 - gap, "Space"), new Beat(123460 - gap, "S"), new Beat(123490 - gap, "L"),
					new Beat(123920 - gap, "K"), new Beat(123920 - gap, "D"), new Beat(124320 - gap, "F"),
					new Beat(124320 - gap, "J"), new Beat(124710 - gap, "Space"), new Beat(125050 - gap, "S"),
					new Beat(125910 - gap, "L"), new Beat(126800 - gap, "F"), new Beat(127550 - gap, "K"),
					new Beat(128390 - gap, "J"), new Beat(128390 - gap, "F"), new Beat(128420 - gap, "S"),
					new Beat(128420 - gap, "L"), new Beat(129160 - gap, "K"), new Beat(129160 - gap, "D"),
					new Beat(130030 - gap, "Space"), new Beat(130780 - gap, "Space"), new Beat(131610 - gap, "S"),
					new Beat(132430 - gap, "L"), new Beat(133240 - gap, "K"), new Beat(133960 - gap, "J"),
					new Beat(134890 - gap, "S"), new Beat(135710 - gap, "F"), new Beat(135710 - gap, "J"),
					new Beat(136540 - gap, "K"), new Beat(137300 - gap, "F"), new Beat(137300 - gap, "J"),
					new Beat(137320 - gap, "S"), new Beat(137320 - gap, "L"), new Beat(138140 - gap, "K"),
					new Beat(138140 - gap, "D"), new Beat(138900 - gap, "Space"), new Beat(139750 - gap, "J"),
					new Beat(139770 - gap, "S"), new Beat(139770 - gap, "F"), new Beat(139770 - gap, " L"),
					new Beat(140480 - gap, "Space"), new Beat(141270 - gap, "L"), new Beat(142020 - gap, "K"),
					new Beat(142930 - gap, "J"), new Beat(143750 - gap, "Space"), new Beat(144500 - gap, "L"),
					new Beat(145380 - gap, "S"), new Beat(146160 - gap, "J"), new Beat(146980 - gap, "D"),
					new Beat(147790 - gap, "L"), new Beat(148590 - gap, "F"), new Beat(149510 - gap, "J"),
					new Beat(150230 - gap, "S"), new Beat(151060 - gap, "K"), new Beat(151860 - gap, "Space"),
					new Beat(152730 - gap, "S"), new Beat(153520 - gap, "Space"), new Beat(154190 - gap, "D"),
					new Beat(155050 - gap, "Space"), new Beat(155830 - gap, "L"), new Beat(156700 - gap, "Space"),
					new Beat(157480 - gap, "J"), new Beat(158340 - gap, "Space"), new Beat(159130 - gap, "K"),
					new Beat(159940 - gap, "Space"), new Beat(160730 - gap, "S"), new Beat(161520 - gap, "Space"),
					new Beat(162300 - gap, "L"), new Beat(163170 - gap, "Space"), new Beat(163980 - gap, "J"),
					new Beat(164410 - gap, "F"), new Beat(164800 - gap, "Space"), new Beat(165640 - gap, "L"),
					new Beat(166430 - gap, "S"), new Beat(167140 - gap, "J"), new Beat(167980 - gap, "Space"),
					new Beat(168840 - gap, "K"), new Beat(169660 - gap, "Space"), new Beat(170450 - gap, "F"),
					new Beat(170890 - gap, "J"), new Beat(171300 - gap, "Space"), new Beat(172090 - gap, "S"),
					new Beat(172480 - gap, "L"), new Beat(172880 - gap, "J"), new Beat(173750 - gap, "D"),
					new Beat(174540 - gap, "K"), new Beat(175350 - gap, "F"), new Beat(176160 - gap, "F"),
					new Beat(176170 - gap, "J"), new Beat(176180 - gap, "S"), new Beat(176190 - gap, "L"),
					new Beat(176980 - gap, "Space"), new Beat(177780 - gap, "Space"), new Beat(178650 - gap, "D"),
					new Beat(179400 - gap, "Space"), new Beat(180200 - gap, "J"), new Beat(181050 - gap, "Space"),
					new Beat(181830 - gap, "K"), new Beat(182660 - gap, "Space"), new Beat(183480 - gap, "J"),
					new Beat(183480 - gap, "F"), new Beat(183480 - gap, "S"), new Beat(183500 - gap, "L"),
					new Beat(184240 - gap, "Space"), new Beat(185090 - gap, "S"), new Beat(185910 - gap, "Space"),
					new Beat(186710 - gap, "F"), new Beat(186710 - gap, "S"), new Beat(187520 - gap, "Space"),
					new Beat(188290 - gap, "J"), new Beat(189120 - gap, "Space"), new Beat(189990 - gap, "L"),
					new Beat(190790 - gap, "L"), new Beat(190810 - gap, "J"), new Beat(191540 - gap, "K"),
					new Beat(192290 - gap, "D"), new Beat(193220 - gap, "J"), new Beat(194030 - gap, "Space"),
					new Beat(194870 - gap, "L"), new Beat(195600 - gap, "S"), new Beat(195620 - gap, "F"),
					new Beat(196460 - gap, "K"), new Beat(197220 - gap, "Space"), new Beat(198030 - gap, "S"),
					new Beat(198430 - gap, "F"), new Beat(198850 - gap, "Space"), new Beat(199680 - gap, "J"),
					new Beat(200440 - gap, "K"), new Beat(201420 - gap, "L"), new Beat(202730 - gap, "S"),
					new Beat(203100 - gap, "D"), new Beat(203950 - gap, "K"), new Beat(204810 - gap, "J"),
					new Beat(205640 - gap, "Space"), new Beat(206510 - gap, "F"), new Beat(207320 - gap, "L"),
					new Beat(208220 - gap, "S"), new Beat(209200 - gap, "K"), new Beat(210100 - gap, "S"),
					new Beat(210520 - gap, "D"), new Beat(210920 - gap, "F"), new Beat(211370 - gap, "J"),
					new Beat(211830 - gap, "K"), new Beat(212320 - gap, "L"), new Beat(212800 - gap, "Space"),
					new Beat(214220 - gap, "K"), new Beat(214220 - gap, "D"),

			};
		} else if (titleName.equals("Friend-ChoMingyu") && difficulty.equals("Hard")) {
			int startTime = 1000;
			beats = new Beat[] { new Beat(5760 - gap, "S"), new Beat(7530 - gap, "F"), new Beat(8290 - gap, "J"),
					new Beat(9100 - gap, "L"), new Beat(10220 - gap, "S"), new Beat(10700 - gap, "D"),
					new Beat(11060 - gap, "F"), new Beat(12340 - gap, "J"), new Beat(12790 - gap, "Space"),
					new Beat(14410 - gap, "S"), new Beat(15180 - gap, "D"), new Beat(16020 - gap, "L"),
					new Beat(16550 - gap, "K"), new Beat(16820 - gap, "J"), new Beat(17690 - gap, "Space"),
					new Beat(17830 - gap, "J"), new Beat(18220 - gap, "K"), new Beat(18440 - gap, "L"),
					new Beat(18830 - gap, "K"), new Beat(19050 - gap, "J"), new Beat(19410 - gap, "F"),
					new Beat(20240 - gap, "Space"), new Beat(21060 - gap, "S"), new Beat(21950 - gap, "F"),
					new Beat(22700 - gap, "J"), new Beat(23570 - gap, "Space"), new Beat(24440 - gap, "L"),
					new Beat(25180 - gap, "K"), new Beat(25960 - gap, "J"), new Beat(26700 - gap, "Space"),
					new Beat(27560 - gap, "S"), new Beat(28370 - gap, "F"), new Beat(29240 - gap, "D"),
					new Beat(30110 - gap, "K"), new Beat(30820 - gap, "J"), new Beat(31670 - gap, "L"),
					new Beat(32560 - gap, "Space"), new Beat(33390 - gap, "K"), new Beat(34200 - gap, "J"),
					new Beat(35020 - gap, "D"), new Beat(35840 - gap, "S"), new Beat(36690 - gap, "Space"),
					new Beat(37490 - gap, "F"), new Beat(38350 - gap, "Space"), new Beat(39230 - gap, "D"),
					new Beat(39980 - gap, "K"), new Beat(40830 - gap, "L"), new Beat(41610 - gap, "K"),
					new Beat(42430 - gap, "J"), new Beat(43240 - gap, "Space"), new Beat(44100 - gap, "S"),
					new Beat(44840 - gap, "F"), new Beat(45670 - gap, "D"), new Beat(46110 - gap, "K"),
					new Beat(46520 - gap, "Space"), new Beat(47360 - gap, "L"), new Beat(48130 - gap, "Space"),
					new Beat(48920 - gap, "J"), new Beat(48960 - gap, "L"), new Beat(49690 - gap, "Space"),
					new Beat(50570 - gap, "S"), new Beat(51430 - gap, "D"), new Beat(52190 - gap, "F"),
					new Beat(52950 - gap, "Space"), new Beat(53780 - gap, "S"), new Beat(53800 - gap, "F"),
					new Beat(54580 - gap, "J"), new Beat(54580 - gap, "L"), new Beat(55350 - gap, "D"),
					new Beat(56110 - gap, "Space"), new Beat(56940 - gap, "K"), new Beat(57780 - gap, "J"),
					new Beat(57780 - gap, "L"), new Beat(58540 - gap, "F"), new Beat(58990 - gap, "D"),
					new Beat(59420 - gap, "S"), new Beat(60240 - gap, "K"), new Beat(61060 - gap, "J"),
					new Beat(61060 - gap, "L"), new Beat(61890 - gap, "F"), new Beat(62670 - gap, "F"),
					new Beat(62670 - gap, "S"), new Beat(63480 - gap, "K"), new Beat(63500 - gap, "D"),
					new Beat(64240 - gap, "S"), new Beat(64240 - gap, "L"), new Beat(65040 - gap, "F"),
					new Beat(65060 - gap, "J"), new Beat(65870 - gap, "D"), new Beat(65870 - gap, "L"),
					new Beat(66690 - gap, "K"), new Beat(67530 - gap, "S"), new Beat(68370 - gap, "J"),
					new Beat(69150 - gap, "K"), new Beat(69970 - gap, "D"), new Beat(70770 - gap, "L"),
					new Beat(71610 - gap, "J"), new Beat(71610 - gap, "L"), new Beat(72430 - gap, "Space"),
					new Beat(73200 - gap, "D"), new Beat(74000 - gap, "K"), new Beat(74750 - gap, "J"),
					new Beat(75560 - gap, "Space"), new Beat(76360 - gap, "F"), new Beat(77170 - gap, "S"),
					new Beat(78030 - gap, "J"), new Beat(78030 - gap, "L"), new Beat(78860 - gap, "Space"),
					new Beat(79640 - gap, "S"), new Beat(79690 - gap, "F"), new Beat(80500 - gap, "D"),
					new Beat(81270 - gap, "K"), new Beat(82110 - gap, "Space"), new Beat(82940 - gap, "J"),
					new Beat(82960 - gap, "L"), new Beat(83740 - gap, "K"), new Beat(84540 - gap, "F"),
					new Beat(85350 - gap, "Space"), new Beat(86160 - gap, "D"), new Beat(86940 - gap, "K"),
					new Beat(87740 - gap, "L"), new Beat(88550 - gap, "K"), new Beat(89410 - gap, "S"),
					new Beat(90180 - gap, "J"), new Beat(91000 - gap, "F"), new Beat(91860 - gap, "Space"),
					new Beat(92620 - gap, "D"), new Beat(93340 - gap, "L"), new Beat(94160 - gap, "K"),
					new Beat(94950 - gap, "S"), new Beat(95840 - gap, "J"), new Beat(96610 - gap, "Space"),
					new Beat(97470 - gap, "F"), new Beat(97490 - gap, "S"), new Beat(98340 - gap, "Space"),
					new Beat(99190 - gap, "L"), new Beat(99190 - gap, "J"), new Beat(99990 - gap, "Space"),
					new Beat(100750 - gap, "D"), new Beat(101550 - gap, "Space"), new Beat(102430 - gap, "J"),
					new Beat(102430 - gap, "K"), new Beat(103170 - gap, "Space"), new Beat(104070 - gap, "S"),
					new Beat(104070 - gap, "F"), new Beat(104810 - gap, "Space"), new Beat(105650 - gap, "L"),
					new Beat(106410 - gap, "Space"), new Beat(107230 - gap, "D"), new Beat(107690 - gap, "K"),
					new Beat(108130 - gap, "Space"), new Beat(108960 - gap, "L"), new Beat(109540 - gap, "K"),
					new Beat(109880 - gap, "J"), new Beat(110120 - gap, "F"), new Beat(110850 - gap, "D"),
					new Beat(111270 - gap, "S"), new Beat(111730 - gap, "Space"), new Beat(112180 - gap, "K"),
					new Beat(112940 - gap, "J"), new Beat(113760 - gap, "L"), new Beat(114550 - gap, "F"),
					new Beat(115370 - gap, "K"), new Beat(116140 - gap, "Space"), new Beat(116990 - gap, "F"),
					new Beat(117010 - gap, "S"), new Beat(117780 - gap, "Space"), new Beat(118630 - gap, "D"),
					new Beat(118650 - gap, "K"), new Beat(119400 - gap, "K"), new Beat(119420 - gap, "D"),
					new Beat(120200 - gap, "F"), new Beat(120200 - gap, "J"), new Beat(120990 - gap, "J"),
					new Beat(120990 - gap, "F"), new Beat(121880 - gap, "S"), new Beat(121900 - gap, "L"),
					new Beat(122670 - gap, "S"), new Beat(122680 - gap, "L"), new Beat(123540 - gap, "K"),
					new Beat(123940 - gap, "J"), new Beat(124330 - gap, "Space"), new Beat(125150 - gap, "F"),
					new Beat(125150 - gap, "S"), new Beat(125950 - gap, "J"), new Beat(125950 - gap, "L"),
					new Beat(126650 - gap, "K"), new Beat(127070 - gap, "D"), new Beat(127450 - gap, "F"),
					new Beat(128080 - gap, "L"), new Beat(128310 - gap, "K"), new Beat(128810 - gap, "J"),
					new Beat(129020 - gap, "F"), new Beat(129480 - gap, "D"), new Beat(129680 - gap, "S"),
					new Beat(130050 - gap, "K"), new Beat(130480 - gap, "J"), new Beat(130870 - gap, "Space"),
					new Beat(131680 - gap, "L"), new Beat(132440 - gap, "L"), new Beat(132460 - gap, "J"),
					new Beat(133260 - gap, "S"), new Beat(133300 - gap, "F"), new Beat(134010 - gap, "D"),
					new Beat(134850 - gap, "K"), new Beat(135680 - gap, "J"), new Beat(135680 - gap, "L"),
					new Beat(136510 - gap, "D"), new Beat(136940 - gap, "D"), new Beat(137380 - gap, "Space"),
					new Beat(138170 - gap, "S"), new Beat(138190 - gap, "F"), new Beat(138950 - gap, "L"),
					new Beat(138970 - gap, "J"), new Beat(139750 - gap, "D"), new Beat(140480 - gap, "K"),
					new Beat(141290 - gap, "L"), new Beat(142000 - gap, "K"), new Beat(142910 - gap, "J"),
					new Beat(143680 - gap, "Space"), new Beat(144520 - gap, "F"), new Beat(145360 - gap, "D"),
					new Beat(146180 - gap, "S"), new Beat(146970 - gap, "D"), new Beat(147850 - gap, "F"),
					new Beat(149130 - gap, "J"), new Beat(149560 - gap, "K"), new Beat(150310 - gap, "L"),
					new Beat(151110 - gap, "L"), new Beat(151130 - gap, "J"), new Beat(151890 - gap, "K"),
					new Beat(152730 - gap, "F"), new Beat(153440 - gap, "Space"), new Beat(154230 - gap, "D"),
					new Beat(155030 - gap, "Space"), new Beat(155900 - gap, "S"), new Beat(155900 - gap, "F"),
					new Beat(156700 - gap, "Space"), new Beat(157520 - gap, "J"), new Beat(157520 - gap, "L"),
					new Beat(158350 - gap, "Space"), new Beat(159100 - gap, "K"), new Beat(159970 - gap, "Space"),
					new Beat(160810 - gap, "J"), new Beat(160820 - gap, "L"), new Beat(161560 - gap, "Space"),
					new Beat(162360 - gap, "S"), new Beat(162400 - gap, "F"), new Beat(163150 - gap, "K"),
					new Beat(163170 - gap, "D"), new Beat(163990 - gap, "F"), new Beat(164030 - gap, "L"),
					new Beat(164840 - gap, "Space"), new Beat(165600 - gap, "S"), new Beat(166080 - gap, "D"),
					new Beat(166330 - gap, "F"), new Beat(166710 - gap, "D"), new Beat(167060 - gap, "S"),
					new Beat(167450 - gap, "J"), new Beat(167830 - gap, "L"), new Beat(168490 - gap, "K"),
					new Beat(168730 - gap, "J"), new Beat(169090 - gap, "F"), new Beat(169540 - gap, "D"),
					new Beat(169950 - gap, "S"), new Beat(170190 - gap, "L"), new Beat(170190 - gap, "J"),
					new Beat(170660 - gap, "D"), new Beat(171330 - gap, "Space"), new Beat(172090 - gap, "K"),
					new Beat(172890 - gap, "Space"), new Beat(173670 - gap, "F"), new Beat(174190 - gap, "J"),
					new Beat(174430 - gap, "K"), new Beat(174810 - gap, "L"), new Beat(175340 - gap, "K"),
					new Beat(175790 - gap, "J"), new Beat(176030 - gap, "D"), new Beat(176830 - gap, "S"),
					new Beat(177050 - gap, "F"), new Beat(177450 - gap, "D"), new Beat(177700 - gap, "K"),
					new Beat(178080 - gap, "L"), new Beat(178280 - gap, "J"), new Beat(178600 - gap, "S"),
					new Beat(179020 - gap, "D"), new Beat(179450 - gap, "Space"), new Beat(180260 - gap, "F"),
					new Beat(180630 - gap, "K"), new Beat(180850 - gap, "J"), new Beat(181260 - gap, "L"),
					new Beat(181650 - gap, "K"), new Beat(182280 - gap, "J"), new Beat(182510 - gap, "J"),
					new Beat(182740 - gap, "S"), new Beat(183360 - gap, "D"), new Beat(183540 - gap, "F"),
					new Beat(183710 - gap, "D"), new Beat(184110 - gap, "S"), new Beat(184480 - gap, "J"),
					new Beat(184750 - gap, "L"), new Beat(185140 - gap, "K"), new Beat(185860 - gap, "Space"),
					new Beat(186690 - gap, "S"), new Beat(186690 - gap, "F"), new Beat(187500 - gap, "Space"),
					new Beat(188300 - gap, "J"), new Beat(188300 - gap, "L"), new Beat(189080 - gap, "Space"),
					new Beat(190000 - gap, "D"), new Beat(190020 - gap, "K"), new Beat(190760 - gap, "S"),
					new Beat(190770 - gap, "L"), new Beat(191210 - gap, "J"), new Beat(191230 - gap, "F"),
					new Beat(192360 - gap, "Space"), new Beat(193200 - gap, "K"), new Beat(193970 - gap, "J"),
					new Beat(193970 - gap, "L"), new Beat(194750 - gap, "D"), new Beat(195600 - gap, "S"),
					new Beat(195600 - gap, "F"), new Beat(196490 - gap, "K"), new Beat(196700 - gap, "J"),
					new Beat(197090 - gap, "J"), new Beat(197440 - gap, "L"), new Beat(197680 - gap, "K"),
					new Beat(198080 - gap, "Space"), new Beat(198820 - gap, "Space"), new Beat(199630 - gap, "S"),
					new Beat(200480 - gap, "F"), new Beat(201390 - gap, "J"), new Beat(202710 - gap, "L"),
					new Beat(203080 - gap, "K"), new Beat(204010 - gap, "J"), new Beat(204360 - gap, "D"),
					new Beat(204510 - gap, "K"), new Beat(204660 - gap, "S"), new Beat(204870 - gap, "L"),
					new Beat(206110 - gap, "F"), new Beat(206470 - gap, "D"), new Beat(207330 - gap, "Space"),
					new Beat(208220 - gap, "J"), new Beat(209470 - gap, "K"), new Beat(209870 - gap, "L"),
					new Beat(210260 - gap, "K"), new Beat(211470 - gap, "S"), new Beat(212430 - gap, "D"),
					new Beat(213300 - gap, "F"), new Beat(214260 - gap, "J"), new Beat(215140 - gap, "K"),
					new Beat(216030 - gap, "L"), new Beat(216880 - gap, "Space") };
		} else if (titleName.equals("Universe-PITTA") && difficulty.equals("Easy")) {
			// int startTime = 1000;
			beats = new Beat[] { new Beat(13010 - gap, "Space"), new Beat(15140 - gap, "Space"),
					new Beat(16970 - gap, "Space"), new Beat(18760 - gap, "Space"), new Beat(20500 - gap, "Space"),
					new Beat(22290 - gap, "Space"), new Beat(24050 - gap, "Space"), new Beat(25700 - gap, "Space"),
					new Beat(28690 - gap, "S"), new Beat(29450 - gap, "D"), new Beat(30300 - gap, "F"),
					new Beat(32140 - gap, "Space"), new Beat(33080 - gap, "S"), new Beat(33840 - gap, "F"),
					new Beat(34770 - gap, "J"), new Beat(35660 - gap, "L"), new Beat(36510 - gap, "K"),
					new Beat(37320 - gap, "Space"), new Beat(38220 - gap, "F"), new Beat(39090 - gap, "J"),
					new Beat(40000 - gap, "J"), new Beat(40180 - gap, "L"), new Beat(40850 - gap, "J"),
					new Beat(41730 - gap, "K"), new Beat(42580 - gap, "S"), new Beat(43490 - gap, "F"),
					new Beat(44400 - gap, "Space"), new Beat(45270 - gap, "J"), new Beat(46180 - gap, "L"),
					new Beat(47100 - gap, "S"), new Beat(47980 - gap, "D"), new Beat(48900 - gap, "F"),
					new Beat(49770 - gap, "K"), new Beat(50670 - gap, "S"), new Beat(51510 - gap, "Space"),
					new Beat(52380 - gap, "L"), new Beat(52400 - gap, "S"), new Beat(52400 - gap, "F"),
					new Beat(52600 - gap, "J"), new Beat(53220 - gap, "K"), new Beat(54110 - gap, "Space"),
					new Beat(54910 - gap, "Space"), new Beat(55970 - gap, "D"), new Beat(56890 - gap, "J"),
					new Beat(57720 - gap, "F"), new Beat(58600 - gap, "Space"), new Beat(59470 - gap, "S"),
					new Beat(60300 - gap, "L"), new Beat(61180 - gap, "K"), new Beat(62040 - gap, "F"),
					new Beat(62930 - gap, "J"), new Beat(63800 - gap, "Space"), new Beat(64660 - gap, "L"),
					new Beat(64670 - gap, "J"), new Beat(65560 - gap, "Space"), new Beat(66450 - gap, "D"),
					new Beat(67410 - gap, "Space"), new Beat(68280 - gap, "S"), new Beat(68300 - gap, "F"),
					new Beat(69160 - gap, "Space"), new Beat(69990 - gap, "K"), new Beat(70890 - gap, "L"),
					new Beat(71760 - gap, "J"), new Beat(72660 - gap, "Space"), new Beat(73570 - gap, "S"),
					new Beat(73570 - gap, "F"), new Beat(74400 - gap, "Space"), new Beat(75290 - gap, "K"),
					new Beat(76140 - gap, "Space"), new Beat(77020 - gap, "L"), new Beat(77020 - gap, "J"),
					new Beat(77970 - gap, "D"), new Beat(78820 - gap, "L"), new Beat(79700 - gap, "J"),
					new Beat(80600 - gap, "K"), new Beat(81460 - gap, "F"), new Beat(82400 - gap, "D"),
					new Beat(83210 - gap, "S"), new Beat(84150 - gap, "J"), new Beat(84990 - gap, "D"),
					new Beat(85840 - gap, "L"), new Beat(86810 - gap, "Space"), new Beat(87740 - gap, "S"),
					new Beat(88510 - gap, "D"), new Beat(89410 - gap, "F"), new Beat(90290 - gap, "Space"),
					new Beat(91210 - gap, "L"), new Beat(92090 - gap, "K"), new Beat(92950 - gap, "J"),
					new Beat(93770 - gap, "Space"), new Beat(94720 - gap, "S"), new Beat(95520 - gap, "D"),
					new Beat(96470 - gap, "F"), new Beat(97370 - gap, "J"), new Beat(98180 - gap, "K"),
					new Beat(99100 - gap, "L"), new Beat(99980 - gap, "J"), new Beat(100830 - gap, "Space"),
					new Beat(101770 - gap, "S"), new Beat(102270 - gap, "S"), new Beat(102710 - gap, "D"),
					new Beat(103160 - gap, "F"), new Beat(103590 - gap, "J"), new Beat(103990 - gap, "J"),
					new Beat(104440 - gap, "K"), new Beat(104880 - gap, "L"), new Beat(105430 - gap, "Space"),
					new Beat(106230 - gap, "Space"), new Beat(107060 - gap, "Space"), new Beat(107940 - gap, "Space"),
					new Beat(108840 - gap, "S"), new Beat(109690 - gap, "L"), new Beat(110590 - gap, "K"),
					new Beat(111450 - gap, "Space"), new Beat(112320 - gap, "F"), new Beat(113240 - gap, "K"),
					new Beat(114100 - gap, "D"), new Beat(114970 - gap, "J"), new Beat(115900 - gap, "Space"),
					new Beat(116800 - gap, "Space"), new Beat(117650 - gap, "Space"), new Beat(118560 - gap, "Space"),
					new Beat(119450 - gap, "S"), new Beat(120310 - gap, "K"), new Beat(121210 - gap, "F"),
					new Beat(122110 - gap, "L"), new Beat(123000 - gap, "J"), new Beat(123000 - gap, "L"),
					new Beat(123890 - gap, "F"), new Beat(123890 - gap, "S"), new Beat(124760 - gap, "K"),
					new Beat(125690 - gap, "D"), new Beat(126490 - gap, "Space"), new Beat(127340 - gap, "Space"),
					new Beat(128220 - gap, "J"), new Beat(129150 - gap, "L"), new Beat(129160 - gap, "J"),
					new Beat(130060 - gap, "S"), new Beat(130060 - gap, "F"), new Beat(130070 - gap, "J"),
					new Beat(130080 - gap, "L"), new Beat(130890 - gap, "K"), new Beat(131770 - gap, "D"),
					new Beat(132600 - gap, "J"), new Beat(133600 - gap, "Space"), new Beat(134480 - gap, "Space"),
					new Beat(135360 - gap, "Space"), new Beat(137130 - gap, "S"), new Beat(137980 - gap, "F"),
					new Beat(138860 - gap, "D"), new Beat(139710 - gap, "K"), new Beat(140680 - gap, "L"),
					new Beat(141490 - gap, "J"), new Beat(142320 - gap, "K"), new Beat(143210 - gap, "Space"),
					new Beat(144140 - gap, "J"), new Beat(144160 - gap, "F"), new Beat(145010 - gap, "K"),
					new Beat(145020 - gap, "D"), new Beat(145920 - gap, "S"), new Beat(145940 - gap, "L"),
					new Beat(146800 - gap, "S"), new Beat(146810 - gap, "F"), new Beat(146820 - gap, "J"),
					new Beat(146820 - gap, "L"), new Beat(147670 - gap, "Space"), new Beat(148550 - gap, "K"),
					new Beat(149370 - gap, "J"), new Beat(150320 - gap, "Space"), new Beat(151200 - gap, "S"),
					new Beat(152030 - gap, "S"), new Beat(152060 - gap, "D"), new Beat(152980 - gap, "K"),
					new Beat(153910 - gap, "J"), new Beat(153930 - gap, "L"), new Beat(154730 - gap, "Space"),
					new Beat(155650 - gap, "K"), new Beat(156540 - gap, "D"), new Beat(157380 - gap, "Space"),
					new Beat(158310 - gap, "F"), new Beat(159140 - gap, "J"), new Beat(160030 - gap, "D"),
					new Beat(160910 - gap, "K"), new Beat(161810 - gap, "S"), new Beat(162730 - gap, "L"),
					new Beat(163540 - gap, "J"), new Beat(164420 - gap, "Space"), new Beat(165370 - gap, "K"),
					new Beat(166220 - gap, "L"), new Beat(167070 - gap, "J"), new Beat(168010 - gap, "Space"),
					new Beat(168850 - gap, "F"), new Beat(169730 - gap, "S"), new Beat(170610 - gap, "D"),
					new Beat(171530 - gap, "Space"), new Beat(172350 - gap, "K"), new Beat(173180 - gap, "J"),
					new Beat(174170 - gap, "L"), new Beat(175040 - gap, "J"), new Beat(175930 - gap, "Space"),
					new Beat(176760 - gap, "Space"), new Beat(177630 - gap, "D"), new Beat(178490 - gap, "F"),
					new Beat(179390 - gap, "J"), new Beat(180260 - gap, "L"), new Beat(181170 - gap, "S"),
					new Beat(182090 - gap, "Space"), new Beat(182950 - gap, "D"), new Beat(183820 - gap, "K"),
					new Beat(184690 - gap, "J"), new Beat(185570 - gap, "Space"), new Beat(186450 - gap, "S"),
					new Beat(187330 - gap, "F"), new Beat(188180 - gap, "K"), new Beat(189110 - gap, "J"),
					new Beat(189960 - gap, "L"), new Beat(190850 - gap, "D"), new Beat(191780 - gap, "S"),
					new Beat(192640 - gap, "F"), new Beat(193540 - gap, "K"), new Beat(194410 - gap, "L"),
					new Beat(195240 - gap, "J"), new Beat(196220 - gap, "Space"), new Beat(197120 - gap, "S"),
					new Beat(197960 - gap, "Space"), new Beat(198840 - gap, "D"), new Beat(199710 - gap, "Space"),
					new Beat(200600 - gap, "F"), new Beat(201450 - gap, "Space"), new Beat(202370 - gap, "F"),
					new Beat(203250 - gap, "Space"), new Beat(204180 - gap, "J"), new Beat(205000 - gap, "Space"),
					new Beat(205880 - gap, "K"), new Beat(206780 - gap, "Space"), new Beat(207670 - gap, "J"),
					new Beat(208560 - gap, "Space"), new Beat(209450 - gap, "L"), new Beat(210280 - gap, "Space"),
					new Beat(211160 - gap, "S"), new Beat(212110 - gap, "L"), new Beat(213010 - gap, "S"),
					new Beat(213910 - gap, "L"), new Beat(214720 - gap, "D"), new Beat(215610 - gap, "J"),
					new Beat(216520 - gap, "K"), new Beat(217410 - gap, "F"), new Beat(218320 - gap, "Space"),
					new Beat(219150 - gap, "J"), new Beat(220070 - gap, "K"), new Beat(220900 - gap, "L"),
					new Beat(221780 - gap, "S"), new Beat(222650 - gap, "F"), new Beat(223580 - gap, "K"),
					new Beat(224430 - gap, "Space"), new Beat(225280 - gap, "D"), new Beat(226150 - gap, "J"),
					new Beat(226990 - gap, "K"), new Beat(228100 - gap, "L"), new Beat(228860 - gap, "S"),
					new Beat(229790 - gap, "F"), new Beat(230620 - gap, "D"), new Beat(231490 - gap, "Space"),
					new Beat(232360 - gap, "J"), new Beat(233240 - gap, "L"), new Beat(234160 - gap, "K"),
					new Beat(234970 - gap, "Space"), new Beat(235870 - gap, "S"), new Beat(236770 - gap, "F"),
					new Beat(237620 - gap, "J"), new Beat(238500 - gap, "L"), new Beat(239470 - gap, "K"),
					new Beat(240350 - gap, "D"), new Beat(241180 - gap, "J"), new Beat(241200 - gap, "S"),
					new Beat(241210 - gap, "F"), new Beat(241230 - gap, "L"), new Beat(242100 - gap, "Space"),
					new Beat(243030 - gap, "J"), new Beat(243040 - gap, "L"), new Beat(243850 - gap, "Space"),
					new Beat(244690 - gap, "S"), new Beat(244690 - gap, "F"), new Beat(245630 - gap, "Space"),
					new Beat(246510 - gap, "D"), new Beat(247300 - gap, "K"), new Beat(248190 - gap, "J"),
					new Beat(249110 - gap, "J"), new Beat(249130 - gap, "L"), new Beat(250030 - gap, "Space"),
					new Beat(250890 - gap, "K"), new Beat(251770 - gap, "D"), new Beat(252620 - gap, "S"),
					new Beat(252640 - gap, "L"), new Beat(253620 - gap, "K"), new Beat(253620 - gap, "D"),
					new Beat(254450 - gap, "K"), new Beat(254470 - gap, "D"), new Beat(255310 - gap, "F"),
					new Beat(255330 - gap, "J"), new Beat(256190 - gap, "F"), new Beat(256210 - gap, "J"),
					new Beat(257060 - gap, "L"), new Beat(257060 - gap, "S"), new Beat(257920 - gap, "S"),
					new Beat(257940 - gap, "L"), new Beat(258820 - gap, "K"), new Beat(258820 - gap, "D"),
					new Beat(259710 - gap, "K"), new Beat(259720 - gap, "D"), new Beat(260560 - gap, "Space"),
					new Beat(261450 - gap, "Space"), new Beat(262300 - gap, "J"), new Beat(263260 - gap, "Space"),
					new Beat(264160 - gap, "K"), new Beat(264950 - gap, "K"), new Beat(265900 - gap, "L"),
					new Beat(266780 - gap, "J"), new Beat(267740 - gap, "S"), new Beat(268110 - gap, "D"),
					new Beat(268560 - gap, "F"), new Beat(269440 - gap, "S"), new Beat(269820 - gap, "D"),
					new Beat(270320 - gap, "F"), new Beat(271200 - gap, "Space"), new Beat(272120 - gap, "Space"),
					new Beat(272920 - gap, "J"), new Beat(273820 - gap, "L"), new Beat(274750 - gap, "K"),
					new Beat(275580 - gap, "S"), new Beat(276520 - gap, "F"), new Beat(277390 - gap, "Space"),
					new Beat(278300 - gap, "K"), new Beat(279110 - gap, "K"), new Beat(279990 - gap, "J"),
					new Beat(280930 - gap, "J"), new Beat(281790 - gap, "F"), new Beat(282680 - gap, "F"),
					new Beat(283560 - gap, "D"), new Beat(284410 - gap, "D"), new Beat(285320 - gap, "S"),
					new Beat(286240 - gap, "S"), };
		} else if (titleName.equals("Universe-PITTA") && difficulty.equals("Hard")) {
			// int startTime = 1000;
			beats = new Beat[] { new Beat(5620 - gap, "S"), new Beat(6850 - gap, "D"), new Beat(7930 - gap, "F"),
					new Beat(9040 - gap, "Space"), new Beat(10050 - gap, "J"), new Beat(10980 - gap, "K"),
					new Beat(11910 - gap, "L"), new Beat(12960 - gap, "Space"), new Beat(14880 - gap, "Space"),
					new Beat(16880 - gap, "Space"), new Beat(18760 - gap, "Space"), new Beat(20860 - gap, "Space"),
					new Beat(22820 - gap, "S"), new Beat(23710 - gap, "D"), new Beat(24620 - gap, "F"),
					new Beat(25550 - gap, "J"), new Beat(26430 - gap, "Space"), new Beat(28350 - gap, "Space"),
					new Beat(30250 - gap, "S"), new Beat(31180 - gap, "D"), new Beat(32190 - gap, "F"),
					new Beat(33130 - gap, "J"), new Beat(33980 - gap, "Space"), new Beat(34880 - gap, "K"),
					new Beat(35680 - gap, "L"), new Beat(36580 - gap, "J"), new Beat(37450 - gap, "Space"),
					new Beat(38340 - gap, "F"), new Beat(39200 - gap, "K"), new Beat(40090 - gap, "L"),
					new Beat(40990 - gap, "Space"), new Beat(41930 - gap, "S"), new Beat(41950 - gap, "F"),
					new Beat(42790 - gap, "J"), new Beat(42810 - gap, "L"), new Beat(43680 - gap, "D"),
					new Beat(44520 - gap, "Space"), new Beat(45470 - gap, "K"), new Beat(46260 - gap, "F"),
					new Beat(47180 - gap, "L"), new Beat(48010 - gap, "J"), new Beat(48910 - gap, "K"),
					new Beat(49740 - gap, "S"), new Beat(50690 - gap, "L"), new Beat(51550 - gap, "K"),
					new Beat(51570 - gap, "L"), new Beat(52410 - gap, "J"), new Beat(53330 - gap, "K"),
					new Beat(53350 - gap, "L"), new Beat(54150 - gap, "D"), new Beat(55020 - gap, "S"),
					new Beat(55020 - gap, "F"), new Beat(55970 - gap, "J"), new Beat(56840 - gap, "Space"),
					new Beat(57710 - gap, "S"), new Beat(58160 - gap, "D"), new Beat(58580 - gap, "Space"),
					new Beat(59430 - gap, "F"), new Beat(60350 - gap, "K"), new Beat(61230 - gap, "L"),
					new Beat(62050 - gap, "K"), new Beat(62950 - gap, "J"), new Beat(63820 - gap, "S"),
					new Beat(64760 - gap, "D"), new Beat(65180 - gap, "F"), new Beat(65630 - gap, "K"),
					new Beat(66510 - gap, "L"), new Beat(67400 - gap, "J"), new Beat(68260 - gap, "D"),
					new Beat(69110 - gap, "S"), new Beat(70000 - gap, "L"), new Beat(70950 - gap, "K"),
					new Beat(71790 - gap, "J"), new Beat(72220 - gap, "L"), new Beat(72680 - gap, "S"),
					new Beat(73120 - gap, "D"), new Beat(73600 - gap, "F"), new Beat(74420 - gap, "K"),
					new Beat(75340 - gap, "J"), new Beat(75370 - gap, "L"), new Beat(76210 - gap, "F"),
					new Beat(76210 - gap, "S"), new Beat(77060 - gap, "K"), new Beat(77920 - gap, "D"),
					new Beat(78840 - gap, "L"), new Beat(79270 - gap, "J"), new Beat(79730 - gap, "K"),
					new Beat(80140 - gap, "F"), new Beat(80600 - gap, "S"), new Beat(81120 - gap, "D"),
					new Beat(81370 - gap, "F"), new Beat(81980 - gap, "K"), new Beat(82280 - gap, "L"),
					new Beat(82700 - gap, "J"), new Beat(83280 - gap, "K"), new Beat(83710 - gap, "D"),
					new Beat(84130 - gap, "S"), new Beat(85030 - gap, "Space"), new Beat(85930 - gap, "F"),
					new Beat(86800 - gap, "Space"), new Beat(87700 - gap, "L"), new Beat(88510 - gap, "Space"),
					new Beat(89430 - gap, "J"), new Beat(89430 - gap, "L"), new Beat(90290 - gap, "Space"),
					new Beat(91200 - gap, "D"), new Beat(91650 - gap, "D"), new Beat(92070 - gap, "Space"),
					new Beat(92970 - gap, "F"), new Beat(93370 - gap, "J"), new Beat(93840 - gap, "Space"),
					new Beat(94750 - gap, "L"), new Beat(95450 - gap, "K"), new Beat(96450 - gap, "J"),
					new Beat(97360 - gap, "Space"), new Beat(98220 - gap, "S"), new Beat(99100 - gap, "D"),
					new Beat(99990 - gap, "F"), new Beat(100450 - gap, "D"), new Beat(100930 - gap, "K"),
					new Beat(101880 - gap, "L"), new Beat(102290 - gap, "J"), new Beat(102760 - gap, "K"),
					new Beat(103190 - gap, "L"), new Beat(103630 - gap, "S"), new Beat(104080 - gap, "F"),
					new Beat(104510 - gap, "D"), new Beat(105420 - gap, "K"), new Beat(105850 - gap, "L"),
					new Beat(106260 - gap, "Space"), new Beat(107120 - gap, "F"), new Beat(107570 - gap, "J"),
					new Beat(107990 - gap, "Space"), new Beat(108930 - gap, "S"), new Beat(108930 - gap, "F"),
					new Beat(109720 - gap, "Space"), new Beat(110600 - gap, "K"), new Beat(110620 - gap, "D"),
					new Beat(111440 - gap, "Space"), new Beat(112430 - gap, "J"), new Beat(112430 - gap, "L"),
					new Beat(113290 - gap, "K"), new Beat(113310 - gap, "L"), new Beat(114130 - gap, "J"),
					new Beat(114980 - gap, "Space"), new Beat(115940 - gap, "F"), new Beat(116820 - gap, "S"),
					new Beat(116820 - gap, "F"), new Beat(117650 - gap, "D"), new Beat(118110 - gap, "K"),
					new Beat(118550 - gap, "J"), new Beat(118550 - gap, "L"), new Beat(119430 - gap, "F"),
					new Beat(120300 - gap, "K"), new Beat(121260 - gap, "D"), new Beat(121680 - gap, "D"),
					new Beat(122160 - gap, "L"), new Beat(123030 - gap, "S"), new Beat(123480 - gap, "S"),
					new Beat(123890 - gap, "J"), new Beat(124840 - gap, "L"), new Beat(125220 - gap, "K"),
					new Beat(125670 - gap, "Space"), new Beat(126500 - gap, "F"), new Beat(127350 - gap, "Space"),
					new Beat(128250 - gap, "K"), new Beat(129230 - gap, "Space"), new Beat(130070 - gap, "S"),
					new Beat(130910 - gap, "D"), new Beat(131770 - gap, "F"), new Beat(132560 - gap, "L"),
					new Beat(133120 - gap, "K"), new Beat(133570 - gap, "J"), new Beat(134420 - gap, "S"),
					new Beat(135310 - gap, "F"), new Beat(136120 - gap, "Space"), new Beat(137110 - gap, "D"),
					new Beat(137990 - gap, "K"), new Beat(138860 - gap, "L"), new Beat(139710 - gap, "J"),
					new Beat(140220 - gap, "K"), new Beat(140490 - gap, "L"), new Beat(140950 - gap, "J"),
					new Beat(141540 - gap, "Space"), new Beat(142400 - gap, "F"), new Beat(142420 - gap, "S"),
					new Beat(143280 - gap, "Space"), new Beat(144170 - gap, "D"), new Beat(145050 - gap, "Space"),
					new Beat(145960 - gap, "J"), new Beat(145980 - gap, "L"), new Beat(146840 - gap, "Space"),
					new Beat(147760 - gap, "K"), new Beat(148570 - gap, "Space"), new Beat(149450 - gap, "J"),
					new Beat(149470 - gap, "L"), new Beat(149930 - gap, "S"), new Beat(149960 - gap, "F"),
					new Beat(150390 - gap, "L"), new Beat(150390 - gap, "K"), new Beat(151250 - gap, "J"),
					new Beat(152120 - gap, "Space"), new Beat(153030 - gap, "D"), new Beat(153860 - gap, "Space"),
					new Beat(154710 - gap, "F"), new Beat(155590 - gap, "L"), new Beat(156080 - gap, "J"),
					new Beat(156340 - gap, "K"), new Beat(156580 - gap, "S"), new Beat(157050 - gap, "D"),
					new Beat(157410 - gap, "Space"), new Beat(158320 - gap, "J"), new Beat(158330 - gap, "L"),
					new Beat(159170 - gap, "J"), new Beat(159190 - gap, "L"), new Beat(160060 - gap, "S"),
					new Beat(160060 - gap, "F"), new Beat(160870 - gap, "D"), new Beat(161840 - gap, "K"),
					new Beat(162290 - gap, "K"), new Beat(162740 - gap, "L"), new Beat(163190 - gap, "J"),
					new Beat(163620 - gap, "F"), new Beat(164420 - gap, "Space"), new Beat(165320 - gap, "D"),
					new Beat(166220 - gap, "Space"), new Beat(167120 - gap, "S"), new Beat(167950 - gap, "Space"),
					new Beat(168870 - gap, "J"), new Beat(168870 - gap, "L"), new Beat(169710 - gap, "Space"),
					new Beat(170600 - gap, "S"), new Beat(170610 - gap, "L"), new Beat(171510 - gap, "Space"),
					new Beat(172380 - gap, "K"), new Beat(172400 - gap, "D"), new Beat(173220 - gap, "Space"),
					new Beat(174170 - gap, "J"), new Beat(174190 - gap, "S"), new Beat(174990 - gap, "Space"),
					new Beat(175940 - gap, "L"), new Beat(176350 - gap, "L"), new Beat(176820 - gap, "K"),
					new Beat(177300 - gap, "J"), new Beat(177710 - gap, "F"), new Beat(178160 - gap, "D"),
					new Beat(178610 - gap, "Space"), new Beat(179480 - gap, "S"), new Beat(180360 - gap, "Space"),
					new Beat(181200 - gap, "L"), new Beat(182110 - gap, "Space"), new Beat(182960 - gap, "K"),
					new Beat(183820 - gap, "Space"), new Beat(184780 - gap, "D"), new Beat(185170 - gap, "J"),
					new Beat(185620 - gap, "Space"), new Beat(186500 - gap, "F"), new Beat(187350 - gap, "L"),
					new Beat(188220 - gap, "K"), new Beat(189100 - gap, "S"), new Beat(190030 - gap, "D"),
					new Beat(190880 - gap, "F"), new Beat(191750 - gap, "J"), new Beat(192620 - gap, "Space"),
					new Beat(193610 - gap, "S"), new Beat(194010 - gap, "S"), new Beat(194490 - gap, "D"),
					new Beat(194910 - gap, "D"), new Beat(195350 - gap, "F"), new Beat(195770 - gap, "F"),
					new Beat(196230 - gap, "K"), new Beat(196670 - gap, "L"), new Beat(197130 - gap, "S"),
					new Beat(197940 - gap, "Space"), new Beat(198850 - gap, "K"), new Beat(199780 - gap, "Space"),
					new Beat(200640 - gap, "L"), new Beat(201270 - gap, "J"), new Beat(201870 - gap, "K"),
					new Beat(202380 - gap, "L"), new Beat(202800 - gap, "J"), new Beat(203230 - gap, "Space"),
					new Beat(204150 - gap, "D"), new Beat(205010 - gap, "Space"), new Beat(205850 - gap, "S"),
					new Beat(206700 - gap, "J"), new Beat(207190 - gap, "K"), new Beat(207630 - gap, "L"),
					new Beat(208070 - gap, "D"), new Beat(208340 - gap, "S"), new Beat(209470 - gap, "Space"),
					new Beat(210320 - gap, "K"), new Beat(211130 - gap, "S"), new Beat(212030 - gap, "Space"),
					new Beat(213030 - gap, "F"), new Beat(213450 - gap, "J"), new Beat(213890 - gap, "Space"),
					new Beat(214740 - gap, "L"), new Beat(215170 - gap, "J"), new Beat(215610 - gap, "Space"),
					new Beat(216640 - gap, "D"), new Beat(216640 - gap, "S"), new Beat(217390 - gap, "Space"),
					new Beat(218250 - gap, "K"), new Beat(219150 - gap, "L"), new Beat(220050 - gap, "J"),
					new Beat(220890 - gap, "D"), new Beat(221780 - gap, "S"), new Beat(222730 - gap, "Space"),
					new Beat(223580 - gap, "K"), new Beat(224470 - gap, "Space"), new Beat(225410 - gap, "L"),
					new Beat(226180 - gap, "Space"), new Beat(226980 - gap, "F"), new Beat(227900 - gap, "Space"),
					new Beat(228830 - gap, "K"), new Beat(229740 - gap, "J"), new Beat(230560 - gap, "F"),
					new Beat(231470 - gap, "Space"), new Beat(232400 - gap, "L"), new Beat(233250 - gap, "K"),
					new Beat(234170 - gap, "J"), new Beat(235010 - gap, "S"), new Beat(235920 - gap, "D"),
					new Beat(236810 - gap, "Space"), new Beat(237670 - gap, "L"), new Beat(238100 - gap, "J"),
					new Beat(238560 - gap, "Space"), new Beat(239470 - gap, "K"), new Beat(239880 - gap, "J"),
					new Beat(240370 - gap, "Space"), new Beat(241180 - gap, "S"), new Beat(241650 - gap, "F"),
					new Beat(242140 - gap, "Space"), new Beat(243070 - gap, "D"), new Beat(243460 - gap, "D"),
					new Beat(243930 - gap, "Space"), new Beat(244760 - gap, "F"), new Beat(245160 - gap, "L"),
					new Beat(245600 - gap, "Space"), new Beat(246480 - gap, "J"), new Beat(247330 - gap, "Space"),
					new Beat(248200 - gap, "S"), new Beat(248690 - gap, "D"), new Beat(249170 - gap, "Space"),
					new Beat(250040 - gap, "K"), new Beat(250510 - gap, "L"), new Beat(250970 - gap, "K"),
					new Beat(251420 - gap, "J"), new Beat(251870 - gap, "L"), new Beat(252250 - gap, "S"),
					new Beat(252750 - gap, "D"), new Beat(253340 - gap, "F"), new Beat(253590 - gap, "D"),
					new Beat(254440 - gap, "Space"), new Beat(255290 - gap, "J"), new Beat(256150 - gap, "Space"),
					new Beat(257050 - gap, "L"), new Beat(257050 - gap, "J"), new Beat(257900 - gap, "Space"),
					new Beat(258820 - gap, "S"), new Beat(258850 - gap, "F"), new Beat(259790 - gap, "Space"),
					new Beat(260670 - gap, "D"), new Beat(261480 - gap, "Space"), new Beat(262340 - gap, "K"),
					new Beat(262360 - gap, "D"), new Beat(263260 - gap, "Space"), new Beat(264110 - gap, "L"),
					new Beat(264130 - gap, "S"), new Beat(265000 - gap, "L"), new Beat(265000 - gap, "S"),
					new Beat(265890 - gap, "K"), new Beat(265890 - gap, "D"), new Beat(266710 - gap, "D"),
					new Beat(266760 - gap, "K"), new Beat(267640 - gap, "J"), new Beat(267670 - gap, "F"),
					new Beat(268530 - gap, "J"), new Beat(268550 - gap, "L"), new Beat(269420 - gap, "S"),
					new Beat(269430 - gap, "F"), new Beat(270310 - gap, "D"), new Beat(271310 - gap, "Space"),
					new Beat(272090 - gap, "K"), new Beat(272970 - gap, "L"), new Beat(273840 - gap, "K"),
					new Beat(274670 - gap, "J"), new Beat(275620 - gap, "Space"), new Beat(276550 - gap, "F"),
					new Beat(276980 - gap, "D"), new Beat(277450 - gap, "Space"), new Beat(278340 - gap, "S"),
					new Beat(279150 - gap, "S"), new Beat(280010 - gap, "D"), new Beat(280940 - gap, "D"),
					new Beat(281830 - gap, "S"), new Beat(282240 - gap, "D"), new Beat(282710 - gap, "F"),
					new Beat(283160 - gap, "J"), new Beat(283610 - gap, "K"), new Beat(284070 - gap, "L"),
					new Beat(284560 - gap, "J"), new Beat(284970 - gap, "K"), new Beat(285410 - gap, "S"),
					new Beat(285810 - gap, "F"), new Beat(286210 - gap, "D"), new Beat(286680 - gap, "Space"),
					new Beat(287150 - gap, "K"), new Beat(287990 - gap, "L"), new Beat(288850 - gap, "J"),
					new Beat(291590 - gap, "Space") };
		} else if (titleName.equals("Ties-Forestella") && difficulty.equals("Easy")) {
			//int startTime = 1000;
			beats = new Beat[] { new Beat(5790 - gap, "J"), new Beat(7800 - gap, "K"), new Beat(9650 - gap, "L"),
					new Beat(5150 - gap, "K"), new Beat(5980 - gap, "L"), new Beat(6910 - gap, "J"),
					new Beat(7820 - gap, "F"), new Beat(8680 - gap, "S"), new Beat(9700 - gap, "D"),
					new Beat(10490 - gap, "K"), new Beat(11430 - gap, "L"), new Beat(12340 - gap, "J"),
					new Beat(13200 - gap, "F"), new Beat(14160 - gap, "D"), new Beat(15070 - gap, "S"),
					new Beat(15080 - gap, "F"), new Beat(15990 - gap, "D"), new Beat(16920 - gap, "J"),
					new Beat(16940 - gap, "L"), new Beat(17760 - gap, "K"), new Beat(18690 - gap, "Space"),
					new Beat(19570 - gap, "S"), new Beat(20520 - gap, "F"), new Beat(21450 - gap, "D"),
					new Beat(22400 - gap, "J"), new Beat(23400 - gap, "L"), new Beat(24180 - gap, "Space"),
					new Beat(25370 - gap, "K"), new Beat(26070 - gap, "K"), new Beat(26900 - gap, "J"),
					new Beat(27800 - gap, "Space"), new Beat(28710 - gap, "S"), new Beat(29630 - gap, "F"),
					new Beat(30610 - gap, "D"), new Beat(31430 - gap, "Space"), new Beat(32330 - gap, "L"),
					new Beat(33260 - gap, "Space"), new Beat(34170 - gap, "K"), new Beat(35090 - gap, "J"),
					new Beat(36020 - gap, "F"), new Beat(36900 - gap, "Space"), new Beat(37820 - gap, "S"),
					new Beat(38760 - gap, "D"), new Beat(39580 - gap, "F"), new Beat(40500 - gap, "Space"),
					new Beat(41370 - gap, "J"), new Beat(41400 - gap, "L"), new Beat(42280 - gap, "S"),
					new Beat(42280 - gap, "F"), new Beat(43110 - gap, "K"), new Beat(44150 - gap, "Space"),
					new Beat(45130 - gap, "F"), new Beat(46050 - gap, "F"), new Beat(46900 - gap, "D"),
					new Beat(47810 - gap, "Space"), new Beat(48630 - gap, "J"), new Beat(49560 - gap, "L"),
					new Beat(50520 - gap, "K"), new Beat(51410 - gap, "Space"), new Beat(52350 - gap, "F"),
					new Beat(53210 - gap, "S"), new Beat(54180 - gap, "D"), new Beat(55030 - gap, "Space"),
					new Beat(55900 - gap, "L"), new Beat(56900 - gap, "K"), new Beat(57840 - gap, "J"),
					new Beat(58730 - gap, "Space"), new Beat(59690 - gap, "F"), new Beat(60500 - gap, "S"),
					new Beat(61360 - gap, "D"), new Beat(62290 - gap, "Space"), new Beat(63230 - gap, "K"),
					new Beat(64190 - gap, "L"), new Beat(65060 - gap, "J"), new Beat(65990 - gap, "Space"),
					new Beat(66830 - gap, "F"), new Beat(67690 - gap, "D"), new Beat(68570 - gap, "S"),
					new Beat(69660 - gap, "K"), new Beat(70550 - gap, "L"), new Beat(71460 - gap, "J"),
					new Beat(72320 - gap, "K"), new Beat(73290 - gap, "D"), new Beat(74190 - gap, "F"),
					new Beat(74980 - gap, "J"), new Beat(75950 - gap, "S"), new Beat(76870 - gap, "F"),
					new Beat(76880 - gap, "S"), new Beat(77900 - gap, "D"), new Beat(78770 - gap, "D"),
					new Beat(79630 - gap, "D"), new Beat(80510 - gap, "Space"), new Beat(81400 - gap, "K"),
					new Beat(82260 - gap, "D"), new Beat(83090 - gap, "J"), new Beat(84110 - gap, "L"),
					new Beat(85030 - gap, "F"), new Beat(86010 - gap, "S"), new Beat(86910 - gap, "D"),
					new Beat(87810 - gap, "Space"), new Beat(88690 - gap, "L"), new Beat(89600 - gap, "J"),
					new Beat(90490 - gap, "K"), new Beat(91420 - gap, "F"), new Beat(92300 - gap, "D"),
					new Beat(93250 - gap, "S"), new Beat(94150 - gap, "F"), new Beat(95050 - gap, "Space"),
					new Beat(95970 - gap, "J"), new Beat(96810 - gap, "L"), new Beat(97810 - gap, "K"),
					new Beat(98760 - gap, "Space"), new Beat(99610 - gap, "F"), new Beat(100480 - gap, "D"),
					new Beat(101430 - gap, "S"), new Beat(102310 - gap, "Space"), new Beat(103190 - gap, "J"),
					new Beat(104110 - gap, "L"), new Beat(105020 - gap, "K"), new Beat(105890 - gap, "F"),
					new Beat(106900 - gap, "D"), new Beat(107800 - gap, "S"), new Beat(108750 - gap, "F"),
					new Beat(109640 - gap, "Space"), new Beat(110500 - gap, "J"), new Beat(111370 - gap, "J"),
					new Beat(112340 - gap, "K"), new Beat(113270 - gap, "J"), new Beat(113270 - gap, "L"),
					new Beat(114110 - gap, "F"), new Beat(114130 - gap, "S"), new Beat(115030 - gap, "D"),
					new Beat(115940 - gap, "K"), new Beat(116930 - gap, "S"), new Beat(117860 - gap, "D"),
					new Beat(118760 - gap, "F"), new Beat(119180 - gap, "J"), new Beat(119630 - gap, "L"),
					new Beat(120480 - gap, "Space"), new Beat(121390 - gap, "D"), new Beat(122310 - gap, "L"),
					new Beat(123210 - gap, "K"), new Beat(124150 - gap, "S"), new Beat(124590 - gap, "F"),
					new Beat(125520 - gap, "K"), new Beat(125970 - gap, "J"), new Beat(126370 - gap, "L"),
					new Beat(126890 - gap, "S"), new Beat(127790 - gap, "Space"), new Beat(128750 - gap, "S"),
					new Beat(128750 - gap, "F"), new Beat(129700 - gap, "K"), new Beat(129700 - gap, "D"),
					new Beat(130520 - gap, "J"), new Beat(130570 - gap, "F"), new Beat(131430 - gap, "L"),
					new Beat(132310 - gap, "L"), new Beat(132330 - gap, "F"), new Beat(133180 - gap, "J"),
					new Beat(133200 - gap, "S"), new Beat(134130 - gap, "K"), new Beat(134130 - gap, "S"),
					new Beat(135010 - gap, "D"), new Beat(135980 - gap, "L"), new Beat(136880 - gap, "K"),
					new Beat(137800 - gap, "J"), new Beat(138690 - gap, "Space"), new Beat(139630 - gap, "F"),
					new Beat(140480 - gap, "D"), new Beat(141440 - gap, "S"), new Beat(142410 - gap, "F"),
					new Beat(143300 - gap, "D"), new Beat(144150 - gap, "K"), new Beat(145020 - gap, "J"),
					new Beat(145950 - gap, "Space"), new Beat(146950 - gap, "F"), new Beat(147820 - gap, "F"),
					new Beat(148730 - gap, "J"), new Beat(149640 - gap, "J"), new Beat(150590 - gap, "L"),
					new Beat(151510 - gap, "S"), new Beat(152360 - gap, "K"), new Beat(153260 - gap, "Space"),
					new Beat(154180 - gap, "D"), new Beat(155060 - gap, "F"), new Beat(155930 - gap, "S"),
					new Beat(156840 - gap, "K"), new Beat(157760 - gap, "J"), new Beat(158810 - gap, "L"),
					new Beat(159620 - gap, "F"), new Beat(160560 - gap, "Space"), new Beat(161420 - gap, "K"),
					new Beat(162320 - gap, "L"), new Beat(163270 - gap, "J"), new Beat(164130 - gap, "K"),
					new Beat(165030 - gap, "F"), new Beat(165920 - gap, "D"), new Beat(166870 - gap, "S"),
					new Beat(167770 - gap, "Space"), new Beat(168710 - gap, "F"), new Beat(169590 - gap, "J"),
					new Beat(170480 - gap, "L"), new Beat(171390 - gap, "K"), new Beat(172360 - gap, "S"),
					new Beat(173260 - gap, "S"), new Beat(174160 - gap, "D"), new Beat(175020 - gap, "D"),
					new Beat(175970 - gap, "F"), new Beat(176890 - gap, "J"), new Beat(177790 - gap, "K"),
					new Beat(178770 - gap, "Space"), new Beat(179660 - gap, "L"), new Beat(180520 - gap, "F"),
					new Beat(181340 - gap, "D"), new Beat(182280 - gap, "K"), new Beat(183220 - gap, "S"),
					new Beat(184100 - gap, "D"), new Beat(185030 - gap, "F"), new Beat(185960 - gap, "Space"),
					new Beat(186860 - gap, "J"), new Beat(187750 - gap, "J"), new Beat(188630 - gap, "K"),
					new Beat(189550 - gap, "K"), new Beat(190460 - gap, "L"), new Beat(191410 - gap, "L"),
					new Beat(192310 - gap, "S"), new Beat(193230 - gap, "F"), new Beat(194090 - gap, "K"),
					new Beat(195040 - gap, "L"), new Beat(195940 - gap, "J"), new Beat(196890 - gap, "K"),
					new Beat(197790 - gap, "F"), new Beat(198700 - gap, "D"), new Beat(199570 - gap, "S"),
					new Beat(200500 - gap, "Space"), new Beat(201450 - gap, "L"), new Beat(202300 - gap, "Space"),
					new Beat(203150 - gap, "K"), new Beat(204110 - gap, "Space"), new Beat(205080 - gap, "D"),
					new Beat(206010 - gap, "Space"), new Beat(206860 - gap, "S"), new Beat(207760 - gap, "Space"),
					new Beat(208680 - gap, "F"), new Beat(209770 - gap, "Space"), new Beat(210610 - gap, "J"),
					new Beat(211480 - gap, "Space"), new Beat(212410 - gap, "K"), new Beat(213290 - gap, "L"),
					new Beat(214170 - gap, "J"), new Beat(215070 - gap, "Space"), new Beat(216020 - gap, "F"),
					new Beat(216890 - gap, "K"), new Beat(216890 - gap, "D"), new Beat(217730 - gap, "S"),
					new Beat(217740 - gap, "L"), new Beat(218650 - gap, "F"), new Beat(219620 - gap, "L"),
					new Beat(219620 - gap, "D"), new Beat(220520 - gap, "S"), new Beat(220520 - gap, "K"),
					new Beat(221450 - gap, "J"), new Beat(222300 - gap, "Space"), new Beat(223200 - gap, "F"),
					new Beat(224050 - gap, "D"), new Beat(225010 - gap, "S"), new Beat(225880 - gap, "K"),
					new Beat(226860 - gap, "J"), new Beat(227780 - gap, "L"), new Beat(228710 - gap, "K"),
					new Beat(229590 - gap, "F"), new Beat(230490 - gap, "S"), new Beat(231410 - gap, "D"),
					new Beat(231860 - gap, "F"), new Beat(232320 - gap, "J"), new Beat(233140 - gap, "Space"),
					new Beat(234100 - gap, "K"), new Beat(235070 - gap, "L"), new Beat(235990 - gap, "K"),
					new Beat(236870 - gap, "J"), new Beat(237750 - gap, "F"), new Beat(238700 - gap, "D"),
					new Beat(239150 - gap, "S"), new Beat(239610 - gap, "D"), new Beat(240520 - gap, "Space"),
					new Beat(241430 - gap, "F"), new Beat(242390 - gap, "K"), new Beat(242870 - gap, "L"),
					new Beat(243360 - gap, "J"), new Beat(244440 - gap, "D"), new Beat(245840 - gap, "S"),
					new Beat(247160 - gap, "D"), new Beat(247680 - gap, "F"), new Beat(248020 - gap, "J"),
					new Beat(248340 - gap, "K"), new Beat(248840 - gap, "L"), new Beat(249840 - gap, "Space") };
		} else if (titleName.equals("Ties-Forestella") && difficulty.equals("Hard")) {
			int startTime = 1000;
			beats = new Beat[] { new Beat(4140 - gap, "Space"), new Beat(5080 - gap, "S"), new Beat(5880 - gap, "D"),
					new Beat(6340 - gap, "F"), new Beat(6830 - gap, "J"), new Beat(7740 - gap, "L"),
					new Beat(8180 - gap, "K"), new Beat(8630 - gap, "J"), new Beat(9590 - gap, "S"),
					new Beat(10460 - gap, "D"), new Beat(11420 - gap, "L"), new Beat(11430 - gap, "J"),
					new Beat(12290 - gap, "F"), new Beat(12310 - gap, "S"), new Beat(13200 - gap, "K"),
					new Beat(13220 - gap, "D"), new Beat(13670 - gap, "L"), new Beat(14100 - gap, "J"),
					new Beat(15060 - gap, "F"), new Beat(15830 - gap, "K"), new Beat(16320 - gap, "Space"),
					new Beat(16750 - gap, "J"), new Beat(17200 - gap, "L"), new Beat(17830 - gap, "K"),
					new Beat(18620 - gap, "Space"), new Beat(19480 - gap, "S"), new Beat(20510 - gap, "F"),
					new Beat(21460 - gap, "D"), new Beat(22330 - gap, "J"), new Beat(23270 - gap, "L"),
					new Beat(24160 - gap, "Space"), new Beat(25060 - gap, "D"), new Beat(26000 - gap, "Space"),
					new Beat(26890 - gap, "S"), new Beat(27770 - gap, "F"), new Beat(28760 - gap, "D"),
					new Beat(29640 - gap, "K"), new Beat(30500 - gap, "J"), new Beat(31420 - gap, "L"),
					new Beat(32300 - gap, "K"), new Beat(33190 - gap, "Space"), new Beat(34130 - gap, "S"),
					new Beat(35100 - gap, "D"), new Beat(35580 - gap, "F"), new Beat(35990 - gap, "J"),
					new Beat(36830 - gap, "L"), new Beat(37820 - gap, "K"), new Beat(38710 - gap, "J"),
					new Beat(39130 - gap, "K"), new Beat(39630 - gap, "L"), new Beat(40540 - gap, "Space"),
					new Beat(41390 - gap, "S"), new Beat(42310 - gap, "F"), new Beat(43180 - gap, "D"),
					new Beat(44130 - gap, "K"), new Beat(45090 - gap, "L"), new Beat(46090 - gap, "J"),
					new Beat(46490 - gap, "K"), new Beat(46890 - gap, "F"), new Beat(47810 - gap, "Space"),
					new Beat(48690 - gap, "D"), new Beat(49540 - gap, "L"), new Beat(50520 - gap, "K"),
					new Beat(51450 - gap, "J"), new Beat(52380 - gap, "S"), new Beat(53390 - gap, "F"),
					new Beat(53740 - gap, "D"), new Beat(54100 - gap, "J"), new Beat(54970 - gap, "Space"),
					new Beat(55830 - gap, "D"), new Beat(56830 - gap, "K"), new Beat(57800 - gap, "L"),
					new Beat(58710 - gap, "J"), new Beat(59210 - gap, "K"), new Beat(60040 - gap, "L"),
					new Beat(60490 - gap, "S"), new Beat(60960 - gap, "D"), new Beat(61440 - gap, "Space"),
					new Beat(62360 - gap, "K"), new Beat(63210 - gap, "J"), new Beat(64160 - gap, "L"),
					new Beat(64590 - gap, "K"), new Beat(65010 - gap, "J"), new Beat(65920 - gap, "S"),
					new Beat(66870 - gap, "D"), new Beat(67720 - gap, "F"), new Beat(68180 - gap, "J"),
					new Beat(68690 - gap, "L"), new Beat(69570 - gap, "Space"), new Beat(70480 - gap, "K"),
					new Beat(71400 - gap, "J"), new Beat(72250 - gap, "S"), new Beat(73210 - gap, "D"),
					new Beat(74160 - gap, "F"), new Beat(75030 - gap, "F"), new Beat(75960 - gap, "D"),
					new Beat(76780 - gap, "D"), new Beat(77730 - gap, "S"), new Beat(78700 - gap, "S"),
					new Beat(79540 - gap, "S"), new Beat(80410 - gap, "Space"), new Beat(81390 - gap, "L"),
					new Beat(82320 - gap, "K"), new Beat(83170 - gap, "J"), new Beat(84120 - gap, "Space"),
					new Beat(85090 - gap, "J"), new Beat(86000 - gap, "L"), new Beat(86930 - gap, "K"),
					new Beat(87390 - gap, "D"), new Beat(87890 - gap, "S"), new Beat(88680 - gap, "F"),
					new Beat(89630 - gap, "D"), new Beat(90520 - gap, "J"), new Beat(91450 - gap, "L"),
					new Beat(92410 - gap, "K"), new Beat(92880 - gap, "J"), new Beat(93300 - gap, "L"),
					new Beat(93730 - gap, "K"), new Beat(94140 - gap, "J"), new Beat(94610 - gap, "F"),
					new Beat(95060 - gap, "D"), new Beat(95500 - gap, "S"), new Beat(95980 - gap, "J"),
					new Beat(96870 - gap, "L"), new Beat(97860 - gap, "K"), new Beat(98690 - gap, "Space"),
					new Beat(99570 - gap, "D"), new Beat(100510 - gap, "S"), new Beat(100940 - gap, "D"),
					new Beat(101400 - gap, "F"), new Beat(102290 - gap, "K"), new Beat(103240 - gap, "J"),
					new Beat(104140 - gap, "J"), new Beat(105080 - gap, "L"), new Beat(105930 - gap, "K"),
					new Beat(106940 - gap, "S"), new Beat(107800 - gap, "D"), new Beat(108270 - gap, "F"),
					new Beat(108700 - gap, "J"), new Beat(109580 - gap, "Space"), new Beat(110500 - gap, "K"),
					new Beat(111380 - gap, "L"), new Beat(112230 - gap, "J"), new Beat(113230 - gap, "F"),
					new Beat(114090 - gap, "D"), new Beat(115080 - gap, "S"), new Beat(115940 - gap, "D"),
					new Beat(116850 - gap, "F"), new Beat(117790 - gap, "J"), new Beat(118670 - gap, "K"),
					new Beat(119110 - gap, "L"), new Beat(119520 - gap, "J"), new Beat(120490 - gap, "S"),
					new Beat(121440 - gap, "F"), new Beat(121440 - gap, "S"), new Beat(122290 - gap, "K"),
					new Beat(122290 - gap, "D"), new Beat(123200 - gap, "F"), new Beat(123220 - gap, "L"),
					new Beat(124120 - gap, "J"), new Beat(124580 - gap, "L"), new Beat(124590 - gap, "J"),
					new Beat(125070 - gap, "K"), new Beat(125480 - gap, "D"), new Beat(125880 - gap, "S"),
					new Beat(126300 - gap, "F"), new Beat(126810 - gap, "K"), new Beat(127750 - gap, "F"),
					new Beat(127750 - gap, "Space"), new Beat(128660 - gap, "S"), new Beat(129630 - gap, "Space"),
					new Beat(129650 - gap, "D"), new Beat(130540 - gap, "K"), new Beat(131460 - gap, "K"),
					new Beat(131480 - gap, "Space"), new Beat(132310 - gap, "J"), new Beat(133210 - gap, "Space"),
					new Beat(133210 - gap, "F"), new Beat(134060 - gap, "S"), new Beat(135030 - gap, "Space"),
					new Beat(135980 - gap, "J"), new Beat(136440 - gap, "K"), new Beat(136720 - gap, "L"),
					new Beat(137420 - gap, "F"), new Beat(137810 - gap, "D"), new Beat(138740 - gap, "K"),
					new Beat(139640 - gap, "J"), new Beat(140520 - gap, "J"), new Beat(141470 - gap, "K"),
					new Beat(141470 - gap, "D"), new Beat(142370 - gap, "K"), new Beat(142370 - gap, "D"),
					new Beat(143250 - gap, "S"), new Beat(144100 - gap, "S"), new Beat(144120 - gap, "J"),
					new Beat(144980 - gap, "L"), new Beat(145920 - gap, "Space"), new Beat(146910 - gap, "K"),
					new Beat(147780 - gap, "L"), new Beat(148680 - gap, "J"), new Beat(149640 - gap, "K"),
					new Beat(149660 - gap, "L"), new Beat(150600 - gap, "S"), new Beat(150600 - gap, "D"),
					new Beat(151510 - gap, "Space"), new Beat(152380 - gap, "F"), new Beat(152390 - gap, "J"),
					new Beat(153290 - gap, "Space"), new Beat(154170 - gap, "K"), new Beat(154170 - gap, "D"),
					new Beat(155040 - gap, "Space"), new Beat(155900 - gap, "S"), new Beat(155910 - gap, "L"),
					new Beat(156890 - gap, "K"), new Beat(156900 - gap, "D"), new Beat(157850 - gap, "J"),
					new Beat(158720 - gap, "K"), new Beat(159170 - gap, "L"), new Beat(159600 - gap, "J"),
					new Beat(160030 - gap, "F"), new Beat(160500 - gap, "D"), new Beat(160970 - gap, "S"),
					new Beat(161430 - gap, "J"), new Beat(162300 - gap, "Space"), new Beat(163230 - gap, "L"),
					new Beat(164150 - gap, "L"), new Beat(164610 - gap, "K"), new Beat(165080 - gap, "L"),
					new Beat(165510 - gap, "J"), new Beat(165930 - gap, "D"), new Beat(166410 - gap, "S"),
					new Beat(166830 - gap, "F"), new Beat(167240 - gap, "D"), new Beat(167710 - gap, "Space"),
					new Beat(168710 - gap, "J"), new Beat(169620 - gap, "K"), new Beat(170510 - gap, "L"),
					new Beat(170510 - gap, "S"), new Beat(171390 - gap, "L"), new Beat(171410 - gap, "D"),
					new Beat(172340 - gap, "J"), new Beat(172340 - gap, "F"), new Beat(173160 - gap, "K"),
					new Beat(173170 - gap, "D"), new Beat(174100 - gap, "S"), new Beat(174120 - gap, "K"),
					new Beat(175040 - gap, "F"), new Beat(175060 - gap, "J"), new Beat(175950 - gap, "L"),
					new Beat(175970 - gap, "F"), new Beat(176840 - gap, "D"), new Beat(176870 - gap, "L"),
					new Beat(177780 - gap, "J"), new Beat(178670 - gap, "L"), new Beat(178670 - gap, "J"),
					new Beat(179650 - gap, "F"), new Beat(179680 - gap, "S"), new Beat(180530 - gap, "Space"),
					new Beat(181400 - gap, "D"), new Beat(182330 - gap, "Space"), new Beat(183260 - gap, "J"),
					new Beat(184080 - gap, "K"), new Beat(184560 - gap, "L"), new Beat(184990 - gap, "F"),
					new Beat(185460 - gap, "L"), new Beat(185910 - gap, "S"), new Beat(186150 - gap, "J"),
					new Beat(186810 - gap, "D"), new Beat(187760 - gap, "Space"), new Beat(188660 - gap, "J"),
					new Beat(189570 - gap, "Space"), new Beat(190600 - gap, "J"), new Beat(191470 - gap, "J"),
					new Beat(192300 - gap, "L"), new Beat(192800 - gap, "K"), new Beat(193290 - gap, "J"),
					new Beat(193720 - gap, "S"), new Beat(194200 - gap, "D"), new Beat(195090 - gap, "Space"),
					new Beat(195930 - gap, "F"), new Beat(196830 - gap, "Space"), new Beat(197830 - gap, "D"),
					new Beat(198320 - gap, "S"), new Beat(198730 - gap, "J"), new Beat(199180 - gap, "K"),
					new Beat(199660 - gap, "L"), new Beat(200550 - gap, "Space"), new Beat(201430 - gap, "F"),
					new Beat(202330 - gap, "Space"), new Beat(203250 - gap, "D"), new Beat(204140 - gap, "S"),
					new Beat(204580 - gap, "J"), new Beat(205040 - gap, "K"), new Beat(205490 - gap, "L"),
					new Beat(205960 - gap, "F"), new Beat(206420 - gap, "K"), new Beat(206890 - gap, "D"),
					new Beat(207820 - gap, "Space"), new Beat(208790 - gap, "S"), new Beat(208810 - gap, "J"),
					new Beat(209570 - gap, "J"), new Beat(210570 - gap, "K"), new Beat(210970 - gap, "L"),
					new Beat(211420 - gap, "J"), new Beat(211900 - gap, "K"), new Beat(212340 - gap, "S"),
					new Beat(212780 - gap, "D"), new Beat(213300 - gap, "F"), new Beat(213750 - gap, "Space"),
					new Beat(214170 - gap, "J"), new Beat(214620 - gap, "Space"), new Beat(215060 - gap, "D"),
					new Beat(215520 - gap, "S"), new Beat(216000 - gap, "F"), new Beat(216900 - gap, "L"),
					new Beat(217580 - gap, "K"), new Beat(217860 - gap, "K"), new Beat(218700 - gap, "J"),
					new Beat(219640 - gap, "S"), new Beat(220130 - gap, "D"), new Beat(220560 - gap, "F"),
					new Beat(221530 - gap, "J"), new Beat(222380 - gap, "Space"), new Beat(223260 - gap, "S"),
					new Beat(224140 - gap, "L"), new Beat(224620 - gap, "K"), new Beat(225060 - gap, "J"),
					new Beat(225940 - gap, "F"), new Beat(226490 - gap, "S"), new Beat(226770 - gap, "D"),
					new Beat(227260 - gap, "D"), new Beat(227880 - gap, "K"), new Beat(228320 - gap, "J"),
					new Beat(228750 - gap, "L"), new Beat(229650 - gap, "Space"), new Beat(230510 - gap, "S"),
					new Beat(230970 - gap, "D"), new Beat(231440 - gap, "F"), new Beat(231870 - gap, "J"),
					new Beat(232350 - gap, "K"), new Beat(233250 - gap, "Space"), new Beat(234170 - gap, "L"),
					new Beat(235080 - gap, "K"), new Beat(235960 - gap, "J"), new Beat(236910 - gap, "L"),
					new Beat(237880 - gap, "S"), new Beat(238190 - gap, "K"), new Beat(238660 - gap, "D"),
					new Beat(239110 - gap, "L"), new Beat(239610 - gap, "J"), new Beat(239610 - gap, "L"),
					new Beat(240550 - gap, "K"), new Beat(241390 - gap, "S"), new Beat(241910 - gap, "D"),
					new Beat(242410 - gap, "F"), new Beat(242910 - gap, "J"), new Beat(243420 - gap, "L"),
					new Beat(244510 - gap, "K"), new Beat(246600 - gap, "J"), new Beat(246940 - gap, "F"),
					new Beat(247350 - gap, "D"), new Beat(247690 - gap, "S"), new Beat(248040 - gap, "D"),
					new Beat(248290 - gap, "F"), new Beat(248550 - gap, "J"), new Beat(248800 - gap, "K"),
					new Beat(249140 - gap, "L"), new Beat(250170 - gap, "J") };
		}
		int i = 0;
		gameMusic.start();
		while (i < beats.length && !isInterrupted()) {
			boolean dropped = false;
			if (beats[i].getTime() <= gameMusic.getTime()) {
				Note note = new Note(beats[i].getNoteName());
				note.start();
				noteList.add(note);
				i++;
			}
			if (!dropped) {
				try {
					Thread.sleep(5);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}

	public void judge(String input) {
		for (int i = 0; i < noteList.size(); i++) {
			Note note = noteList.get(i);
			if (input.equals(note.getNoteType())) {
				judgeEvent(note.judge());
				break;
			}
		}
	}

	public void judgeEvent(String judge) {
		if (!judge.equals("None")) {
			blueFlareImage = new ImageIcon(Main.class.getResource("../images/flareImage.png")).getImage();
		}
		if (judge.equals("Miss")) {
			judgeImage = new ImageIcon(Main.class.getResource("../images/judgeMiss.png")).getImage();
		} else if (judge.equals("Late")) {
			judgeImage = new ImageIcon(Main.class.getResource("../images/judgeLate.png")).getImage();
			score += 100;
		} else if (judge.equals("Good")) {
			judgeImage = new ImageIcon(Main.class.getResource("../images/judgeGood.png")).getImage();
			score += 300;
		} else if (judge.equals("Great")) {
			judgeImage = new ImageIcon(Main.class.getResource("../images/judgeGreat.png")).getImage();
			score += 500;
		} else if (judge.equals("Perfect")) {
			judgeImage = new ImageIcon(Main.class.getResource("../images/judgePerfect.png")).getImage();
			score += 1000;
		} else if (judge.equals("Early")) {
			judgeImage = new ImageIcon(Main.class.getResource("../images/judgeEarly.png")).getImage();
			score += 100;
		}

	}

	@Override
	public void run() {// Thread떄문에 run메소드를 실행
		dropNotes();
	}

}
