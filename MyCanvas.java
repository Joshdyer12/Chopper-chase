package GamePackage;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.LinkedList;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

import sun.audio.*;

public class MyCanvas extends Canvas implements KeyListener{
	
	Goodguy mega = new Goodguy(150,310,75,75,"Files/Wake6.png");
	//Badguy bottom = new Badguy (-100,650,1700,50, "Files/blackRect.png");
	Background back = new Background (0,0,1400,805, "Files/forest.png");
	Background startscreen = new Background (0,0,1400,805,"Files/Homescreen.png");
	Background optionscreen = new Background (0,0,1400,805,"Files/options.png");
	Background lossscreen = new Background (0,0,1400,805,"Files/lossscreen.png");
	Background winscreen = new Background (0,0,805,1400,"Files/winscreen.png");
	LinkedList badguys = new LinkedList();
	LinkedList fireballs = new LinkedList();
	LinkedList blocks = new LinkedList();
	
	int time;
	int score;
	int level;
	int scorelimit;
	
	boolean megaMoved = false;
	boolean spacePressed = false;
	int lastBlast = -10;
	boolean StartGame = false;
	boolean optionScreen = false;
	boolean gameLoss = false;
	boolean gameWin = false;

public MyCanvas () {
	
	this.setSize (1400,800);
	this.addKeyListener(this);//add key listener to canvas
	this .setBackground(VERY_LIGHT_BLUE);
	playIt("Files/missioni.wav");

	TimerTask repeatedTask = new TimerTask() {

	Random rand = new Random();
	
        public Random getRand() {
		return rand;
	}

	public void setRand(Random rand) {
		this.rand = rand;
	}

			public void run() {
                for(int i = 0; i < badguys.size(); i++) {// draw bad guys
                    Badguy bg = (Badguy) badguys.get(i);
                    if (bg.getxCoord()<= 25) {
                    	gameLoss = true;
                    	StartGame = false;
                    	
                    }
    
                    if (level == 1) {
                    bg.setyCoord(bg.getyCoord() - rand.nextInt(60));
                    bg.setxCoord(bg.getxCoord() - rand.nextInt(60));
                    bg.setyCoord(bg.getyCoord() + rand.nextInt(60));
                }
                    if (level == 2) {
                    	bg.setyCoord(bg.getyCoord() - rand.nextInt(70));
                        bg.setxCoord(bg.getxCoord() - rand.nextInt(70));
                        bg.setyCoord(bg.getyCoord() + rand.nextInt(70));
                    }
                    if (level == 3) {
                    	bg.setyCoord(bg.getyCoord() - rand.nextInt(80));
                        bg.setxCoord(bg.getxCoord() - rand.nextInt(80));
                        bg.setyCoord(bg.getyCoord() + rand.nextInt(80));
                    }
                    }
                repaint();
            }
        };
        Timer timer = new Timer("Timer");
        long delay  = 10L;
        long period = 600L;
        timer.scheduleAtFixedRate(repeatedTask, delay, period);
        
	Random rand = new Random();
	int winwidth = this.getWidth();
	int winheight = this.getHeight();
	int rx = rand.nextInt();
	int ry = rand.nextInt();
			
	
	Rectangle ggrect = new Rectangle(mega.getxCoord(), mega.getyCoord(), mega.getWidth(), mega.getHeight());
	for (int i = 0; i<20; i++) {
		Badguy bg = new Badguy(rand.nextInt(winwidth)+ 6000, rand.nextInt(winheight-270),70,70,"Files/helil.png");
		Rectangle r = new Rectangle(bg.getxCoord()-60,bg.getyCoord()+35,bg.getWidth()+110,bg.getHeight()+35);
		if (r.intersects(ggrect)) {
			//if (r.contains(sonic.getxCoord(),sonic.getyCoord())) {
			System.out.println("badguy on top of mega");
			continue;
		}
		badguys.add(bg);
	
	}

}

final Color VERY_LIGHT_BLUE = new Color(80,200,255);
final Color RED = new Color (250,0,0);
final Color WHITE = new Color (255,255,255);

public void paint(Graphics g) {
	if (StartGame == false ) {
		g.drawImage(startscreen.getImg(), startscreen.getxCoord() , startscreen.getyCoord(), startscreen.getWidth(), startscreen.getHeight(), this);
		}
	if (optionScreen == true) {
		g.drawImage(optionscreen.getImg(), optionscreen.getxCoord(), optionscreen.getyCoord(), optionscreen.getWidth(), optionscreen.getHeight(), this);
	}
	if (gameLoss == true) {
		g.drawImage (lossscreen.getImg(), lossscreen.getxCoord(), lossscreen.getyCoord(), lossscreen.getWidth(), lossscreen.getHeight(), this);
		Font font  = new Font ("Helvetica", Font.BOLD, 40);
		g.setFont(font);
		g.setColor(WHITE);
		g.drawString("Score =  " + Integer.toString(score) + " / 20", 890,130);
	}
	if (gameWin == true) {
		g.drawImage(winscreen.getImg(), winscreen.getxCoord(), winscreen.getyCoord(), winscreen.getHeight(), winscreen.getWidth(), this);
		
	}
	

	if (StartGame == true && score == 20) {
		gameWin = true;
	}
	
		
		else if(StartGame == true) {
		time++;
		Rectangle ggrect = new Rectangle(mega.getxCoord(), mega.getyCoord(), mega.getWidth(), mega.getHeight());
		for (int i = 0; i<10; i++) {//21 copies of the block
			//Block bl = new Block(20, 600, 80, 80, "Files/bBlock.png");//moves 70 to the right to draw next block
			//Rectangle br = new Rectangle(bl.getxCoord(), bl.getyCoord(), bl.getHeight(), bl.getWidth());
			g.drawImage(back.getImg(), back.getxCoord(), back.getyCoord(), back.getWidth(),back.getHeight(), this );
			
			

			//g.drawImage(bl.getImg(), bl.getxCoord(), bl.getyCoord(), bl.getWidth(), bl.getHeight(), this);
			
			//g.drawImage(bottom.getImg(), bottom.getxCoord(), bottom.getyCoord(), bottom.getWidth(), bottom.getHeight(), this);
			
	Font font  = new Font ("Helvetica", Font.BOLD, 40);
			g.setFont(font);
			//g.setColor(RED);
			g.drawString("Score: " + Integer.toString(score), 40, 60);
			g.setColor(WHITE);
			g.drawString("Level " + Integer.toString(level), 650,750);
			
		
		}
		
		
		g.drawImage(mega.getImg(), mega.getxCoord(), mega.getyCoord(), mega.getWidth(), mega.getHeight(), this);
		
		for (int a = 0; a < badguys.size(); a++) {
			Badguy bg = (Badguy) badguys.get(a);
			g.drawImage(bg.getImg(), bg.getxCoord(), bg.getyCoord(), bg.getWidth(), bg.getHeight(), this);
			Rectangle r = new Rectangle(bg.getxCoord(), bg.getyCoord(), bg.getWidth(), bg.getHeight());
			
		for(int j = 0; j < fireballs.size(); j++) {
			Projectile k = (Projectile) fireballs.get(j);
			if (k.getxCoord() > this.getWidth() || k.getxCoord()<-30) {fireballs.remove(k); }
			if (time%2==0) {//runs code every 6 instead of every 1
				k.setxCoord(k.getxCoord()  + k.getdirection()*2);
			}
			g.drawImage(k.getImg(), k.getxCoord(), k.getyCoord(), k.getWidth(), k.getHeight(), this);
			
			Rectangle kr = new Rectangle(k.getxCoord(), k.getyCoord(), k.getWidth(), k.getHeight());
			if (kr.intersects(r)) {
				badguys.remove(a);
				fireballs.remove(j);
				score++;
			}
			//repaint();
		}
		repaint();
		}
	}
	}
	


public void keyPressed(KeyEvent e) {
	
	int key = e.getKeyCode();
	
	if (key == KeyEvent.VK_G && StartGame == false) {
		optionScreen = true;
	}
	//if (e.getKeyCode()==49 && optionScreen == true){
	//level = 1;
	//StartGame = true;
	//}
	if (e.getKeyCode()==10 && optionScreen == true) {
		optionScreen = false;
		level = 1;
		StartGame = true;
	}
	if (e.getKeyCode() == 92 && optionScreen == true) {
		optionScreen = false;
		level = 2;
		StartGame = true;
	}
	if (e.getKeyCode() == 8 && optionScreen == true) {
		optionScreen = false;
		level = 3;
		StartGame = true;
	}
	
		
		if (e.getKeyCode()==10 && gameLoss == true || e.getKeyCode() == 10 && gameWin == true) {
		StartGame = false;
		gameLoss = false;
		gameWin = false;
		score = 0;
		Random rand = new Random();
		int winwidth = this.getWidth();
		int winheight = this.getHeight();
		int rx = rand.nextInt();
		int ry = rand.nextInt();
		
		while (badguys.size()>0) {
			for (int i = 0; i<badguys.size(); i++) {
				badguys.remove(i);
			}
			
		}
		
		Rectangle ggrect = new Rectangle(mega.getxCoord(), mega.getyCoord(), mega.getWidth(), mega.getHeight());
		for (int i = 0; i<20; i++) {
			Badguy bg = new Badguy(rand.nextInt(winwidth)+ 4000, rand.nextInt(winheight-270),70,70,"Files/helil.png");
			Rectangle r = new Rectangle(bg.getxCoord(),bg.getyCoord(),bg.getWidth(),bg.getHeight());
			if (r.intersects(ggrect)) {
				//if (r.contains(sonic.getxCoord(),sonic.getyCoord())) {
				System.out.println("badguy on top of mega");
				continue;
			}
			badguys.add(bg);
		
		}
		repaint();
	}
	
	if(e.getKeyCode() == 32 && megaMoved == true && time-lastBlast>60) {//pass 300 ms since last time you shot to shoot again
		if (mega.getPhase()>0 && spacePressed==false) {
			Projectile fireball = new Projectile(mega.getxCoord()+70, mega.getyCoord()+15,30,20,"Files/redBall.png");
			fireball.setdirection(1);
			fireballs.add(fireball);
		}
		else if (spacePressed==false) {
			Projectile fireball = new Projectile(mega.getxCoord(), mega.getyCoord()+15,30,20,"Files/redBall-.png");
			fireball.setdirection(-1);
			fireballs.add(fireball);
			
		}
		lastBlast = time;
		spacePressed = true;
	}
	else {
		megaMoved = true;
	}
	
	System.out.println(e);
	mega.moveIt(e.getKeyCode(), this.getWidth(), this.getHeight());
	
	for(int i = 0; i < badguys.size(); i++) {
		Badguy bg = (Badguy) badguys.get(i);
		Rectangle r = new Rectangle(bg.getxCoord(), bg.getyCoord(), bg.getWidth(), bg.getHeight());
		if (r.contains(mega.getxCoord(), mega.getyCoord())) {
			System.out.println("badguy hit by mega");
			badguys.remove(i);
			score++;
		}
	}
	repaint();
}

public void playIt(String filename) {
	try {
		InputStream in = new FileInputStream(filename);
		AudioStream as = new AudioStream(in);
		AudioPlayer.player.start(as);
	} catch (IOException e) {
		System.out.println (e);
	}
		
}
	
	public void keyTyped(KeyEvent e) {
}
	

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		if (e.getKeyCode()==39) {
			mega.setImg("Files/Wake7.png");
			mega.setPhase(1);
		}
		if (e.getKeyCode()==37){
			mega.setImg("Files/Wake-7.png");
			mega.setPhase(-1);
		}
		if (e.getKeyCode()==32) {
			spacePressed = false;
		} 
		if (e.getKeyCode()==49 && StartGame == false) {
			StartGame = true;
			level = 1;
		}
		if (e.getKeyCode()==50 && StartGame == false) {
			StartGame = true;
			level = 2;
		}
		if (e.getKeyCode()==51 && StartGame == false) {
			StartGame = true;
			level = 3;
		}
	}
}
	


