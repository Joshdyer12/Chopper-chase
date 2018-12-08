package GamePackage;

import java.awt.Image;
import java.awt.Toolkit;

public class Goodguy {

	private int xCoord = 0;
	private int yCoord = 0;
	private int width = 20;
	private int height = 20;
	private Image img;
	private int phase = 0;
	
	
	public Goodguy() {
		setxCoord(10);
		setyCoord(10);
		setWidth(30);
		setHeight(30);
		setImg("../Files/Wake6.png");
	}
	
	public Goodguy(int x, int y, int w, int h, String imgpath) {
			setxCoord(x);
			setyCoord(y);
			setWidth(w);
			setHeight(h);
			setImg(imgpath);
		}
	public void moveIt(int direction, int w, int h) {
		int speed = 20;
		int x = getxCoord();
		int y = getyCoord();
		if (direction == 39) {
			
			if (phase<1) {
				setImg("Files/Run1.png");
			}
			setPhase(getPhase()+1);
			if (phase==1) {
			}
			else if (phase==2) {
				setImg("Files/Run2.png");
			}
			else if (phase==3) {
				setImg("Files/Run3.png");
			}
			else if (phase==4) {
				setImg("Files/Run4.png");
			}
			else if (phase==5) {
				setImg("Files/Run5.png");
			}
			else if (phase==6) {
				setImg("Files/Run6.png");
			}
			else if (phase==7) {
				setImg("Files/Run7.png");
			}
			else if (phase==8) {
				setImg("Files/Run8.png");
			}
			else if (phase==9) {
				setImg("Files/Run9.png");
			}
			else if (phase==10) {
				setImg("Files/Run10.png");
				setPhase(1);
			}
			
			x = x + speed;
			if (x > w) {x = x - 20 * 3; }
			setxCoord(x);
			//setImg("Files/goodRight.jpg");
		} else if (direction == 37) {
			if (phase<0) {
				setImg("Files/Run-1.png");
			}
			setPhase(getPhase()-1);
			if (phase==-1) {
			}
			else if (phase==-2) {
				setImg("Files/Run-2.png");
			}
			else if (phase==-3) {
				setImg("Files/Run-3.png");
			}
			else if (phase==-4) {
				setImg("Files/Run-4.png");
			}
			else if (phase==-5) {
				setImg("Files/Run-5.png");
			}
			else if (phase==-6) {
				setImg("Files/Run-6.png");
			}
			else if (phase==-7) {
				setImg("Files/Run-7.png");
			}
			else if (phase==-8) {
				setImg("Files/Run-8.png");
			}
			else if (phase==-9) {
				setImg("Files/Run-9.png");
			}
			else if (phase==-10) {
				setImg("Files/Run-10.png");
				setPhase(-1);
			}
			x = x - speed;
			if (x < 0) {x = x + speed * 3; }
			setxCoord(x);
			//setImg("Files/goodLeft.jpg");
		} else if (direction == 38) {
			y = y - speed;
			if (y < 0) {y = y + speed * 3; }
			setyCoord(y);
			//setImg("Files/goodRight.jpg");
		} else if (direction == 40) {
			y = y + speed;
			if (y > 750) {y = y - speed * 3; }
			setyCoord(y);
			//setImg("Files/goodRight.jpg");
			if (phase<0) {
				if (phase==-1) {
				}
				else if (phase==-2) {
					setImg("Files/Run-2.png");
				}
				else if (phase==-3) {
					setImg("Files/Run-3.png");
				}
				else if (phase==-4) {
					setImg("Files/Run-4.png");
				}
				else if (phase==-5) {
					setImg("Files/Run-5.png");
				}
				else if (phase==-6) {
					setImg("Files/Run-6.png");
				}
				else if (phase==-7) {
					setImg("Files/Run-7.png");
				}
				else if (phase==-8) {
					setImg("Files/Run-8.png");
				}
				else if (phase==-9) {
					setImg("Files/Run-9.png");
				}
				else if (phase==-10) {
					setImg("Files/Run-10.png");
					setPhase(-1);
				}
				phase--;
			}
			else {
				if (phase==1) {
				}
				else if (phase==2) {
					setImg("Files/Run2.png");
				}
				else if (phase==3) {
					setImg("Files/Run3.png");
				}
				else if (phase==4) {
					setImg("Files/Run4.png");
				}
				else if (phase==5) {
					setImg("Files/Run5.png");
				}
				else if (phase==6) {
					setImg("Files/Run6.png");
				}
				else if (phase==7) {
					setImg("Files/Run7.png");
				}
				else if (phase==8) {
					setImg("Files/Run8.png");
				}
				else if (phase==9) {
					setImg("Files/Run9.png");
				}
				else if (phase==10) {
					setImg("Files/Run10.png");
					setPhase(1);
				}
				phase++;
			}
		}
	}
		
	public void setImg(String imgpath) {
		this.img = Toolkit.getDefaultToolkit().getImage(imgpath);
	}

	public int getxCoord() {
		return xCoord;
	}

	public void setxCoord(int xCoord) {
		this.xCoord = xCoord;
	}

	public int getyCoord() {
		return yCoord;
	}

	public void setyCoord(int yCoord) {
		if (yCoord>560) {
			yCoord = 560;
		}
		this.yCoord = yCoord;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}
	
	public int getPhase() {
		return phase;
	}

	public void setPhase(int phase) {
		this.phase = phase;
	}

	public Image getImg() {
		return img;
	}

	public void setImg(Image img) {
		this.img = img;
	}
	
	
		// TODO Auto-generated constructor stub

}
