package GamePackage;

import java.awt.Image;
import java.awt.Toolkit;

public class Projectile {

		private int xCoord = 0;
		private int yCoord = 0;
		private int width = 20;
		private int height = 20;
		private Image img;
		private int direction = 1;
		
			public Projectile() {
			setxCoord(10);
			setyCoord(10);
			setWidth(30);
			setHeight(30);
			setImg("../Files/redBall.png");
		}
		
		public Projectile(int x, int y, int w, int h, String imgpath) {
				setxCoord(x);
				setyCoord(y);
				setWidth(w);
				setHeight(h);
				setImg(imgpath);
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

		public Image getImg() {
			return img;
		}

		public void setImg(Image img) {
			this.img = img;
		}
			public int getdirection() {
				return direction;
			}

			public void setdirection(int direction) {
				this.direction = direction;
		
			// TODO Auto-generated constructor stub



	}


			// TODO Auto-generated method stub
			
		}


